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

import org.openhwgroup.corev.ide.definition.api.Board;

public final class DefinedBoard implements Board {

	private final String identifier;
	private final String title;

	public DefinedBoard(String identifier, String title) {
		this.identifier = identifier;
		this.title = title;
	}

	@Override
	public String identifier() {
		return identifier;
	}

	@Override
	public String title() {
		return title;
	}

}
