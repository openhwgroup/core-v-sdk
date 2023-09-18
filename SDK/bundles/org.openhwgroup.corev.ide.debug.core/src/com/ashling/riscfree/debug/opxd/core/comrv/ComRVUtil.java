/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import org.eclipse.core.runtime.Platform;

import com.ashling.riscfree.debug.opxd.core.utils.BundleAvailabilityChecker;

/**
 * @author vinod.appu
 *
 */
public class ComRVUtil {

	// TODO: There should be a better approach to handle the
	// isComRVEngineDebuggingEnabled flag, check the usage for more details
	public static boolean isComRVEngineDebuggingEnabled = true;

	/**
	 * Return true if the product build with comrv plugins
	 * 
	 * @return
	 */
	public static boolean isComRVBundlesAvailable() {
		return BundleAvailabilityChecker.isComRVBundlesAvailable();
	}
}
