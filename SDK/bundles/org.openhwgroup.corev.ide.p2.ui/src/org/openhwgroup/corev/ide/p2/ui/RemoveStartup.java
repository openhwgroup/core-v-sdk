package org.openhwgroup.corev.ide.p2.ui;

import org.eclipse.ui.IStartup;
import org.openhwgroup.corev.ide.internal.p2.ui.P2UiActivator;

public class RemoveStartup implements IStartup {

	@Override
	public void earlyStartup() {
		// FIXME: AF: to register policy
		P2UiActivator.getDefault();
	}

}
