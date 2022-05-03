/*******************************************************************************
 * Copyright (c) 2021 ArSysOp and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Nikifor Fedorov (ArSysOp) - initial API and implementation
 *******************************************************************************/
package org.openhwgroup.corev.ide.definition.ui.meta;

import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.openhwgroup.corev.ide.definition.project.DefinedBoard;
import org.openhwgroup.corev.ide.definition.storage.JsonStorage;

public final class DefineBoardWizard extends Wizard implements INewWizard {

	private String identifier = new String();
	private String title = new String();

	@Override
	public void addPages() {
		addPage(new Page());
	}

	@Override
	public boolean performFinish() {
		new JsonStorage().put(new DefinedBoard(identifier, title));
		return true;
	}

	private final class Page extends WizardPage {

		protected Page() {
			super("create_board"); //$NON-NLS-1$
			setTitle("Define new board"); //$NON-NLS-1$
			setDescription("Define new board from scratch"); //$NON-NLS-1$
		}

		@Override
		public void createControl(Composite parent) {
			Composite container = container(parent);
			createStringGroup(container, "Enter board identifier", value -> identifier = value); //$NON-NLS-1$
			createStringGroup(container, "Enter board display name", value -> title = value); //$NON-NLS-1$
			setControl(container);
		}

		private Composite container(Composite parent) {
			Composite container = new Composite(parent, SWT.NONE);
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).create());
			container.setLayoutData(GridDataFactory.fillDefaults().create());
			return container;
		}

		private void createStringGroup(Composite container, String hint, Consumer<String> modify) {
			Label label = new Label(container, SWT.NONE);
			label.setLayoutData(GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).create());
			label.setText(hint + ": "); //$NON-NLS-1$
			Text field = new Text(container, SWT.BORDER);
			field.setMessage(hint);
			field.setLayoutData(
					GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).span(2, 1).grab(true, false).create());
			field.addModifyListener(event -> {
				modify.accept(field.getText());
			});
		}

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Define new board"); //$NON-NLS-1$
	}

}
