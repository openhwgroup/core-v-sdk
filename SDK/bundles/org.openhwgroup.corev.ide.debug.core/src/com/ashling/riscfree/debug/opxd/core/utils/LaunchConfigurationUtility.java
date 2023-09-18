/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import com.ashling.riscfree.debug.opxd.core.Activator;
import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.preferences.DefaultPreferences;
import com.ashling.riscfree.debug.opxd.core.probe.scan.DebugProbe;
import com.ashling.riscfree.debug.opxd.emf.devices.core.AshlingProcessorDatabaseParser;
import com.ashling.riscfree.debug.opxd.emf.devices.core.AshlingProcessorDatabaseParser.ARCH_TYPE;

/**
 * @author IOT2
 *
 */
public class LaunchConfigurationUtility {

	private static String RISCV_LAUNCH_CONFIG_TYPE = "com.ashling.riscfree.debug.opxd.launchConfigurationType";
	/**
	 * Find and return a freeport
	 * 
	 * @return
	 */
	public static Integer findFreePort() {
		try (ServerSocket socket = new ServerSocket(0)) {
			return socket.getLocalPort();
		} catch (IOException e) {
		}
		return -1;
	}

	/*
	 * Adds the thread selection related keys to the existing launch, if it is not
	 * present.
	 */
	public static void addThreadSelectionAttrsIfNotPresent(ILaunchConfiguration launchConfiguration) {
		try {
			if(!launchConfiguration.hasAttribute(ConfigurationAttributes.GDB_THREAD_NUMBER)) {
				ILaunchConfigurationWorkingCopy workingCopy = launchConfiguration.getWorkingCopy();
				workingCopy.setAttribute(ConfigurationAttributes.GDB_THREAD_NUMBER, DefaultPreferences.DEFAULT_THREAD_NUMBER);
				workingCopy.doSave();
			}
			
		} catch (CoreException e) {
			Activator.log(e);
		}
	}
	
	/*
	 * Adds the semi hosting enabled attribute
	 */
	public static void addSemiHostingEnabledAttrIfNotPresent(ILaunchConfiguration launchConfiguration) {
		try {
			if(!launchConfiguration.hasAttribute(ConfigurationAttributes.GDB_SEMIHOSTING_ENABLED)) {
				ILaunchConfigurationWorkingCopy workingCopy = launchConfiguration.getWorkingCopy();
				workingCopy.setAttribute(ConfigurationAttributes.GDB_SEMIHOSTING_ENABLED, DefaultPreferences.DEFAULT_SEMIHOSTING_ENABLED);
				workingCopy.doSave();
			}
			
		} catch (CoreException e) {
			Activator.log(e);
		}
	}
	
	/*
	 * This method will read the keys from the existing launch configuration and the
	 * common key names will be migrated. There were some keys used wrongly till
	 * v129-B. No other option to escape from those keys which are coming as part of
	 * an existing configuration created using v129-B or ago.
	 */
	public static void migrateLaunchConfiguration(ILaunchConfiguration launchConfiguration, MigrationObject migrationObject) {
		try {
			Map<String, Object> originalAttributes = launchConfiguration.getAttributes();

			// Remove all existing attributes for transport type - START
			Object transportType = originalAttributes.get("com.ashling.riscfree.debug.opxd.arc.targetDevice");
			
			//if the arc target device keys is null we need to check with ARM launch configuration
			if(transportType==null) {
				transportType = originalAttributes.get("com.ashling.riscfree.debug.opxd.arm.targetDevice");
			}
			if (null == transportType) {
				transportType = originalAttributes.get("com.ashling.riscfree.debug.opxd.probeType");
			}
			//In new configurations the above keys won't be available
			if(transportType != null)
			{
			String tansportTypeValue = (String) transportType;
			originalAttributes.remove("com.ashling.riscfree.debug.opxd.probeType");
			originalAttributes.remove("com.ashling.riscfree.debug.opxd.arc.targetDevice");
			originalAttributes.remove("com.ashling.riscfree.debug.opxd.arm.targetDevice");
			
			
			// Remove all existing attributes for transport type - END

			// Adding new transport type attribute
			originalAttributes.put(ConfigurationAttributes.TRANSPORT_TYPE, getTransportType(tansportTypeValue));
			
			}

			// Migrate to new attributes here
			Map<String, Object> migratedAttributes = new HashMap<>();
			originalAttributes.forEach((k, v) -> {
				migratedAttributes.put(getNewKey(k), v);
			});
			ILaunchConfigurationWorkingCopy workingCopy = launchConfiguration.getWorkingCopy();
			workingCopy.setAttributes(migratedAttributes);
			findAndaddCoreNumberAttrToRISCVLaunch(workingCopy);
			addMMUAwarenessAttrToRISCVLaunch(workingCopy);
			addFDCAttrsToRISCVLaunch(workingCopy);
			workingCopy.doSave();
			addSerialNumberAttr(launchConfiguration, migrationObject);
		} catch (CoreException e) {
			Activator.log(e);
		}
	}
	
	public static void addSerialNumberAttr(ILaunchConfiguration launchConfiguration, MigrationObject migrationObject) {
		if(migrationObject == null) {
			return;
		}
		try {
			ILaunchConfigurationWorkingCopy launchConfigurationWorkingCopy = launchConfiguration.getWorkingCopy();
			if (launchConfiguration.getAttribute(ConfigurationAttributes.GDB_SERVER_DEBUGGER_SERIAL_NUMBER,
					(String) null) == null) {
				String existingProbeName = launchConfiguration
						.getAttribute(ConfigurationAttributes.GDB_SERVER_DEBUGGER_INSTANCE, "");
				String existingProbeType = ConfigurationHelper.getDebuggerTypeParamValue(
						launchConfiguration.getAttribute(ConfigurationAttributes.GDB_SERVER_DEBUGGER_PROBE_TYPE, ""));
				migrationObject.getMigrationAttrVal(ConfigurationAttributes.DEBUG_PROBE_MIGRATION)
						.ifPresent(debugProbes -> {
							if (debugProbes instanceof DebugProbe[] && existingProbeName != null
									&& existingProbeType != null) {
								List<DebugProbe> debugProbeList = Arrays.asList((DebugProbe[]) debugProbes);
								Optional<DebugProbe> newDebugProbeDet = debugProbeList.stream().filter(dbgProbe -> {
									// existing launch configurations have probe type attributes
									// starting with serial number and a space.
									// just for double checking the probe type is also compared.
									return dbgProbe.getDeviceName().toLowerCase()
											.contains(existingProbeType.toLowerCase())
											&& existingProbeName.startsWith(dbgProbe.getSerialNumber() + " ");
								}).findAny();
								newDebugProbeDet.ifPresent(newDbgProbe -> {
									launchConfigurationWorkingCopy.setAttribute(
											ConfigurationAttributes.GDB_SERVER_DEBUGGER_INSTANCE,
											newDbgProbe.getDisplayName());
									launchConfigurationWorkingCopy.setAttribute(
											ConfigurationAttributes.GDB_SERVER_DEBUGGER_SERIAL_NUMBER,
											newDbgProbe.getSerialNumber());
									try {
										launchConfigurationWorkingCopy.doSave();
									} catch (CoreException e) {
										Activator.log(e);
									}
								});
							}
						});
			}
		} catch (CoreException e) {
			Activator.log(e);
		}
	}
	
	public static boolean enableMMUAwarenessCfg() {
		return BundleAvailabilityChecker.isMIPSBundlesAvailable() || BundleAvailabilityChecker.isGeneralProduct();
	}
	
	public static boolean enableFDCCfg() {
		return BundleAvailabilityChecker.isMIPSBundlesAvailable();
	}
	
	private static void findAndaddCoreNumberAttrToRISCVLaunch(ILaunchConfigurationWorkingCopy workingCopy)
			throws CoreException {
		if (workingCopy.getType().getIdentifier().equals(RISCV_LAUNCH_CONFIG_TYPE)) {
			if (!workingCopy.hasAttribute(ConfigurationAttributes.GDB_SERVER_CORE_NUMBER)) {
				AshlingProcessorDatabaseParser deviceTreeParser = new AshlingProcessorDatabaseParser();
				String tapString = workingCopy.getAttribute(ConfigurationAttributes.GDB_SERVER_TAP_NUMBER,
						DefaultPreferences.GDB_SERVER_TAP_NUMBER_DEFAULT);
				String deviceName = workingCopy.getAttribute(ConfigurationAttributes.GDB_SERVER_TARGET_DEVICE, "");
				if (!deviceName.isEmpty()) {
					// fetch the first core under this tap from the device.xml
					deviceTreeParser.getCores(deviceName, ARCH_TYPE.RISCV).stream().filter(c -> {
						short refId;
						if (c.getDAP() != null) {
							refId = c.getDAP().getJTAGDP().getRefid();
						} else {
							refId = c.getTap().getRefid();
						}
						int tapNumber = deviceTreeParser.getTapNumber(refId, deviceName);
						if (tapString.equals(String.valueOf(tapNumber))) {
							return true;
						}
						return false;
					}).findFirst()
							.ifPresent(c -> workingCopy.setAttribute(ConfigurationAttributes.GDB_SERVER_CORE_NUMBER,
									String.valueOf(c.getNumber())));
				}

			}
		}
	}

	private static void addMMUAwarenessAttrToRISCVLaunch(ILaunchConfigurationWorkingCopy workingCopy) throws CoreException {
		if (workingCopy.getType().getIdentifier().equals(RISCV_LAUNCH_CONFIG_TYPE) && enableMMUAwarenessCfg()) {
			if (!workingCopy.hasAttribute(ConfigurationAttributes.MMU_AWARENESS_CHECK)) {
				workingCopy.setAttribute(ConfigurationAttributes.MMU_AWARENESS_CHECK, DefaultPreferences.DEFAULT_MMU_AWARENESS_CHECK);
			}
		}
	}
	
	private static void addFDCAttrsToRISCVLaunch(ILaunchConfigurationWorkingCopy workingCopy) throws CoreException {
		if (workingCopy.getType().getIdentifier().equals(RISCV_LAUNCH_CONFIG_TYPE) && enableFDCCfg()) {
			if (!workingCopy.hasAttribute(ConfigurationAttributes.FDC_ENABLED)) {
				workingCopy.setAttribute(ConfigurationAttributes.FDC_ENABLED, DefaultPreferences.DEFAULT_FDC_CHECK);
				workingCopy.setAttribute(ConfigurationAttributes.FDC_CHANNEL_SIZE_INDEX,
						DefaultPreferences.DEFAULT_FDC_CHANNEL_SIZE_INDEX);
			}
		}
	}
	
	private static String getTransportType(String tansportTypeValue) {
		//Do not change the order of the loop
		if (tansportTypeValue.contains("CJTAG")) {
			return "cJTAG";
		}
		else if (tansportTypeValue.contains("JTAG")) {
			return "JTAG";
		}
		
		else if (tansportTypeValue.contains("SWD")) {
			return "SWD";
		}
		return "JTAG";
	}

	private static String getNewKey(String originalKey) {

		if (originalKey.endsWith(ConfigurationAttributes.GDB_SERVER_TARGET_DEVICE_KEY)) {
			return ConfigurationAttributes.GDB_SERVER_TARGET_DEVICE;
		} else if (originalKey.endsWith(ConfigurationAttributes.GDB_SERVER_TARGET_CORE_KEY)) {
			// There was a bug in ARC debug launch configuration, it was using CORE to save
			// device name till v129-B
			return ConfigurationAttributes.GDB_SERVER_TARGET_DEVICE;
		} else if (originalKey.endsWith(ConfigurationAttributes.GDB_SERVER_TAP_NUMBER_KEY)) {
			return ConfigurationAttributes.GDB_SERVER_TAP_NUMBER;
		} else if (originalKey.endsWith(ConfigurationAttributes.GDB_SERVER_TARGET_REG_FILE_KEY)) {
			return ConfigurationAttributes.GDB_SERVER_TARGET_REG_FILE;
		} else if (originalKey.endsWith(ConfigurationAttributes.GDB_SERVER_JTAG_FREQUENCY_KEY)) {
			return ConfigurationAttributes.GDB_SERVER_JTAG_FREQUENCY;
		} else if (originalKey.endsWith(ConfigurationAttributes.GDB_SERVER_DEBUGGER_INSTANCE_KEY)) {
			return ConfigurationAttributes.GDB_SERVER_DEBUGGER_INSTANCE;
		}
		return originalKey;

	}
}