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

import org.openhwgroup.corev.ide.definition.api.Board;
import org.openhwgroup.corev.ide.definition.api.Configuration;
import org.openhwgroup.corev.ide.definition.api.Toolchain;

public final class SimpleConfiguration implements Configuration {

	private final List<Board> boards;
	private final List<Toolchain> toolchains;

	public SimpleConfiguration(List<Board> boards, List<Toolchain> toolchains) {
		this.boards = boards;
		this.toolchains = toolchains;
	}

	@Override
	public List<Board> boards() {
		return boards;
	}

	@Override
	public List<Toolchain> toolchains() {
		return toolchains;
	}

}
