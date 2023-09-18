/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.dsf.disassembly;

import org.eclipse.cdt.debug.internal.ui.disassembly.dsf.IDisassemblyBackend;
import org.eclipse.cdt.dsf.debug.internal.ui.disassembly.DisassemblyBackendDsf;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.cdt.dsf.ui.viewmodel.datamodel.IDMVMContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;

/**
 * @author vinod.appu
 * Overridden to support - git-lab # 470, Advance ComRV features 
 *
 */
@SuppressWarnings("restriction")
public class AshDisassemblyBackendDsfFactory implements IAdapterFactory {

	private static final Class<?>[] ADAPTERS = { IDisassemblyBackend.class };

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (IDisassemblyBackend.class.equals(adapterType)) {
			if (adaptableObject instanceof IAdaptable
					&& DisassemblyBackendDsf.supportsDebugContext_((IAdaptable) adaptableObject)) {
				String sessionId = ((IDMVMContext) adaptableObject).getDMContext().getSessionId();
				DsfSession session = DsfSession.getSession(sessionId);
				if (session.isActive()) {
					return (T) new AshDisassemblyBackend();
				}
			}
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return ADAPTERS;
	}

}
