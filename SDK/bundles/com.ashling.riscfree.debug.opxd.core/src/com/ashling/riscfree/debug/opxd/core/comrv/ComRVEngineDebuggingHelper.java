/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import org.eclipse.cdt.debug.gdbjtag.core.Activator;
import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExecutionDMContext;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.mi.service.IMICommandControl;
import org.eclipse.cdt.dsf.mi.service.IMIRunControl;
import org.eclipse.cdt.dsf.mi.service.command.CommandFactory;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.State;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

import com.ashling.riscfree.debug.opxd.core.dsf.IRISCVCommandFactory;


public enum ComRVEngineDebuggingHelper {
	INSTANCE;

	private static final String ENABLING_OR_DISABLING_ComRV_DEBUGGING_FAILED_NOREASON = "Enabling/Disabling ComRV debugging failed with unknown reason";
	private static DsfSession lastDebugSession = null;
	
	public void createOverlay(final DsfServicesTracker tracker, DsfSession debugSession, RequestMonitor requestMonitor) {
		IMICommandControl gdbCommandService = tracker.getService(IMICommandControl.class);
		IGDBControl gdbControlService = tracker.getService(IGDBControl.class);
		MIComRVEngineDebugging overlayCommand = null;
		if (gdbCommandService != null) {
			CommandFactory commandFactory = gdbCommandService.getCommandFactory();
			if (commandFactory instanceof IRISCVCommandFactory) {
				overlayCommand = ((IRISCVCommandFactory) commandFactory).createSkipComRVEngineDebugging(gdbCommandService.getContext(),ComRVUtil.isComRVEngineDebuggingEnabled);

			}
		}
		if (gdbControlService != null && overlayCommand != null) {
			gdbControlService.queueCommand(overlayCommand,
					new DataRequestMonitor<MIInfo>(debugSession.getExecutor(), requestMonitor) {
						@Override
						protected void handleCompleted() {
							if (isSuccess() && getData().isDone()) {
								requestMonitor.done();
							} else {
								MIInfo info = getData();
								requestMonitor.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
										info != null ? info.toString() : ENABLING_OR_DISABLING_ComRV_DEBUGGING_FAILED_NOREASON));
							}
						}
					});
		}
	}
	
	public boolean canExecute(final DsfServicesTracker tracker, DsfSession debugSession, IExecutionDMContext context)
	{
		if(lastDebugSession != debugSession)
		{
			//TODO: Temporary work-round this will work only if one RISC-V launch at a time. Now only single launch supported, we should support multiple launch case
			//New debug sessions started, the button status should be pressed
			lastDebugSession = debugSession;
			ComRVUtil.isComRVEngineDebuggingEnabled = true;
			ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
			Command comrv_engine_debugging_command = service.getCommand("com.ashling.riscfree.debug.comrv.enableenginedebugging");
			if(comrv_engine_debugging_command != null)
			{
				State state = comrv_engine_debugging_command.getState("com.ashling.riscfree.debug.opxd.overlay.toggleState");
				state.setValue(true);
			}
			service.refreshElements("com.ashling.riscfree.debug.comrv.enableenginedebugging", null);
		}
		
		IMIRunControl mirunControl = tracker.getService(IMIRunControl.class);
		if (mirunControl!= null && context != null && mirunControl.isSuspended(context)) {
			IComRVService comRVService = tracker.getService(IComRVService.class);
			//ComRVService will be available if and only if comRV debugging is enabled
			if (comRVService != null) {
				return true;
			}
		}

		return false;
	}
}
