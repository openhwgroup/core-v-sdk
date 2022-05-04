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
package org.openhwgroup.corev.ide.ui.workbench.meta;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.openhwgroup.corev.ide.definition.json.JsonConfiguration;
import org.openhwgroup.corev.ide.ui.workbench.Messages;

public final class Boards extends PropertyNode {

	public Boards(IProject project) {
		super(project);
	}

	@Override
	public String title() {
		return Messages.Boards_title;
	}

	@Override
	public Object[] getChildren() {
		try {
			IFile file = project().getFile("corev.mf"); //$NON-NLS-1$
			return new JsonConfiguration().apply(file.getContents()).boards().toArray();
		} catch (CoreException e) {
			Platform.getLog(getClass()).log(e.getStatus());
			return new Object[0];
		}
	}

}
