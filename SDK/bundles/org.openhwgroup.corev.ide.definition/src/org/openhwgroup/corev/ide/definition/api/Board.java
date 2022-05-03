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

/**
 * Board accumulates the info about the board.
 * Use {@code DefinedBoard} as a default implementation
 * 
 * @author Nikifor Fedorov
 *
 */
public interface Board {

	/**
	 * An unique identifier for the board
	 * @return identifier
	 */
	String identifier();
	
	/**
	 * Any name to be displayed in user interface representation
	 * @return
	 */
	String title();
	
}
