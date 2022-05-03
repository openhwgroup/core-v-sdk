/*******************************************************************************
 * Copyright (c) 2015 Liviu Ionescu.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Liviu Ionescu - initial version
 *******************************************************************************/

package org.eclipse.embedcdt.debug.gdbjtag.qemu.core.preferences;

import org.eclipse.embedcdt.core.EclipseUtils;
import org.eclipse.embedcdt.core.preferences.Discoverer;
import org.eclipse.embedcdt.internal.debug.gdbjtag.qemu.core.Activator;

public class DefaultPreferences extends org.eclipse.embedcdt.debug.gdbjtag.core.preferences.DefaultPreferences {

	// ------------------------------------------------------------------------

	public static final boolean SERVER_DO_START_DEFAULT = true;
	public static final boolean DO_START_GDB_SERVER_DEFAULT = true;

	public static final String SERVER_EXECUTABLE_DEFAULT_NAME = "qemu-system-gnuarmeclipse";
	public static final String QEMU_BOARD_NAME_DEFAULT = "spike";
	public static final String QEMU_DEVICE_NAME_DEFAULT = "";
	public static final int SERVER_GDB_PORT_NUMBER_DEFAULT = 1234;
	public static final String SERVER_OTHER_OPTIONS_DEFAULT = "-S -d unimp,guest_errors"; //$NON-NLS-1$

	public static final boolean DO_GDB_SERVER_ALLOCATE_CONSOLE_DEFAULT = true;

	public static final boolean QEMU_IS_VERBOSE_DEFAULT = false;

	public static final String CLIENT_OTHER_OPTIONS_DEFAULT = "";

	public static final String CLIENT_COMMANDS_DEFAULT = "set mem inaccessible-by-default off\nset arch riscv:rv32\nset remotetimeout 250\n";

	public static final boolean USE_REMOTE_TARGET_DEFAULT = true;
	public static final String REMOTE_IP_ADDRESS_LOCALHOST = "localhost"; //$NON-NLS-1$
	public static final String REMOTE_IP_ADDRESS_DEFAULT = REMOTE_IP_ADDRESS_LOCALHOST; // $NON-NLS-1$
	public static final int REMOTE_PORT_NUMBER_DEFAULT = SERVER_GDB_PORT_NUMBER_DEFAULT;

	public static final boolean DO_INITIAL_RESET_DEFAULT = false;
	public static final String DO_INITIAL_RESET_COMMAND = "monitor system_reset ";

	public static final String HALT_COMMAND = ""; // "monitor stop";

	public static final boolean ENABLE_SEMIHOSTING_DEFAULT = true;

	public static final String ENABLE_SEMIHOSTING_OPTION = "-semihosting-config enable=on,target=native";

	public static final String INIT_OTHER_DEFAULT = "";

	public static final boolean DO_DEBUG_IN_RAM_DEFAULT = true;

	public static final boolean DO_PRERUN_RESET_DEFAULT = true;
	public static final String DO_PRERUN_RESET_COMMAND = DO_INITIAL_RESET_COMMAND;

	public static final boolean DO_STOP_AT_DEFAULT = true;
	public static final String STOP_AT_NAME_DEFAULT = "main";

	public static final String PRERUN_OTHER_DEFAULT = "";

	public static final boolean DO_CONTINUE_DEFAULT = true;

	public static final String DO_CONTINUE_COMMAND = "continue";
	public static final boolean DISABLE_GRAPHICS_DEFAULT = true;

	// ------------------------------------------------------------------------

	// HKCU & HKLM LOCAL_MACHINE
	private static final String REG_SUBKEY = "\\GNU ARM Eclipse\\QEMU";
	// Standard Microsoft recommendation.
	private static final String REG_NAME = "InstallLocation";

	// ------------------------------------------------------------------------

	//<CUSTOMISATION> ASHLING
	public static final String SERVER_EXECUTABLE_DEFAULT = "${eclipse_home}/../qemu/qemu-system-riscv32";
	protected static final String CLIENT_EXECUTABLE_DEFAULT = "${eclipse_home}/../toolchain/riscv64-unknown-elf/bin/riscv64-unknown-elf-gdb";

	public enum OS {
		WINDOWS, LINUX
	}

	public DefaultPreferences(String pluginId) {
		super(pluginId);
	}

	//<CUSTOMISATION> ASHLING

	// ------------------------------------------------------------------------

	public String getGdbServerExecutable() {
		return getString(PersistentPreferences.GDB_SERVER_EXECUTABLE,
				getOSSpecificExecutableString(SERVER_EXECUTABLE_DEFAULT));
	}

	public String getGdbClientExecutable() {
		return getString(PersistentPreferences.GDB_CLIENT_EXECUTABLE,
				getOSSpecificExecutableString(CLIENT_EXECUTABLE_DEFAULT));
	}

	// ------------------------------------------------------------------------

	public String getExecutableName() {

		String key = PersistentPreferences.EXECUTABLE_NAME;
		String value = getString(key, "");

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.getExecutableName()=\"" + value + "\"");
		}
		return value;
	}

	public String getExecutableNameOs() {

		String key = EclipseUtils.getKeyOs(PersistentPreferences.EXECUTABLE_NAME_OS);

		String value = getString(key, "");
		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.getExecutableNameOs()=\"" + value + "\" (" + key + ")");
		}
		return value;
	}

	public void putExecutableName(String value) {

		String key = PersistentPreferences.EXECUTABLE_NAME;

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.putExecutableName(\"" + value + "\")");
		}
		putString(key, value);
	}

	// ------------------------------------------------------------------------

	public String getInstallFolder() {

		String key = PersistentPreferences.INSTALL_FOLDER;
		String value = getString(key, "");

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.getInstallFolder() = \"" + value + "\"");
		}
		return value;
	}

	public void putInstallFolder(String value) {

		String key = PersistentPreferences.INSTALL_FOLDER;

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.putInstallFolder(\"" + value + "\")");
		}
		putString(key, value);
	}

	// ------------------------------------------------------------------------

	@Override
	public String getSearchPath() {

		String key = PersistentPreferences.SEARCH_PATH;
		String value = getString(key, "");

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.getSearchPath()=\"" + value + "\"");
		}
		return value;
	}

	@Override
	public String getSearchPathOs() {

		String key = EclipseUtils.getKeyOs(PersistentPreferences.SEARCH_PATH_OS);
		String value = getString(key, "");

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.getSearchPathOs()=\"" + value + "\" (" + key + ")");
		}
		return value;
	}

	@Override
	public void putSearchPath(String value) {

		String key = PersistentPreferences.SEARCH_PATH;

		if (Activator.getInstance().isDebugging()) {
			System.out.println("qemu.DefaultPreferences.putSearchPath(\"" + value + "\")");
		}
		putString(key, value);
	}

	// ------------------------------------------------------------------------

	public boolean getQemuEnableSemihosting() {

		return getBoolean(PersistentPreferences.GDB_QEMU_ENABLE_SEMIHOSTING, ENABLE_SEMIHOSTING_DEFAULT);
	}

	// ------------------------------------------------------------------------

	public boolean getTabMainCheckProgram() {
		return getBoolean(PersistentPreferences.TAB_MAIN_CHECK_PROGRAM,
				PersistentPreferences.TAB_MAIN_CHECK_PROGRAM_DEFAULT);
	}

	// ------------------------------------------------------------------------

	public boolean getGdbServerDoStart() {
		return getBoolean(PersistentPreferences.GDB_SERVER_DO_START, SERVER_DO_START_DEFAULT);
	}

	public String getGdbServerOtherOptions() {
		return getString(PersistentPreferences.GDB_SERVER_OTHER_OPTIONS, SERVER_OTHER_OPTIONS_DEFAULT);
	}

	public String getGdbClientOtherOptions() {
		return getString(PersistentPreferences.GDB_CLIENT_OTHER_OPTIONS, CLIENT_OTHER_OPTIONS_DEFAULT);
	}

	public String getGdbClientCommands() {
		return getString(PersistentPreferences.GDB_CLIENT_COMMANDS, CLIENT_COMMANDS_DEFAULT);
	}

	// ------------------------------------------------------------------------

	public boolean getQemuDebugInRam() {
		return getBoolean(PersistentPreferences.GDB_QEMU_DO_DEBUG_IN_RAM, DO_DEBUG_IN_RAM_DEFAULT);
	}

	public boolean getQemuDoInitialReset() {
		return getBoolean(PersistentPreferences.GDB_QEMU_DO_INITIAL_RESET, DO_INITIAL_RESET_DEFAULT);
	}

	public String getQemuInitOther() {
		return getString(PersistentPreferences.GDB_QEMU_INIT_OTHER, INIT_OTHER_DEFAULT);
	}

	public boolean getQemuDoPreRunReset() {
		return getBoolean(PersistentPreferences.GDB_QEMU_DO_PRERUN_RESET, DO_PRERUN_RESET_DEFAULT);
	}

	public String getQemuPreRunOther() {
		return getString(PersistentPreferences.GDB_QEMU_PRERUN_OTHER, PRERUN_OTHER_DEFAULT);
	}

	public boolean getQemuDisableGraphics() {
		return getBoolean(PersistentPreferences.GDB_QEMU_DISABLE_GRAPHICS, DISABLE_GRAPHICS_DEFAULT);
	}

	// ------------------------------------------------------------------------

	@Override
	protected String getRegistryInstallFolder(String subFolder, String executableName) {

		String path = Discoverer.getRegistryInstallFolder(executableName, subFolder, REG_SUBKEY, REG_NAME);
		return path;
	}

	// ------------------------------------------------------------------------

	//		<CUSTOMISATION> ASHLING

	public static OS getOperatingSystem() {

		// detecting the operating system using os.name System property
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {
			return OS.WINDOWS;
		}

		else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			return OS.LINUX;
		}
		return null;
	}

	private String getOSSpecificExecutableString(String executableString) {

		if ((getOperatingSystem() == OS.WINDOWS)) {
			return executableString + ".exe";
		}
		return executableString;
	}
	//		<CUSTOMISATION> ASHLING
}
