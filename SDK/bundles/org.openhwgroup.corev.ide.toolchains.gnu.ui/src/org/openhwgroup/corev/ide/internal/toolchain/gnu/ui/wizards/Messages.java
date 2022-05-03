/*******************************************************************************
 * Copyright (c) 2020 ArSysOp and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alexander Fedorov (ArSysOp) - initial API and implementation
 *******************************************************************************/
package org.openhwgroup.corev.ide.internal.toolchain.gnu.ui.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.openhwgroup.corev.ide.internal.toolchain.gnu.ui.wizards.messages"; //$NON-NLS-1$
	public static String GnuToolchainWizardPage_help_message;
	public static String GnuToolchainWizardPage_help_title;
	public static String GnuToolchainWizardPage_page_massage;
	public static String GnuToolchainWizardPage_page_name;
	public static String GnuToolchainWizardPage_page_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
