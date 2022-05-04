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
package org.openhwgroup.corev.ide.ui.workbench;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.openhwgroup.corev.ide.ui.workbench.meta.Boards;
import org.openhwgroup.corev.ide.ui.workbench.meta.Debuggers;
import org.openhwgroup.corev.ide.ui.workbench.meta.PropertyNode;
import org.openhwgroup.corev.ide.ui.workbench.meta.SDKs;
import org.openhwgroup.corev.ide.ui.workbench.meta.Toolchains;

public final class ContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject) {
			return new PropertyNode[] { //
					new Toolchains((IProject) parentElement), //
					new Boards((IProject) parentElement), //
					new SDKs((IProject) parentElement), //
					new Debuggers((IProject) parentElement) };
		}
		if (parentElement instanceof PropertyNode) {
			return ((PropertyNode) parentElement).getChildren();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof PropertyNode) {
			return ((PropertyNode) element).project();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IProject || element instanceof PropertyNode) {
			return true;
		}
		return false;
	}

}
