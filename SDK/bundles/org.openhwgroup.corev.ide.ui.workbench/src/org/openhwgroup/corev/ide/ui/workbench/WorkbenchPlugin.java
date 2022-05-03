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
package org.openhwgroup.corev.ide.ui.workbench;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.openhwgroup.corev.ide.ui.workbench.meta.Boards;
import org.openhwgroup.corev.ide.ui.workbench.meta.Debuggers;
import org.openhwgroup.corev.ide.ui.workbench.meta.SDKs;
import org.openhwgroup.corev.ide.ui.workbench.meta.Toolchains;
import org.osgi.framework.BundleContext;

public class WorkbenchPlugin extends AbstractUIPlugin {

	private static AbstractUIPlugin plugin;
	private BundleContext context;

	public static AbstractUIPlugin getDefault() {
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry registry) {
		addIcon(registry, Boards.class.getName(), "images/board.png"); //$NON-NLS-1$
		addIcon(registry, Toolchains.class.getName(), "images/shell.png"); //$NON-NLS-1$
		addIcon(registry, SDKs.class.getName(), "images/box.png"); //$NON-NLS-1$
		addIcon(registry, Debuggers.class.getName(), "images/debug.png"); //$NON-NLS-1$
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		this.context = context;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		this.context = null;
		plugin = null;
	}

	private void addIcon(ImageRegistry registry, String key, String path) {
		URL url = FileLocator.find(context.getBundle(), new Path(path), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		registry.put(key, image);
	}

}
