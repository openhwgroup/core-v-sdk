package com.ashling.riscfree.debug.opxd.core.utils;

import org.eclipse.core.runtime.Platform;

public class BundleAvailabilityChecker {
	private BundleAvailabilityChecker() {

	}
	
	public static final String COMRV_BUNDLE_NAME = "com.ashling.riscfree.debug.overlay.comrv";
	
	public static final String MIPS_BUNDLE_NAME = "com.ashling.riscfree.managedbuild.cross.mips";
	
	public static final String GCOV_BUNDLE_NAME = "org.eclipse.linuxtools.gcov.core";
	
	public static final String OS_AWARENESS_BUNDLE_NAME = "com.ashling.riscfree.debug.osawareness.ui";
	
	public static final String INTEL_BUNDLE_NAME= "com.ashling.riscfree.managedbuild.cross.intelriscv.core";

	public static final String OPXD_ARC_BUNDLE_NAME= "com.ashling.riscfree.debug.opxd.arc";
	
	public static final String OPXD_ARM_BUNDLE_NAME= "com.ashling.riscfree.debug.opxd.arm";
	
	/**
	 * Return true if the product build with comrv plugins
	 * 
	 * @return
	 */
	public static boolean isComRVBundlesAvailable() {
		return Platform.getBundle(COMRV_BUNDLE_NAME) != null ? true : false;
	}
	
	/**
	 * Return true if the product build with MIPS plugins
	 * 
	 * @return
	 */
	public static boolean isMIPSBundlesAvailable() {
		return Platform.getBundle(MIPS_BUNDLE_NAME) != null ? true : false;
	}
	
	public static boolean isGCOVBundleAvailable() {
		return Platform.getBundle(GCOV_BUNDLE_NAME) != null ? true : false;
	}
	
	public static boolean isOSAwarenessBundleAvailable() {
		return Platform.getBundle(OS_AWARENESS_BUNDLE_NAME) != null ? true : false;
	}
	
	public static boolean isINTELBundleAvailable() {
		return Platform.getBundle(INTEL_BUNDLE_NAME) != null ? true : false;
	}
	
	public static boolean isGeneralProduct() {
		return Platform.getBundle(OPXD_ARC_BUNDLE_NAME) != null && Platform.getBundle(OPXD_ARM_BUNDLE_NAME) != null;
	}
}
