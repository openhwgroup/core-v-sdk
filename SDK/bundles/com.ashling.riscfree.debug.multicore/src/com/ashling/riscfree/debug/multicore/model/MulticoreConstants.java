package com.ashling.riscfree.debug.multicore.model;
/**
 * Constants used for multicore debug
 * 
 * @author vinod.appu
 *
 */
public final class MulticoreConstants {
	private MulticoreConstants() {
	}

	// TODO: There was a typo in v132 release, so need to keep the old typo here to
	// make the launch configurations backward compatible.
	public static final String OLD_PLUGIN_ID = "com.asling.riscfree.debug.multicore";
	public static final String CORE_ID_FILTER = "CORE_ID";
	public static final String CORE_ATTRIBUTE_START = "_##_CORE_";
	public static final String CORE_NAME_FORMAT = CORE_ATTRIBUTE_START + "%s";
	public static final String CORE_ATTRIBUTE_FORMAT = CORE_ATTRIBUTE_START + "%s_%s"; //$NON-NLS-1$
	public static final String CORE_DEBUG_CONFIGURATION = OLD_PLUGIN_ID + ".CORE_DEBUG_CONFIGURATION";
	public static final String CORE_FILTER = "(" + CORE_ID_FILTER + "=" + "%s)";
	public static final String CORE_PROGRAMS_ATTRIBUTES = OLD_PLUGIN_ID + ".CORE_PROGRAMS";
	public static final String CORE_DEBUGGER_ID = OLD_PLUGIN_ID + ".CORE_DEBUGGER_ID";
	public static final String RISCV_DEBUGGER_ID="1";
	public static final String ARC_DEBUGGER_ID="2";
	public static final String ARM_DEBUGGER_ID="3";
}
