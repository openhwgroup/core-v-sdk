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
package org.openhwgroup.corev.ide.definition.project;

import java.util.function.BiConsumer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.openhwgroup.corev.ide.definition.api.Configuration;
import org.openhwgroup.corev.ide.definition.api.Project;
import org.openhwgroup.corev.ide.definition.storage.WriteConfiguration;

public final class CreateProject implements BiConsumer<Project, IProgressMonitor> {

	@Override
	public void accept(Project data, IProgressMonitor monitor) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(data.name());
		if (!project.exists()) {
			try {
				IProjectDescription description = workspace.newProjectDescription(data.name());
				description.setLocation(new Path(data.path()));
				project.create(description, monitor);
				project.open(monitor);
				generateManifest(data.configuration(), monitor, project);
			} catch (CoreException e) {
				Platform.getLog(getClass()).log(e.getStatus());
			}
		}
	}

	private void generateManifest(Configuration data, IProgressMonitor monitor, IProject project) throws CoreException {
		IFile manifest = project.getFile("corev.mf"); //$NON-NLS-1$
		if (manifest.exists()) {
			manifest.delete(true, monitor);
		}
		manifest.create(new WriteConfiguration().apply(data), false, monitor);
	}

}
