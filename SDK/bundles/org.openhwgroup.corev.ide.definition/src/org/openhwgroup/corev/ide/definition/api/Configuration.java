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
package org.openhwgroup.corev.ide.definition.api;

import java.util.List;

/**
 * Class represents a single project configuration with all meta in it.
 * 
 * @author Nikifor Fedorov
 *
 */
public interface Configuration {

	/**
	 * @return list of all boards in current configuration
	 */
	List<Board> boards();

	/**
	 * @return list of all toolchains
	 */
	List<Toolchain> toolchains();

}
