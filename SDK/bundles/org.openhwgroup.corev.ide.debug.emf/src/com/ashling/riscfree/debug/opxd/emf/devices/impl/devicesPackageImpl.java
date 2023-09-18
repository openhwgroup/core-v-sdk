/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class devicesPackageImpl extends EPackageImpl implements devicesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arcEmulatorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ashlingProcessorDataBaseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreInfoTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dapTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass debuggerControlTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jtagdpTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jtagScanChainTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mdmapTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memAreaTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tapTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tapType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetVoltageTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vjtagTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see devicesPackage.DevicesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private devicesPackageImpl() {
		super(eNS_URI, devicesFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link devicesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static devicesPackage init() {
		if (isInited) return (devicesPackage)EPackage.Registry.INSTANCE.getEPackage(devicesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDevicesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		devicesPackageImpl theDevicesPackage = registeredDevicesPackage instanceof devicesPackageImpl ? (devicesPackageImpl)registeredDevicesPackage : new devicesPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDevicesPackage.createPackageContents();

		// Initialize created meta-data
		theDevicesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDevicesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(devicesPackage.eNS_URI, theDevicesPackage);
		return theDevicesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getARCEmulatorType() {
		return arcEmulatorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getARCEmulatorType_TargetVoltage() {
		return (EReference)arcEmulatorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAshlingProcessorDataBaseType() {
		return ashlingProcessorDataBaseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAshlingProcessorDataBaseType_Processor() {
		return (EReference)ashlingProcessorDataBaseTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAshlingProcessorDataBaseType_Date() {
		return (EAttribute)ashlingProcessorDataBaseTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAshlingProcessorDataBaseType_Family() {
		return (EAttribute)ashlingProcessorDataBaseTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAshlingProcessorDataBaseType_SubSet() {
		return (EAttribute)ashlingProcessorDataBaseTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAshlingProcessorDataBaseType_Version() {
		return (EAttribute)ashlingProcessorDataBaseTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreInfoType() {
		return coreInfoTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreInfoType_Core() {
		return (EReference)coreInfoTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreType() {
		return coreTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreType_DAP() {
		return (EReference)coreTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreType_Tap() {
		return (EReference)coreTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreType_VJTAG() {
		return (EReference)coreTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreType_DebugBaseAddress() {
		return (EAttribute)coreTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreType_Memory() {
		return (EReference)coreTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreType_GDBRegFile() {
		return (EAttribute)coreTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreType_Architecture() {
		return (EAttribute)coreTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreType_Family() {
		return (EAttribute)coreTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreType_Name() {
		return (EAttribute)coreTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoreType_Number() {
		return (EAttribute)coreTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDAPType() {
		return dapTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDAPType_JTAGDP() {
		return (EReference)dapTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDAPType_SWDDP() {
		return (EReference)dapTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_DebugBaseAddress() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_CTIBaseAddress() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_PTMBaseAddress() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_ETMBaseAddress() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_FunnelPortIndex() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_DebugApIndex() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_DebugPulpNPCAddr() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_DebugTransport() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_MemoryApIndex() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_JtagApIndex() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDAPType_UseMemApForMemAccess() {
		return (EAttribute)dapTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDebuggerControlType() {
		return debuggerControlTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebuggerControlType_MaxJtagFrequencyKhz() {
		return (EAttribute)debuggerControlTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AshlingProcessorDataBase() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJTAGDPType() {
		return jtagdpTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJTAGDPType_Refid() {
		return (EAttribute)jtagdpTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJTAGScanChainType() {
		return jtagScanChainTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJTAGScanChainType_Tap() {
		return (EReference)jtagScanChainTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDMAPType() {
		return mdmapTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMDMAPType_BaseAddress() {
		return (EAttribute)mdmapTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemAreaType() {
		return memAreaTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemAreaType_Access() {
		return (EAttribute)memAreaTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemAreaType_Name() {
		return (EAttribute)memAreaTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemAreaType_Size() {
		return (EAttribute)memAreaTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemAreaType_Start() {
		return (EAttribute)memAreaTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemAreaType_Type() {
		return (EAttribute)memAreaTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryType() {
		return memoryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryType_MemArea() {
		return (EReference)memoryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorType() {
		return processorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSFunnelBaseAddress() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSETFBaseAddress() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSETRBaseAddress() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSTPIUBaseAddress() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSSTMBaseAddress() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSSTMFunnelPortIndex() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CSTSBaseAddress() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_InternalName() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_DeviceType() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_CoresightCompliant() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_ResetType() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_DebuggerControl() {
		return (EReference)processorTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_ARCEmulator() {
		return (EReference)processorTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_InstructionToSelectADI() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_MDMAP() {
		return (EReference)processorTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_EscapeSequenceType() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_JTAGScanChain() {
		return (EReference)processorTypeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessorType_CoreInfo() {
		return (EReference)processorTypeEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_MultiCoreSupported() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_UseNonStopMode() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_DefaultTAP() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorType_Device() {
		return (EAttribute)processorTypeEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTapType() {
		return tapTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapType_Refid() {
		return (EAttribute)tapTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTapType1() {
		return tapType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapType1_IRlength() {
		return (EAttribute)tapType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapType1_BypassInst() {
		return (EAttribute)tapType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapType1_Id() {
		return (EAttribute)tapType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTapType1_Number() {
		return (EAttribute)tapType1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetVoltageType() {
		return targetVoltageTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetVoltageType_SupplyType() {
		return (EAttribute)targetVoltageTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVJTAGType() {
		return vjtagTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVJTAGType_NodeIndex() {
		return (EAttribute)vjtagTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public devicesFactory getDevicesFactory() {
		return (devicesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		arcEmulatorTypeEClass = createEClass(ARC_EMULATOR_TYPE);
		createEReference(arcEmulatorTypeEClass, ARC_EMULATOR_TYPE__TARGET_VOLTAGE);

		ashlingProcessorDataBaseTypeEClass = createEClass(ASHLING_PROCESSOR_DATA_BASE_TYPE);
		createEReference(ashlingProcessorDataBaseTypeEClass, ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR);
		createEAttribute(ashlingProcessorDataBaseTypeEClass, ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE);
		createEAttribute(ashlingProcessorDataBaseTypeEClass, ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY);
		createEAttribute(ashlingProcessorDataBaseTypeEClass, ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET);
		createEAttribute(ashlingProcessorDataBaseTypeEClass, ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION);

		coreInfoTypeEClass = createEClass(CORE_INFO_TYPE);
		createEReference(coreInfoTypeEClass, CORE_INFO_TYPE__CORE);

		coreTypeEClass = createEClass(CORE_TYPE);
		createEReference(coreTypeEClass, CORE_TYPE__DAP);
		createEReference(coreTypeEClass, CORE_TYPE__TAP);
		createEReference(coreTypeEClass, CORE_TYPE__VJTAG);
		createEAttribute(coreTypeEClass, CORE_TYPE__DEBUG_BASE_ADDRESS);
		createEReference(coreTypeEClass, CORE_TYPE__MEMORY);
		createEAttribute(coreTypeEClass, CORE_TYPE__GDB_REG_FILE);
		createEAttribute(coreTypeEClass, CORE_TYPE__ARCHITECTURE);
		createEAttribute(coreTypeEClass, CORE_TYPE__FAMILY);
		createEAttribute(coreTypeEClass, CORE_TYPE__NAME);
		createEAttribute(coreTypeEClass, CORE_TYPE__NUMBER);

		dapTypeEClass = createEClass(DAP_TYPE);
		createEReference(dapTypeEClass, DAP_TYPE__JTAGDP);
		createEReference(dapTypeEClass, DAP_TYPE__SWDDP);
		createEAttribute(dapTypeEClass, DAP_TYPE__DEBUG_BASE_ADDRESS);
		createEAttribute(dapTypeEClass, DAP_TYPE__CTI_BASE_ADDRESS);
		createEAttribute(dapTypeEClass, DAP_TYPE__PTM_BASE_ADDRESS);
		createEAttribute(dapTypeEClass, DAP_TYPE__ETM_BASE_ADDRESS);
		createEAttribute(dapTypeEClass, DAP_TYPE__FUNNEL_PORT_INDEX);
		createEAttribute(dapTypeEClass, DAP_TYPE__DEBUG_AP_INDEX);
		createEAttribute(dapTypeEClass, DAP_TYPE__DEBUG_PULP_NPC_ADDR);
		createEAttribute(dapTypeEClass, DAP_TYPE__DEBUG_TRANSPORT);
		createEAttribute(dapTypeEClass, DAP_TYPE__MEMORY_AP_INDEX);
		createEAttribute(dapTypeEClass, DAP_TYPE__JTAG_AP_INDEX);
		createEAttribute(dapTypeEClass, DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS);

		debuggerControlTypeEClass = createEClass(DEBUGGER_CONTROL_TYPE);
		createEAttribute(debuggerControlTypeEClass, DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ASHLING_PROCESSOR_DATA_BASE);

		jtagdpTypeEClass = createEClass(JTAGDP_TYPE);
		createEAttribute(jtagdpTypeEClass, JTAGDP_TYPE__REFID);

		jtagScanChainTypeEClass = createEClass(JTAG_SCAN_CHAIN_TYPE);
		createEReference(jtagScanChainTypeEClass, JTAG_SCAN_CHAIN_TYPE__TAP);

		mdmapTypeEClass = createEClass(MDMAP_TYPE);
		createEAttribute(mdmapTypeEClass, MDMAP_TYPE__BASE_ADDRESS);

		memAreaTypeEClass = createEClass(MEM_AREA_TYPE);
		createEAttribute(memAreaTypeEClass, MEM_AREA_TYPE__ACCESS);
		createEAttribute(memAreaTypeEClass, MEM_AREA_TYPE__NAME);
		createEAttribute(memAreaTypeEClass, MEM_AREA_TYPE__SIZE);
		createEAttribute(memAreaTypeEClass, MEM_AREA_TYPE__START);
		createEAttribute(memAreaTypeEClass, MEM_AREA_TYPE__TYPE);

		memoryTypeEClass = createEClass(MEMORY_TYPE);
		createEReference(memoryTypeEClass, MEMORY_TYPE__MEM_AREA);

		processorTypeEClass = createEClass(PROCESSOR_TYPE);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CSETF_BASE_ADDRESS);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CSETR_BASE_ADDRESS);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CSSTM_BASE_ADDRESS);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CSTS_BASE_ADDRESS);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__INTERNAL_NAME);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__DEVICE_TYPE);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__CORESIGHT_COMPLIANT);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__RESET_TYPE);
		createEReference(processorTypeEClass, PROCESSOR_TYPE__DEBUGGER_CONTROL);
		createEReference(processorTypeEClass, PROCESSOR_TYPE__ARC_EMULATOR);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI);
		createEReference(processorTypeEClass, PROCESSOR_TYPE__MDMAP);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE);
		createEReference(processorTypeEClass, PROCESSOR_TYPE__JTAG_SCAN_CHAIN);
		createEReference(processorTypeEClass, PROCESSOR_TYPE__CORE_INFO);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__MULTI_CORE_SUPPORTED);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__USE_NON_STOP_MODE);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__DEFAULT_TAP);
		createEAttribute(processorTypeEClass, PROCESSOR_TYPE__DEVICE);

		tapTypeEClass = createEClass(TAP_TYPE);
		createEAttribute(tapTypeEClass, TAP_TYPE__REFID);

		tapType1EClass = createEClass(TAP_TYPE1);
		createEAttribute(tapType1EClass, TAP_TYPE1__IRLENGTH);
		createEAttribute(tapType1EClass, TAP_TYPE1__BYPASS_INST);
		createEAttribute(tapType1EClass, TAP_TYPE1__ID);
		createEAttribute(tapType1EClass, TAP_TYPE1__NUMBER);

		targetVoltageTypeEClass = createEClass(TARGET_VOLTAGE_TYPE);
		createEAttribute(targetVoltageTypeEClass, TARGET_VOLTAGE_TYPE__SUPPLY_TYPE);

		vjtagTypeEClass = createEClass(VJTAG_TYPE);
		createEAttribute(vjtagTypeEClass, VJTAG_TYPE__NODE_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(arcEmulatorTypeEClass, ARCEmulatorType.class, "ARCEmulatorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getARCEmulatorType_TargetVoltage(), this.getTargetVoltageType(), null, "targetVoltage", null, 1, 1, ARCEmulatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ashlingProcessorDataBaseTypeEClass, AshlingProcessorDataBaseType.class, "AshlingProcessorDataBaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAshlingProcessorDataBaseType_Processor(), this.getProcessorType(), null, "processor", null, 1, -1, AshlingProcessorDataBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAshlingProcessorDataBaseType_Date(), theXMLTypePackage.getDate(), "date", null, 1, 1, AshlingProcessorDataBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAshlingProcessorDataBaseType_Family(), theXMLTypePackage.getString(), "family", null, 1, 1, AshlingProcessorDataBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAshlingProcessorDataBaseType_SubSet(), theXMLTypePackage.getString(), "subSet", null, 1, 1, AshlingProcessorDataBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAshlingProcessorDataBaseType_Version(), theXMLTypePackage.getUnsignedByte(), "version", null, 1, 1, AshlingProcessorDataBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreInfoTypeEClass, CoreInfoType.class, "CoreInfoType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCoreInfoType_Core(), this.getCoreType(), null, "core", null, 1, -1, CoreInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreTypeEClass, CoreType.class, "CoreType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCoreType_DAP(), this.getDAPType(), null, "dAP", null, 0, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreType_Tap(), this.getTapType(), null, "tap", null, 0, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreType_VJTAG(), this.getVJTAGType(), null, "vJTAG", null, 0, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreType_DebugBaseAddress(), theXMLTypePackage.getString(), "debugBaseAddress", null, 0, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreType_Memory(), this.getMemoryType(), null, "memory", null, 0, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreType_GDBRegFile(), theXMLTypePackage.getString(), "gDBRegFile", null, 0, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreType_Architecture(), theXMLTypePackage.getString(), "architecture", null, 1, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreType_Family(), theXMLTypePackage.getString(), "family", null, 1, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoreType_Number(), theXMLTypePackage.getUnsignedByte(), "number", null, 1, 1, CoreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dapTypeEClass, DAPType.class, "DAPType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDAPType_JTAGDP(), this.getJTAGDPType(), null, "jTAGDP", null, 1, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDAPType_SWDDP(), ecorePackage.getEObject(), null, "sWDDP", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_DebugBaseAddress(), theXMLTypePackage.getString(), "debugBaseAddress", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_CTIBaseAddress(), theXMLTypePackage.getString(), "cTIBaseAddress", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_PTMBaseAddress(), theXMLTypePackage.getString(), "pTMBaseAddress", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_ETMBaseAddress(), theXMLTypePackage.getString(), "eTMBaseAddress", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_FunnelPortIndex(), theXMLTypePackage.getUnsignedByte(), "funnelPortIndex", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_DebugApIndex(), theXMLTypePackage.getUnsignedByte(), "debugApIndex", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_DebugPulpNPCAddr(), theXMLTypePackage.getString(), "debugPulpNPCAddr", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_DebugTransport(), theXMLTypePackage.getUnsignedByte(), "debugTransport", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_MemoryApIndex(), theXMLTypePackage.getUnsignedByte(), "memoryApIndex", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_JtagApIndex(), theXMLTypePackage.getUnsignedByte(), "jtagApIndex", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDAPType_UseMemApForMemAccess(), theXMLTypePackage.getUnsignedByte(), "useMemApForMemAccess", null, 0, 1, DAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(debuggerControlTypeEClass, DebuggerControlType.class, "DebuggerControlType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDebuggerControlType_MaxJtagFrequencyKhz(), theXMLTypePackage.getUnsignedInt(), "maxJtagFrequencyKhz", null, 1, 1, DebuggerControlType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AshlingProcessorDataBase(), this.getAshlingProcessorDataBaseType(), null, "ashlingProcessorDataBase", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(jtagdpTypeEClass, JTAGDPType.class, "JTAGDPType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJTAGDPType_Refid(), theXMLTypePackage.getUnsignedByte(), "refid", null, 1, 1, JTAGDPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jtagScanChainTypeEClass, JTAGScanChainType.class, "JTAGScanChainType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJTAGScanChainType_Tap(), this.getTapType1(), null, "tap", null, 1, -1, JTAGScanChainType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mdmapTypeEClass, MDMAPType.class, "MDMAPType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMDMAPType_BaseAddress(), theXMLTypePackage.getString(), "baseAddress", null, 1, 1, MDMAPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memAreaTypeEClass, MemAreaType.class, "MemAreaType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemAreaType_Access(), theXMLTypePackage.getString(), "access", null, 1, 1, MemAreaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemAreaType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, MemAreaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemAreaType_Size(), theXMLTypePackage.getString(), "size", null, 1, 1, MemAreaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemAreaType_Start(), theXMLTypePackage.getString(), "start", null, 1, 1, MemAreaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemAreaType_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, MemAreaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryTypeEClass, MemoryType.class, "MemoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemoryType_MemArea(), this.getMemAreaType(), null, "memArea", null, 1, -1, MemoryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processorTypeEClass, ProcessorType.class, "ProcessorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessorType_CSFunnelBaseAddress(), theXMLTypePackage.getString(), "cSFunnelBaseAddress", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CSETFBaseAddress(), theXMLTypePackage.getString(), "cSETFBaseAddress", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CSETRBaseAddress(), theXMLTypePackage.getString(), "cSETRBaseAddress", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CSTPIUBaseAddress(), theXMLTypePackage.getString(), "cSTPIUBaseAddress", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CSSTMBaseAddress(), theXMLTypePackage.getString(), "cSSTMBaseAddress", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CSSTMFunnelPortIndex(), theXMLTypePackage.getUnsignedByte(), "cSSTMFunnelPortIndex", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CSTSBaseAddress(), theXMLTypePackage.getString(), "cSTSBaseAddress", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_InternalName(), theXMLTypePackage.getString(), "internalName", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_DeviceType(), theXMLTypePackage.getUnsignedByte(), "deviceType", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_CoresightCompliant(), theXMLTypePackage.getUnsignedByte(), "coresightCompliant", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_ResetType(), theXMLTypePackage.getString(), "resetType", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessorType_DebuggerControl(), this.getDebuggerControlType(), null, "debuggerControl", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessorType_ARCEmulator(), this.getARCEmulatorType(), null, "aRCEmulator", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_InstructionToSelectADI(), theXMLTypePackage.getString(), "instructionToSelectADI", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessorType_MDMAP(), this.getMDMAPType(), null, "mDMAP", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_EscapeSequenceType(), theXMLTypePackage.getUnsignedByte(), "escapeSequenceType", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessorType_JTAGScanChain(), this.getJTAGScanChainType(), null, "jTAGScanChain", null, 1, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessorType_CoreInfo(), this.getCoreInfoType(), null, "coreInfo", null, 1, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_MultiCoreSupported(), theXMLTypePackage.getBoolean(), "multiCoreSupported", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_UseNonStopMode(), theXMLTypePackage.getBoolean(), "useNonStopMode", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_DefaultTAP(), theXMLTypePackage.getUnsignedByte(), "defaultTAP", null, 0, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessorType_Device(), theXMLTypePackage.getString(), "device", null, 1, 1, ProcessorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tapTypeEClass, TapType.class, "TapType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTapType_Refid(), theXMLTypePackage.getUnsignedByte(), "refid", null, 1, 1, TapType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tapType1EClass, TapType1.class, "TapType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTapType1_IRlength(), theXMLTypePackage.getUnsignedByte(), "iRlength", null, 1, 1, TapType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapType1_BypassInst(), theXMLTypePackage.getString(), "bypassInst", null, 1, 1, TapType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapType1_Id(), theXMLTypePackage.getUnsignedByte(), "id", null, 1, 1, TapType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTapType1_Number(), theXMLTypePackage.getUnsignedByte(), "number", null, 1, 1, TapType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetVoltageTypeEClass, TargetVoltageType.class, "TargetVoltageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetVoltageType_SupplyType(), theXMLTypePackage.getString(), "supplyType", null, 1, 1, TargetVoltageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vjtagTypeEClass, VJTAGType.class, "VJTAGType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVJTAGType_NodeIndex(), theXMLTypePackage.getUnsignedByte(), "nodeIndex", null, 1, 1, VJTAGType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "qualified", "false"
		   });
		addAnnotation
		  (arcEmulatorTypeEClass,
		   source,
		   new String[] {
			   "name", "ARCEmulator_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getARCEmulatorType_TargetVoltage(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TargetVoltage",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (ashlingProcessorDataBaseTypeEClass,
		   source,
		   new String[] {
			   "name", "AshlingProcessorDataBase_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getAshlingProcessorDataBaseType_Processor(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Processor",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAshlingProcessorDataBaseType_Date(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Date",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAshlingProcessorDataBaseType_Family(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Family",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAshlingProcessorDataBaseType_SubSet(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "SubSet",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAshlingProcessorDataBaseType_Version(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Version",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (coreInfoTypeEClass,
		   source,
		   new String[] {
			   "name", "CoreInfo_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getCoreInfoType_Core(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Core",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (coreTypeEClass,
		   source,
		   new String[] {
			   "name", "Core_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getCoreType_DAP(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DAP",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_Tap(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Tap",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_VJTAG(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VJTAG",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_DebugBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DebugBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_Memory(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Memory",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_GDBRegFile(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GDBRegFile",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_Architecture(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Architecture",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_Family(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Family",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getCoreType_Number(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Number",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (dapTypeEClass,
		   source,
		   new String[] {
			   "name", "DAP_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getDAPType_JTAGDP(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "JTAGDP",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_SWDDP(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SWDDP",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_DebugBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DebugBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_CTIBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CTIBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_PTMBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PTMBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_ETMBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ETMBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_FunnelPortIndex(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "FunnelPortIndex",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_DebugApIndex(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DebugApIndex",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_DebugPulpNPCAddr(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DebugPulpNPCAddr",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_DebugTransport(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DebugTransport",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_MemoryApIndex(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "MemoryApIndex",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_JtagApIndex(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "JtagApIndex",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDAPType_UseMemApForMemAccess(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "UseMemApForMemAccess",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (debuggerControlTypeEClass,
		   source,
		   new String[] {
			   "name", "DebuggerControl_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getDebuggerControlType_MaxJtagFrequencyKhz(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "MaxJtagFrequencyKhz",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (documentRootEClass,
		   source,
		   new String[] {
			   "name", "",
			   "kind", "mixed"
		   });
		addAnnotation
		  (getDocumentRoot_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "xmlns:prefix"
		   });
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "xsi:schemaLocation"
		   });
		addAnnotation
		  (getDocumentRoot_AshlingProcessorDataBase(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "AshlingProcessorDataBase",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (jtagdpTypeEClass,
		   source,
		   new String[] {
			   "name", "JTAGDP_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getJTAGDPType_Refid(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "refid",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (jtagScanChainTypeEClass,
		   source,
		   new String[] {
			   "name", "JTAGScanChain_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getJTAGScanChainType_Tap(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "Tap",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (mdmapTypeEClass,
		   source,
		   new String[] {
			   "name", "MDMAP_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getMDMAPType_BaseAddress(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "BaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (memAreaTypeEClass,
		   source,
		   new String[] {
			   "name", "MemArea_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getMemAreaType_Access(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Access",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getMemAreaType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getMemAreaType_Size(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Size",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getMemAreaType_Start(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Start",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getMemAreaType_Type(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Type",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (memoryTypeEClass,
		   source,
		   new String[] {
			   "name", "Memory_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getMemoryType_MemArea(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "MemArea",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (processorTypeEClass,
		   source,
		   new String[] {
			   "name", "Processor_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getProcessorType_CSFunnelBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSFunnelBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CSETFBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSETFBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CSETRBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSETRBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CSTPIUBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSTPIUBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CSSTMBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSSTMBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CSSTMFunnelPortIndex(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSSTMFunnelPortIndex",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CSTSBaseAddress(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CSTSBaseAddress",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_InternalName(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "InternalName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_DeviceType(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DeviceType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CoresightCompliant(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CoresightCompliant",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_ResetType(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ResetType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_DebuggerControl(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DebuggerControl",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_ARCEmulator(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ARCEmulator",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_InstructionToSelectADI(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "InstructionToSelectADI",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_MDMAP(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "MDMAP",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_EscapeSequenceType(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "EscapeSequenceType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_JTAGScanChain(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "JTAGScanChain",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_CoreInfo(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CoreInfo",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_MultiCoreSupported(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "MultiCoreSupported",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_UseNonStopMode(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "UseNonStopMode",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_DefaultTAP(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DefaultTAP",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getProcessorType_Device(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Device",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (tapTypeEClass,
		   source,
		   new String[] {
			   "name", "Tap_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getTapType_Refid(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "refid",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (tapType1EClass,
		   source,
		   new String[] {
			   "name", "Tap_._1_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getTapType1_IRlength(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "IRlength",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTapType1_BypassInst(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BypassInst",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTapType1_Id(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "id",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTapType1_Number(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "Number",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (targetVoltageTypeEClass,
		   source,
		   new String[] {
			   "name", "TargetVoltage_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getTargetVoltageType_SupplyType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "SupplyType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (vjtagTypeEClass,
		   source,
		   new String[] {
			   "name", "VJTAG_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getVJTAGType_NodeIndex(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "NodeIndex",
			   "namespace", "##targetNamespace"
		   });
	}

} //DevicesPackageImpl
