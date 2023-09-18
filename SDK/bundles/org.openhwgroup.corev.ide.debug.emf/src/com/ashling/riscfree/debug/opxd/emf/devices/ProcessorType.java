/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Devices.ProcessorType#getCSFunnelBaseAddress <em>CS Funnel Base Address</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCSETFBaseAddress <em>CSETF Base Address</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCSETRBaseAddress <em>CSETR Base Address</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCSTPIUBaseAddress <em>CSTPIU Base Address</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCSSTMBaseAddress <em>CSSTM Base Address</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCSSTMFunnelPortIndex <em>CSSTM Funnel Port Index</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCSTSBaseAddress <em>CSTS Base Address</em>}</li>
 *   <li>{@link Devices.ProcessorType#getInternalName <em>Internal Name</em>}</li>
 *   <li>{@link Devices.ProcessorType#getDeviceType <em>Device Type</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCoresightCompliant <em>Coresight Compliant</em>}</li>
 *   <li>{@link Devices.ProcessorType#getResetType <em>Reset Type</em>}</li>
 *   <li>{@link Devices.ProcessorType#getDebuggerControl <em>Debugger Control</em>}</li>
 *   <li>{@link Devices.ProcessorType#getARCEmulator <em>ARC Emulator</em>}</li>
 *   <li>{@link Devices.ProcessorType#getInstructionToSelectADI <em>Instruction To Select ADI</em>}</li>
 *   <li>{@link Devices.ProcessorType#getMDMAP <em>MDMAP</em>}</li>
 *   <li>{@link Devices.ProcessorType#getEscapeSequenceType <em>Escape Sequence Type</em>}</li>
 *   <li>{@link Devices.ProcessorType#getJTAGScanChain <em>JTAG Scan Chain</em>}</li>
 *   <li>{@link Devices.ProcessorType#getCoreInfo <em>Core Info</em>}</li>
 *   <li>{@link Devices.ProcessorType#isMultiCoreSupported <em>Multi Core Supported</em>}</li>
 *   <li>{@link Devices.ProcessorType#isUseNonStopMode <em>Use Non Stop Mode</em>}</li>
 *   <li>{@link Devices.ProcessorType#getDefaultTAP <em>Default TAP</em>}</li>
 *   <li>{@link Devices.ProcessorType#getDevice <em>Device</em>}</li>
 * </ul>
 *
 * @see devicesPackage.DevicesPackage#getProcessorType()
 * @model extendedMetaData="name='Processor_._type' kind='elementOnly'"
 * @generated
 */
public interface ProcessorType extends EObject {
	/**
	 * Returns the value of the '<em><b>CS Funnel Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CS Funnel Base Address</em>' attribute.
	 * @see #setCSFunnelBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSFunnelBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CSFunnelBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCSFunnelBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSFunnelBaseAddress <em>CS Funnel Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CS Funnel Base Address</em>' attribute.
	 * @see #getCSFunnelBaseAddress()
	 * @generated
	 */
	void setCSFunnelBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>CSETF Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CSETF Base Address</em>' attribute.
	 * @see #setCSETFBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSETFBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CSETFBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCSETFBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSETFBaseAddress <em>CSETF Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CSETF Base Address</em>' attribute.
	 * @see #getCSETFBaseAddress()
	 * @generated
	 */
	void setCSETFBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>CSETR Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CSETR Base Address</em>' attribute.
	 * @see #setCSETRBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSETRBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CSETRBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCSETRBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSETRBaseAddress <em>CSETR Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CSETR Base Address</em>' attribute.
	 * @see #getCSETRBaseAddress()
	 * @generated
	 */
	void setCSETRBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>CSTPIU Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CSTPIU Base Address</em>' attribute.
	 * @see #setCSTPIUBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSTPIUBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CSTPIUBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCSTPIUBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSTPIUBaseAddress <em>CSTPIU Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CSTPIU Base Address</em>' attribute.
	 * @see #getCSTPIUBaseAddress()
	 * @generated
	 */
	void setCSTPIUBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>CSSTM Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CSSTM Base Address</em>' attribute.
	 * @see #setCSSTMBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSSTMBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CSSTMBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCSSTMBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSSTMBaseAddress <em>CSSTM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CSSTM Base Address</em>' attribute.
	 * @see #getCSSTMBaseAddress()
	 * @generated
	 */
	void setCSSTMBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>CSSTM Funnel Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CSSTM Funnel Port Index</em>' attribute.
	 * @see #isSetCSSTMFunnelPortIndex()
	 * @see #unsetCSSTMFunnelPortIndex()
	 * @see #setCSSTMFunnelPortIndex(short)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSSTMFunnelPortIndex()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='CSSTMFunnelPortIndex' namespace='##targetNamespace'"
	 * @generated
	 */
	short getCSSTMFunnelPortIndex();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSSTMFunnelPortIndex <em>CSSTM Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CSSTM Funnel Port Index</em>' attribute.
	 * @see #isSetCSSTMFunnelPortIndex()
	 * @see #unsetCSSTMFunnelPortIndex()
	 * @see #getCSSTMFunnelPortIndex()
	 * @generated
	 */
	void setCSSTMFunnelPortIndex(short value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#getCSSTMFunnelPortIndex <em>CSSTM Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCSSTMFunnelPortIndex()
	 * @see #getCSSTMFunnelPortIndex()
	 * @see #setCSSTMFunnelPortIndex(short)
	 * @generated
	 */
	void unsetCSSTMFunnelPortIndex();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#getCSSTMFunnelPortIndex <em>CSSTM Funnel Port Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>CSSTM Funnel Port Index</em>' attribute is set.
	 * @see #unsetCSSTMFunnelPortIndex()
	 * @see #getCSSTMFunnelPortIndex()
	 * @see #setCSSTMFunnelPortIndex(short)
	 * @generated
	 */
	boolean isSetCSSTMFunnelPortIndex();

	/**
	 * Returns the value of the '<em><b>CSTS Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CSTS Base Address</em>' attribute.
	 * @see #setCSTSBaseAddress(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CSTSBaseAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='CSTSBaseAddress' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCSTSBaseAddress();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCSTSBaseAddress <em>CSTS Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CSTS Base Address</em>' attribute.
	 * @see #getCSTSBaseAddress()
	 * @generated
	 */
	void setCSTSBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>Internal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Name</em>' attribute.
	 * @see #setInternalName(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_InternalName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='InternalName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getInternalName();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getInternalName <em>Internal Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Name</em>' attribute.
	 * @see #getInternalName()
	 * @generated
	 */
	void setInternalName(String value);

	/**
	 * Returns the value of the '<em><b>Device Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device Type</em>' attribute.
	 * @see #isSetDeviceType()
	 * @see #unsetDeviceType()
	 * @see #setDeviceType(short)
	 * @see devicesPackage.DevicesPackage#getProcessorType_DeviceType()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='DeviceType' namespace='##targetNamespace'"
	 * @generated
	 */
	short getDeviceType();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getDeviceType <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Type</em>' attribute.
	 * @see #isSetDeviceType()
	 * @see #unsetDeviceType()
	 * @see #getDeviceType()
	 * @generated
	 */
	void setDeviceType(short value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#getDeviceType <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeviceType()
	 * @see #getDeviceType()
	 * @see #setDeviceType(short)
	 * @generated
	 */
	void unsetDeviceType();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#getDeviceType <em>Device Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Device Type</em>' attribute is set.
	 * @see #unsetDeviceType()
	 * @see #getDeviceType()
	 * @see #setDeviceType(short)
	 * @generated
	 */
	boolean isSetDeviceType();

	/**
	 * Returns the value of the '<em><b>Coresight Compliant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coresight Compliant</em>' attribute.
	 * @see #isSetCoresightCompliant()
	 * @see #unsetCoresightCompliant()
	 * @see #setCoresightCompliant(short)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CoresightCompliant()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='CoresightCompliant' namespace='##targetNamespace'"
	 * @generated
	 */
	short getCoresightCompliant();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCoresightCompliant <em>Coresight Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coresight Compliant</em>' attribute.
	 * @see #isSetCoresightCompliant()
	 * @see #unsetCoresightCompliant()
	 * @see #getCoresightCompliant()
	 * @generated
	 */
	void setCoresightCompliant(short value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#getCoresightCompliant <em>Coresight Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoresightCompliant()
	 * @see #getCoresightCompliant()
	 * @see #setCoresightCompliant(short)
	 * @generated
	 */
	void unsetCoresightCompliant();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#getCoresightCompliant <em>Coresight Compliant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coresight Compliant</em>' attribute is set.
	 * @see #unsetCoresightCompliant()
	 * @see #getCoresightCompliant()
	 * @see #setCoresightCompliant(short)
	 * @generated
	 */
	boolean isSetCoresightCompliant();

	/**
	 * Returns the value of the '<em><b>Reset Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Type</em>' attribute.
	 * @see #setResetType(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_ResetType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='ResetType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getResetType();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getResetType <em>Reset Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Type</em>' attribute.
	 * @see #getResetType()
	 * @generated
	 */
	void setResetType(String value);

	/**
	 * Returns the value of the '<em><b>Debugger Control</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debugger Control</em>' containment reference.
	 * @see #setDebuggerControl(DebuggerControlType)
	 * @see devicesPackage.DevicesPackage#getProcessorType_DebuggerControl()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DebuggerControl' namespace='##targetNamespace'"
	 * @generated
	 */
	DebuggerControlType getDebuggerControl();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getDebuggerControl <em>Debugger Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debugger Control</em>' containment reference.
	 * @see #getDebuggerControl()
	 * @generated
	 */
	void setDebuggerControl(DebuggerControlType value);

	/**
	 * Returns the value of the '<em><b>ARC Emulator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ARC Emulator</em>' containment reference.
	 * @see #setARCEmulator(ARCEmulatorType)
	 * @see devicesPackage.DevicesPackage#getProcessorType_ARCEmulator()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ARCEmulator' namespace='##targetNamespace'"
	 * @generated
	 */
	ARCEmulatorType getARCEmulator();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getARCEmulator <em>ARC Emulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ARC Emulator</em>' containment reference.
	 * @see #getARCEmulator()
	 * @generated
	 */
	void setARCEmulator(ARCEmulatorType value);

	/**
	 * Returns the value of the '<em><b>Instruction To Select ADI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instruction To Select ADI</em>' attribute.
	 * @see #setInstructionToSelectADI(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_InstructionToSelectADI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='InstructionToSelectADI' namespace='##targetNamespace'"
	 * @generated
	 */
	String getInstructionToSelectADI();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getInstructionToSelectADI <em>Instruction To Select ADI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instruction To Select ADI</em>' attribute.
	 * @see #getInstructionToSelectADI()
	 * @generated
	 */
	void setInstructionToSelectADI(String value);

	/**
	 * Returns the value of the '<em><b>MDMAP</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MDMAP</em>' containment reference.
	 * @see #setMDMAP(MDMAPType)
	 * @see devicesPackage.DevicesPackage#getProcessorType_MDMAP()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MDMAP' namespace='##targetNamespace'"
	 * @generated
	 */
	MDMAPType getMDMAP();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getMDMAP <em>MDMAP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MDMAP</em>' containment reference.
	 * @see #getMDMAP()
	 * @generated
	 */
	void setMDMAP(MDMAPType value);

	/**
	 * Returns the value of the '<em><b>Escape Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escape Sequence Type</em>' attribute.
	 * @see #isSetEscapeSequenceType()
	 * @see #unsetEscapeSequenceType()
	 * @see #setEscapeSequenceType(short)
	 * @see devicesPackage.DevicesPackage#getProcessorType_EscapeSequenceType()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='EscapeSequenceType' namespace='##targetNamespace'"
	 * @generated
	 */
	short getEscapeSequenceType();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getEscapeSequenceType <em>Escape Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Sequence Type</em>' attribute.
	 * @see #isSetEscapeSequenceType()
	 * @see #unsetEscapeSequenceType()
	 * @see #getEscapeSequenceType()
	 * @generated
	 */
	void setEscapeSequenceType(short value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#getEscapeSequenceType <em>Escape Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEscapeSequenceType()
	 * @see #getEscapeSequenceType()
	 * @see #setEscapeSequenceType(short)
	 * @generated
	 */
	void unsetEscapeSequenceType();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#getEscapeSequenceType <em>Escape Sequence Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Escape Sequence Type</em>' attribute is set.
	 * @see #unsetEscapeSequenceType()
	 * @see #getEscapeSequenceType()
	 * @see #setEscapeSequenceType(short)
	 * @generated
	 */
	boolean isSetEscapeSequenceType();

	/**
	 * Returns the value of the '<em><b>JTAG Scan Chain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JTAG Scan Chain</em>' containment reference.
	 * @see #setJTAGScanChain(JTAGScanChainType)
	 * @see devicesPackage.DevicesPackage#getProcessorType_JTAGScanChain()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='JTAGScanChain' namespace='##targetNamespace'"
	 * @generated
	 */
	JTAGScanChainType getJTAGScanChain();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getJTAGScanChain <em>JTAG Scan Chain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JTAG Scan Chain</em>' containment reference.
	 * @see #getJTAGScanChain()
	 * @generated
	 */
	void setJTAGScanChain(JTAGScanChainType value);

	/**
	 * Returns the value of the '<em><b>Core Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Core Info</em>' containment reference.
	 * @see #setCoreInfo(CoreInfoType)
	 * @see devicesPackage.DevicesPackage#getProcessorType_CoreInfo()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='CoreInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	CoreInfoType getCoreInfo();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getCoreInfo <em>Core Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Info</em>' containment reference.
	 * @see #getCoreInfo()
	 * @generated
	 */
	void setCoreInfo(CoreInfoType value);

	/**
	 * Returns the value of the '<em><b>Multi Core Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Core Supported</em>' attribute.
	 * @see #isSetMultiCoreSupported()
	 * @see #unsetMultiCoreSupported()
	 * @see #setMultiCoreSupported(boolean)
	 * @see devicesPackage.DevicesPackage#getProcessorType_MultiCoreSupported()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='MultiCoreSupported' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isMultiCoreSupported();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#isMultiCoreSupported <em>Multi Core Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Core Supported</em>' attribute.
	 * @see #isSetMultiCoreSupported()
	 * @see #unsetMultiCoreSupported()
	 * @see #isMultiCoreSupported()
	 * @generated
	 */
	void setMultiCoreSupported(boolean value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#isMultiCoreSupported <em>Multi Core Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMultiCoreSupported()
	 * @see #isMultiCoreSupported()
	 * @see #setMultiCoreSupported(boolean)
	 * @generated
	 */
	void unsetMultiCoreSupported();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#isMultiCoreSupported <em>Multi Core Supported</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multi Core Supported</em>' attribute is set.
	 * @see #unsetMultiCoreSupported()
	 * @see #isMultiCoreSupported()
	 * @see #setMultiCoreSupported(boolean)
	 * @generated
	 */
	boolean isSetMultiCoreSupported();

	/**
	 * Returns the value of the '<em><b>Use Non Stop Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Non Stop Mode</em>' attribute.
	 * @see #isSetUseNonStopMode()
	 * @see #unsetUseNonStopMode()
	 * @see #setUseNonStopMode(boolean)
	 * @see devicesPackage.DevicesPackage#getProcessorType_UseNonStopMode()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='UseNonStopMode' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isUseNonStopMode();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#isUseNonStopMode <em>Use Non Stop Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Non Stop Mode</em>' attribute.
	 * @see #isSetUseNonStopMode()
	 * @see #unsetUseNonStopMode()
	 * @see #isUseNonStopMode()
	 * @generated
	 */
	void setUseNonStopMode(boolean value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#isUseNonStopMode <em>Use Non Stop Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUseNonStopMode()
	 * @see #isUseNonStopMode()
	 * @see #setUseNonStopMode(boolean)
	 * @generated
	 */
	void unsetUseNonStopMode();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#isUseNonStopMode <em>Use Non Stop Mode</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use Non Stop Mode</em>' attribute is set.
	 * @see #unsetUseNonStopMode()
	 * @see #isUseNonStopMode()
	 * @see #setUseNonStopMode(boolean)
	 * @generated
	 */
	boolean isSetUseNonStopMode();

	/**
	 * Returns the value of the '<em><b>Default TAP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default TAP</em>' attribute.
	 * @see #isSetDefaultTAP()
	 * @see #unsetDefaultTAP()
	 * @see #setDefaultTAP(short)
	 * @see devicesPackage.DevicesPackage#getProcessorType_DefaultTAP()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedByte"
	 *        extendedMetaData="kind='element' name='DefaultTAP' namespace='##targetNamespace'"
	 * @generated
	 */
	short getDefaultTAP();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getDefaultTAP <em>Default TAP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default TAP</em>' attribute.
	 * @see #isSetDefaultTAP()
	 * @see #unsetDefaultTAP()
	 * @see #getDefaultTAP()
	 * @generated
	 */
	void setDefaultTAP(short value);

	/**
	 * Unsets the value of the '{@link Devices.ProcessorType#getDefaultTAP <em>Default TAP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefaultTAP()
	 * @see #getDefaultTAP()
	 * @see #setDefaultTAP(short)
	 * @generated
	 */
	void unsetDefaultTAP();

	/**
	 * Returns whether the value of the '{@link Devices.ProcessorType#getDefaultTAP <em>Default TAP</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Default TAP</em>' attribute is set.
	 * @see #unsetDefaultTAP()
	 * @see #getDefaultTAP()
	 * @see #setDefaultTAP(short)
	 * @generated
	 */
	boolean isSetDefaultTAP();

	/**
	 * Returns the value of the '<em><b>Device</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' attribute.
	 * @see #setDevice(String)
	 * @see devicesPackage.DevicesPackage#getProcessorType_Device()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Device' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDevice();

	/**
	 * Sets the value of the '{@link Devices.ProcessorType#getDevice <em>Device</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' attribute.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(String value);

} // ProcessorType
