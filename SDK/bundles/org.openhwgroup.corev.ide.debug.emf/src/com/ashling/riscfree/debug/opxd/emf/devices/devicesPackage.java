/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see devicesFactory.DevicesFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface devicesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Devices";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "file:/C:/Users/Ashling/Downloads/devices.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Devices";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	devicesPackage eINSTANCE = com.ashling.riscfree.debug.opxd.emf.devices.impl.devicesPackageImpl.init();

	/**
	 * The meta object id for the '{@link Devices.impl.ARCEmulatorTypeImpl <em>ARC Emulator Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.ARCEmulatorTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getARCEmulatorType()
	 * @generated
	 */
	int ARC_EMULATOR_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Target Voltage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_EMULATOR_TYPE__TARGET_VOLTAGE = 0;

	/**
	 * The number of structural features of the '<em>ARC Emulator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_EMULATOR_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>ARC Emulator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_EMULATOR_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.AshlingProcessorDataBaseTypeImpl <em>Ashling Processor Data Base Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.AshlingProcessorDataBaseTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getAshlingProcessorDataBaseType()
	 * @generated
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE = 1;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY = 2;

	/**
	 * The feature id for the '<em><b>Sub Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION = 4;

	/**
	 * The number of structural features of the '<em>Ashling Processor Data Base Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Ashling Processor Data Base Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASHLING_PROCESSOR_DATA_BASE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.CoreInfoTypeImpl <em>Core Info Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.CoreInfoTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getCoreInfoType()
	 * @generated
	 */
	int CORE_INFO_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Core</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_INFO_TYPE__CORE = 0;

	/**
	 * The number of structural features of the '<em>Core Info Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_INFO_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Core Info Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_INFO_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.CoreTypeImpl <em>Core Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.CoreTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getCoreType()
	 * @generated
	 */
	int CORE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>DAP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__DAP = 0;

	/**
	 * The feature id for the '<em><b>Tap</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__TAP = 1;

	/**
	 * The feature id for the '<em><b>VJTAG</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__VJTAG = 2;

	/**
	 * The feature id for the '<em><b>Debug Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__DEBUG_BASE_ADDRESS = 3;

	/**
	 * The feature id for the '<em><b>Memory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__MEMORY = 4;

	/**
	 * The feature id for the '<em><b>GDB Reg File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__GDB_REG_FILE = 5;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__ARCHITECTURE = 6;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__FAMILY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__NAME = 8;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE__NUMBER = 9;

	/**
	 * The number of structural features of the '<em>Core Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Core Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.DAPTypeImpl <em>DAP Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.DAPTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getDAPType()
	 * @generated
	 */
	int DAP_TYPE = 4;

	/**
	 * The feature id for the '<em><b>JTAGDP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__JTAGDP = 0;

	/**
	 * The feature id for the '<em><b>SWDDP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__SWDDP = 1;

	/**
	 * The feature id for the '<em><b>Debug Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__DEBUG_BASE_ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>CTI Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__CTI_BASE_ADDRESS = 3;

	/**
	 * The feature id for the '<em><b>PTM Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__PTM_BASE_ADDRESS = 4;

	/**
	 * The feature id for the '<em><b>ETM Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__ETM_BASE_ADDRESS = 5;

	/**
	 * The feature id for the '<em><b>Funnel Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__FUNNEL_PORT_INDEX = 6;

	/**
	 * The feature id for the '<em><b>Debug Ap Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__DEBUG_AP_INDEX = 7;

	/**
	 * The feature id for the '<em><b>Debug Pulp NPC Addr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__DEBUG_PULP_NPC_ADDR = 8;

	/**
	 * The feature id for the '<em><b>Debug Transport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__DEBUG_TRANSPORT = 9;

	/**
	 * The feature id for the '<em><b>Memory Ap Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__MEMORY_AP_INDEX = 10;

	/**
	 * The feature id for the '<em><b>Jtag Ap Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__JTAG_AP_INDEX = 11;

	/**
	 * The feature id for the '<em><b>Use Mem Ap For Mem Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS = 12;

	/**
	 * The number of structural features of the '<em>DAP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>DAP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAP_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.DebuggerControlTypeImpl <em>Debugger Control Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.DebuggerControlTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getDebuggerControlType()
	 * @generated
	 */
	int DEBUGGER_CONTROL_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Max Jtag Frequency Khz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ = 0;

	/**
	 * The number of structural features of the '<em>Debugger Control Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUGGER_CONTROL_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Debugger Control Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUGGER_CONTROL_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.DocumentRootImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Ashling Processor Data Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ASHLING_PROCESSOR_DATA_BASE = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.JTAGDPTypeImpl <em>JTAGDP Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.JTAGDPTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getJTAGDPType()
	 * @generated
	 */
	int JTAGDP_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Refid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTAGDP_TYPE__REFID = 0;

	/**
	 * The number of structural features of the '<em>JTAGDP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTAGDP_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>JTAGDP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTAGDP_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.JTAGScanChainTypeImpl <em>JTAG Scan Chain Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.JTAGScanChainTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getJTAGScanChainType()
	 * @generated
	 */
	int JTAG_SCAN_CHAIN_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Tap</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTAG_SCAN_CHAIN_TYPE__TAP = 0;

	/**
	 * The number of structural features of the '<em>JTAG Scan Chain Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTAG_SCAN_CHAIN_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>JTAG Scan Chain Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTAG_SCAN_CHAIN_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.MDMAPTypeImpl <em>MDMAP Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.MDMAPTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getMDMAPType()
	 * @generated
	 */
	int MDMAP_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDMAP_TYPE__BASE_ADDRESS = 0;

	/**
	 * The number of structural features of the '<em>MDMAP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDMAP_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MDMAP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDMAP_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.MemAreaTypeImpl <em>Mem Area Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.MemAreaTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getMemAreaType()
	 * @generated
	 */
	int MEM_AREA_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE__ACCESS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE__SIZE = 2;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE__START = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Mem Area Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Mem Area Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEM_AREA_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.MemoryTypeImpl <em>Memory Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.MemoryTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getMemoryType()
	 * @generated
	 */
	int MEMORY_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Mem Area</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_TYPE__MEM_AREA = 0;

	/**
	 * The number of structural features of the '<em>Memory Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Memory Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.ProcessorTypeImpl <em>Processor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.ProcessorTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getProcessorType()
	 * @generated
	 */
	int PROCESSOR_TYPE = 12;

	/**
	 * The feature id for the '<em><b>CS Funnel Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>CSETF Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CSETF_BASE_ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>CSETR Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CSETR_BASE_ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>CSTPIU Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS = 3;

	/**
	 * The feature id for the '<em><b>CSSTM Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CSSTM_BASE_ADDRESS = 4;

	/**
	 * The feature id for the '<em><b>CSSTM Funnel Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX = 5;

	/**
	 * The feature id for the '<em><b>CSTS Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CSTS_BASE_ADDRESS = 6;

	/**
	 * The feature id for the '<em><b>Internal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__INTERNAL_NAME = 7;

	/**
	 * The feature id for the '<em><b>Device Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__DEVICE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Coresight Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CORESIGHT_COMPLIANT = 9;

	/**
	 * The feature id for the '<em><b>Reset Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__RESET_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Debugger Control</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__DEBUGGER_CONTROL = 11;

	/**
	 * The feature id for the '<em><b>ARC Emulator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__ARC_EMULATOR = 12;

	/**
	 * The feature id for the '<em><b>Instruction To Select ADI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI = 13;

	/**
	 * The feature id for the '<em><b>MDMAP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__MDMAP = 14;

	/**
	 * The feature id for the '<em><b>Escape Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>JTAG Scan Chain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__JTAG_SCAN_CHAIN = 16;

	/**
	 * The feature id for the '<em><b>Core Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__CORE_INFO = 17;

	/**
	 * The feature id for the '<em><b>Multi Core Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__MULTI_CORE_SUPPORTED = 18;

	/**
	 * The feature id for the '<em><b>Use Non Stop Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__USE_NON_STOP_MODE = 19;

	/**
	 * The feature id for the '<em><b>Default TAP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__DEFAULT_TAP = 20;

	/**
	 * The feature id for the '<em><b>Device</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE__DEVICE = 21;

	/**
	 * The number of structural features of the '<em>Processor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE_FEATURE_COUNT = 22;

	/**
	 * The number of operations of the '<em>Processor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.TapTypeImpl <em>Tap Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.TapTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getTapType()
	 * @generated
	 */
	int TAP_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Refid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE__REFID = 0;

	/**
	 * The number of structural features of the '<em>Tap Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tap Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.TapType1Impl <em>Tap Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.TapType1Impl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getTapType1()
	 * @generated
	 */
	int TAP_TYPE1 = 14;

	/**
	 * The feature id for the '<em><b>IRlength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE1__IRLENGTH = 0;

	/**
	 * The feature id for the '<em><b>Bypass Inst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE1__BYPASS_INST = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE1__ID = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE1__NUMBER = 3;

	/**
	 * The number of structural features of the '<em>Tap Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE1_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tap Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAP_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.TargetVoltageTypeImpl <em>Target Voltage Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.TargetVoltageTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getTargetVoltageType()
	 * @generated
	 */
	int TARGET_VOLTAGE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Supply Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_VOLTAGE_TYPE__SUPPLY_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Target Voltage Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_VOLTAGE_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Target Voltage Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_VOLTAGE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Devices.impl.VJTAGTypeImpl <em>VJTAG Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Devices.impl.VJTAGTypeImpl
	 * @see devicesPackageImpl.impl.DevicesPackageImpl#getVJTAGType()
	 * @generated
	 */
	int VJTAG_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Node Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VJTAG_TYPE__NODE_INDEX = 0;

	/**
	 * The number of structural features of the '<em>VJTAG Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VJTAG_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>VJTAG Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VJTAG_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Devices.ARCEmulatorType <em>ARC Emulator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARC Emulator Type</em>'.
	 * @see Devices.ARCEmulatorType
	 * @generated
	 */
	EClass getARCEmulatorType();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.ARCEmulatorType#getTargetVoltage <em>Target Voltage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Voltage</em>'.
	 * @see Devices.ARCEmulatorType#getTargetVoltage()
	 * @see #getARCEmulatorType()
	 * @generated
	 */
	EReference getARCEmulatorType_TargetVoltage();

	/**
	 * Returns the meta object for class '{@link Devices.AshlingProcessorDataBaseType <em>Ashling Processor Data Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ashling Processor Data Base Type</em>'.
	 * @see Devices.AshlingProcessorDataBaseType
	 * @generated
	 */
	EClass getAshlingProcessorDataBaseType();

	/**
	 * Returns the meta object for the containment reference list '{@link Devices.AshlingProcessorDataBaseType#getProcessor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processor</em>'.
	 * @see Devices.AshlingProcessorDataBaseType#getProcessor()
	 * @see #getAshlingProcessorDataBaseType()
	 * @generated
	 */
	EReference getAshlingProcessorDataBaseType_Processor();

	/**
	 * Returns the meta object for the attribute '{@link Devices.AshlingProcessorDataBaseType#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see Devices.AshlingProcessorDataBaseType#getDate()
	 * @see #getAshlingProcessorDataBaseType()
	 * @generated
	 */
	EAttribute getAshlingProcessorDataBaseType_Date();

	/**
	 * Returns the meta object for the attribute '{@link Devices.AshlingProcessorDataBaseType#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family</em>'.
	 * @see Devices.AshlingProcessorDataBaseType#getFamily()
	 * @see #getAshlingProcessorDataBaseType()
	 * @generated
	 */
	EAttribute getAshlingProcessorDataBaseType_Family();

	/**
	 * Returns the meta object for the attribute '{@link Devices.AshlingProcessorDataBaseType#getSubSet <em>Sub Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Set</em>'.
	 * @see Devices.AshlingProcessorDataBaseType#getSubSet()
	 * @see #getAshlingProcessorDataBaseType()
	 * @generated
	 */
	EAttribute getAshlingProcessorDataBaseType_SubSet();

	/**
	 * Returns the meta object for the attribute '{@link Devices.AshlingProcessorDataBaseType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see Devices.AshlingProcessorDataBaseType#getVersion()
	 * @see #getAshlingProcessorDataBaseType()
	 * @generated
	 */
	EAttribute getAshlingProcessorDataBaseType_Version();

	/**
	 * Returns the meta object for class '{@link Devices.CoreInfoType <em>Core Info Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Info Type</em>'.
	 * @see Devices.CoreInfoType
	 * @generated
	 */
	EClass getCoreInfoType();

	/**
	 * Returns the meta object for the containment reference list '{@link Devices.CoreInfoType#getCore <em>Core</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Core</em>'.
	 * @see Devices.CoreInfoType#getCore()
	 * @see #getCoreInfoType()
	 * @generated
	 */
	EReference getCoreInfoType_Core();

	/**
	 * Returns the meta object for class '{@link Devices.CoreType <em>Core Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Type</em>'.
	 * @see Devices.CoreType
	 * @generated
	 */
	EClass getCoreType();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.CoreType#getDAP <em>DAP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>DAP</em>'.
	 * @see Devices.CoreType#getDAP()
	 * @see #getCoreType()
	 * @generated
	 */
	EReference getCoreType_DAP();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.CoreType#getTap <em>Tap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tap</em>'.
	 * @see Devices.CoreType#getTap()
	 * @see #getCoreType()
	 * @generated
	 */
	EReference getCoreType_Tap();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.CoreType#getVJTAG <em>VJTAG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>VJTAG</em>'.
	 * @see Devices.CoreType#getVJTAG()
	 * @see #getCoreType()
	 * @generated
	 */
	EReference getCoreType_VJTAG();

	/**
	 * Returns the meta object for the attribute '{@link Devices.CoreType#getDebugBaseAddress <em>Debug Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Base Address</em>'.
	 * @see Devices.CoreType#getDebugBaseAddress()
	 * @see #getCoreType()
	 * @generated
	 */
	EAttribute getCoreType_DebugBaseAddress();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.CoreType#getMemory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Memory</em>'.
	 * @see Devices.CoreType#getMemory()
	 * @see #getCoreType()
	 * @generated
	 */
	EReference getCoreType_Memory();

	/**
	 * Returns the meta object for the attribute '{@link Devices.CoreType#getGDBRegFile <em>GDB Reg File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>GDB Reg File</em>'.
	 * @see Devices.CoreType#getGDBRegFile()
	 * @see #getCoreType()
	 * @generated
	 */
	EAttribute getCoreType_GDBRegFile();

	/**
	 * Returns the meta object for the attribute '{@link Devices.CoreType#getArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Architecture</em>'.
	 * @see Devices.CoreType#getArchitecture()
	 * @see #getCoreType()
	 * @generated
	 */
	EAttribute getCoreType_Architecture();

	/**
	 * Returns the meta object for the attribute '{@link Devices.CoreType#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family</em>'.
	 * @see Devices.CoreType#getFamily()
	 * @see #getCoreType()
	 * @generated
	 */
	EAttribute getCoreType_Family();

	/**
	 * Returns the meta object for the attribute '{@link Devices.CoreType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Devices.CoreType#getName()
	 * @see #getCoreType()
	 * @generated
	 */
	EAttribute getCoreType_Name();

	/**
	 * Returns the meta object for the attribute '{@link Devices.CoreType#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see Devices.CoreType#getNumber()
	 * @see #getCoreType()
	 * @generated
	 */
	EAttribute getCoreType_Number();

	/**
	 * Returns the meta object for class '{@link Devices.DAPType <em>DAP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DAP Type</em>'.
	 * @see Devices.DAPType
	 * @generated
	 */
	EClass getDAPType();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.DAPType#getJTAGDP <em>JTAGDP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>JTAGDP</em>'.
	 * @see Devices.DAPType#getJTAGDP()
	 * @see #getDAPType()
	 * @generated
	 */
	EReference getDAPType_JTAGDP();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.DAPType#getSWDDP <em>SWDDP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SWDDP</em>'.
	 * @see Devices.DAPType#getSWDDP()
	 * @see #getDAPType()
	 * @generated
	 */
	EReference getDAPType_SWDDP();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getDebugBaseAddress <em>Debug Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Base Address</em>'.
	 * @see Devices.DAPType#getDebugBaseAddress()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_DebugBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getCTIBaseAddress <em>CTI Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CTI Base Address</em>'.
	 * @see Devices.DAPType#getCTIBaseAddress()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_CTIBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getPTMBaseAddress <em>PTM Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PTM Base Address</em>'.
	 * @see Devices.DAPType#getPTMBaseAddress()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_PTMBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getETMBaseAddress <em>ETM Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ETM Base Address</em>'.
	 * @see Devices.DAPType#getETMBaseAddress()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_ETMBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getFunnelPortIndex <em>Funnel Port Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Funnel Port Index</em>'.
	 * @see Devices.DAPType#getFunnelPortIndex()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_FunnelPortIndex();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getDebugApIndex <em>Debug Ap Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Ap Index</em>'.
	 * @see Devices.DAPType#getDebugApIndex()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_DebugApIndex();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getDebugPulpNPCAddr <em>Debug Pulp NPC Addr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Pulp NPC Addr</em>'.
	 * @see Devices.DAPType#getDebugPulpNPCAddr()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_DebugPulpNPCAddr();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getDebugTransport <em>Debug Transport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Transport</em>'.
	 * @see Devices.DAPType#getDebugTransport()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_DebugTransport();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getMemoryApIndex <em>Memory Ap Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Ap Index</em>'.
	 * @see Devices.DAPType#getMemoryApIndex()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_MemoryApIndex();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getJtagApIndex <em>Jtag Ap Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jtag Ap Index</em>'.
	 * @see Devices.DAPType#getJtagApIndex()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_JtagApIndex();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DAPType#getUseMemApForMemAccess <em>Use Mem Ap For Mem Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Mem Ap For Mem Access</em>'.
	 * @see Devices.DAPType#getUseMemApForMemAccess()
	 * @see #getDAPType()
	 * @generated
	 */
	EAttribute getDAPType_UseMemApForMemAccess();

	/**
	 * Returns the meta object for class '{@link Devices.DebuggerControlType <em>Debugger Control Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debugger Control Type</em>'.
	 * @see Devices.DebuggerControlType
	 * @generated
	 */
	EClass getDebuggerControlType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.DebuggerControlType#getMaxJtagFrequencyKhz <em>Max Jtag Frequency Khz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Jtag Frequency Khz</em>'.
	 * @see Devices.DebuggerControlType#getMaxJtagFrequencyKhz()
	 * @see #getDebuggerControlType()
	 * @generated
	 */
	EAttribute getDebuggerControlType_MaxJtagFrequencyKhz();

	/**
	 * Returns the meta object for class '{@link Devices.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see Devices.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link Devices.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see Devices.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link Devices.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see Devices.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link Devices.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see Devices.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.DocumentRoot#getAshlingProcessorDataBase <em>Ashling Processor Data Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ashling Processor Data Base</em>'.
	 * @see Devices.DocumentRoot#getAshlingProcessorDataBase()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AshlingProcessorDataBase();

	/**
	 * Returns the meta object for class '{@link Devices.JTAGDPType <em>JTAGDP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JTAGDP Type</em>'.
	 * @see Devices.JTAGDPType
	 * @generated
	 */
	EClass getJTAGDPType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.JTAGDPType#getRefid <em>Refid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Refid</em>'.
	 * @see Devices.JTAGDPType#getRefid()
	 * @see #getJTAGDPType()
	 * @generated
	 */
	EAttribute getJTAGDPType_Refid();

	/**
	 * Returns the meta object for class '{@link Devices.JTAGScanChainType <em>JTAG Scan Chain Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JTAG Scan Chain Type</em>'.
	 * @see Devices.JTAGScanChainType
	 * @generated
	 */
	EClass getJTAGScanChainType();

	/**
	 * Returns the meta object for the containment reference list '{@link Devices.JTAGScanChainType#getTap <em>Tap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tap</em>'.
	 * @see Devices.JTAGScanChainType#getTap()
	 * @see #getJTAGScanChainType()
	 * @generated
	 */
	EReference getJTAGScanChainType_Tap();

	/**
	 * Returns the meta object for class '{@link Devices.MDMAPType <em>MDMAP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDMAP Type</em>'.
	 * @see Devices.MDMAPType
	 * @generated
	 */
	EClass getMDMAPType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.MDMAPType#getBaseAddress <em>Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Address</em>'.
	 * @see Devices.MDMAPType#getBaseAddress()
	 * @see #getMDMAPType()
	 * @generated
	 */
	EAttribute getMDMAPType_BaseAddress();

	/**
	 * Returns the meta object for class '{@link Devices.MemAreaType <em>Mem Area Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mem Area Type</em>'.
	 * @see Devices.MemAreaType
	 * @generated
	 */
	EClass getMemAreaType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.MemAreaType#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see Devices.MemAreaType#getAccess()
	 * @see #getMemAreaType()
	 * @generated
	 */
	EAttribute getMemAreaType_Access();

	/**
	 * Returns the meta object for the attribute '{@link Devices.MemAreaType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Devices.MemAreaType#getName()
	 * @see #getMemAreaType()
	 * @generated
	 */
	EAttribute getMemAreaType_Name();

	/**
	 * Returns the meta object for the attribute '{@link Devices.MemAreaType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see Devices.MemAreaType#getSize()
	 * @see #getMemAreaType()
	 * @generated
	 */
	EAttribute getMemAreaType_Size();

	/**
	 * Returns the meta object for the attribute '{@link Devices.MemAreaType#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see Devices.MemAreaType#getStart()
	 * @see #getMemAreaType()
	 * @generated
	 */
	EAttribute getMemAreaType_Start();

	/**
	 * Returns the meta object for the attribute '{@link Devices.MemAreaType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Devices.MemAreaType#getType()
	 * @see #getMemAreaType()
	 * @generated
	 */
	EAttribute getMemAreaType_Type();

	/**
	 * Returns the meta object for class '{@link Devices.MemoryType <em>Memory Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Type</em>'.
	 * @see Devices.MemoryType
	 * @generated
	 */
	EClass getMemoryType();

	/**
	 * Returns the meta object for the containment reference list '{@link Devices.MemoryType#getMemArea <em>Mem Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mem Area</em>'.
	 * @see Devices.MemoryType#getMemArea()
	 * @see #getMemoryType()
	 * @generated
	 */
	EReference getMemoryType_MemArea();

	/**
	 * Returns the meta object for class '{@link Devices.ProcessorType <em>Processor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor Type</em>'.
	 * @see Devices.ProcessorType
	 * @generated
	 */
	EClass getProcessorType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSFunnelBaseAddress <em>CS Funnel Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CS Funnel Base Address</em>'.
	 * @see Devices.ProcessorType#getCSFunnelBaseAddress()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSFunnelBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSETFBaseAddress <em>CSETF Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CSETF Base Address</em>'.
	 * @see Devices.ProcessorType#getCSETFBaseAddress()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSETFBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSETRBaseAddress <em>CSETR Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CSETR Base Address</em>'.
	 * @see Devices.ProcessorType#getCSETRBaseAddress()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSETRBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSTPIUBaseAddress <em>CSTPIU Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CSTPIU Base Address</em>'.
	 * @see Devices.ProcessorType#getCSTPIUBaseAddress()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSTPIUBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSSTMBaseAddress <em>CSSTM Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CSSTM Base Address</em>'.
	 * @see Devices.ProcessorType#getCSSTMBaseAddress()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSSTMBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSSTMFunnelPortIndex <em>CSSTM Funnel Port Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CSSTM Funnel Port Index</em>'.
	 * @see Devices.ProcessorType#getCSSTMFunnelPortIndex()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSSTMFunnelPortIndex();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCSTSBaseAddress <em>CSTS Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CSTS Base Address</em>'.
	 * @see Devices.ProcessorType#getCSTSBaseAddress()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CSTSBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getInternalName <em>Internal Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal Name</em>'.
	 * @see Devices.ProcessorType#getInternalName()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_InternalName();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getDeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device Type</em>'.
	 * @see Devices.ProcessorType#getDeviceType()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_DeviceType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getCoresightCompliant <em>Coresight Compliant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coresight Compliant</em>'.
	 * @see Devices.ProcessorType#getCoresightCompliant()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_CoresightCompliant();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getResetType <em>Reset Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Type</em>'.
	 * @see Devices.ProcessorType#getResetType()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_ResetType();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.ProcessorType#getDebuggerControl <em>Debugger Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Debugger Control</em>'.
	 * @see Devices.ProcessorType#getDebuggerControl()
	 * @see #getProcessorType()
	 * @generated
	 */
	EReference getProcessorType_DebuggerControl();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.ProcessorType#getARCEmulator <em>ARC Emulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>ARC Emulator</em>'.
	 * @see Devices.ProcessorType#getARCEmulator()
	 * @see #getProcessorType()
	 * @generated
	 */
	EReference getProcessorType_ARCEmulator();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getInstructionToSelectADI <em>Instruction To Select ADI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instruction To Select ADI</em>'.
	 * @see Devices.ProcessorType#getInstructionToSelectADI()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_InstructionToSelectADI();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.ProcessorType#getMDMAP <em>MDMAP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>MDMAP</em>'.
	 * @see Devices.ProcessorType#getMDMAP()
	 * @see #getProcessorType()
	 * @generated
	 */
	EReference getProcessorType_MDMAP();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getEscapeSequenceType <em>Escape Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Sequence Type</em>'.
	 * @see Devices.ProcessorType#getEscapeSequenceType()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_EscapeSequenceType();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.ProcessorType#getJTAGScanChain <em>JTAG Scan Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>JTAG Scan Chain</em>'.
	 * @see Devices.ProcessorType#getJTAGScanChain()
	 * @see #getProcessorType()
	 * @generated
	 */
	EReference getProcessorType_JTAGScanChain();

	/**
	 * Returns the meta object for the containment reference '{@link Devices.ProcessorType#getCoreInfo <em>Core Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Core Info</em>'.
	 * @see Devices.ProcessorType#getCoreInfo()
	 * @see #getProcessorType()
	 * @generated
	 */
	EReference getProcessorType_CoreInfo();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#isMultiCoreSupported <em>Multi Core Supported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Core Supported</em>'.
	 * @see Devices.ProcessorType#isMultiCoreSupported()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_MultiCoreSupported();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#isUseNonStopMode <em>Use Non Stop Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Non Stop Mode</em>'.
	 * @see Devices.ProcessorType#isUseNonStopMode()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_UseNonStopMode();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getDefaultTAP <em>Default TAP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default TAP</em>'.
	 * @see Devices.ProcessorType#getDefaultTAP()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_DefaultTAP();

	/**
	 * Returns the meta object for the attribute '{@link Devices.ProcessorType#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device</em>'.
	 * @see Devices.ProcessorType#getDevice()
	 * @see #getProcessorType()
	 * @generated
	 */
	EAttribute getProcessorType_Device();

	/**
	 * Returns the meta object for class '{@link Devices.TapType <em>Tap Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tap Type</em>'.
	 * @see Devices.TapType
	 * @generated
	 */
	EClass getTapType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.TapType#getRefid <em>Refid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Refid</em>'.
	 * @see Devices.TapType#getRefid()
	 * @see #getTapType()
	 * @generated
	 */
	EAttribute getTapType_Refid();

	/**
	 * Returns the meta object for class '{@link Devices.TapType1 <em>Tap Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tap Type1</em>'.
	 * @see Devices.TapType1
	 * @generated
	 */
	EClass getTapType1();

	/**
	 * Returns the meta object for the attribute '{@link Devices.TapType1#getIRlength <em>IRlength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IRlength</em>'.
	 * @see Devices.TapType1#getIRlength()
	 * @see #getTapType1()
	 * @generated
	 */
	EAttribute getTapType1_IRlength();

	/**
	 * Returns the meta object for the attribute '{@link Devices.TapType1#getBypassInst <em>Bypass Inst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bypass Inst</em>'.
	 * @see Devices.TapType1#getBypassInst()
	 * @see #getTapType1()
	 * @generated
	 */
	EAttribute getTapType1_BypassInst();

	/**
	 * Returns the meta object for the attribute '{@link Devices.TapType1#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see Devices.TapType1#getId()
	 * @see #getTapType1()
	 * @generated
	 */
	EAttribute getTapType1_Id();

	/**
	 * Returns the meta object for the attribute '{@link Devices.TapType1#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see Devices.TapType1#getNumber()
	 * @see #getTapType1()
	 * @generated
	 */
	EAttribute getTapType1_Number();

	/**
	 * Returns the meta object for class '{@link Devices.TargetVoltageType <em>Target Voltage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Voltage Type</em>'.
	 * @see Devices.TargetVoltageType
	 * @generated
	 */
	EClass getTargetVoltageType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.TargetVoltageType#getSupplyType <em>Supply Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supply Type</em>'.
	 * @see Devices.TargetVoltageType#getSupplyType()
	 * @see #getTargetVoltageType()
	 * @generated
	 */
	EAttribute getTargetVoltageType_SupplyType();

	/**
	 * Returns the meta object for class '{@link Devices.VJTAGType <em>VJTAG Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VJTAG Type</em>'.
	 * @see Devices.VJTAGType
	 * @generated
	 */
	EClass getVJTAGType();

	/**
	 * Returns the meta object for the attribute '{@link Devices.VJTAGType#getNodeIndex <em>Node Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Index</em>'.
	 * @see Devices.VJTAGType#getNodeIndex()
	 * @see #getVJTAGType()
	 * @generated
	 */
	EAttribute getVJTAGType_NodeIndex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	devicesFactory getDevicesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Devices.impl.ARCEmulatorTypeImpl <em>ARC Emulator Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.ARCEmulatorTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getARCEmulatorType()
		 * @generated
		 */
		EClass ARC_EMULATOR_TYPE = eINSTANCE.getARCEmulatorType();

		/**
		 * The meta object literal for the '<em><b>Target Voltage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_EMULATOR_TYPE__TARGET_VOLTAGE = eINSTANCE.getARCEmulatorType_TargetVoltage();

		/**
		 * The meta object literal for the '{@link Devices.impl.AshlingProcessorDataBaseTypeImpl <em>Ashling Processor Data Base Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.AshlingProcessorDataBaseTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getAshlingProcessorDataBaseType()
		 * @generated
		 */
		EClass ASHLING_PROCESSOR_DATA_BASE_TYPE = eINSTANCE.getAshlingProcessorDataBaseType();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASHLING_PROCESSOR_DATA_BASE_TYPE__PROCESSOR = eINSTANCE.getAshlingProcessorDataBaseType_Processor();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASHLING_PROCESSOR_DATA_BASE_TYPE__DATE = eINSTANCE.getAshlingProcessorDataBaseType_Date();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASHLING_PROCESSOR_DATA_BASE_TYPE__FAMILY = eINSTANCE.getAshlingProcessorDataBaseType_Family();

		/**
		 * The meta object literal for the '<em><b>Sub Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASHLING_PROCESSOR_DATA_BASE_TYPE__SUB_SET = eINSTANCE.getAshlingProcessorDataBaseType_SubSet();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASHLING_PROCESSOR_DATA_BASE_TYPE__VERSION = eINSTANCE.getAshlingProcessorDataBaseType_Version();

		/**
		 * The meta object literal for the '{@link Devices.impl.CoreInfoTypeImpl <em>Core Info Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.CoreInfoTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getCoreInfoType()
		 * @generated
		 */
		EClass CORE_INFO_TYPE = eINSTANCE.getCoreInfoType();

		/**
		 * The meta object literal for the '<em><b>Core</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_INFO_TYPE__CORE = eINSTANCE.getCoreInfoType_Core();

		/**
		 * The meta object literal for the '{@link Devices.impl.CoreTypeImpl <em>Core Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.CoreTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getCoreType()
		 * @generated
		 */
		EClass CORE_TYPE = eINSTANCE.getCoreType();

		/**
		 * The meta object literal for the '<em><b>DAP</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_TYPE__DAP = eINSTANCE.getCoreType_DAP();

		/**
		 * The meta object literal for the '<em><b>Tap</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_TYPE__TAP = eINSTANCE.getCoreType_Tap();

		/**
		 * The meta object literal for the '<em><b>VJTAG</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_TYPE__VJTAG = eINSTANCE.getCoreType_VJTAG();

		/**
		 * The meta object literal for the '<em><b>Debug Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_TYPE__DEBUG_BASE_ADDRESS = eINSTANCE.getCoreType_DebugBaseAddress();

		/**
		 * The meta object literal for the '<em><b>Memory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_TYPE__MEMORY = eINSTANCE.getCoreType_Memory();

		/**
		 * The meta object literal for the '<em><b>GDB Reg File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_TYPE__GDB_REG_FILE = eINSTANCE.getCoreType_GDBRegFile();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_TYPE__ARCHITECTURE = eINSTANCE.getCoreType_Architecture();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_TYPE__FAMILY = eINSTANCE.getCoreType_Family();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_TYPE__NAME = eINSTANCE.getCoreType_Name();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORE_TYPE__NUMBER = eINSTANCE.getCoreType_Number();

		/**
		 * The meta object literal for the '{@link Devices.impl.DAPTypeImpl <em>DAP Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.DAPTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getDAPType()
		 * @generated
		 */
		EClass DAP_TYPE = eINSTANCE.getDAPType();

		/**
		 * The meta object literal for the '<em><b>JTAGDP</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAP_TYPE__JTAGDP = eINSTANCE.getDAPType_JTAGDP();

		/**
		 * The meta object literal for the '<em><b>SWDDP</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAP_TYPE__SWDDP = eINSTANCE.getDAPType_SWDDP();

		/**
		 * The meta object literal for the '<em><b>Debug Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__DEBUG_BASE_ADDRESS = eINSTANCE.getDAPType_DebugBaseAddress();

		/**
		 * The meta object literal for the '<em><b>CTI Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__CTI_BASE_ADDRESS = eINSTANCE.getDAPType_CTIBaseAddress();

		/**
		 * The meta object literal for the '<em><b>PTM Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__PTM_BASE_ADDRESS = eINSTANCE.getDAPType_PTMBaseAddress();

		/**
		 * The meta object literal for the '<em><b>ETM Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__ETM_BASE_ADDRESS = eINSTANCE.getDAPType_ETMBaseAddress();

		/**
		 * The meta object literal for the '<em><b>Funnel Port Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__FUNNEL_PORT_INDEX = eINSTANCE.getDAPType_FunnelPortIndex();

		/**
		 * The meta object literal for the '<em><b>Debug Ap Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__DEBUG_AP_INDEX = eINSTANCE.getDAPType_DebugApIndex();

		/**
		 * The meta object literal for the '<em><b>Debug Pulp NPC Addr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__DEBUG_PULP_NPC_ADDR = eINSTANCE.getDAPType_DebugPulpNPCAddr();

		/**
		 * The meta object literal for the '<em><b>Debug Transport</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__DEBUG_TRANSPORT = eINSTANCE.getDAPType_DebugTransport();

		/**
		 * The meta object literal for the '<em><b>Memory Ap Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__MEMORY_AP_INDEX = eINSTANCE.getDAPType_MemoryApIndex();

		/**
		 * The meta object literal for the '<em><b>Jtag Ap Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__JTAG_AP_INDEX = eINSTANCE.getDAPType_JtagApIndex();

		/**
		 * The meta object literal for the '<em><b>Use Mem Ap For Mem Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAP_TYPE__USE_MEM_AP_FOR_MEM_ACCESS = eINSTANCE.getDAPType_UseMemApForMemAccess();

		/**
		 * The meta object literal for the '{@link Devices.impl.DebuggerControlTypeImpl <em>Debugger Control Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.DebuggerControlTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getDebuggerControlType()
		 * @generated
		 */
		EClass DEBUGGER_CONTROL_TYPE = eINSTANCE.getDebuggerControlType();

		/**
		 * The meta object literal for the '<em><b>Max Jtag Frequency Khz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUGGER_CONTROL_TYPE__MAX_JTAG_FREQUENCY_KHZ = eINSTANCE.getDebuggerControlType_MaxJtagFrequencyKhz();

		/**
		 * The meta object literal for the '{@link Devices.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.DocumentRootImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Ashling Processor Data Base</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ASHLING_PROCESSOR_DATA_BASE = eINSTANCE.getDocumentRoot_AshlingProcessorDataBase();

		/**
		 * The meta object literal for the '{@link Devices.impl.JTAGDPTypeImpl <em>JTAGDP Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.JTAGDPTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getJTAGDPType()
		 * @generated
		 */
		EClass JTAGDP_TYPE = eINSTANCE.getJTAGDPType();

		/**
		 * The meta object literal for the '<em><b>Refid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JTAGDP_TYPE__REFID = eINSTANCE.getJTAGDPType_Refid();

		/**
		 * The meta object literal for the '{@link Devices.impl.JTAGScanChainTypeImpl <em>JTAG Scan Chain Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.JTAGScanChainTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getJTAGScanChainType()
		 * @generated
		 */
		EClass JTAG_SCAN_CHAIN_TYPE = eINSTANCE.getJTAGScanChainType();

		/**
		 * The meta object literal for the '<em><b>Tap</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JTAG_SCAN_CHAIN_TYPE__TAP = eINSTANCE.getJTAGScanChainType_Tap();

		/**
		 * The meta object literal for the '{@link Devices.impl.MDMAPTypeImpl <em>MDMAP Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.MDMAPTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getMDMAPType()
		 * @generated
		 */
		EClass MDMAP_TYPE = eINSTANCE.getMDMAPType();

		/**
		 * The meta object literal for the '<em><b>Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MDMAP_TYPE__BASE_ADDRESS = eINSTANCE.getMDMAPType_BaseAddress();

		/**
		 * The meta object literal for the '{@link Devices.impl.MemAreaTypeImpl <em>Mem Area Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.MemAreaTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getMemAreaType()
		 * @generated
		 */
		EClass MEM_AREA_TYPE = eINSTANCE.getMemAreaType();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEM_AREA_TYPE__ACCESS = eINSTANCE.getMemAreaType_Access();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEM_AREA_TYPE__NAME = eINSTANCE.getMemAreaType_Name();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEM_AREA_TYPE__SIZE = eINSTANCE.getMemAreaType_Size();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEM_AREA_TYPE__START = eINSTANCE.getMemAreaType_Start();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEM_AREA_TYPE__TYPE = eINSTANCE.getMemAreaType_Type();

		/**
		 * The meta object literal for the '{@link Devices.impl.MemoryTypeImpl <em>Memory Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.MemoryTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getMemoryType()
		 * @generated
		 */
		EClass MEMORY_TYPE = eINSTANCE.getMemoryType();

		/**
		 * The meta object literal for the '<em><b>Mem Area</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_TYPE__MEM_AREA = eINSTANCE.getMemoryType_MemArea();

		/**
		 * The meta object literal for the '{@link Devices.impl.ProcessorTypeImpl <em>Processor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.ProcessorTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getProcessorType()
		 * @generated
		 */
		EClass PROCESSOR_TYPE = eINSTANCE.getProcessorType();

		/**
		 * The meta object literal for the '<em><b>CS Funnel Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS = eINSTANCE.getProcessorType_CSFunnelBaseAddress();

		/**
		 * The meta object literal for the '<em><b>CSETF Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CSETF_BASE_ADDRESS = eINSTANCE.getProcessorType_CSETFBaseAddress();

		/**
		 * The meta object literal for the '<em><b>CSETR Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CSETR_BASE_ADDRESS = eINSTANCE.getProcessorType_CSETRBaseAddress();

		/**
		 * The meta object literal for the '<em><b>CSTPIU Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS = eINSTANCE.getProcessorType_CSTPIUBaseAddress();

		/**
		 * The meta object literal for the '<em><b>CSSTM Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CSSTM_BASE_ADDRESS = eINSTANCE.getProcessorType_CSSTMBaseAddress();

		/**
		 * The meta object literal for the '<em><b>CSSTM Funnel Port Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX = eINSTANCE.getProcessorType_CSSTMFunnelPortIndex();

		/**
		 * The meta object literal for the '<em><b>CSTS Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CSTS_BASE_ADDRESS = eINSTANCE.getProcessorType_CSTSBaseAddress();

		/**
		 * The meta object literal for the '<em><b>Internal Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__INTERNAL_NAME = eINSTANCE.getProcessorType_InternalName();

		/**
		 * The meta object literal for the '<em><b>Device Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__DEVICE_TYPE = eINSTANCE.getProcessorType_DeviceType();

		/**
		 * The meta object literal for the '<em><b>Coresight Compliant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__CORESIGHT_COMPLIANT = eINSTANCE.getProcessorType_CoresightCompliant();

		/**
		 * The meta object literal for the '<em><b>Reset Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__RESET_TYPE = eINSTANCE.getProcessorType_ResetType();

		/**
		 * The meta object literal for the '<em><b>Debugger Control</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR_TYPE__DEBUGGER_CONTROL = eINSTANCE.getProcessorType_DebuggerControl();

		/**
		 * The meta object literal for the '<em><b>ARC Emulator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR_TYPE__ARC_EMULATOR = eINSTANCE.getProcessorType_ARCEmulator();

		/**
		 * The meta object literal for the '<em><b>Instruction To Select ADI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI = eINSTANCE.getProcessorType_InstructionToSelectADI();

		/**
		 * The meta object literal for the '<em><b>MDMAP</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR_TYPE__MDMAP = eINSTANCE.getProcessorType_MDMAP();

		/**
		 * The meta object literal for the '<em><b>Escape Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE = eINSTANCE.getProcessorType_EscapeSequenceType();

		/**
		 * The meta object literal for the '<em><b>JTAG Scan Chain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR_TYPE__JTAG_SCAN_CHAIN = eINSTANCE.getProcessorType_JTAGScanChain();

		/**
		 * The meta object literal for the '<em><b>Core Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR_TYPE__CORE_INFO = eINSTANCE.getProcessorType_CoreInfo();

		/**
		 * The meta object literal for the '<em><b>Multi Core Supported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__MULTI_CORE_SUPPORTED = eINSTANCE.getProcessorType_MultiCoreSupported();

		/**
		 * The meta object literal for the '<em><b>Use Non Stop Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__USE_NON_STOP_MODE = eINSTANCE.getProcessorType_UseNonStopMode();

		/**
		 * The meta object literal for the '<em><b>Default TAP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__DEFAULT_TAP = eINSTANCE.getProcessorType_DefaultTAP();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_TYPE__DEVICE = eINSTANCE.getProcessorType_Device();

		/**
		 * The meta object literal for the '{@link Devices.impl.TapTypeImpl <em>Tap Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.TapTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getTapType()
		 * @generated
		 */
		EClass TAP_TYPE = eINSTANCE.getTapType();

		/**
		 * The meta object literal for the '<em><b>Refid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_TYPE__REFID = eINSTANCE.getTapType_Refid();

		/**
		 * The meta object literal for the '{@link Devices.impl.TapType1Impl <em>Tap Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.TapType1Impl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getTapType1()
		 * @generated
		 */
		EClass TAP_TYPE1 = eINSTANCE.getTapType1();

		/**
		 * The meta object literal for the '<em><b>IRlength</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_TYPE1__IRLENGTH = eINSTANCE.getTapType1_IRlength();

		/**
		 * The meta object literal for the '<em><b>Bypass Inst</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_TYPE1__BYPASS_INST = eINSTANCE.getTapType1_BypassInst();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_TYPE1__ID = eINSTANCE.getTapType1_Id();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAP_TYPE1__NUMBER = eINSTANCE.getTapType1_Number();

		/**
		 * The meta object literal for the '{@link Devices.impl.TargetVoltageTypeImpl <em>Target Voltage Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.TargetVoltageTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getTargetVoltageType()
		 * @generated
		 */
		EClass TARGET_VOLTAGE_TYPE = eINSTANCE.getTargetVoltageType();

		/**
		 * The meta object literal for the '<em><b>Supply Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_VOLTAGE_TYPE__SUPPLY_TYPE = eINSTANCE.getTargetVoltageType_SupplyType();

		/**
		 * The meta object literal for the '{@link Devices.impl.VJTAGTypeImpl <em>VJTAG Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Devices.impl.VJTAGTypeImpl
		 * @see devicesPackageImpl.impl.DevicesPackageImpl#getVJTAGType()
		 * @generated
		 */
		EClass VJTAG_TYPE = eINSTANCE.getVJTAGType();

		/**
		 * The meta object literal for the '<em><b>Node Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VJTAG_TYPE__NODE_INDEX = eINSTANCE.getVJTAGType_NodeIndex();

	}

} //DevicesPackage
