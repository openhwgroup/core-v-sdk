package com.ashling.riscfree.debug.opxd.core.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import com.ashling.riscfree.debug.opxd.core.Activator;
import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.preferences.DefaultPreferences;
import com.ashling.riscfree.debug.opxd.core.probe.scan.ProbeNames;
import com.ashling.riscfree.debug.opxd.core.probe.scan.ScanUtil;


public class ConfigurationHelper {

	public static final String DEBUG_PROBE_UNKNOWN = "Unknown";
	// The below constants are used in 
	// org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuFinalLaunchSequence for QEMU launch also.
	// So any updates to these constants should be done in both classes.
	public static final String RTOS_SCRIPT_FOLDER_NAME = "RTOS";
	public static final String SCRIPT_FOLDER_NAME = "scripts";
	public static final String GDB_SUPPORT_SCRIPTS_FOLDER_NAME = "gdb-support-scripts";
	public static final String AUTO_ADJUST_DISPLAY_VALUE = "Auto adjust";
	// The display string should not be saved in launch configuration, since if
	// later we need to change the display string, it should not force us to do
	// migration for existing launch configurations 
	public static final String AUTO_ADJUST_CONF_VALUE = "auto-adjust";
	//Server param could also change that is why it is added in a different constant.
	public static final String AUTO_ADJUST_SERVER_PARAM = "auto-adjust";

	private static final List<ProbeDetails> PROBE_DETAILS_LIST = new ArrayList<>();
	private static final Map<String, String> FDC_CHANNEL_SIZE = new LinkedHashMap<>();
	
	static {
		try (InputStream input = ConfigurationHelper.class.getClassLoader()
				.getResourceAsStream("/resources/debug-probe-types.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			prop.forEach((k, v) -> {
				if (!k.toString().isBlank() && !v.toString().isBlank()) {
					String[] probeNameDetails = v.toString().split(",");
					PROBE_DETAILS_LIST.add(new ProbeDetails(k.toString(), probeNameDetails[0].trim(),
							(probeNameDetails.length > 1 ? probeNameDetails[1].trim() : null)));
				}
			});
		} catch (Exception ex) {
			Activator.log(ex);
		}
		
		try (InputStream input = ConfigurationHelper.class.getClassLoader()
				.getResourceAsStream("/resources/fdc-channel-size.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			FDC_CHANNEL_SIZE.putAll(prop.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
		} catch (Exception ex) {
			Activator.log(ex);
		}
	}

	private ConfigurationHelper() {

	}
	
	public static void addTapNbrAndCoreNbr(ILaunchConfiguration configuration, List<String> cmdLst) throws CoreException {
		String coreNumber = configuration.getAttribute(ConfigurationAttributes.GDB_SERVER_CORE_NUMBER, "");
		
		// Add tap number command if transport type is not swd.
		if (!configuration.getAttribute(ConfigurationAttributes.TRANSPORT_TYPE, "").equalsIgnoreCase("swd")) {
			String tapNumber = getTapNumber(configuration);
			if (!tapNumber.equals("")) {
				cmdLst.add("--tap-number");
				cmdLst.add(tapNumber);
			}
			
			if (!coreNumber.equals("")) {
				cmdLst.add("--core-number");
				cmdLst.add(coreNumber);
			}
		} else {
			if (!coreNumber.equals("")) {
				cmdLst.add("--core-number");
				cmdLst.add(coreNumber);
			}
		}
	}
	
	public static String getDebugProbeSerialNumber(ILaunchConfiguration configuration) throws CoreException
	{
		String serialNumber = configuration.getAttribute(ConfigurationAttributes.GDB_SERVER_DEBUGGER_SERIAL_NUMBER, "");
		if (!serialNumber.isBlank()) {
			return serialNumber;
		} else {
			// working with old existing launch configuration
			String strvalue = configuration.getAttribute(ConfigurationAttributes.GDB_SERVER_DEBUGGER_INSTANCE,
					DefaultPreferences.GDB_SERVER_DEBUGGER_INSTANCE);
			if (strvalue.equals(DefaultPreferences.GDB_SERVER_DEBUGGER_INSTANCE)) {
				strvalue = ScanUtil.getDefault().firstFoundDebugProbe(ProbeNames.OPELLA_XD);
				if (strvalue != null) {
					return strvalue;
				}
				return DefaultPreferences.GDB_SERVER_DEBUGGER_INSTANCE;
			}
			String[] opxdInstanceString = strvalue.split(" ");
			return opxdInstanceString[0].trim();
		}
	}
	
	public static String getTapNumber(ILaunchConfiguration configuration) throws CoreException {
		String tapString = configuration.getAttribute(ConfigurationAttributes.GDB_SERVER_TAP_NUMBER,
				DefaultPreferences.GDB_SERVER_TAP_NUMBER_DEFAULT);
		return tapString.split(" ")[0].trim();
	}

	public static String getDebuggerTypeNum(String debuggerProbeName) {	
		return PROBE_DETAILS_LIST.stream()
				.filter(probeDet -> debuggerProbeName.toLowerCase().contains(probeDet.getProbeName().toLowerCase()))
				.map(probeDet -> probeDet.getProbeNumber()).findAny().orElse("-1");
	}
	
	public static boolean isAutoClockSupported(String debuggerProbeName) {
		return PROBE_DETAILS_LIST.stream()
				.filter(probeDet -> debuggerProbeName.toLowerCase().contains(probeDet.getProbeName().toLowerCase()))
				.map(probeDet -> probeDet.isAutoClockSupported()).findAny().orElse(false);
	}

	public static String getDebuggerTypeParamValue(String debuggerProbeNum) {
		return PROBE_DETAILS_LIST.stream().filter(probeDet -> probeDet.getProbeNumber().equals(debuggerProbeNum))
				.map(ProbeDetails::getProbeName).findAny().orElse(DEBUG_PROBE_UNKNOWN).toLowerCase();
	}
	
	public static String getJtagFreqCommParam(String jtagFreq) {
		jtagFreq = Optional.ofNullable(jtagFreq).orElseGet(() -> {
			if (BundleAvailabilityChecker.isINTELBundleAvailable()) {
				return DefaultPreferences.INTEL_GDB_SERVER_JTAG_FREQUENCY_DEFAULT;
			} else {
				return DefaultPreferences.GDB_SERVER_JTAG_FREQUENCY_DEFAULT;
			}
		});
		// It could be called from UI when we do detect scanchain, 
		// at that time the value would be display string.
		if (AUTO_ADJUST_CONF_VALUE.equalsIgnoreCase(jtagFreq) || AUTO_ADJUST_DISPLAY_VALUE.equalsIgnoreCase(jtagFreq)) {
			return AUTO_ADJUST_SERVER_PARAM;
		} else {
			float fJtagFreq = Float.parseFloat(jtagFreq);
			int ijtagFreq = (int) (fJtagFreq * 1000); // Making it to KHz
			return Integer.toString(ijtagFreq) + "KHz";
		}
	}
	
	public static Collection<String> getFDCSizeDisplayValues(){
		return FDC_CHANNEL_SIZE.values();
	}
	
	public static String getFDCSizeDisplayString(String sizeIndex) {
		return FDC_CHANNEL_SIZE.getOrDefault(sizeIndex, "");
	}
	
	public static String getFDCSize(String displayString) {
		return FDC_CHANNEL_SIZE.entrySet().stream().filter(entry -> entry.getValue().equalsIgnoreCase(displayString))
				.map(Entry::getKey).findAny().orElse("");
	}
}
