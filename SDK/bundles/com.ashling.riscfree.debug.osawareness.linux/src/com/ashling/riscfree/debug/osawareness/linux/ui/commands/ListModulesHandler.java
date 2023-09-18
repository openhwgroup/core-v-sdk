package com.ashling.riscfree.debug.osawareness.linux.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ashling.riscfree.debug.osawareness.linux.Activator;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;

/**
 * Default handler for List Modules command.
 *
 */
public class ListModulesHandler extends AbstractHandler {
	private static String MODULES_VIEW = "com.ashling.riscfree.debug.osawareness.linux.modules";

	@Override
	public Object execute(ExecutionEvent event) {
		OSAwarenessDebugUtil.performLinuxAction(() -> {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
			if (window != null) {
				IWorkbenchPage page = window.getActivePage();
				if (page != null) {
					try {
						page.showView(MODULES_VIEW);
					} catch (PartInitException e) {
						Activator.log(e);
					}
				}
			}
		});
		return null;
	}

}
