package com.ashling.riscfree.debug.multicore.dsf;

import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.cdt.dsf.service.IDsfService;
import org.osgi.framework.BundleContext;

import com.ashling.riscfree.debug.multicore.model.MulticoreConstants;

/**
 * @author vinod.appu
 *
 * @implNote DsfService able to track core specific services in a session.
 */
public class CoreDsfServicesTracker extends DsfServicesTracker implements ICoreDsfServiceTracker {
	private String coreId;
	private String sessionId;

	public CoreDsfServicesTracker(BundleContext bundleContext, String sessionId, String coreId) {
		super(bundleContext, sessionId);
		this.coreId = coreId;
		this.sessionId = sessionId;
	}

	// Here we redirect to the core specific service
	@Override
	public <V> V getService(Class<V> serviceClass) {
		StringBuilder builder = new StringBuilder();
		builder.append("(&");
		builder.append(String.format(MulticoreConstants.CORE_FILTER, coreId));
		builder.append("(");
		builder.append(IDsfService.PROP_SESSION_ID);
		builder.append("=");
		builder.append(sessionId);
		builder.append("))");
		return super.getService(serviceClass, builder.toString().intern());
	}

	// Here we redirect to the core specific service
	@Override
	public <V> V getService(Class<V> serviceClass, String filter) {
		return getService(serviceClass, null);
	}
}
