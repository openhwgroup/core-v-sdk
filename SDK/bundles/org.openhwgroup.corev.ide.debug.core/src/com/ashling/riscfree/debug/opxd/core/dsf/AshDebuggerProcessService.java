/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf;

import java.util.Map;

import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.DsfExecutor;
import org.eclipse.cdt.dsf.concurrent.Sequence;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IContainerDMContext;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuProcesses_7_2_1;

/**
 * @author vinod.appu
 *
 */
public class AshDebuggerProcessService extends GnuMcuProcesses_7_2_1 {

	public AshDebuggerProcessService(DsfSession session) {
		super(session);
	}
	
	@Override
	protected Sequence getStartOrRestartProcessSequence(DsfExecutor executor, IContainerDMContext containerDmc,
			Map<String, Object> attributes, boolean restart, DataRequestMonitor<IContainerDMContext> rm) {
		if (restart) {
			return new AshRestartProcessSequence(executor, containerDmc, attributes, restart, rm);
		}
		return super.getStartOrRestartProcessSequence(executor, containerDmc, attributes, restart, rm);
	}

}
