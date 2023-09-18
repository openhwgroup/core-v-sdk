package com.ashling.riscfree.debug.ease.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.model.DsfLaunch;
import org.eclipse.cdt.dsf.debug.service.IProcesses.IProcessDMContext;
import org.eclipse.cdt.dsf.debug.service.IProcesses.IThreadDMContext;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExecutionDMContext;
import org.eclipse.cdt.dsf.debug.service.IStack.IFrameDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.gdb.launching.GDBProcess;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.cdt.dsf.mi.service.IMIRunControl;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import com.ashling.riscfree.debug.ease.Activator;
import com.ashling.riscfree.debug.ease.dsf.EASEScriptUtil;
import com.ashling.riscfree.debug.ease.dsf.ScriptVariable;
import com.ashling.riscfree.debug.multicore.dsf.CoreDsfServicesTracker;
import com.ashling.riscfree.debug.multicore.model.IMulticoreLaunch;

/**
 * A This is an abstract class represents a debug view which will update the
 * contents via running a script
 */

//TODO: Some dirty code is there to make views thread specific and non thread specific, worth a rework

public class EASEDebugView extends AbstractDebugView
		implements IDebugEventSetListener, IWorkbenchListener, IEASEView, ISelectionListener {

	private static final String VIEW_POPULATOR_SCRIPT_END = "_populator.py";
	private static final String VIEW_CONFIGURATOR_SCRIPT_END = "_configurator.py";
	private TreeViewer viewer;
	private Action autoRefreshViewContents;
	private int columnCount;
	private List<Integer> columnWidthArray;
	private List<String> columnHeaders;
	private String iconFolderName;
	private List<?> taskList;
	private Map<String, Image> viewImageDescriptors = new HashMap<String, Image>();

	private Composite parentCoposite;
	protected DsfSession activeSession;
	private IAdaptable activeThreadContext;
	protected IProcessDMContext activeProcessDMContext;

	private Action expandAllAction;
	private Action collapseAllAction;
	private TextContributionItem searchTextField;
	private ComboContributionItem tokenCombo;
	private Action searchRight;
	private Action searchLeft;
	private int selectedSearchIndex;
	private int searchIndex = 0;
	LinkedHashMap<TreeItem, Object> treeItemMap = new LinkedHashMap<>();
	List<SearchModel> searchList = new ArrayList<>();
	List<TreeItem> itemList = new ArrayList<>();
	final Color selectionColor = new Color(Display.getCurrent(), 204, 204, 255);
	final Color colorYellow = new Color(Display.getCurrent(), 255, 255, 102);
	final Color colorWhite = new Color(Display.getCurrent(), 255, 255, 255);
	private Shell shell;

	private boolean isNonDebugView = false;

	private static final Object synchronizerObject = new Object();

	private static final String[] SEARCH_FILTER = new String[] { "All" };

	@Override
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	@Override
	public void setIconFolderName(String folderName) {
		iconFolderName = folderName;
		loadImageDescriptors();
	}

	@Override
	public void setColumnWidthArray(List<Integer> columnWidthArray) {
		this.columnWidthArray = columnWidthArray;
	}

	@Override
	public void setColumnHeaders(List<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}

	/*
	 * The content provider class is responsible for providing objects to the view.
	 * It can wrap existing objects in adapters or simply return objects as-is.
	 * These objects may be sensitive to the current input of the view, or ignore it
	 * and always show the same content (like Task List, for example).
	 */

	class ViewContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getElements(Object parent) {
			return ArrayContentProvider.getInstance().getElements(parent);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				List<?> arraysList = ((List<?>) parentElement).stream()
						.filter(p -> p instanceof List && !((List<?>) p).isEmpty()).collect(Collectors.toList());
				return arraysList.toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {

			if (element instanceof List) {
				List<?> arraysList = ((List<?>) element).stream()
						.filter(p -> p instanceof List && !((List<?>) p).isEmpty()).collect(Collectors.toList());

				return !arraysList.isEmpty();
			}
			return false;
		}
	}

	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider, IColorProvider {
		public String getColumnText(Object obj, int index) {
			List<?> listOfValues = (List<?>) obj;
			if (listOfValues.size() > index) {
				return getText(listOfValues.get(index));
			} else {
				return "";
			}
		}

		public Image getColumnImage(Object obj, int index) {
			if (obj instanceof List<?>) {
				List<?> listObj = (List<?>) obj;
				if (listObj.size() > index) {
					Object colVal = listObj.get(index);
					if (colVal instanceof String) {
						return viewImageDescriptors.get(colVal);
					}
				}
			}
			return getImage(obj);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof String) {
				return super.getText(element);
			} else {
				return "";
			}
		}

		@Override
		public Color getForeground(Object element) {
			List<?> listOfValues = (List<?>) element;
			// Expect index columnCount+! as foreground color
			if (listOfValues.size() > EASEDebugView.this.columnCount + 1) {
				Object foreGroundVal = listOfValues.get(columnCount + 1);
				if (foreGroundVal instanceof String) {
					String colourName = (String) foreGroundVal;
					if (!colourName.isBlank()) {
						// TODO: It would be nice if user can select any color using RGB. Now only SWT
						// system colors can be selected
						return PlatformUI.getWorkbench().getDisplay()
								.getSystemColor(Integer.parseInt(colourName.trim()));
					}
				}
			}
			return null;
		}

		@Override
		public Color getBackground(Object element) {
			List<?> listOfValues = (List<?>) element;
			// Expect index columnCount as background color
			if (listOfValues.size() > EASEDebugView.this.columnCount) {
				Object backGroundVal = listOfValues.get(columnCount);
				if (backGroundVal instanceof String) {
					String colourName = (String) backGroundVal;
					if (!colourName.isBlank()) {
						// TODO: It would be nice if user can select any color using RGB. Now only SWT
						// system colors can be selected
						return PlatformUI.getWorkbench().getDisplay()
								.getSystemColor(Integer.parseInt(colourName.trim()));
					}
				}
			}

			return null;
		}
	}

	private TreeViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		final TreeViewerColumn viewerColumn = new TreeViewerColumn(viewer, SWT.NONE);
		final TreeColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setToolTipText(title);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;

	}

	public double[] getColumnValues(int index) {
		final int itemCount = viewer.getTree().getItemCount();
		double[] line = new double[itemCount];
		for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
			TreeItem item = viewer.getTree().getItem(itemIndex);

			line[itemIndex] = Double.parseDouble(item.getText(index));
		}
		return line;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void handleDebugEvents(DebugEvent[] events) {
		if (events == null) {
			throw new IllegalArgumentException("debug event is null.");
		} else {
			DebugEvent[] eventArray = events;
			int eventsLength = events.length;

			for (int var3 = 0; var3 < eventsLength; ++var3) {
				DebugEvent de = eventArray[var3];
				if (de.getKind() == 8 && de.getSource() != null && de.getSource() instanceof GDBProcess) {
					this.handleTerminateEvent(de);
				}
			}

		}

	}

	private void handleTerminateEvent(DebugEvent de) {
		GDBProcess gdbProcess = (GDBProcess) de.getSource();
		if (gdbProcess != null) {
			activeSession = null;
			activeThreadContext = null;
			clearViewContent();
		}

	}

	@Override
	protected Viewer createViewer(Composite parent) {

		shell = parent.getShell();
		this.parentCoposite = parent;
		DebugPlugin.getDefault().addDebugEventListener(this);
		getSite().getPage().addSelectionListener(IDebugUIConstants.ID_DEBUG_VIEW, this);
		viewer = makeViewer(parent);
		viewer.getTree().setLinesVisible(true);
		viewer.getTree().setHeaderVisible(true);
		configureViewer();
		if (syncActiveDebugLaunch()) {
			activeThreadContext = null;
			populateView();
		}
		return viewer;
	}
	
	protected TreeViewer makeViewer(Composite parent) {
		return new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	}

	private boolean syncActiveDebugLaunch() {
		activeSession = getActiveSession();
		return activeSession != null;
	}

	private DsfSession getActiveSession() {
		ILaunch activeLaunch = getActiveLaunch();
		if (activeLaunch instanceof GdbLaunch) {
			return ((GdbLaunch) activeLaunch).getSession();
		} else if (activeLaunch instanceof IMulticoreLaunch) {
			return ((IMulticoreLaunch) activeLaunch).getSession();
		}
		return null;
	}

	protected ILaunch getActiveLaunch() {
		IAdaptable currentDebugContext = DebugUITools.getDebugContext();
		if (currentDebugContext == null) {
			return null;
		}

		ILaunch launch = null;
		if (currentDebugContext instanceof IDebugElement) {
			launch = ((IDebugElement) currentDebugContext).getLaunch();
		} else if (currentDebugContext instanceof ILaunch) {
			IDebugTarget debugTarget = ((ILaunch) currentDebugContext).getDebugTarget();
			if (debugTarget != null) {
				launch = debugTarget.getLaunch();
			}
		} else {
			launch = currentDebugContext.getAdapter(ILaunch.class);
		}
		return launch;
	}

	private void configureViewer() {
		executeScript(getViewConfigurationScriptID());
	}

	// Fix for git-lab#359 - made synchronized along with setInput
	@Override
	public void createView() {
		synchronized (synchronizerObject) {
			Display.getDefault().syncExec(this::createColumns);
		}
	}

	private void createColumns() {
		for (int i = 0; i < columnCount; i++) {
			if (columnHeaders != null && columnWidthArray != null)
				createTableViewerColumn(columnHeaders.get(i), columnWidthArray.get(i), i + 1);
		}
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setContentProvider(new ViewContentProvider());
		// TODO: Is there any better location to be moved
		tokenCombo.getComboControl().setItems(getSearchFilters());
		tokenCombo.getComboControl().select(0);
	}

	private void loadImageDescriptors() {
		if (iconFolderName != null) {
			File imageFolder = new File(iconFolderName);
			if (imageFolder.exists() && imageFolder.isDirectory()) {
				try {
					Files.list(imageFolder.toPath()).forEach(p -> {
						try {
							viewImageDescriptors.put(p.getFileName().toString().split("\\.")[0],
									ImageDescriptor.createFromURL(p.toUri().toURL()).createImage());
						} catch (MalformedURLException e) {
							Activator.log(e);
						}
					});
				} catch (IOException e) {
					Activator.log(e);
				}
			}
		}
	}

	@Override
	public void setInput(List<?> viewerInput) {
		this.taskList = viewerInput;
		// Fix for git-lab #361
		viewer.setAutoExpandLevel(0);
		// Fix for git-lab#359 - made synchronized along with createView
		synchronized (synchronizerObject) {
			if (!viewer.getTree().isDisposed() && viewer.getContentProvider() != null) {
				if (expandAllAction.isChecked()) {
					viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
				}
				Display.getDefault().asyncExec(() -> viewer.setInput(viewerInput));
			}
		}
	}

	@Override
	protected void createContextMenu(Control menuControl) {
		if (!isStaticDebugView()) {
			MenuManager menuMgr = new MenuManager("#PopUp"); //$NON-NLS-1$
			Menu menu = menuMgr.createContextMenu(menuControl);
			menuControl.setMenu(menu);
			fillContextMenu(menuMgr);
			addContextMenuManager(menuMgr);
		}
	}

	@Override
	protected void fillContextMenu(IMenuManager menu) {
		if (!isStaticDebugView()) {
			menu.add(autoRefreshViewContents);
		}

		menu.add(searchTextField);
		menu.add(tokenCombo);
		menu.add(searchLeft);
		menu.add(searchRight);
		menu.add(collapseAllAction);
		menu.add(expandAllAction);

	}

	@Override
	public void dispose() {
		selectionColor.dispose();
		colorWhite.dispose();
		colorYellow.dispose();
		DebugPlugin.getDefault().removeDebugEventListener(this);
		getSite().getPage().removeSelectionListener(IDebugUIConstants.ID_DEBUG_VIEW, this);
		viewImageDescriptors.values().forEach(Image::dispose);
		viewImageDescriptors.clear();
		if (taskList != null) {
			taskList.clear();
		}
		super.dispose();
	}

	@Override
	public boolean preShutdown(IWorkbench workbench, boolean forced) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postShutdown(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configureToolBar(IToolBarManager manager) {
		// Update actions needed only if the view is a non static debug view
		if (!isStaticDebugView()) {
			manager.add(autoRefreshViewContents);
		}

		// Update the actions only if the view supports search
		if (isSearchEnabled()) {
			manager.add(searchTextField);
			manager.add(tokenCombo);
			manager.add(searchLeft);
			manager.add(searchRight);
		}

		manager.add(expandAllAction);
		manager.add(collapseAllAction);

	}

	@Override
	protected void createActions() {

		// Update actions needed only if the view is a non static debug view
		if (!isStaticDebugView()) {
			autoRefreshViewContents = new Action("Auto Refresh", IAction.AS_CHECK_BOX) {
				@Override
				public void run() {
					if (autoRefreshViewContents.isChecked()) {
						syncActiveDebugLaunch();
						populateView();
					}
				}
			};
			autoRefreshViewContents.setToolTipText("Auto Refresh");
			autoRefreshViewContents.setImageDescriptor(Activator.getImageDescriptor("icons/refresh.png"));
			autoRefreshViewContents.setChecked(true); // Making it checked by default
		}

		if (isStaticDebugView()) {
			expandAllAction = new Action("Expand All") {

				@Override
				public void run() {
					if (viewer != null && viewer.getInput() != null) {
						if (!searchTextField.getText().isEmpty()) {
							searchTree(searchTextField.getText());
						}
						if (isStaticDebugView()) {
							// No need to check isChecked if the view is a static view.
							viewer.expandAll();
							viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
							return;
						}
						if (expandAllAction.isChecked()) {
							viewer.expandAll();
							viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
						} else {
							viewer.setAutoExpandLevel(0);
						}

					}
				}
			};

		}

		else {
			expandAllAction = new Action("Expand All", Action.AS_CHECK_BOX) {
				@Override
				public void run() {
					if (viewer != null && viewer.getInput() != null) {
						if (expandAllAction.isChecked()) {
							viewer.expandAll();
							viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
						} else {
							viewer.setAutoExpandLevel(0);
						}
					}
				}
			};
		}

		if (isAutoexpandedView()) {
			expandAllAction.setChecked(true);
		}

		collapseAllAction = new Action("Collapse All") {
			public void run() {
				if (!isStaticDebugView()) {
					expandAllAction.setChecked(false);
				}
				if (viewer != null && viewer.getInput() != null) {
					viewer.collapseAll();
				}
			}
		};

		searchLeft = new Action("Search Left") {
			public void run() {
				highlightSearch(searchList.get(searchIndex).getTreeItem(), searchList.get(searchIndex).getColumnIndex(),
						colorYellow);
				if (searchIndex > 0) {
					searchIndex--;
					highlightSearch(searchList.get(searchIndex).getTreeItem(),
							searchList.get(searchIndex).getColumnIndex(), selectionColor);
				} else {
					searchIndex = searchList.size() - 1;
					highlightSearch(searchList.get(searchIndex).getTreeItem(),
							searchList.get(searchIndex).getColumnIndex(), selectionColor);
				}
			}
		};

		searchRight = new Action("Search Right") {
			public void run() {
				highlightSearch(searchList.get(searchIndex).getTreeItem(), searchList.get(searchIndex).getColumnIndex(),
						colorYellow);
				if (searchIndex < searchList.size() - 1) {
					searchIndex++;
					highlightSearch(searchList.get(searchIndex).getTreeItem(),
							searchList.get(searchIndex).getColumnIndex(), selectionColor);
				} else {
					searchIndex = 0;
					highlightSearch(searchList.get(searchIndex).getTreeItem(),
							searchList.get(searchIndex).getColumnIndex(), selectionColor);
				}

			}
		};

		searchTextField = new TextContributionItem("searchText") {
			@Override
			public Control createControl(Composite parent) {
				// Let ComboContributionItem create the initial control.
				Control control = super.createControl(parent);
				Text text = getTextControl();
				text.setMessage("Find...");
				text.setToolTipText("Enter text to search");

				text.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent event) {
						if (event.keyCode == SWT.CR || event.keyCode == SWT.KEYPAD_CR) {
							searchTree(searchTextField.getText());
						}

						if (text.getText().isEmpty()) {
							clearSelection();
						} else {
							searchTree(text.getText());
						}
					}
				});
				return control;
			}
		};

		tokenCombo = new ComboContributionItem("Search Filter") {
			@Override
			public Control createControl(Composite parent) {
				// Let ComboContributionItem create the initial control.
				Control control = super.createControl(parent);
				Combo combo = getComboControl();
				combo.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {

						if(viewer.getInput()!=null) {
						selectedSearchIndex = combo.getSelectionIndex();
						searchTree(searchTextField.getText());
						}
					}
				});
				// Return the default control.
				return control;
			}
		};

		searchRight.setToolTipText("search up");
		searchLeft.setToolTipText("search down");
		searchRight.setImageDescriptor(Activator.getImageDescriptor("icons/search_next.gif"));
		searchLeft.setImageDescriptor(Activator.getImageDescriptor("icons/search_prev.gif"));

		expandAllAction.setToolTipText("Expand all");
		collapseAllAction.setToolTipText("Collapse all");
		expandAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/expandall.png"));
		collapseAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/collapseall.png"));
	}

	/**
	 * 
	 * This method will search through the entire data and find there is any match
	 * if there is any match it will parse the data to the corresponding model to
	 * make search easy
	 * 
	 * @param search text
	 */

	private void searchTree(String searchText) {

		if(searchText.isEmpty())
			return;
		clearSelection();
		for (int itemIndex = 0; itemIndex < viewer.getTree().getItemCount(); itemIndex++) {
			boolean searchFound = false;
			TreeItem item = viewer.getTree().getItem(itemIndex);
			if (item.getData().toString().toUpperCase().contains(searchText.toUpperCase())) {
				viewer.expandToLevel(item.getData(), TreeViewer.ALL_LEVELS);
				itemList.add(item);
				for (int i = 0; i < item.getItems().length; i++) {
					if (item.getItem(i).getData().toString().toUpperCase().contains(searchText.toUpperCase())) {
						itemList.add(item.getItem(i));
						searchFound = true;
					}

				}
			}

			if (!searchFound) {
				viewer.collapseToLevel(item.getData(), TreeViewer.ALL_LEVELS);
			}
		}
		searchList.addAll(new LinkedHashSet<>(generateSearchList(itemList, searchText, selectedSearchIndex)));

		/*
		 * Applying yellow color(search found) to the blocks which matches the search
		 * text
		 */
		for (int itemIndex = 0; itemIndex < searchList.size(); itemIndex++) {
			searchList.get(itemIndex).getTreeItem().setBackground(searchList.get(itemIndex).getColumnIndex(),
					colorYellow);
		}

		/*
		 * Applying the green color to the first block to imitate the selection
		 */
		if (searchList.isEmpty() || itemList.isEmpty()) {
			openNoResultFoundDialog();
		} else {
			highlightSearch(searchList.get(0).getTreeItem(), searchList.get(0).getColumnIndex(), selectionColor);
		}
	}

	private void openNoResultFoundDialog() {
		MessageDialog.openInformation(shell, "Search failed", "Can't find the text  \"" + searchTextField.getText() + "\".");

	}

	/*
	 * This method clears all the selection and collapse the viewer to the initial
	 * state
	 */
	private void clearSelection() {
		itemList.clear();
		treeItemMap.clear();
		searchIndex = 0;

		for (int itemIndex = 0; itemIndex < searchList.size(); itemIndex++) {
			highlightSearch(searchList.get(itemIndex).getTreeItem(), searchList.get(itemIndex).getColumnIndex(),
					colorWhite);
		}

		searchList.clear();
	}

	/**
	 * This method set the background color for the TreeItem's specified column and
	 * color
	 * 
	 * @param TreeItem
	 * @param Column   Index
	 * @param Color
	 */
	private void highlightSearch(TreeItem item, int columnIndex, Color color) {
		if (!item.isDisposed()) {
			item.setBackground(columnIndex, color);
		}
	}

	private void populateView() {
		// If it's a non debug view, data can be populated straight

		if (isNonDebugView) {
			executeScript(getViewPopulationScriptID());
			return;
		}
		activeProcessDMContext = getSelectedProcessDMContext();
		if (!canPopulateView(DebugUITools.getDebugContext())) {
			activeThreadContext = null;
			return;
		}
		activeThreadContext = null;
		activeThreadContext = getSelectedDMContext();
		executeScript(getViewPopulationScriptID());
	}

	private IProcessDMContext getSelectedProcessDMContext() {

		IAdaptable presentDebugContext = DebugUITools.getDebugContext();
		if (null == presentDebugContext) {
			return null;
		}
		return DMContexts.getAncestorOfType(presentDebugContext.getAdapter(IDMContext.class), IProcessDMContext.class);

	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

	/**
	 * Called each time a selection changes in the Debug View.
	 * {@inheritDoc} Implementation of overridden (or abstract) method.
	 * 
	 * @param part
	 * @param selection
	 */
	@Override
	public synchronized void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// No need to process further since this is not a debug view
		if (isNonDebugView) {
			return;
		}
		if (selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (obj instanceof IAdaptable) {
				ILaunch launch = (ILaunch) ((IAdaptable) obj).getAdapter(ILaunch.class);
				if (launch instanceof DsfLaunch) {

					if (autoRefreshViewContents != null && !autoRefreshViewContents.isChecked()) {
						// Nothing to do if auto refresh is not selected
						return;
					}

					if (isCoreSpecificView()) {
						if (!isActiveThreadChanged()) {
							// No need to populate since there is no change in core selection happened
							return;
						} else {
							clearViewContent();
						}
					}

					// Fix for git-lab #362, #360
					if (isStaticDebugView()) {
						if (isActiveDebugSessionChanged() || isActiveProcessChanged()) {
							clearViewContent();
							populateView();
						}
					} else if (syncActiveDebugLaunch()) {
						clearViewContent();
						populateView();
					}
				}
			}
		}
	}

	// TODO: Vinod - Need to review. It's better to go for a proper debug view
	// implementation!
	private boolean isActiveProcessChanged() {
		IProcessDMContext selectedProcess = getSelectedProcessDMContext();
		if (activeProcessDMContext == null || selectedProcess == null) {
			return true;
		}
		return !selectedProcess.equals(activeProcessDMContext);
	}

	private void clearViewContent() {
		if (!viewer.getTree().isDisposed() && viewer.getContentProvider() != null) {
			Display.getDefault().asyncExec(() -> {
				// slight hack to clear selection,
				// otherwise it will create exception when the viewer content cleared.
				viewer.setSelection(null);
				viewer.setInput(null);
			});
		}
	}

	// TODO: Worth a re-look into this function and usage
	private boolean isActiveThreadChanged() {
		return activeThreadContext != getSelectedDMContext();
	}

	private boolean isActiveDebugSessionChanged() {
		DsfSession selectedSession = getActiveSession();
		if (selectedSession != activeSession) {
			activeSession = selectedSession;
			return true;
		}
		return false;
	}

	protected boolean canPopulateView(IAdaptable currentDebugContext) {
		if (!isStaticDebugView()) {
			if (currentDebugContext == null || activeSession == null) {
				return false;
			}
			final DsfServicesTracker tracker = new DsfServicesTracker(
					Activator.getDefault().getBundle().getBundleContext(), activeSession.getId());
			IMIRunControl mirunControl = tracker.getService(IMIRunControl.class);
			tracker.dispose();
			return mirunControl != null && mirunControl.isSuspended(DMContexts
					.getAncestorOfType(currentDebugContext.getAdapter(IDMContext.class), IExecutionDMContext.class));
		} else {

			return activeSession != null;
		}
	}

	/**
	 * Identifier/script location will be used to configure the view
	 * 
	 * @return - return script identifier or absolute path of the script
	 */
	protected String getViewConfigurationScriptID() {
		String scriptNameStart = getPartName().toLowerCase().replaceAll("\\s", "").trim();
		return scriptNameStart + VIEW_CONFIGURATOR_SCRIPT_END;
	}

	/**
	 * Identifier/script location will be used to populate the view
	 * 
	 * @return - return script identifier or absolute path of the script
	 */
	protected String getViewPopulationScriptID() {
		String scriptNameStart = getPartName().toLowerCase().replaceAll("\\s", "").trim();
		return scriptNameStart + VIEW_POPULATOR_SCRIPT_END;
	}

	protected void executeScript(String scriptID) {
		EASEScriptUtil.INSTANCE.executeSript(scriptID, getScriptVariables(DebugUITools.getDebugContext()),
				Optional.empty());
	}

	protected ScriptVariable[] getScriptVariables(IAdaptable currentDebugContext) {
		return new ScriptVariable[] { new ScriptVariable("custom_view", this) };
	}

	/**
	 * Returns a thread IThreadDMContext or IExecutionDMContext
	 * 
	 * @return
	 */
	private IDMContext getSelectedDMContext() {
		IAdaptable presentDebugContext = DebugUITools.getDebugContext();
		IExecutionDMContext executionDMContext = presentDebugContext.getAdapter(IExecutionDMContext.class);
		if (executionDMContext != null) {
			return executionDMContext;
		}
		IThreadDMContext threadDMContext = presentDebugContext.getAdapter(IThreadDMContext.class);
		if (threadDMContext == null) {
			IFrameDMContext frameDMContext = presentDebugContext.getAdapter(IFrameDMContext.class);
			if (frameDMContext != null) {
				threadDMContext = DMContexts.getAncestorOfType(frameDMContext, IThreadDMContext.class);
			}
		}

		return threadDMContext;
	}

	/**
	 * The view content's won't be changing (The script won't be running) on debug
	 * operations if it's a static view
	 * 
	 * @return
	 */
	protected boolean isStaticDebugView() {
		return false;
	}

	/**
	 * Return true if the view is core specific (CDT/GDB Thread specific). Return
	 * false if the view is stack specific (Eg: Register values are call stack
	 * specific)
	 * 
	 * @return
	 */
	protected boolean isCoreSpecificView() {
		return true;
	}

	@Override
	public boolean isAutoexpandedView() {
		return false;
	}

	/**
	 * Get service tracker for given context. If it's a multicore launch, creates a
	 * core service tracker. This API may return null, clients has to take care.
	 * 
	 * @since 2.0.0
	 * @param currentDebugContext
	 * @param activeSession
	 * @return
	 */
	protected DsfServicesTracker getServiceTracker(IAdaptable currentDebugContext, DsfSession activeSession) {
		DsfServicesTracker tracker = null;
		ILaunch launch = currentDebugContext.getAdapter(ILaunch.class);
		if (launch instanceof IMulticoreLaunch) {
			// We've to track core specific service since it's a multicore launch
			ICommandControlDMContext commandContext = DMContexts.getAncestorOfType(
					currentDebugContext.getAdapter(IDMContext.class), ICommandControlDMContext.class);
			if (commandContext != null) {
				// commandContext.getCommandControlId() will give core id
				tracker = new CoreDsfServicesTracker(Activator.getDefault().getBundle().getBundleContext(),
						activeSession.getId(), commandContext.getCommandControlId());
			}
		} else {
			tracker = new DsfServicesTracker(Activator.getDefault().getBundle().getBundleContext(),
					activeSession.getId());
		}
		return tracker;
	}

	/**
	 * Set's whether the view is a non debug view or not. If it's a non debug view,
	 * view won't get updated according to the debug context change.
	 * 
	 * @since 3.0.0
	 * @param isNonDebugView
	 */
	public void setNonDebugView(boolean isNonDebugView) {
		this.isNonDebugView = isNonDebugView;
	}

	@Override
	public boolean isSearchEnabled() {
		return false;
	}

	@Override
	public String[] getSearchFilters() {
		return SEARCH_FILTER;
	}

	/**
	 * This method will create the search list with column index and TreeItem
	 * 
	 * @param list   of TreeItems which the search text found
	 * @param search query text
	 * @param search filter index
	 * @return List of searchModel objects which matches the search text
	 * 
	 */
	protected List<SearchModel> generateSearchList(List<TreeItem> itemList, String searchText, int searchFilter) {

		searchText = searchText.toUpperCase();
		List<SearchModel> searchList = new ArrayList<>();
		for (int itemIndex = 0; itemIndex < itemList.size(); itemIndex++) {
			TreeItem treeItem = itemList.get(itemIndex);
			if (searchFilter == 0) {
				List<String> parentItem = (List<String>) treeItem.getData();
				if (parentItem != null) {
					for (int i = 0; i < parentItem.size(); i++) {
						if (parentItem.get(i) instanceof String) {
							if (parentItem.get(i).toUpperCase().contains(searchText)) {
								searchList.add(new SearchModel(treeItem, i));

							}
						}
					}
				}
			}
			for (int j = 0; j < treeItem.getItems().length; j++) {
				List<String> childItem = (List<String>) treeItem.getItem(j).getData();
				if (childItem != null) {
					for (int k = 0; k < childItem.size(); k++) {
						if (childItem.get(k) instanceof String) {
							if (childItem.get(k).toUpperCase().contains(searchText)) {
								searchList.add(new SearchModel(treeItem.getItem(j), k));
							}
						}
					}
				}
			}
			/*
			 * if the search filter is other than ALL we only need to search through the
			 * specific column
			 */
			if (searchFilter > 0) {
				List<SearchModel> tempList = new ArrayList<>();
				for (int i = 0; i < searchList.size(); i++) {
					if (((searchList.get(i).getColumnIndex() == searchFilter - 1))) {
						tempList.add(searchList.get(i));
					}
				}
				searchList = tempList;
			}
		}

		return searchList;

	}
}
