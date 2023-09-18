/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf;

import java.util.Map;

import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.DsfExecutor;
import org.eclipse.cdt.dsf.concurrent.ReflectionSequence.Execute;
import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IContainerDMContext;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuRestartProcessSequence;

import com.ashling.riscfree.debug.opxd.core.Activator;

/**
 * @author vinod.appu
 *
 */
public class AshRestartProcessSequence extends GnuMcuRestartProcessSequence {
	private DsfServicesTracker fTracker;

	public AshRestartProcessSequence(DsfExecutor executor, IContainerDMContext containerDmc,
			Map<String, Object> attributes, boolean restart, DataRequestMonitor<IContainerDMContext> rm) {
		super(executor, containerDmc, attributes, restart, rm);
	}

	@Override
	protected String[] getExecutionOrder(String group) {
		if (GROUP_TOP_LEVEL.equals(group)) {
			return new String[] { 
					"stepStopTargetStatusService", //$NON-NLS-1$
					"stepInitializeBaseSequence", //$NON-NLS-1$
					"stepRestartCommands", //$NON-NLS-1$
					"stepStartTargetStatusService", //$NON-NLS-1$
			};
		}
		return null;
	}
	
	@Execute
	public void stepStopTargetStatusService(final RequestMonitor rm)
	{
		fTracker = new DsfServicesTracker(Activator.getDefault().getBundle().getBundleContext(),
				getContainerContext().getSessionId());
		ITargetStatusService targetStatusService = fTracker.getService(ITargetStatusService.class);
		if (targetStatusService != null) {
			targetStatusService.stopStatusPolling();
		}
		fTracker.dispose();
		rm.done();
	}
	
	@Execute
	public void stepStartTargetStatusService(final RequestMonitor rm)
	{
		fTracker = new DsfServicesTracker(Activator.getDefault().getBundle().getBundleContext(),
				getContainerContext().getSessionId());
		ITargetStatusService targetStatusService = fTracker.getService(ITargetStatusService.class);
		if (targetStatusService != null) {
			targetStatusService.startStatusPolling();
		}
		fTracker.dispose();
		rm.done();
	}
}
