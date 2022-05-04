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

import java.util.List;

import org.openhwgroup.corev.ide.definition.api.Toolchain;

public final class DefinedToolchain implements Toolchain {

	private final String identifier;
	private final String title;
	private final String path;
	private final List<String> boards;

	public DefinedToolchain(String identifier, String title, String path, List<String> boards) {
		this.identifier = identifier;
		this.title = title;
		this.path = path;
		this.boards = boards;
	}

	@Override
	public String identifier() {
		return identifier;
	}

	@Override
	public String title() {
		return title;
	}

	@Override
	public String path() {
		return path;
	}

	@Override
	public List<String> boards() {
		return boards;
	}

}
