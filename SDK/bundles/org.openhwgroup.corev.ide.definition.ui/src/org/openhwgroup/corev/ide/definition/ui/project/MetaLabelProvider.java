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

import org.eclipse.jface.viewers.LabelProvider;
import org.openhwgroup.corev.ide.definition.api.Board;
import org.openhwgroup.corev.ide.definition.api.Toolchain;

public final class MetaLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof Toolchain) {
			return ((Toolchain) element).title();
		}
		if (element instanceof Board) {
			return ((Board) element).title();
		}
		return super.getText(element);
	}

}
