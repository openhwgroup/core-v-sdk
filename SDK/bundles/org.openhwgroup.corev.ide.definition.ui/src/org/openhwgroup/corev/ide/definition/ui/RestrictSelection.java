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
package org.openhwgroup.corev.ide.definition.ui;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.List;

public class RestrictSelection implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		deselect(e);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		deselect(e);
	}

	private void deselect(SelectionEvent e) {
		List list = (List) e.widget;
		list.deselectAll();
	}

}
