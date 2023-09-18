/**
 * Default preferences
 */
package com.ashling.riscfree.debug.opxd.core.preferences;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.utils.BundleAvailabilityChecker;

/**
 * @author Suresh
 *
 */
public class DefaultPreferences {

	private static final boolean DEFAULT_TAP_RESET_CHECK = false;
	private static final boolean DEFAULT_CODE_COVERAGE = false;
	public static final boolean OS_AWARENESS_RTOS_DEBUGGING = false;
	public static final boolean OS_AWARENESS_CUSTOM_RTOS = false;
	public static final String GDB_SERVER_JTAG_FREQUENCY_DEFAULT = "1";
	public static final String INTEL_GDB_SERVER_JTAG_FREQUENCY_DEFAULT = "16";
	public static final String GDB_SERVER_DEBUGGER_INSTANCE = "No debug probes found";
	public static final boolean DEFAUT_LOAD_IMAGE = true;
	public static final boolean DEFAUT_LOAD_SYMBOL = true;
	public static final boolean DEFAULT_TARGET_RESET_CHECK = false;
	public static final String DEFAUT_LOAD_IMAGE_OFFSET = "";
	public static final String DEFAUT_LOAD_SYMBOL_OFFSET = "";
	public static final String DEFAULT_TARGET_DEVICE="SiFive-E-Cores";
	public static final String DEFAULT_TRANSPORT_TYPE="JTAG";
	public static final String DEFAULT_THREAD_NUMBER="0";
	public static final String GDB_CLIENT_COMRV_EXECUTABLE_DEFAULT = "${eclipse_home}/../toolchain/riscv64-unknown-elf/llvm-gdb/riscv32-unknown-elf-gdb";
	public static final boolean DEFAULT_ATTACH_MODE = false;
	public static final boolean DEFAULT_SEMIHOSTING_ENABLED = false;
	public static final boolean DEFAULT_MMU_AWARENESS_CHECK = false;
	public static final boolean DEFAULT_FDC_CHECK = false;
	public static final String DEFAULT_FDC_CHANNEL_SIZE_INDEX = "3";
	
	public static final String GDB_SERVER_TAP_NUMBER_DEFAULT = "1";
	// ------------------------------------------------------------------------

	protected String fPluginId;

	/**
	 * The DefaultScope preference store.
	 */
	protected IEclipsePreferences fPreferences;

	// ------------------------------------------------------------------------

	public DefaultPreferences(String pluginId) {
		fPluginId = pluginId;
		fPreferences = DefaultScope.INSTANCE.getNode(fPluginId);
	}

	// ------------------------------------------------------------------------

	public static <T> T getDefaultValue(String attrName, Class<T> type) {
		switch (attrName) {
		case ConfigurationAttributes.TAP_RESET_CHECK:
			if (BundleAvailabilityChecker.isMIPSBundlesAvailable()) {
				return type.cast(true);
			}
			return type.cast(DEFAULT_TAP_RESET_CHECK);
		case ConfigurationAttributes.CODE_COVERAGE:
			if (BundleAvailabilityChecker.isMIPSBundlesAvailable()) {
				return type.cast(false);
			}
			return type.cast(DEFAULT_CODE_COVERAGE);
		case ConfigurationAttributes.TARGET_STATUS_CHECK:
			return type.cast(false);
		default:
			return type.cast(null);
		}
	}
	
	/**
	 * Get a string preference value, or the default.
	 * 
	 * @param key
	 *            a string with the key to search.
	 * @param defaultValue
	 *            a string with the default, possibly null.
	 * @return a trimmed string, or a null default.
	 */
	public String getString(String key, String defaultValue) {
		String value;
		value = fPreferences.get(key, defaultValue);
		if (value != null) {
			value = value.trim();
		}

		return value;
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		boolean value = fPreferences.getBoolean(key, defaultValue);
		return value;
	}

	public int getInt(String key, int defaultValue) {

		int value = fPreferences.getInt(key, defaultValue);
		return value;
	}

	public void putString(String key, String value) {
		fPreferences.put(key, value);
	}

	public void putInt(String key, int value) {
		fPreferences.putInt(key, value);
	}

	public void putBoolean(String key, boolean value) {
		fPreferences.putBoolean(key, value);
	}
}