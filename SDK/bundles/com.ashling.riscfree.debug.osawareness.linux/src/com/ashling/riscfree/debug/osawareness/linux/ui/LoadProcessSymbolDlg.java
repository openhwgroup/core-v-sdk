package com.ashling.riscfree.debug.osawareness.linux.ui;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ashling.riscfree.debug.osawareness.linux.Messages;

public class LoadProcessSymbolDlg extends Dialog implements ModifyListener, SelectionListener {

	public static LoadProcessSymbolDlg getDefault(Shell parentShell) {
		if (debugProcessFromMainDialog == null) {
			debugProcessFromMainDialog = new LoadProcessSymbolDlg(parentShell);
		}
		passedProcessName = null;
		dbgAlreadyLoadedProcess = false;
		return debugProcessFromMainDialog;
	}

	public static LoadProcessSymbolDlg getDefault(Shell parentShell, String module) {
		if (debugProcessFromMainDialog == null) {
			debugProcessFromMainDialog = new LoadProcessSymbolDlg(parentShell);
		}
		passedProcessName = module;
		dbgAlreadyLoadedProcess = true;
		return debugProcessFromMainDialog;
	}

	private static String passedProcessName;
	private static boolean dbgAlreadyLoadedProcess;
	private File processFile;
	private Label rootFileSystem;
	private Button processFileBrowseButton;
	final private int textWidth = 300;
	private Label processName;
	private Text processText;
	private Button RootSystemBrowseButton;
	private File rootFile;
	private Label shareLibSearch;
	private Button sharedLibRemoveButton;
	private Text rootFileSystemText;
	private List sharedLibSearchList;
	private Button sharedLibAddButton;
	private ArrayList<String> sharedLibraryList;
	private static LoadProcessSymbolDlg debugProcessFromMainDialog = null;

	private String rfsdir = ""; //$NON-NLS-1$
	private Button btnOK;
	private Button btnCancel;

	/**
	 * 
	 * @param parentShell
	 */
	public LoadProcessSymbolDlg(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		sharedLibraryList = new ArrayList<String>();
	}

	/**
	 * 
	 * @param parentShell
	 */
	protected LoadProcessSymbolDlg(IShellProvider parentShell) {
		super(parentShell);
	}

	/**
	 * 
	 * @return
	 */
	public File getProcessFile() {
		return processFile;
	}

	/**
	 * 
	 */
	public File getRootFile() {

		return rootFile;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getSharedLibSearchList() {

		return sharedLibraryList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events
	 * .ModifyEvent)
	 */
	@Override
	public void modifyText(ModifyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse
	 * .swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt
	 * .events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {

	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		btnOK = createButton(parent, IDialogConstants.OK_ID, Messages.Debug, true); //$NON-NLS-1$
		btnCancel = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		btnOK.setEnabled(false);
		if (processFile != null) {
			processText.setText(processFile.toString());
		}
	}

	/**
	 * 
	 * @param grp
	 * @param gridData
	 */
	private void createLibraryPathSubGroup(Group grp, GridData gridData) {

		shareLibSearch = new Label(grp, SWT.NONE);
		shareLibSearch.setText(Messages.Shared_lib_paths); //$NON-NLS-1$

		sharedLibSearchList = new List(grp, SWT.BORDER | SWT.MULTI | SWT.LINE_SOLID | SWT.V_SCROLL | SWT.H_SCROLL);
		sharedLibSearchList.setLayoutData(gridData);

		for (int i = 0; i < sharedLibraryList.size(); i++) {
			sharedLibSearchList.add(sharedLibraryList.get(i).toString());
		}
		final Composite subcom = new Composite(grp, SWT.None);
		final GridLayout gridLayout = new GridLayout(1, true);
		final GridData gridData1 = new GridData(SWT.CENTER, SWT.TOP, true, true);
		// gridLayout.numColumns = 1;
		subcom.setLayout(gridLayout);
		sharedLibAddButton = new Button(subcom, SWT.NONE);
		sharedLibAddButton.setText(Messages.Add);
		sharedLibAddButton.setLayoutData(gridData1);
		sharedLibAddButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleAddButtonSelected();
			}

		});

		sharedLibRemoveButton = new Button(subcom, SWT.NONE);
		sharedLibRemoveButton.setText(Messages.Remove);
		sharedLibRemoveButton.setLayoutData(gridData1);
		sharedLibRemoveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleRemoveButtonSelected();
			}
		});

	}

	/**
	 * 
	 * @param comp
	 * @param gd
	 */
	private void createProcessGroup(Composite comp) {
		final GridData gridData = new GridData(GridData.FILL_BOTH);
		// gridData.minimumHeight=100;
		gridData.minimumWidth = textWidth;
		// gridData.minimumHeight = 10;
		final Group grp = new Group(comp, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		grp.setLayout(layout);
		grp.setLayoutData(gridData);

		processName = new Label(grp, SWT.NONE);
		if (dbgAlreadyLoadedProcess) {
			processName.setText(Messages.Debug_already_running_process_path);
		} else {
			processName.setText(Messages.Process_name); //$NON-NLS-1$
		}

		processText = new Text(grp, SWT.SINGLE | SWT.BORDER);
		processText.setLayoutData(gridData);

		processText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent evt) {
				final IPath exePath = new Path(processText.getText());
				processFile = exePath.toFile();
				if (processFile.exists()) {
					btnOK.setEnabled(true);
				} else {
					btnOK.setEnabled(false);
				}
			}
		});

		processFileBrowseButton = new Button(grp, SWT.NONE);
		processFileBrowseButton.setText(Messages.Browse_with_dots);
		processFileBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleBrowseButtonSelected();
			}

		});
		createRootFileSystemSubGroup(grp, gridData);
	}

	/**
	 * 
	 * @param comp
	 * @param gd
	 */
	private void createRootFileSystemSubGroup(Group grp, GridData gridData) {
		rootFileSystem = new Label(grp, SWT.NONE);
		rootFileSystem.setText(Messages.Rootfs_dir); //$NON-NLS-1$

		rootFileSystemText = new Text(grp, SWT.SINGLE | SWT.BORDER);
		rootFileSystemText.setLayoutData(gridData);
		rootFileSystemText.setText(rfsdir);

		rootFileSystemText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent evt) {
				final IPath exePath = new Path(rootFileSystemText.getText());
				rootFile = exePath.toFile();
				rfsdir = rootFile.toString();
			}
		});
		RootSystemBrowseButton = new Button(grp, SWT.NONE);
		RootSystemBrowseButton.setText(Messages.Browse_with_dots);

		RootSystemBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleRootSystemBrowseButtonSelected();
			}
		});
	}

	/**
	 * 
	 * @param comp
	 * @param gd
	 */
	private void createSharedLibraryPathGroup(Composite comp) {

		final GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.minimumWidth = textWidth;
		final Group grp = new Group(comp, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		grp.setLayout(layout);
		grp.setLayoutData(gridData);
		grp.setText(Messages.Share_Library);
		createLibraryPathSubGroup(grp, gridData);

	}

	/**
	 * 
	 * @param browseText
	 * @return
	 */
	private void handleBrowseButtonSelected() {
		final FileDialog fileDialog = new FileDialog(processText.getShell(), SWT.NONE);
		fileDialog.setFileName(processText.getText());
		final String[] filterExt = { "*" }; //$NON-NLS-1$
		fileDialog.setFilterExtensions(filterExt);
		final String text = fileDialog.open();
		if (text != null) {
			processText.setText(text);
			final IPath exePath = new Path(text);
			processFile = exePath.toFile();

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets
	 * .Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		String title = new String();
		if (dbgAlreadyLoadedProcess) {
			title = String.format(Messages.Load_symbols_for_process+" %s", passedProcessName);
		} else {
			title = Messages.Debug_process_from_main;
		}
		newShell.setText(title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		final GridData gridData = new GridData(GridData.FILL_BOTH);
		parent.setLayoutData(gridData);
		createProcessGroup(parent);
		createSharedLibraryPathGroup(parent);
		return parent;
	}

	protected void handleAddButtonSelected() {
		final DirectoryDialog dirDialog = new DirectoryDialog(sharedLibSearchList.getShell(), SWT.NONE);
		final String text = dirDialog.open();
		if (text != null) {
			boolean contains = false;
			for (int i = 0; i < sharedLibraryList.size(); i++) {
				if (sharedLibraryList.get(i).equalsIgnoreCase(text)) {
					contains = true;
				}
			}
			if (!contains) {
				sharedLibraryList.add(text);
				sharedLibSearchList.add(text);
			}

		}
	}

	protected void handleRemoveButtonSelected() {
		for (int i = 0; i < sharedLibSearchList.toString().length(); i++) {
			if (sharedLibSearchList.isSelected(i)) {
				sharedLibSearchList.remove(i);
				sharedLibraryList.remove(i);
			}

		}
	}

	protected void handleRootSystemBrowseButtonSelected() {
		final DirectoryDialog dirDialog = new DirectoryDialog(rootFileSystemText.getShell(), SWT.NONE);

		final String text = dirDialog.open();
		if (text != null) {
			rootFileSystemText.setText(text);
			final IPath exePath = new Path(text);
			rootFile = exePath.toFile();
			rfsdir = rootFile.toString();
		}
	}

}
