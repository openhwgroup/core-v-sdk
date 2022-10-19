package com.ashling.riscfree.debug.osawareness.linux.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ashling.riscfree.debug.osawareness.linux.Activator;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;

/**
 * Default handler for List Process command.
 *
 */
public class ListProcessHandler extends AbstractHandler {
	private static String PROCESS_VIEW = "com.ashling.riscfree.debug.osawareness.linux.process";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		OSAwarenessDebugUtil.performLinuxAction(()->{
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
			if (window != null) {
				IWorkbenchPage page = window.getActivePage();
				if(page != null) {
					try {
						page.showView(PROCESS_VIEW);
					} catch (PartInitException e) {
						Activator.log(e);
					}
				}
			}
		});
		return null;
	}
}
