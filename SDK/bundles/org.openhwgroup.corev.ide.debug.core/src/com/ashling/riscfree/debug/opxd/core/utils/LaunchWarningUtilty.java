package com.ashling.riscfree.debug.opxd.core.utils;

import org.eclipse.core.runtime.IStatus;

import com.ashling.riscfree.debug.opxd.core.ui.Messages;

/**
 * Helper for showing warning/error messages during the launch.
 * 
 */
public class LaunchWarningUtilty {

	private LaunchWarningUtilty() {
	}

	public static void showStartUpBpFailureWarning(IStatus status) {
		DSFUtility.INSTANCE.openWarning(Messages.getString("startupBpFailure.warning_title"),
				new StringBuilder("\"").append(status.getMessage()).append("\"\n\n")
						.append(Messages.getString("startupBpFailure.warning_message")).toString(),
				null);
	}

}
