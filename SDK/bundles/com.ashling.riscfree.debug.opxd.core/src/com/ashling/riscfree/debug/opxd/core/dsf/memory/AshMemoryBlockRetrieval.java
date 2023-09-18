/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf.memory;

import java.math.BigInteger;

import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.IMemory.IMemoryDMContext;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.embedcdt.debug.gdbjtag.core.memory.PeripheralMemoryBlockRetrieval;

import com.ashling.riscfree.debug.opxd.core.comrv.IComRVService;
import com.ashling.riscfree.debug.opxd.core.utils.DSFUtility;

/**
 * @author vinod.appu
 * Overridden to support - git-lab # 470, Advance ComRV features 
 *
 */
public class AshMemoryBlockRetrieval extends PeripheralMemoryBlockRetrieval {

	private ILaunchConfiguration launchConfig;
	private boolean isComRVLaunch;

	/**
	 * @param modelId
	 * @param config
	 * @param session
	 * @throws DebugException
	 */
	public AshMemoryBlockRetrieval(String modelId, ILaunchConfiguration config, DsfSession session)
			throws DebugException {
		super(modelId, config, session);
		this.launchConfig = config;
	}

	@Override
	protected BigInteger resolveMemoryAddress(IDMContext dmc, String expression) throws DebugException {
		// TODO: This is a tricky part, the expression can be an overlay symbol but it
		// can be otherwise too
		IComRVService comRVService = DSFUtility.INSTANCE.getComRVService(dmc);
		if(comRVService == null)
		{
			return super.resolveMemoryAddress(dmc, expression);
		}
		isComRVLaunch = true;
		if (comRVService.isOverlaySymbol(expression)) {
			if (comRVService.isLoadedOverlaySymbol(expression)) {
				return new BigInteger(comRVService.getLoadedPhysicalAddress(expression), 16);
			} else {
				DSFUtility.INSTANCE.openWarning("Go to symbol", "ComRV symbol " + expression + " is not loaded.", null);
				return super.resolveMemoryAddress(dmc, expression);
			}
		} else {
			return super.resolveMemoryAddress(dmc, expression);
		}
	}

	@Override
	protected void createBlocksFromConfiguration(IMemoryDMContext memoryCtx, String memento) throws CoreException {
		// Nothing to do if it's a ComRV launch
		IDMContext dmc= memoryCtx.getAdapter(IDMContext.class);
		if (null == DSFUtility.INSTANCE.getComRVService(dmc)) {
			super.createBlocksFromConfiguration(memoryCtx, memento);
		}
	}
	
	@Override
	public void saveMemoryBlocks() {
		// Nothing to do if it's a ComRV launch
		if (!isComRVLaunch) {
			super.saveMemoryBlocks();
		}
	}
}
