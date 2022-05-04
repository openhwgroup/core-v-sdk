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
package org.openhwgroup.corev.ide.ui.intro;

import java.util.Properties;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.openhwgroup.corev.ide.definition.ui.project.ProjectWizard;

public final class CreateProjectAction implements IIntroAction {

	@Override
	public void run(IIntroSite site, Properties params) {
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		if (shell != null) {
			new WizardDialog(shell, new ProjectWizard()).open();
		}

	}

}
