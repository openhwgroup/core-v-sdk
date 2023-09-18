/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf.memory;

import org.eclipse.cdt.dsf.debug.model.DsfMemoryBlockRetrieval;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IMemoryBlockRetrieval;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GdbMcuMemoryBlockRetrievalManager;

import com.ashling.riscfree.debug.opxd.core.Activator;

/**
 * @author vinod.appu
 * Overridden to support - git-lab # 470, Advance ComRV features 
 *
 */
public class AshMemoryBlockRetrievalManager extends GdbMcuMemoryBlockRetrievalManager {

	/**
	 * @param modelId
	 * @param config
	 * @param session
	 */
	public AshMemoryBlockRetrievalManager(String modelId, ILaunchConfiguration config, DsfSession session) {
		super(modelId, config, session);
	}

	@Override
	protected IMemoryBlockRetrieval createMemoryBlockRetrieval(String model, ILaunchConfiguration config,
			DsfSession session) {
		DsfMemoryBlockRetrieval memRetrieval = null;

		try {
			memRetrieval = new AshMemoryBlockRetrieval(model, config, session);
		} catch (DebugException e) {
			Activator.log(e.getStatus());
		}

		return memRetrieval;
	}

}
