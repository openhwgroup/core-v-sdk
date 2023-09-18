package com.ashling.riscfree.debug.osawareness.linux.ui;

import org.eclipse.jface.dialogs.Dialog;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ashling.riscfree.debug.osawareness.linux.Messages;

public class DebugAlreadyRunningModuleDialog extends Dialog implements ModifyListener, SelectionListener {

	private Text moduleText;
	private Text moduleNameText;
	private String moduleFullPath;
	private Label modulePathLabel;
	private Label moduleNameLabel;
	private Button moduleFileBrowseButton;
	private String ModuleName;
	static private DebugAlreadyRunningModuleDialog dlgDbgAlreadyRunnigModule;
	final private int textWidth = 300;

	/**
	 * 
	 * @param parentShell
	 * @param module
	 */
	private DebugAlreadyRunningModuleDialog(Shell parentShell, String module) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		SetText(module);

	}

	public static DebugAlreadyRunningModuleDialog getDefault(Shell parentShell, String module) {
		if (dlgDbgAlreadyRunnigModule == null) {
			dlgDbgAlreadyRunnigModule = new DebugAlreadyRunningModuleDialog(parentShell, module);
		}
		return dlgDbgAlreadyRunnigModule;
	}

	/**
	 * 
	 * @param parentShell
	 */
	private DebugAlreadyRunningModuleDialog(IShellProvider parentShell) {
		super(parentShell);

	}

	/**
	 * 
	 * @return
	 */
	public String GetText() {
		return moduleFullPath;
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

	/**
	 * 
	 * @param module
	 */
	public void SetText(String module) {
		ModuleName = module;
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

	/**
	 * 
	 * @param comp
	 * @param gd
	 */
	private void createModulePathBrowseGroup(Composite comp, GridData gd) {
		final Group grp = new Group(comp, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		grp.setLayout(layout);
		grp.setLayoutData(gd);

		moduleNameLabel = new Label(grp, SWT.NONE);
		moduleNameLabel.setText(Messages.Module_name_without_ko);

		moduleNameText = new Text(grp, SWT.BORDER);
		moduleNameText.setLayoutData(gd);
		moduleNameText.setText(ModuleName);
		moduleNameText.setEnabled(false);

		moduleNameLabel = new Label(grp, SWT.NONE);
		moduleNameLabel.setEnabled(false);

		modulePathLabel = new Label(grp, SWT.NONE);
		modulePathLabel.setText(Messages.Module_symbol_file);

		moduleText = new Text(grp, SWT.BORDER);
		final GridData gdtxt = new GridData(450, SWT.DEFAULT);
		moduleText.setLayoutData(gdtxt);

		moduleFileBrowseButton = new Button(grp, SWT.NULL);
		moduleFileBrowseButton.setText(Messages.Browse_with_dots);
		moduleFileBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleBinaryBrowseButtonSelected();
			}

		});

	}

	/**
	 * 
	 */
	private void handleBinaryBrowseButtonSelected() {
		final FileDialog fileDialog = new FileDialog(moduleText.getShell(), SWT.NONE);
		fileDialog.setFileName(moduleText.getText());
		final String[] filterExt = { "*.ko", "*" }; //$NON-NLS-1$ //$NON-NLS-2$
		fileDialog.setFilterExtensions(filterExt);
		final String text = fileDialog.open();
		if (text != null) {
			moduleText.setText(text);
			moduleFullPath = text.toString();

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
		newShell.setText(Messages.Load_symbols_of_module); //$NON-NLS-1$
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

		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		final GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.minimumWidth = textWidth;
		parent.setLayoutData(gridData);
		final Composite composite = new Composite(parent, SWT.None);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		composite.setLayout(gridLayout);
		parent = composite;
		createModulePathBrowseGroup(parent, gridData);
		if (moduleFullPath != null) {
			moduleText.setText(moduleFullPath);
		}
		return parent;
	}

}
