/**
 *
 */
package com.ashling.riscfree.debug.multicore.util;

import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExecutionDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.cdt.dsf.service.IDsfService;

import com.ashling.riscfree.debug.multicore.model.MulticoreConstants;

/**
 * @author vinod.appu
 *
 * @implNote Utility methods to track core specific services
 */
public final class MulticoreServiceUtility {

	private MulticoreServiceUtility() {
	}

	public static <V> V trackCoreService(Class<V> serviceClass, DsfServicesTracker tracker, String coreId,
			DsfSession session) {
		StringBuilder builder = new StringBuilder();
		builder.append("(&");
		builder.append(String.format(MulticoreConstants.CORE_FILTER, coreId));
		builder.append("(");
		builder.append(IDsfService.PROP_SESSION_ID);
		builder.append("=");
		builder.append(session.getId());
		builder.append("))");
		return tracker.getService(serviceClass, builder.toString().intern());
	}
	
	public static <V> V trackCoreService(Class<V> serviceClass, DsfServicesTracker tracker, IDMContext dmc) {
		ICommandControlDMContext commandControlDMC = DMContexts.getAncestorOfType(dmc, ICommandControlDMContext.class);
		if(commandControlDMC == null)
		{
			return null;
		}
		String coreId = commandControlDMC.getCommandControlId();		
		StringBuilder builder = new StringBuilder();
		builder.append("(&");
		builder.append(String.format(MulticoreConstants.CORE_FILTER, coreId));
		builder.append("(");
		builder.append(IDsfService.PROP_SESSION_ID);
		builder.append("=");
		builder.append(dmc.getSessionId());
		builder.append("))");
		return tracker.getService(serviceClass, builder.toString().intern());
	}
}
