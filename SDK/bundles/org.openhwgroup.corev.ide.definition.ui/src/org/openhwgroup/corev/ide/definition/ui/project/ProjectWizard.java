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
package org.openhwgroup.corev.ide.definition.ui.project;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.openhwgroup.corev.ide.definition.api.Project;
import org.openhwgroup.corev.ide.definition.project.CoreVProject;
import org.openhwgroup.corev.ide.definition.project.CreateProject;

public class ProjectWizard extends Wizard implements INewWizard {

	private final DefinePage page = new DefinePage();

	public ProjectWizard() {
		setWindowTitle("New CORE-V project"); //$NON-NLS-1$
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	@Override
	public void addPages() {
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		final Project project = new CoreVProject(page.name(), page.path(), page.configuration());
		Job job = Job.create("Creating CORE-V project", monitor -> { //$NON-NLS-1$
			new CreateProject().accept(project, monitor);
		});
		job.schedule();
		return true;
	}

}
