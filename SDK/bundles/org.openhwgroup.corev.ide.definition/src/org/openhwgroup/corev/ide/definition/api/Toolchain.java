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
 * Toolchain describes a toolchain for your board(s).
 * Use {@code DefinedToolchain} as a default implementation.
 * @author Nikifor Fedorov
 *
 */
public interface Toolchain {
	
	/**
	 * An unique identifier for the toolchain
	 * @return identifier
	 */
	String identifier();
	
	/**
	 * Any name to be displayed in user interface representation
	 * @return title
	 */
	String title();
	
	/**
	 * A path to the <b>root</b> folder of the toolchain
	 * @return the string representation of path
	 */
	String path();
	
	/**
	 * List of all boards identifiers this toolchain is applicable to
	 * @return list of boards for the toolchain
	 */
	List<String> boards();

}
