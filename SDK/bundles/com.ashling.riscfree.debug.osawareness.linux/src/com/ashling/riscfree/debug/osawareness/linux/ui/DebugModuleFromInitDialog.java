/*******************************************************************************
 * Copyright (c) 2009 Ashling Microsystems Ltd.
 * All rights reserved. 
 * This software is the confidential and proprietary information of 
 * Ashling Microsystems Ltd. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ashling.

 *******************************************************************************/

package com.ashling.riscfree.debug.osawareness.linux.ui;

import java.io.File;

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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ashling.riscfree.debug.osawareness.linux.Messages;

public class DebugModuleFromInitDialog extends Dialog implements ModifyListener, SelectionListener {

	private Text moduleText;
	private File moduleFile;
	private Label moduleName;
	private Label moduleLinux;
	private Button moduleFileBrowseButton;
	final private int textWidth = 300;
	static private DebugModuleFromInitDialog debugModuleFromInitdlg = null;
	private Button btnOK;

	public static DebugModuleFromInitDialog getDefault(Shell parentShell) {
		if (debugModuleFromInitdlg == null) {
			debugModuleFromInitdlg = new DebugModuleFromInitDialog(parentShell);
		}
		return debugModuleFromInitdlg;
	}

	/**
	 * 
	 * @param parentShell
	 */
	private DebugModuleFromInitDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	/**
	 * 
	 * @param parentShell
	 */
	protected DebugModuleFromInitDialog(IShellProvider parentShell) {
		super(parentShell);
	}

	/**
	 * 
	 * @return
	 */
	public File getText() {
		return moduleFile;
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

	/**
	 * 
	 * @param comp
	 * @param gd
	 */
	private void createModuleGroup(Composite comp, GridData gd) {
		final Group grp = new Group(comp, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		grp.setLayout(layout);
		grp.setLayoutData(gd);

		moduleName = new Label(grp, SWT.NONE);
		moduleName.setText(Messages.Module_name); //$NON-NLS-1$

		moduleText = new Text(grp, SWT.BORDER);
		final GridData gdtxt = new GridData(450, SWT.DEFAULT);
		moduleText.setLayoutData(gdtxt);

		moduleText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent evt) {
				final IPath exePath = new Path(moduleText.getText());
				moduleFile = exePath.toFile();
				if (moduleFile.exists()) {
					btnOK.setEnabled(true);
				} else {
					btnOK.setEnabled(false);
				}
			}
		});

		moduleFileBrowseButton = new Button(grp, SWT.NULL);
		moduleFileBrowseButton.setText(Messages.Browse);

		moduleLinux = new Label(grp, SWT.NONE);
		moduleLinux.setEnabled(false);
		moduleFileBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleBinaryBrowseButtonSelected();
			}

		});
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

		// use the same title used by the platform dialog
		newShell.setText(Messages.Debug_module_from_init); //$NON-NLS-1$
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
		createModuleGroup(parent, gridData);
		return parent;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		btnOK = createButton(parent, IDialogConstants.OK_ID, Messages.Debug, true); //$NON-NLS-1$
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		btnOK.setEnabled(false);
		if (moduleFile != null) {
			moduleText.setText(moduleFile.toString());
		}
	}

	/**
	 * 
	 */
	void handleBinaryBrowseButtonSelected() {
		final FileDialog fileDialog = new FileDialog(moduleText.getShell(), SWT.NONE);
		fileDialog.setFileName(moduleText.getText());
		final String[] filterExt = { "*.ko", "*" }; //$NON-NLS-1$ //$NON-NLS-2$
		fileDialog.setFilterExtensions(filterExt);
		final String text = fileDialog.open();
		if (text != null) {
			moduleText.setText(text);
			final IPath exePath = new Path(text);

			moduleFile = exePath.toFile();

		}
	}

}
