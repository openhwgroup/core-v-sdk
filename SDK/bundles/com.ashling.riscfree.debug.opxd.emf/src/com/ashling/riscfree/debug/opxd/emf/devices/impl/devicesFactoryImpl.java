/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ashling.riscfree.debug.opxd.emf.devices.ARCEmulatorType;
import com.ashling.riscfree.debug.opxd.emf.devices.AshlingProcessorDataBaseType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreInfoType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreType;
import com.ashling.riscfree.debug.opxd.emf.devices.DAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.DebuggerControlType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesFactory;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.DocumentRoot;
import com.ashling.riscfree.debug.opxd.emf.devices.JTAGDPType;
import com.ashling.riscfree.debug.opxd.emf.devices.JTAGScanChainType;
import com.ashling.riscfree.debug.opxd.emf.devices.MDMAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.MemAreaType;
import com.ashling.riscfree.debug.opxd.emf.devices.MemoryType;
import com.ashling.riscfree.debug.opxd.emf.devices.ProcessorType;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType;
import com.ashling.riscfree.debug.opxd.emf.devices.TapType1;
import com.ashling.riscfree.debug.opxd.emf.devices.TargetVoltageType;
import com.ashling.riscfree.debug.opxd.emf.devices.VJTAGType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class devicesFactoryImpl extends EFactoryImpl implements devicesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static devicesFactory init() {
		try {
			devicesFactory theDevicesFactory = (devicesFactory)EPackage.Registry.INSTANCE.getEFactory(devicesPackage.eNS_URI);
			if (theDevicesFactory != null) {
				return theDevicesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new devicesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public devicesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case devicesPackage.ARC_EMULATOR_TYPE: return createARCEmulatorType();
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE: return createAshlingProcessorDataBaseType();
			case devicesPackage.CORE_INFO_TYPE: return createCoreInfoType();
			case devicesPackage.CORE_TYPE: return createCoreType();
			case devicesPackage.DAP_TYPE: return createDAPType();
			case devicesPackage.DEBUGGER_CONTROL_TYPE: return createDebuggerControlType();
			case devicesPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case devicesPackage.JTAGDP_TYPE: return createJTAGDPType();
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE: return createJTAGScanChainType();
			case devicesPackage.MDMAP_TYPE: return createMDMAPType();
			case devicesPackage.MEM_AREA_TYPE: return createMemAreaType();
			case devicesPackage.MEMORY_TYPE: return createMemoryType();
			case devicesPackage.PROCESSOR_TYPE: return createProcessorType();
			case devicesPackage.TAP_TYPE: return createTapType();
			case devicesPackage.TAP_TYPE1: return createTapType1();
			case devicesPackage.TARGET_VOLTAGE_TYPE: return createTargetVoltageType();
			case devicesPackage.VJTAG_TYPE: return createVJTAGType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARCEmulatorType createARCEmulatorType() {
		ARCEmulatorTypeImpl arcEmulatorType = new ARCEmulatorTypeImpl();
		return arcEmulatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AshlingProcessorDataBaseType createAshlingProcessorDataBaseType() {
		AshlingProcessorDataBaseTypeImpl ashlingProcessorDataBaseType = new AshlingProcessorDataBaseTypeImpl();
		return ashlingProcessorDataBaseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreInfoType createCoreInfoType() {
		CoreInfoTypeImpl coreInfoType = new CoreInfoTypeImpl();
		return coreInfoType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreType createCoreType() {
		CoreTypeImpl coreType = new CoreTypeImpl();
		return coreType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DAPType createDAPType() {
		DAPTypeImpl dapType = new DAPTypeImpl();
		return dapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebuggerControlType createDebuggerControlType() {
		DebuggerControlTypeImpl debuggerControlType = new DebuggerControlTypeImpl();
		return debuggerControlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JTAGDPType createJTAGDPType() {
		JTAGDPTypeImpl jtagdpType = new JTAGDPTypeImpl();
		return jtagdpType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JTAGScanChainType createJTAGScanChainType() {
		JTAGScanChainTypeImpl jtagScanChainType = new JTAGScanChainTypeImpl();
		return jtagScanChainType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDMAPType createMDMAPType() {
		MDMAPTypeImpl mdmapType = new MDMAPTypeImpl();
		return mdmapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemAreaType createMemAreaType() {
		MemAreaTypeImpl memAreaType = new MemAreaTypeImpl();
		return memAreaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryType createMemoryType() {
		MemoryTypeImpl memoryType = new MemoryTypeImpl();
		return memoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorType createProcessorType() {
		ProcessorTypeImpl processorType = new ProcessorTypeImpl();
		return processorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapType createTapType() {
		TapTypeImpl tapType = new TapTypeImpl();
		return tapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapType1 createTapType1() {
		TapType1Impl tapType1 = new TapType1Impl();
		return tapType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetVoltageType createTargetVoltageType() {
		TargetVoltageTypeImpl targetVoltageType = new TargetVoltageTypeImpl();
		return targetVoltageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VJTAGType createVJTAGType() {
		VJTAGTypeImpl vjtagType = new VJTAGTypeImpl();
		return vjtagType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public devicesPackage getDevicesPackage() {
		return (devicesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static devicesPackage getPackage() {
		return devicesPackage.eINSTANCE;
	}

} //DevicesFactoryImpl
