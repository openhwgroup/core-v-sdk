package com.ashling.riscfree.debug.opxd.emf.devices.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.ashling.riscfree.debug.opxd.emf.devices.AshlingProcessorDataBaseType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreInfoType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreType;
import com.ashling.riscfree.debug.opxd.emf.devices.DAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.DocumentRoot;
import com.ashling.riscfree.debug.opxd.emf.devices.JTAGScanChainType;
import com.ashling.riscfree.debug.opxd.emf.devices.ProcessorType;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType1;
import com.ashling.riscfree.debug.opxd.emf.devices.util.FamilyModel;
import com.ashling.riscfree.debug.opxd.emf.devices.util.devicesResourceFactoryImpl;

public class AshlingProcessorDatabaseParser {

	String processorDBFilePath = null;
	private ResourceSetImpl resourceSet = null;
	private static Resource processorDB = null;
	private EObject eObject = null;
	private Map<String, ProcessorType> deviceNameToProcessorMap;
	private AshlingProcessorDataBaseType ashDB;
	private final String XMLPath = "${eclipse_home}/../debugger/common/";

	public enum ARCH_TYPE {
		ARM {
			public String toString() {
				return "ARM";
			}
		},
		RISCV {
			public String toString() {
				return "RISC-V";
			}
		},
		ARC {
			public String toString() {
				return "ARC";
			}

		}
	}

	public AshlingProcessorDatabaseParser() {

		this.processorDBFilePath = resolvePath(XMLPath) + File.separator + "devices.xml";
		loadXML();
	}

	public void loadXML() {

		try {

			deviceNameToProcessorMap = new LinkedHashMap<String, ProcessorType>();
			List<ProcessorType> temp = new ArrayList<ProcessorType>();
			resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml",
					new devicesResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("devicesxml",
					new devicesResourceFactoryImpl());
			// disable DTD resolution since it fails for MusicXML files
			Map<String, Boolean> parserFeatures = new HashMap<>();
			parserFeatures.put("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			resourceSet.getLoadOptions().put(XMLResource.OPTION_PARSER_FEATURES, parserFeatures);
			processorDB = resourceSet.getResource(URI.createFileURI(new File(processorDBFilePath).getAbsolutePath()),
					true);
			eObject = processorDB.getContents().get(0);
			if (eObject instanceof DocumentRoot) {
				ashDB = ((DocumentRoot) eObject).getAshlingProcessorDataBase();

				ashDB = ((DocumentRoot) eObject).getAshlingProcessorDataBase();
				temp = ashDB.getProcessor();
			}
			for (int i = 0; i < temp.size(); i++)
				deviceNameToProcessorMap.put(temp.get(i).getDevice(), temp.get(i));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public List<String> getDeviceNameList(ARCH_TYPE architecture) {

		List<String> deviceNameList = new ArrayList<>();

		Set<String> keys = deviceNameToProcessorMap.keySet();
		switch (architecture) {

		case RISCV: {
			return keys.stream().filter(k -> {
				return deviceNameToProcessorMap.get(k).getCoreInfo().getCore().stream().anyMatch(core -> {
					return core.getArchitecture().equals(ARCH_TYPE.RISCV.toString());
				});
			}).collect(Collectors.toList());

		}
		case ARC: {
			return keys.stream().filter(k -> {
				return deviceNameToProcessorMap.get(k).getCoreInfo().getCore().stream().anyMatch(core -> {
					return core.getArchitecture().equals(ARCH_TYPE.ARC.toString());
				});
			}).collect(Collectors.toList());
		}

		case ARM: {
			return keys.stream().filter(k -> {
				return deviceNameToProcessorMap.get(k).getCoreInfo().getCore().stream().anyMatch(core -> {
					return core.getArchitecture().equals(ARCH_TYPE.ARM.toString());
				});
			}).collect(Collectors.toList());
		}

		}

		return deviceNameList;
	}

	public List<String> getDeviceNameList() {
		List<String> deviceNameList = new ArrayList<>();
		deviceNameToProcessorMap.forEach((k, v) -> deviceNameList.add(k));
		return deviceNameList;

	}

	public String getRegisterFile(String deviceName, String coreName, ARCH_TYPE arch) {

		ProcessorType processor = deviceNameToProcessorMap.get(deviceName);
		if (processor != null) {

			Optional<CoreType> coreType = processor.getCoreInfo().getCore().stream()
					.filter(p -> p.getArchitecture().equals(arch.toString()) && p.getName().equals(coreName)).findAny();

			return coreType.isPresent() ? coreType.get().getGDBRegFile() : null;
		}
		return null;
	}

	public CoreInfoType getCoreInfo(String deviceName, ARCH_TYPE arch) {

		ProcessorType processor = deviceNameToProcessorMap.get(deviceName);
		if (processor != null) {

			Optional<CoreInfoType> filterResult = IntStream.range(0, processor.getCoreInfo().getCore().size())
					.filter(i -> processor.getCoreInfo().getCore().get(i).getArchitecture().equals(arch.toString()))
					.mapToObj(i -> processor.getCoreInfo()).findFirst();

			return filterResult.isPresent() ? filterResult.get() : null;
		}
		return null;
	}

	public CoreInfoType getCoreInfo(String deviceName) {
		ProcessorType processor = deviceNameToProcessorMap.get(deviceName);
		if (processor != null) {
			return processor.getCoreInfo();
		}
		return null;
	}

	public short getDefaultTAP(String deviceName, ARCH_TYPE arc) {
		ProcessorType processor = deviceNameToProcessorMap.get(deviceName);
		if (processor != null && processor.isSetDefaultTAP()) {

			return processor.getDefaultTAP();
		}
		return 0;
	}

	public boolean isNonStopEnabled(String deviceName, ARCH_TYPE arc) {
		ProcessorType processor = deviceNameToProcessorMap.get(deviceName);
		if (processor != null && processor.isSetUseNonStopMode()) {
			return processor.isUseNonStopMode();
		}
		return false;
	}

	public String getDefaultDevice() {

		if (deviceNameToProcessorMap.keySet().stream().findFirst().isPresent())
			return deviceNameToProcessorMap.keySet().stream().findFirst().get();
		return "";
	}

	public String getDefaultDevice(ARCH_TYPE archType) {

		return deviceNameToProcessorMap.entrySet().stream().filter(deviceDet -> {
			return deviceDet.getValue().getCoreInfo().getCore().stream()
					.filter(cit -> archType.toString().equalsIgnoreCase(cit.getArchitecture())).findAny().isPresent();
		}).findFirst().map(Entry::getKey).orElse("");
	}

	public List<String> getTAPList(String deviceName, ARCH_TYPE archType) {

		if (deviceName != null && !deviceName.isEmpty()) {
			CoreInfoType coreInfo = deviceNameToProcessorMap.get(deviceName).getCoreInfo();
			JTAGScanChainType jtag = deviceNameToProcessorMap.get(deviceName).getJTAGScanChain();
			List<String> tapList = new ArrayList<>();

			for (int i = 0; i < jtag.getTap().size(); i++) {
				for (int j = 0; j < coreInfo.getCore().size(); j++) {

					TapType tap = coreInfo.getCore().get(j).getTap();
					short tapId = jtag.getTap().get(i).getId();
					String coreArchitecture = coreInfo.getCore().get(j).getArchitecture();

					/*
					 * In the case of RISC and ARC devices the xml format for RefId is CoreInfo ->
					 * Core -> Tap -> RefId
					 */
					if (tap != null) {
						if (tapId == tap.getRefid()) {

							if (coreArchitecture.equals(archType.toString())) {
								tapList.add(new StringBuilder().append(jtag.getTap().get(i).getNumber()).append("(")
										.append(coreInfo.getCore().get(j).getName()).append(")").toString());
							}
						}
					}
					/*
					 * In the case of ARM devices (Eg:Ashling-QSDK585) the xml format for RefId is
					 * CoreInfo -> Core -> DAP -> JTAGDP -> RefId
					 */
					else if (coreInfo.getCore().get(j).getDAP() != null) {
						if (tapId == coreInfo.getCore().get(j).getDAP().getJTAGDP().getRefid()) {

							if (coreArchitecture.equals(archType.toString())) {
								tapList.add(new StringBuilder().append(jtag.getTap().get(i).getNumber()).append("(")
										.append(coreInfo.getCore().get(j).getName()).append(")").toString());
							}
						}
					}
				}

			}

			return tapList;
		}
		return Collections.emptyList();

	}

	public List<TapType1> getTAPDetails(String deviceName) {

		if (deviceName != null && !deviceName.isEmpty()) {
			JTAGScanChainType jtag = deviceNameToProcessorMap.get(deviceName).getJTAGScanChain();
			return jtag.getTap();
		}
		return Collections.emptyList();
	}

	public List<String> getTAPDetails(String deviceName, ARCH_TYPE archType) {

		if (deviceName != null && !deviceName.isEmpty()) {
			CoreInfoType coreInfo = deviceNameToProcessorMap.get(deviceName).getCoreInfo();
			JTAGScanChainType jtag = deviceNameToProcessorMap.get(deviceName).getJTAGScanChain();
			Map<Short, Short> tapMap = jtag.getTap().stream()
					.collect(Collectors.toMap(TapType1::getId, TapType1::getNumber));
			return coreInfo.getCore().stream().filter(core -> core.getArchitecture().equals(archType.toString()))
					.flatMap(c -> {

						if (c.getTap() != null) {
							if (tapMap.containsKey(c.getTap().getRefid())) {
								return Stream.of(tapMap.get(c.getTap().getRefid()).toString());
							}
						} else if (c.getDAP() != null) {
							if (tapMap.containsKey(c.getDAP().getJTAGDP().getRefid())) {
								return Stream.of(tapMap.get(c.getDAP().getJTAGDP().getRefid()).toString());
							}
						}

						return Stream.empty();

					}).distinct().collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public List<String> getCoreList(String deviceName, ARCH_TYPE archType) {

		List<String> coreList = new ArrayList<>();
		if (deviceName != null && !deviceName.isEmpty()) {
			CoreInfoType coreInfo = deviceNameToProcessorMap.get(deviceName).getCoreInfo();
			if (coreInfo != null) {

				coreList.addAll(coreInfo.getCore().stream().filter(c -> c.getArchitecture().equals(archType.toString()))
						.map(c -> c.getName()).collect(Collectors.toList()));

			}

			return coreList;
		}
		return Collections.emptyList();

	}

	public List<String> getCoreList(String deviceName) {

		List<String> coreList = new ArrayList<>();
		if (deviceName != null && !deviceName.isEmpty()) {
			CoreInfoType coreInfo = deviceNameToProcessorMap.get(deviceName).getCoreInfo();
			if (coreInfo != null) {

				coreList.addAll(coreInfo.getCore().stream().map(c -> c.getName()).collect(Collectors.toList()));
			}

			return coreList;
		}
		return Collections.emptyList();

	}

	public boolean isMulticoreEnabled(String deviceName) {
		if (deviceName != null && !deviceName.isEmpty()) {
			return deviceNameToProcessorMap.get(deviceName).isMultiCoreSupported();
		}
		return false;
	}

	public short getTapNumber(short refid, String deviceName) {

		Optional<Short> filterResult = deviceNameToProcessorMap.get(deviceName).getJTAGScanChain().getTap().stream()
				.filter(tap -> tap.getId() == refid).map(id -> id.getNumber()).findFirst();

		return filterResult.isPresent() ? filterResult.get() : null;

	}

	public String getTapName(String deviceName, short tapNumber) {
		if (!deviceName.isBlank()) {

			CoreInfoType coreInfo = deviceNameToProcessorMap.get(deviceName).getCoreInfo();
			JTAGScanChainType jtag = deviceNameToProcessorMap.get(deviceName).getJTAGScanChain();

			for (int i = 0; i < jtag.getTap().size(); i++) {
				for (int j = 0; j < coreInfo.getCore().size(); j++) {

					if (coreInfo.getCore().get(j).getTap() != null) {
						if (jtag.getTap().get(i).getNumber() == tapNumber) {
							if (jtag.getTap().get(i).getId() == coreInfo.getCore().get(j).getTap().getRefid()) {

								return new StringBuilder().append(tapNumber).append("(")
										.append(coreInfo.getCore().get(j).getName()).append(")").toString();
							}
						}
					}
				}

			}
		}

		return "";
	}

	public String resolvePath(String value) {
		try {
			// Do not report undefined variables
			value = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(value, false)
					.trim();
		} catch (CoreException e) {
			System.out.println(e.toString());
		}
		return value;
	}

	/**
	 * Return the .text section start address
	 * 
	 * @param Target       device Name
	 * @param Architecture type
	 * @return List of core with specified architecture
	 */
	public List<CoreType> getCores(String deviceName, ARCH_TYPE arch) {

		List<CoreType> coreList = new ArrayList<>();
		if (deviceName != null && !deviceName.isEmpty()) {
			ProcessorType device = deviceNameToProcessorMap.get(deviceName);
			if (device != null) {
				CoreInfoType coreInfo = deviceNameToProcessorMap.get(deviceName).getCoreInfo();
				if (coreInfo != null) {
					coreList.addAll(coreInfo.getCore().stream().filter(c -> c.getArchitecture().equals(arch.toString()))
							.collect(Collectors.toList()));
				}

				return coreList;
			}
		}
		return Collections.emptyList();

	}

	public String getDefaultResetType(String deviceName) {

		return deviceNameToProcessorMap.get(deviceName).getResetType().trim();

	};

	public String getInitargetDeviceCombo(ARCH_TYPE arch) {

		for (Map.Entry<String, ProcessorType> entry : deviceNameToProcessorMap.entrySet()) {
			if (entry.getValue().getCoreInfo().getCore().get(0).getArchitecture().equals(arch.toString())) {
				return entry.getKey();
			}
		}
		return "";
	}

	// this method called when the Debug Connection is ARM-SWD-TPA-R1 is enabled
	// because it list's all the core's
	// in the Connect to core combo box and we can parse from the xml using the
	// index
	public String getCoreNumber(String deviceName, int coreNumIndex) {
		return Short.toString(
				deviceNameToProcessorMap.get(deviceName).getCoreInfo().getCore().get(coreNumIndex).getNumber());
	}

	/**
	 * Returns list of FamilyModel (Architecture,Family name,GDBReg file) objects
	 * 
	 * @param null
	 * @return list of FamilyModel object
	 */
	public List<FamilyModel> getFamilyDetails() {

		List<FamilyModel> familyList = new ArrayList<>();
		for (Map.Entry<String, ProcessorType> entry : deviceNameToProcessorMap.entrySet()) {
			entry.getValue().getCoreInfo().getCore().forEach(k -> {
				FamilyModel familyModel = new FamilyModel();
				familyModel.setArchitecture(k.getArchitecture());
				familyModel.setFamily(k.getFamily());
				familyModel.setRegFile(k.getGDBRegFile());
				familyList.add(familyModel);
			});
		}
		return familyList;
	}

	public String getCoreFamily(String debuggingDeviceName, int coreIndex) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getFamily();
	}

	public String getCoreArchitecture(String debuggingDeviceName, int coreIndex) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex)
				.getArchitecture();
	}

	public String getCoreName(String debuggingDeviceName, int coreIndex) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getName();
	}

	public String getFunnelBaseAddress(String debuggingDeviceName) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCSFunnelBaseAddress();
	}

	public String getETFBaseAddress(String debuggingDeviceName) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCSETFBaseAddress();
	}

	public String getETRBaseAddress(String debuggingDeviceName) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCSETRBaseAddress();
	}

	public String getTPIUBaseAddress(String debuggingDeviceName) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCSTPIUBaseAddress();
	}

	public String getSTMBaseAddress(String debuggingDeviceName) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCSSTMBaseAddress();
	}

	public int getSTMFunnelPortIndex(String debuggingDeviceName) {
		return deviceNameToProcessorMap.get(debuggingDeviceName).getCSSTMFunnelPortIndex();
	}

	public String getCTIBaseAddress(String debuggingDeviceName, int coreIndex) {
		DAPType dap = deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getDAP();
		if (null != dap) {
			return dap.getCTIBaseAddress();
		}
		return "";
	}

	public String getETMBaseAddress(String debuggingDeviceName, int coreIndex) {
		DAPType dap = deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getDAP();
		if (null != dap) {
			return dap.getETMBaseAddress();
		}
		return "";
	}

	public int getFunnelPortIndex(String debuggingDeviceName, int coreIndex) throws CoreException {
		DAPType dap = deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getDAP();
		if (null != dap) {
			return dap.getFunnelPortIndex();
		}
		return -1;
	}

	public String getPTMBaseAddress(String debuggingDeviceName, int coreIndex) {
		DAPType dap = deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getDAP();
		if (null != dap) {
			return dap.getPTMBaseAddress();
		}
		return "";
	}

	public String getDebugBaseAddress(String debuggingDeviceName, int coreIndex) {
		DAPType dap = deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getDAP();
		if (null != dap) {
			return dap.getDebugBaseAddress();
		}
		return "";
	}

	public int getDebugAPIndex(String debuggingDeviceName, int coreIndex) {
		DAPType dap = deviceNameToProcessorMap.get(debuggingDeviceName).getCoreInfo().getCore().get(coreIndex).getDAP();
		if (null != dap) {
			return dap.getDebugApIndex();
		}
		return -1;
	}
}
