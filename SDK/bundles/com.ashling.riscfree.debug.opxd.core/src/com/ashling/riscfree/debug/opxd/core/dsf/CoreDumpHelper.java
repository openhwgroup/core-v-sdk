/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf;

import org.eclipse.cdt.debug.gdbjtag.core.Activator;
import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.DsfExecutor;
import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExecutionDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.mi.service.IMICommandControl;
import org.eclipse.cdt.dsf.mi.service.IMIRunControl;
import org.eclipse.cdt.dsf.mi.service.command.CommandFactory;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author vinod.appu
 *
 */
/**
 * 
 * Sample usage of the utility is below.
 * 
 * CoreDumpHelper.INSTANCE.createCoreDump(DsfSession.getActiveSessions()[0],
 * "C:\\dump.bin", new ImmediateRequestMonitor() {
 * 
 * @Override protected void handleCompleted() { System.out.println("Is Success =
 *           " + isSuccess()); } });
 *
 */
public enum CoreDumpHelper {
	INSTANCE;

	private static final String CORE_DUMP_FAILED_NOREASON = "Core dump failed with unknown reason";

	public void createCoreDump(final DsfServicesTracker tracker, DsfExecutor dsfExecutor, String absoluteFilePath,
			RequestMonitor requestMonitor) {
		IMICommandControl gdbCommandService = tracker.getService(IMICommandControl.class);
		IGDBControl gdbControlService = tracker.getService(IGDBControl.class);
		MICoreDump coreDumpCommand = null;
		if (gdbCommandService != null) {
			CommandFactory commandFactory = gdbCommandService.getCommandFactory();
			if (commandFactory instanceof IAshCommandFactory) {
				coreDumpCommand = ((IAshCommandFactory) commandFactory)
						.createCLICoreDump(gdbCommandService.getContext(), absoluteFilePath);

			}
		}
		if (gdbControlService != null && coreDumpCommand != null) {
			gdbControlService.queueCommand(coreDumpCommand,
					new DataRequestMonitor<MIInfo>(dsfExecutor, requestMonitor) {
						@Override
						protected void handleCompleted() {
							if (isSuccess() && getData().isDone()) {
								requestMonitor.done();
							} else {
								MIInfo info = getData();
								requestMonitor.done(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
										info != null ? info.toString() : CORE_DUMP_FAILED_NOREASON));
							}
						}
					});
		}
		tracker.dispose();
	}

	public boolean canExecute(DsfSession debugSession, IExecutionDMContext context) {
		final DsfServicesTracker tracker = new DsfServicesTracker(Activator.getBundleContext(), debugSession.getId());
		IMIRunControl mirunControl = tracker.getService(IMIRunControl.class);
		if (context != null && mirunControl.isSuspended(context)) {
			IMICommandControl gdbCommandService = tracker.getService(IMICommandControl.class);
			if (gdbCommandService != null) {
				CommandFactory commandFactory = gdbCommandService.getCommandFactory();
				if (commandFactory instanceof IAshCommandFactory) {
					return true;
				}
			}
		}

		return false;
	}
}
