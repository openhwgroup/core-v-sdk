/*******************************************************************************
 * Copyright (c) 2020 ArSysOp and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alexander Fedorov (ArSysOp) - initial API and implementation
 *******************************************************************************/
package org.openhwgroup.corev.ide.internal.toolchain.gnu.ui.wizards;

import org.eclipse.cdt.managedbuilder.ui.wizards.MBSCustomPage;
import org.eclipse.cdt.managedbuilder.ui.wizards.MBSCustomPageManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class GnuToolchainWizardPage extends MBSCustomPage {

	private static final String ID = "org.openhwgroup.corev.ide.mbs.gnu.ui.wizard.page.setup"; //$NON-NLS-1$
	private static final String WIZARD = "wizard"; //$NON-NLS-1$

	private Composite composite;

	public GnuToolchainWizardPage() {
		super(ID);
	}

	@Override
	public String getName() {
		return Messages.GnuToolchainWizardPage_page_name;
	}

	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
	}

	@Override
	public void dispose() {
		composite.dispose();
	}

	@Override
	public Control getControl() {
		return composite;
	}

	@Override
	public String getDescription() {
		return getTitle();
	}

	@Override
	public String getErrorMessage() {
		// TODO implement
		return null;
	}

	@Override
	public Image getImage() {
		// TODO implement
		return null;
	}

	@Override
	public String getMessage() {
		return Messages.GnuToolchainWizardPage_page_massage;
	}

	@Override
	public String getTitle() {
		return Messages.GnuToolchainWizardPage_page_title;
	}

	@Override
	public void performHelp() {
		MessageDialog.openInformation(getWizard().getContainer().getShell(), Messages.GnuToolchainWizardPage_help_title,
				Messages.GnuToolchainWizardPage_help_message);
	}

	@Override
	public void setDescription(String description) {
		// TODO implement
	}

	@Override
	public void setImageDescriptor(ImageDescriptor image) {
		// TODO implement
	}

	@Override
	public void setTitle(String title) {
		// TODO implement
	}

	@Override
	public void setWizard(IWizard newWizard) {
		super.setWizard(newWizard);
		MBSCustomPageManager.addPageProperty(ID, WIZARD, newWizard);
	}

	@Override
	public void setVisible(boolean visible) {
		composite.setVisible(visible);
	}

	@Override
	protected boolean isCustomPageComplete() {
		// TODO Auto-generated method stub
		return true;
	}

}
