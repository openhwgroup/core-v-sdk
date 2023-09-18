/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf.disassembly;

import java.math.BigInteger;

import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.internal.ui.disassembly.DisassemblyBackendDsf;
import org.eclipse.cdt.dsf.ui.viewmodel.datamodel.IDMVMContext;
import org.eclipse.core.runtime.IAdaptable;

import com.ashling.riscfree.debug.opxd.core.comrv.IComRVService;
import com.ashling.riscfree.debug.opxd.core.utils.DSFUtility;

/**
 * @author vinod.appu
 * Overridden to support - git-lab # 470, Advance ComRV features 
 *
 */
@SuppressWarnings("restriction")
public class AshDisassemblyBackend extends DisassemblyBackendDsf {

	private volatile IDMContext dmContext;

	@Override
	public void gotoSymbol(final String symbol) {
		if (!hasFrameContext()) {
			return;
		}
	}

	@Override
	public BigInteger evaluateAddressExpression(String symbol, boolean suppressError) {
		// Without a suspended context, using the expressions service is pointless.
		if (!hasFrameContext()) {
			return null;
		}

		IComRVService comRVService = DSFUtility.INSTANCE.getComRVService(dmContext);
		if (comRVService == null) {
			return super.evaluateAddressExpression(symbol, suppressError);
		}
		if (comRVService.isOverlaySymbol(symbol)) {
			if (comRVService.isLoadedOverlaySymbol(symbol)) {
				return new BigInteger(comRVService.getLoadedPhysicalAddress(symbol), 16);
			} else {
				DSFUtility.INSTANCE.openWarning("Go to symbol", "ComRV symbol \"" + symbol + "\" is not loaded, proceeding with the virtual address from ELF.", null);
				return super.evaluateAddressExpression(symbol, suppressError);
			}
		}
		return super.evaluateAddressExpression(symbol, suppressError);
	}

	@Override
	public SetDebugContextResult setDebugContext(IAdaptable context) {
		IDMVMContext vmContext = context.getAdapter(IDMVMContext.class);
		dmContext = vmContext.getDMContext();
		return super.setDebugContext(context);
	}
}
