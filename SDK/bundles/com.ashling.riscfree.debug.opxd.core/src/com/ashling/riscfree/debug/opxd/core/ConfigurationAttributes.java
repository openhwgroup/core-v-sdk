/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core;

/**
 * @author vinod.appu
 *
 */
public interface ConfigurationAttributes extends org.eclipse.embedcdt.debug.gdbjtag.core.ConfigurationAttributes{
	public static final String RISCFREE_PREFIX = Activator.PLUGIN_ID;

	public static final String GDB_SERVER_TARGET_CORE_KEY = ".targetCore";
	public static final String GDB_SERVER_TARGET_DEVICE_KEY = ".targetDevice";
	public static final String GDB_SERVER_TAP_NUMBER_KEY = ".tapNumber";
	public static final String GDB_SERVER_TARGET_REG_FILE_KEY = ".targetRegFile";
	public static final String GDB_SERVER_JTAG_FREQUENCY_KEY = ".jtagFrequency";
	public static final String GDB_SERVER_DEBUGGER_INSTANCE_KEY = ".deviceName";
	public static final String GDB_SERVER_DEBUGGER_PROBE_TYPE = RISCFREE_PREFIX + ".probeType";

	// TODO: @Promod, if the original key changed in some case, it's going to break
	// us!
	public static final String GDBTAG_PREFIX = "org.eclipse.cdt.debug.gdbjtag.core";

	// These are the migrated keys used from the existing launch configuration
	public static final String GDB_SERVER_TARGET_DEVICE = RISCFREE_PREFIX + GDB_SERVER_TARGET_DEVICE_KEY;
	public static final String GDB_SERVER_JTAG_FREQUENCY = RISCFREE_PREFIX + GDB_SERVER_JTAG_FREQUENCY_KEY;
	public static final String GDB_SERVER_DEBUGGER_INSTANCE = RISCFREE_PREFIX + GDB_SERVER_DEBUGGER_INSTANCE_KEY;

	public static final String GDB_SERVER_TARGET_CORE = RISCFREE_PREFIX + GDB_SERVER_TARGET_CORE_KEY; // $NON-NLS-1$
	public static final String GDB_SERVER_TARGET_REG_FILE = RISCFREE_PREFIX + GDB_SERVER_TARGET_REG_FILE_KEY; // $NON-NLS-1$
	public static final String GDB_SERVER_TAP_NUMBER = RISCFREE_PREFIX + GDB_SERVER_TAP_NUMBER_KEY; // $NON-NLS-1$

	// The below set of RTOS attributes are there in the parent class also.
	// Since they have to be used in QEMU launch. 
	// So any updates to these should b done there also.
	public static final String RTOS_DEBUG = RISCFREE_PREFIX + ".isRTOSDebug";
	public static final String RTOS_CUSTOM = RISCFREE_PREFIX + ".isCustomRTOS";
	public static final String RTOS_TYPE = RISCFREE_PREFIX + ".rtosType";
	public static final String RTOS_VERSION = RISCFREE_PREFIX + ".rtosVersion";
	public static final String RTOS_SCRIPT_LOCATION = RISCFREE_PREFIX + ".rtosScriptLocation";
	
	public static final String TARGET_STATUS_CHECK = RISCFREE_PREFIX + ".targetStatus";
	public static final String TRANSPORT_TYPE = RISCFREE_PREFIX + ".transportType";
	public static final String TAP_RESET_CHECK = RISCFREE_PREFIX + ".tapReset";
	public static final String MMU_AWARENESS_CHECK = RISCFREE_PREFIX + ".enableMMUAwareness";
	public static final String TARGET_RESET_CHECK = RISCFREE_PREFIX + ".targetReset";
	public static final String GDB_SERVER_DEBUGGER_SERIAL_NUMBER = RISCFREE_PREFIX + ".serialNumber";
	public static final String GDB_PROGRAM_COUNTER = GDBTAG_PREFIX + ".setPcRegister";
	public static final String GDB_PROGRAM_COUNTER_AT = GDBTAG_PREFIX + ".pcRegister";
	public static final String GDB_THREAD_NUMBER = GDBTAG_PREFIX + ".threadNumber";
	public static final String GDB_PROGRAM_BREAK_POINT = GDBTAG_PREFIX + ".setStopAt";
	public static final String GDB_PROGRAM_BREAK_POINT_AT = GDBTAG_PREFIX + ".stopAt";
	public static final String OTHER_RUN_COMMANDS = GDBTAG_PREFIX + ".otherRunCommands";
	public static final String GDB_PROGRAM_LOAD_IMAGE = GDBTAG_PREFIX + ".loadImage";
	public static final String GDB_PROGRAM_IMAGE_OFFSET = GDBTAG_PREFIX + ".imageOffset";
	public static final String GDB_PROGRAM_LOAD_SYMBOLS = GDBTAG_PREFIX + ".loadSymbols";
	public static final String GDB_PROGRAM_SYMBOL_OFFSET = GDBTAG_PREFIX + ".symbolOffset";
	public static final String ATTACH_MODE = RISCFREE_PREFIX + ".attachMode";
	public static final String CODE_COVERAGE = RISCFREE_PREFIX + ".codeCoverage";
	public static final String GDB_SERVER_CORE_NUMBER = RISCFREE_PREFIX + ".coreNumber";
	public static final String GDB_SEMIHOSTING_ENABLED = RISCFREE_PREFIX + ".semiHostingEnabled";
	public static final String FDC_ENABLED = RISCFREE_PREFIX + ".fdcEnabled";
	public static final String FDC_CHANNEL_SIZE_INDEX = RISCFREE_PREFIX + ".fdcChannelSize";
	// Attributes to be used for migration of an existing launch configuration to a new one.
	public static final String DEBUG_PROBE_MIGRATION = RISCFREE_PREFIX + ".debugProbeMigration";

}
