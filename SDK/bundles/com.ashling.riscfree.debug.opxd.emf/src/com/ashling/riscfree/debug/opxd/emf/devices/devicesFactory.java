/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see devicesPackage.DevicesPackage
 * @generated
 */
public interface devicesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	devicesFactory eINSTANCE = com.ashling.riscfree.debug.opxd.emf.devices.impl.devicesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ARC Emulator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ARC Emulator Type</em>'.
	 * @generated
	 */
	ARCEmulatorType createARCEmulatorType();

	/**
	 * Returns a new object of class '<em>Ashling Processor Data Base Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ashling Processor Data Base Type</em>'.
	 * @generated
	 */
	AshlingProcessorDataBaseType createAshlingProcessorDataBaseType();

	/**
	 * Returns a new object of class '<em>Core Info Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Info Type</em>'.
	 * @generated
	 */
	CoreInfoType createCoreInfoType();

	/**
	 * Returns a new object of class '<em>Core Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Type</em>'.
	 * @generated
	 */
	CoreType createCoreType();

	/**
	 * Returns a new object of class '<em>DAP Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DAP Type</em>'.
	 * @generated
	 */
	DAPType createDAPType();

	/**
	 * Returns a new object of class '<em>Debugger Control Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Debugger Control Type</em>'.
	 * @generated
	 */
	DebuggerControlType createDebuggerControlType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>JTAGDP Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JTAGDP Type</em>'.
	 * @generated
	 */
	JTAGDPType createJTAGDPType();

	/**
	 * Returns a new object of class '<em>JTAG Scan Chain Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JTAG Scan Chain Type</em>'.
	 * @generated
	 */
	JTAGScanChainType createJTAGScanChainType();

	/**
	 * Returns a new object of class '<em>MDMAP Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDMAP Type</em>'.
	 * @generated
	 */
	MDMAPType createMDMAPType();

	/**
	 * Returns a new object of class '<em>Mem Area Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mem Area Type</em>'.
	 * @generated
	 */
	MemAreaType createMemAreaType();

	/**
	 * Returns a new object of class '<em>Memory Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Type</em>'.
	 * @generated
	 */
	MemoryType createMemoryType();

	/**
	 * Returns a new object of class '<em>Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Type</em>'.
	 * @generated
	 */
	ProcessorType createProcessorType();

	/**
	 * Returns a new object of class '<em>Tap Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tap Type</em>'.
	 * @generated
	 */
	TapType createTapType();

	/**
	 * Returns a new object of class '<em>Tap Type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tap Type1</em>'.
	 * @generated
	 */
	TapType1 createTapType1();

	/**
	 * Returns a new object of class '<em>Target Voltage Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Voltage Type</em>'.
	 * @generated
	 */
	TargetVoltageType createTargetVoltageType();

	/**
	 * Returns a new object of class '<em>VJTAG Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VJTAG Type</em>'.
	 * @generated
	 */
	VJTAGType createVJTAGType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	devicesPackage getDevicesPackage();

} //DevicesFactory
