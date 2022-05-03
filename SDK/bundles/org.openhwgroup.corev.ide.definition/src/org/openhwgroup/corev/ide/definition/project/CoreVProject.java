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

import org.openhwgroup.corev.ide.definition.api.Configuration;
import org.openhwgroup.corev.ide.definition.api.Project;

public final class CoreVProject implements Project {

	private final String name;
	private final String path;
	private final Configuration configuration;

	public CoreVProject(String name, String path, Configuration configuration) {
		this.name = name;
		this.path = path;
		this.configuration = configuration;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String path() {
		return path;
	}

	@Override
	public Configuration configuration() {
		return configuration;
	}

}
