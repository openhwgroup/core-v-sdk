package org.openhwgroup.corev.ide.internal.p2.ui;

import org.eclipse.equinox.p2.engine.IProvisioningPlan;
import org.eclipse.equinox.p2.operations.ProfileChangeOperation;
import org.eclipse.equinox.p2.ui.Policy;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.component.annotations.Component;

@Component(service = Policy.class, property = "service.ranking:Integer=1")
public final class CorevPolicy extends Policy {

	@Override
	public boolean continueWorkingWithOperation(ProfileChangeOperation operation, Shell shell) {
		// don't continue if superclass has already identified problem scenarios
		boolean ok = super.continueWorkingWithOperation(operation, shell);
		if (!ok) {
			return false;
		}
		IProvisioningPlan plan = operation.getProvisioningPlan();
		if (plan == null) {
			return false;
		}
		// FIXME: hook Passage here
		return ok;
	}

}
