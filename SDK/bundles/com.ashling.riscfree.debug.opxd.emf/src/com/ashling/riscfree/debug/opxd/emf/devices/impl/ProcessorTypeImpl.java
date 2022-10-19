/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.ashling.riscfree.debug.opxd.emf.devices.ARCEmulatorType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreInfoType;
import com.ashling.riscfree.debug.opxd.emf.devices.DebuggerControlType;
import com.ashling.riscfree.debug.opxd.emf.devices.devicesPackage;
import com.ashling.riscfree.debug.opxd.emf.devices.JTAGScanChainType;
import com.ashling.riscfree.debug.opxd.emf.devices.MDMAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.ProcessorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSFunnelBaseAddress <em>CS Funnel Base Address</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSETFBaseAddress <em>CSETF Base Address</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSETRBaseAddress <em>CSETR Base Address</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSTPIUBaseAddress <em>CSTPIU Base Address</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSSTMBaseAddress <em>CSSTM Base Address</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSSTMFunnelPortIndex <em>CSSTM Funnel Port Index</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCSTSBaseAddress <em>CSTS Base Address</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getInternalName <em>Internal Name</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getDeviceType <em>Device Type</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCoresightCompliant <em>Coresight Compliant</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getResetType <em>Reset Type</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getDebuggerControl <em>Debugger Control</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getARCEmulator <em>ARC Emulator</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getInstructionToSelectADI <em>Instruction To Select ADI</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getMDMAP <em>MDMAP</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getEscapeSequenceType <em>Escape Sequence Type</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getJTAGScanChain <em>JTAG Scan Chain</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getCoreInfo <em>Core Info</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#isMultiCoreSupported <em>Multi Core Supported</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#isUseNonStopMode <em>Use Non Stop Mode</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getDefaultTAP <em>Default TAP</em>}</li>
 *   <li>{@link Devices.impl.ProcessorTypeImpl#getDevice <em>Device</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessorTypeImpl extends MinimalEObjectImpl.Container implements ProcessorType {
	/**
	 * The default value of the '{@link #getCSFunnelBaseAddress() <em>CS Funnel Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSFunnelBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CS_FUNNEL_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCSFunnelBaseAddress() <em>CS Funnel Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSFunnelBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cSFunnelBaseAddress = CS_FUNNEL_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCSETFBaseAddress() <em>CSETF Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSETFBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CSETF_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCSETFBaseAddress() <em>CSETF Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSETFBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cSETFBaseAddress = CSETF_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCSETRBaseAddress() <em>CSETR Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSETRBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CSETR_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCSETRBaseAddress() <em>CSETR Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSETRBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cSETRBaseAddress = CSETR_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCSTPIUBaseAddress() <em>CSTPIU Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSTPIUBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CSTPIU_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCSTPIUBaseAddress() <em>CSTPIU Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSTPIUBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cSTPIUBaseAddress = CSTPIU_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCSSTMBaseAddress() <em>CSSTM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSSTMBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CSSTM_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCSSTMBaseAddress() <em>CSSTM Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSSTMBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cSSTMBaseAddress = CSSTM_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCSSTMFunnelPortIndex() <em>CSSTM Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSSTMFunnelPortIndex()
	 * @generated
	 * @ordered
	 */
	protected static final short CSSTM_FUNNEL_PORT_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCSSTMFunnelPortIndex() <em>CSSTM Funnel Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSSTMFunnelPortIndex()
	 * @generated
	 * @ordered
	 */
	protected short cSSTMFunnelPortIndex = CSSTM_FUNNEL_PORT_INDEX_EDEFAULT;

	/**
	 * This is true if the CSSTM Funnel Port Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cSSTMFunnelPortIndexESet;

	/**
	 * The default value of the '{@link #getCSTSBaseAddress() <em>CSTS Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSTSBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String CSTS_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCSTSBaseAddress() <em>CSTS Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSTSBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String cSTSBaseAddress = CSTS_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInternalName() <em>Internal Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalName()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERNAL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInternalName() <em>Internal Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalName()
	 * @generated
	 * @ordered
	 */
	protected String internalName = INTERNAL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeviceType() <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceType()
	 * @generated
	 * @ordered
	 */
	protected static final short DEVICE_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDeviceType() <em>Device Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceType()
	 * @generated
	 * @ordered
	 */
	protected short deviceType = DEVICE_TYPE_EDEFAULT;

	/**
	 * This is true if the Device Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean deviceTypeESet;

	/**
	 * The default value of the '{@link #getCoresightCompliant() <em>Coresight Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoresightCompliant()
	 * @generated
	 * @ordered
	 */
	protected static final short CORESIGHT_COMPLIANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCoresightCompliant() <em>Coresight Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoresightCompliant()
	 * @generated
	 * @ordered
	 */
	protected short coresightCompliant = CORESIGHT_COMPLIANT_EDEFAULT;

	/**
	 * This is true if the Coresight Compliant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean coresightCompliantESet;

	/**
	 * The default value of the '{@link #getResetType() <em>Reset Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResetType()
	 * @generated
	 * @ordered
	 */
	protected static final String RESET_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResetType() <em>Reset Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResetType()
	 * @generated
	 * @ordered
	 */
	protected String resetType = RESET_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDebuggerControl() <em>Debugger Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebuggerControl()
	 * @generated
	 * @ordered
	 */
	protected DebuggerControlType debuggerControl;

	/**
	 * The cached value of the '{@link #getARCEmulator() <em>ARC Emulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getARCEmulator()
	 * @generated
	 * @ordered
	 */
	protected ARCEmulatorType aRCEmulator;

	/**
	 * The default value of the '{@link #getInstructionToSelectADI() <em>Instruction To Select ADI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionToSelectADI()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTRUCTION_TO_SELECT_ADI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstructionToSelectADI() <em>Instruction To Select ADI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionToSelectADI()
	 * @generated
	 * @ordered
	 */
	protected String instructionToSelectADI = INSTRUCTION_TO_SELECT_ADI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMDMAP() <em>MDMAP</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMDMAP()
	 * @generated
	 * @ordered
	 */
	protected MDMAPType mDMAP;

	/**
	 * The default value of the '{@link #getEscapeSequenceType() <em>Escape Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscapeSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final short ESCAPE_SEQUENCE_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEscapeSequenceType() <em>Escape Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscapeSequenceType()
	 * @generated
	 * @ordered
	 */
	protected short escapeSequenceType = ESCAPE_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * This is true if the Escape Sequence Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean escapeSequenceTypeESet;

	/**
	 * The cached value of the '{@link #getJTAGScanChain() <em>JTAG Scan Chain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJTAGScanChain()
	 * @generated
	 * @ordered
	 */
	protected JTAGScanChainType jTAGScanChain;

	/**
	 * The cached value of the '{@link #getCoreInfo() <em>Core Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreInfo()
	 * @generated
	 * @ordered
	 */
	protected CoreInfoType coreInfo;

	/**
	 * The default value of the '{@link #isMultiCoreSupported() <em>Multi Core Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiCoreSupported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_CORE_SUPPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiCoreSupported() <em>Multi Core Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiCoreSupported()
	 * @generated
	 * @ordered
	 */
	protected boolean multiCoreSupported = MULTI_CORE_SUPPORTED_EDEFAULT;

	/**
	 * This is true if the Multi Core Supported attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean multiCoreSupportedESet;

	/**
	 * The default value of the '{@link #isUseNonStopMode() <em>Use Non Stop Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNonStopMode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_NON_STOP_MODE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseNonStopMode() <em>Use Non Stop Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNonStopMode()
	 * @generated
	 * @ordered
	 */
	protected boolean useNonStopMode = USE_NON_STOP_MODE_EDEFAULT;

	/**
	 * This is true if the Use Non Stop Mode attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useNonStopModeESet;

	/**
	 * The default value of the '{@link #getDefaultTAP() <em>Default TAP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTAP()
	 * @generated
	 * @ordered
	 */
	protected static final short DEFAULT_TAP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultTAP() <em>Default TAP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTAP()
	 * @generated
	 * @ordered
	 */
	protected short defaultTAP = DEFAULT_TAP_EDEFAULT;

	/**
	 * This is true if the Default TAP attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultTAPESet;

	/**
	 * The default value of the '{@link #getDevice() <em>Device</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected static final String DEVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDevice() <em>Device</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected String device = DEVICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return devicesPackage.Literals.PROCESSOR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCSFunnelBaseAddress() {
		return cSFunnelBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSFunnelBaseAddress(String newCSFunnelBaseAddress) {
		String oldCSFunnelBaseAddress = cSFunnelBaseAddress;
		cSFunnelBaseAddress = newCSFunnelBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS, oldCSFunnelBaseAddress, cSFunnelBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCSETFBaseAddress() {
		return cSETFBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSETFBaseAddress(String newCSETFBaseAddress) {
		String oldCSETFBaseAddress = cSETFBaseAddress;
		cSETFBaseAddress = newCSETFBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CSETF_BASE_ADDRESS, oldCSETFBaseAddress, cSETFBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCSETRBaseAddress() {
		return cSETRBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSETRBaseAddress(String newCSETRBaseAddress) {
		String oldCSETRBaseAddress = cSETRBaseAddress;
		cSETRBaseAddress = newCSETRBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CSETR_BASE_ADDRESS, oldCSETRBaseAddress, cSETRBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCSTPIUBaseAddress() {
		return cSTPIUBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSTPIUBaseAddress(String newCSTPIUBaseAddress) {
		String oldCSTPIUBaseAddress = cSTPIUBaseAddress;
		cSTPIUBaseAddress = newCSTPIUBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS, oldCSTPIUBaseAddress, cSTPIUBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCSSTMBaseAddress() {
		return cSSTMBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSSTMBaseAddress(String newCSSTMBaseAddress) {
		String oldCSSTMBaseAddress = cSSTMBaseAddress;
		cSSTMBaseAddress = newCSSTMBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CSSTM_BASE_ADDRESS, oldCSSTMBaseAddress, cSSTMBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getCSSTMFunnelPortIndex() {
		return cSSTMFunnelPortIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSSTMFunnelPortIndex(short newCSSTMFunnelPortIndex) {
		short oldCSSTMFunnelPortIndex = cSSTMFunnelPortIndex;
		cSSTMFunnelPortIndex = newCSSTMFunnelPortIndex;
		boolean oldCSSTMFunnelPortIndexESet = cSSTMFunnelPortIndexESet;
		cSSTMFunnelPortIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX, oldCSSTMFunnelPortIndex, cSSTMFunnelPortIndex, !oldCSSTMFunnelPortIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCSSTMFunnelPortIndex() {
		short oldCSSTMFunnelPortIndex = cSSTMFunnelPortIndex;
		boolean oldCSSTMFunnelPortIndexESet = cSSTMFunnelPortIndexESet;
		cSSTMFunnelPortIndex = CSSTM_FUNNEL_PORT_INDEX_EDEFAULT;
		cSSTMFunnelPortIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX, oldCSSTMFunnelPortIndex, CSSTM_FUNNEL_PORT_INDEX_EDEFAULT, oldCSSTMFunnelPortIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCSSTMFunnelPortIndex() {
		return cSSTMFunnelPortIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCSTSBaseAddress() {
		return cSTSBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCSTSBaseAddress(String newCSTSBaseAddress) {
		String oldCSTSBaseAddress = cSTSBaseAddress;
		cSTSBaseAddress = newCSTSBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CSTS_BASE_ADDRESS, oldCSTSBaseAddress, cSTSBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternalName() {
		return internalName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalName(String newInternalName) {
		String oldInternalName = internalName;
		internalName = newInternalName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__INTERNAL_NAME, oldInternalName, internalName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getDeviceType() {
		return deviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeviceType(short newDeviceType) {
		short oldDeviceType = deviceType;
		deviceType = newDeviceType;
		boolean oldDeviceTypeESet = deviceTypeESet;
		deviceTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__DEVICE_TYPE, oldDeviceType, deviceType, !oldDeviceTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeviceType() {
		short oldDeviceType = deviceType;
		boolean oldDeviceTypeESet = deviceTypeESet;
		deviceType = DEVICE_TYPE_EDEFAULT;
		deviceTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__DEVICE_TYPE, oldDeviceType, DEVICE_TYPE_EDEFAULT, oldDeviceTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeviceType() {
		return deviceTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getCoresightCompliant() {
		return coresightCompliant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoresightCompliant(short newCoresightCompliant) {
		short oldCoresightCompliant = coresightCompliant;
		coresightCompliant = newCoresightCompliant;
		boolean oldCoresightCompliantESet = coresightCompliantESet;
		coresightCompliantESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CORESIGHT_COMPLIANT, oldCoresightCompliant, coresightCompliant, !oldCoresightCompliantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCoresightCompliant() {
		short oldCoresightCompliant = coresightCompliant;
		boolean oldCoresightCompliantESet = coresightCompliantESet;
		coresightCompliant = CORESIGHT_COMPLIANT_EDEFAULT;
		coresightCompliantESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__CORESIGHT_COMPLIANT, oldCoresightCompliant, CORESIGHT_COMPLIANT_EDEFAULT, oldCoresightCompliantESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCoresightCompliant() {
		return coresightCompliantESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResetType() {
		return resetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetType(String newResetType) {
		String oldResetType = resetType;
		resetType = newResetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__RESET_TYPE, oldResetType, resetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebuggerControlType getDebuggerControl() {
		return debuggerControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDebuggerControl(DebuggerControlType newDebuggerControl, NotificationChain msgs) {
		DebuggerControlType oldDebuggerControl = debuggerControl;
		debuggerControl = newDebuggerControl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL, oldDebuggerControl, newDebuggerControl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebuggerControl(DebuggerControlType newDebuggerControl) {
		if (newDebuggerControl != debuggerControl) {
			NotificationChain msgs = null;
			if (debuggerControl != null)
				msgs = ((InternalEObject)debuggerControl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL, null, msgs);
			if (newDebuggerControl != null)
				msgs = ((InternalEObject)newDebuggerControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL, null, msgs);
			msgs = basicSetDebuggerControl(newDebuggerControl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL, newDebuggerControl, newDebuggerControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARCEmulatorType getARCEmulator() {
		return aRCEmulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetARCEmulator(ARCEmulatorType newARCEmulator, NotificationChain msgs) {
		ARCEmulatorType oldARCEmulator = aRCEmulator;
		aRCEmulator = newARCEmulator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR, oldARCEmulator, newARCEmulator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setARCEmulator(ARCEmulatorType newARCEmulator) {
		if (newARCEmulator != aRCEmulator) {
			NotificationChain msgs = null;
			if (aRCEmulator != null)
				msgs = ((InternalEObject)aRCEmulator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR, null, msgs);
			if (newARCEmulator != null)
				msgs = ((InternalEObject)newARCEmulator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR, null, msgs);
			msgs = basicSetARCEmulator(newARCEmulator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR, newARCEmulator, newARCEmulator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstructionToSelectADI() {
		return instructionToSelectADI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstructionToSelectADI(String newInstructionToSelectADI) {
		String oldInstructionToSelectADI = instructionToSelectADI;
		instructionToSelectADI = newInstructionToSelectADI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI, oldInstructionToSelectADI, instructionToSelectADI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDMAPType getMDMAP() {
		return mDMAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMDMAP(MDMAPType newMDMAP, NotificationChain msgs) {
		MDMAPType oldMDMAP = mDMAP;
		mDMAP = newMDMAP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__MDMAP, oldMDMAP, newMDMAP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMDMAP(MDMAPType newMDMAP) {
		if (newMDMAP != mDMAP) {
			NotificationChain msgs = null;
			if (mDMAP != null)
				msgs = ((InternalEObject)mDMAP).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__MDMAP, null, msgs);
			if (newMDMAP != null)
				msgs = ((InternalEObject)newMDMAP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__MDMAP, null, msgs);
			msgs = basicSetMDMAP(newMDMAP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__MDMAP, newMDMAP, newMDMAP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getEscapeSequenceType() {
		return escapeSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscapeSequenceType(short newEscapeSequenceType) {
		short oldEscapeSequenceType = escapeSequenceType;
		escapeSequenceType = newEscapeSequenceType;
		boolean oldEscapeSequenceTypeESet = escapeSequenceTypeESet;
		escapeSequenceTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE, oldEscapeSequenceType, escapeSequenceType, !oldEscapeSequenceTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEscapeSequenceType() {
		short oldEscapeSequenceType = escapeSequenceType;
		boolean oldEscapeSequenceTypeESet = escapeSequenceTypeESet;
		escapeSequenceType = ESCAPE_SEQUENCE_TYPE_EDEFAULT;
		escapeSequenceTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE, oldEscapeSequenceType, ESCAPE_SEQUENCE_TYPE_EDEFAULT, oldEscapeSequenceTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEscapeSequenceType() {
		return escapeSequenceTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JTAGScanChainType getJTAGScanChain() {
		return jTAGScanChain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJTAGScanChain(JTAGScanChainType newJTAGScanChain, NotificationChain msgs) {
		JTAGScanChainType oldJTAGScanChain = jTAGScanChain;
		jTAGScanChain = newJTAGScanChain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN, oldJTAGScanChain, newJTAGScanChain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJTAGScanChain(JTAGScanChainType newJTAGScanChain) {
		if (newJTAGScanChain != jTAGScanChain) {
			NotificationChain msgs = null;
			if (jTAGScanChain != null)
				msgs = ((InternalEObject)jTAGScanChain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN, null, msgs);
			if (newJTAGScanChain != null)
				msgs = ((InternalEObject)newJTAGScanChain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN, null, msgs);
			msgs = basicSetJTAGScanChain(newJTAGScanChain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN, newJTAGScanChain, newJTAGScanChain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreInfoType getCoreInfo() {
		return coreInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreInfo(CoreInfoType newCoreInfo, NotificationChain msgs) {
		CoreInfoType oldCoreInfo = coreInfo;
		coreInfo = newCoreInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CORE_INFO, oldCoreInfo, newCoreInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreInfo(CoreInfoType newCoreInfo) {
		if (newCoreInfo != coreInfo) {
			NotificationChain msgs = null;
			if (coreInfo != null)
				msgs = ((InternalEObject)coreInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__CORE_INFO, null, msgs);
			if (newCoreInfo != null)
				msgs = ((InternalEObject)newCoreInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - devicesPackage.PROCESSOR_TYPE__CORE_INFO, null, msgs);
			msgs = basicSetCoreInfo(newCoreInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__CORE_INFO, newCoreInfo, newCoreInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiCoreSupported() {
		return multiCoreSupported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiCoreSupported(boolean newMultiCoreSupported) {
		boolean oldMultiCoreSupported = multiCoreSupported;
		multiCoreSupported = newMultiCoreSupported;
		boolean oldMultiCoreSupportedESet = multiCoreSupportedESet;
		multiCoreSupportedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__MULTI_CORE_SUPPORTED, oldMultiCoreSupported, multiCoreSupported, !oldMultiCoreSupportedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMultiCoreSupported() {
		boolean oldMultiCoreSupported = multiCoreSupported;
		boolean oldMultiCoreSupportedESet = multiCoreSupportedESet;
		multiCoreSupported = MULTI_CORE_SUPPORTED_EDEFAULT;
		multiCoreSupportedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__MULTI_CORE_SUPPORTED, oldMultiCoreSupported, MULTI_CORE_SUPPORTED_EDEFAULT, oldMultiCoreSupportedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMultiCoreSupported() {
		return multiCoreSupportedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseNonStopMode() {
		return useNonStopMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNonStopMode(boolean newUseNonStopMode) {
		boolean oldUseNonStopMode = useNonStopMode;
		useNonStopMode = newUseNonStopMode;
		boolean oldUseNonStopModeESet = useNonStopModeESet;
		useNonStopModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__USE_NON_STOP_MODE, oldUseNonStopMode, useNonStopMode, !oldUseNonStopModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUseNonStopMode() {
		boolean oldUseNonStopMode = useNonStopMode;
		boolean oldUseNonStopModeESet = useNonStopModeESet;
		useNonStopMode = USE_NON_STOP_MODE_EDEFAULT;
		useNonStopModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__USE_NON_STOP_MODE, oldUseNonStopMode, USE_NON_STOP_MODE_EDEFAULT, oldUseNonStopModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUseNonStopMode() {
		return useNonStopModeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getDefaultTAP() {
		return defaultTAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTAP(short newDefaultTAP) {
		short oldDefaultTAP = defaultTAP;
		defaultTAP = newDefaultTAP;
		boolean oldDefaultTAPESet = defaultTAPESet;
		defaultTAPESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__DEFAULT_TAP, oldDefaultTAP, defaultTAP, !oldDefaultTAPESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultTAP() {
		short oldDefaultTAP = defaultTAP;
		boolean oldDefaultTAPESet = defaultTAPESet;
		defaultTAP = DEFAULT_TAP_EDEFAULT;
		defaultTAPESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, devicesPackage.PROCESSOR_TYPE__DEFAULT_TAP, oldDefaultTAP, DEFAULT_TAP_EDEFAULT, oldDefaultTAPESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultTAP() {
		return defaultTAPESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevice(String newDevice) {
		String oldDevice = device;
		device = newDevice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, devicesPackage.PROCESSOR_TYPE__DEVICE, oldDevice, device));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL:
				return basicSetDebuggerControl(null, msgs);
			case devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR:
				return basicSetARCEmulator(null, msgs);
			case devicesPackage.PROCESSOR_TYPE__MDMAP:
				return basicSetMDMAP(null, msgs);
			case devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN:
				return basicSetJTAGScanChain(null, msgs);
			case devicesPackage.PROCESSOR_TYPE__CORE_INFO:
				return basicSetCoreInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case devicesPackage.PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS:
				return getCSFunnelBaseAddress();
			case devicesPackage.PROCESSOR_TYPE__CSETF_BASE_ADDRESS:
				return getCSETFBaseAddress();
			case devicesPackage.PROCESSOR_TYPE__CSETR_BASE_ADDRESS:
				return getCSETRBaseAddress();
			case devicesPackage.PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS:
				return getCSTPIUBaseAddress();
			case devicesPackage.PROCESSOR_TYPE__CSSTM_BASE_ADDRESS:
				return getCSSTMBaseAddress();
			case devicesPackage.PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX:
				return getCSSTMFunnelPortIndex();
			case devicesPackage.PROCESSOR_TYPE__CSTS_BASE_ADDRESS:
				return getCSTSBaseAddress();
			case devicesPackage.PROCESSOR_TYPE__INTERNAL_NAME:
				return getInternalName();
			case devicesPackage.PROCESSOR_TYPE__DEVICE_TYPE:
				return getDeviceType();
			case devicesPackage.PROCESSOR_TYPE__CORESIGHT_COMPLIANT:
				return getCoresightCompliant();
			case devicesPackage.PROCESSOR_TYPE__RESET_TYPE:
				return getResetType();
			case devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL:
				return getDebuggerControl();
			case devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR:
				return getARCEmulator();
			case devicesPackage.PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI:
				return getInstructionToSelectADI();
			case devicesPackage.PROCESSOR_TYPE__MDMAP:
				return getMDMAP();
			case devicesPackage.PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE:
				return getEscapeSequenceType();
			case devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN:
				return getJTAGScanChain();
			case devicesPackage.PROCESSOR_TYPE__CORE_INFO:
				return getCoreInfo();
			case devicesPackage.PROCESSOR_TYPE__MULTI_CORE_SUPPORTED:
				return isMultiCoreSupported();
			case devicesPackage.PROCESSOR_TYPE__USE_NON_STOP_MODE:
				return isUseNonStopMode();
			case devicesPackage.PROCESSOR_TYPE__DEFAULT_TAP:
				return getDefaultTAP();
			case devicesPackage.PROCESSOR_TYPE__DEVICE:
				return getDevice();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case devicesPackage.PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS:
				setCSFunnelBaseAddress((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSETF_BASE_ADDRESS:
				setCSETFBaseAddress((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSETR_BASE_ADDRESS:
				setCSETRBaseAddress((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS:
				setCSTPIUBaseAddress((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSSTM_BASE_ADDRESS:
				setCSSTMBaseAddress((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX:
				setCSSTMFunnelPortIndex((Short)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSTS_BASE_ADDRESS:
				setCSTSBaseAddress((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__INTERNAL_NAME:
				setInternalName((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__DEVICE_TYPE:
				setDeviceType((Short)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CORESIGHT_COMPLIANT:
				setCoresightCompliant((Short)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__RESET_TYPE:
				setResetType((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL:
				setDebuggerControl((DebuggerControlType)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR:
				setARCEmulator((ARCEmulatorType)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI:
				setInstructionToSelectADI((String)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__MDMAP:
				setMDMAP((MDMAPType)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE:
				setEscapeSequenceType((Short)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN:
				setJTAGScanChain((JTAGScanChainType)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__CORE_INFO:
				setCoreInfo((CoreInfoType)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__MULTI_CORE_SUPPORTED:
				setMultiCoreSupported((Boolean)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__USE_NON_STOP_MODE:
				setUseNonStopMode((Boolean)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__DEFAULT_TAP:
				setDefaultTAP((Short)newValue);
				return;
			case devicesPackage.PROCESSOR_TYPE__DEVICE:
				setDevice((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case devicesPackage.PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS:
				setCSFunnelBaseAddress(CS_FUNNEL_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSETF_BASE_ADDRESS:
				setCSETFBaseAddress(CSETF_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSETR_BASE_ADDRESS:
				setCSETRBaseAddress(CSETR_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS:
				setCSTPIUBaseAddress(CSTPIU_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSSTM_BASE_ADDRESS:
				setCSSTMBaseAddress(CSSTM_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX:
				unsetCSSTMFunnelPortIndex();
				return;
			case devicesPackage.PROCESSOR_TYPE__CSTS_BASE_ADDRESS:
				setCSTSBaseAddress(CSTS_BASE_ADDRESS_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__INTERNAL_NAME:
				setInternalName(INTERNAL_NAME_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__DEVICE_TYPE:
				unsetDeviceType();
				return;
			case devicesPackage.PROCESSOR_TYPE__CORESIGHT_COMPLIANT:
				unsetCoresightCompliant();
				return;
			case devicesPackage.PROCESSOR_TYPE__RESET_TYPE:
				setResetType(RESET_TYPE_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL:
				setDebuggerControl((DebuggerControlType)null);
				return;
			case devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR:
				setARCEmulator((ARCEmulatorType)null);
				return;
			case devicesPackage.PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI:
				setInstructionToSelectADI(INSTRUCTION_TO_SELECT_ADI_EDEFAULT);
				return;
			case devicesPackage.PROCESSOR_TYPE__MDMAP:
				setMDMAP((MDMAPType)null);
				return;
			case devicesPackage.PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE:
				unsetEscapeSequenceType();
				return;
			case devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN:
				setJTAGScanChain((JTAGScanChainType)null);
				return;
			case devicesPackage.PROCESSOR_TYPE__CORE_INFO:
				setCoreInfo((CoreInfoType)null);
				return;
			case devicesPackage.PROCESSOR_TYPE__MULTI_CORE_SUPPORTED:
				unsetMultiCoreSupported();
				return;
			case devicesPackage.PROCESSOR_TYPE__USE_NON_STOP_MODE:
				unsetUseNonStopMode();
				return;
			case devicesPackage.PROCESSOR_TYPE__DEFAULT_TAP:
				unsetDefaultTAP();
				return;
			case devicesPackage.PROCESSOR_TYPE__DEVICE:
				setDevice(DEVICE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case devicesPackage.PROCESSOR_TYPE__CS_FUNNEL_BASE_ADDRESS:
				return CS_FUNNEL_BASE_ADDRESS_EDEFAULT == null ? cSFunnelBaseAddress != null : !CS_FUNNEL_BASE_ADDRESS_EDEFAULT.equals(cSFunnelBaseAddress);
			case devicesPackage.PROCESSOR_TYPE__CSETF_BASE_ADDRESS:
				return CSETF_BASE_ADDRESS_EDEFAULT == null ? cSETFBaseAddress != null : !CSETF_BASE_ADDRESS_EDEFAULT.equals(cSETFBaseAddress);
			case devicesPackage.PROCESSOR_TYPE__CSETR_BASE_ADDRESS:
				return CSETR_BASE_ADDRESS_EDEFAULT == null ? cSETRBaseAddress != null : !CSETR_BASE_ADDRESS_EDEFAULT.equals(cSETRBaseAddress);
			case devicesPackage.PROCESSOR_TYPE__CSTPIU_BASE_ADDRESS:
				return CSTPIU_BASE_ADDRESS_EDEFAULT == null ? cSTPIUBaseAddress != null : !CSTPIU_BASE_ADDRESS_EDEFAULT.equals(cSTPIUBaseAddress);
			case devicesPackage.PROCESSOR_TYPE__CSSTM_BASE_ADDRESS:
				return CSSTM_BASE_ADDRESS_EDEFAULT == null ? cSSTMBaseAddress != null : !CSSTM_BASE_ADDRESS_EDEFAULT.equals(cSSTMBaseAddress);
			case devicesPackage.PROCESSOR_TYPE__CSSTM_FUNNEL_PORT_INDEX:
				return isSetCSSTMFunnelPortIndex();
			case devicesPackage.PROCESSOR_TYPE__CSTS_BASE_ADDRESS:
				return CSTS_BASE_ADDRESS_EDEFAULT == null ? cSTSBaseAddress != null : !CSTS_BASE_ADDRESS_EDEFAULT.equals(cSTSBaseAddress);
			case devicesPackage.PROCESSOR_TYPE__INTERNAL_NAME:
				return INTERNAL_NAME_EDEFAULT == null ? internalName != null : !INTERNAL_NAME_EDEFAULT.equals(internalName);
			case devicesPackage.PROCESSOR_TYPE__DEVICE_TYPE:
				return isSetDeviceType();
			case devicesPackage.PROCESSOR_TYPE__CORESIGHT_COMPLIANT:
				return isSetCoresightCompliant();
			case devicesPackage.PROCESSOR_TYPE__RESET_TYPE:
				return RESET_TYPE_EDEFAULT == null ? resetType != null : !RESET_TYPE_EDEFAULT.equals(resetType);
			case devicesPackage.PROCESSOR_TYPE__DEBUGGER_CONTROL:
				return debuggerControl != null;
			case devicesPackage.PROCESSOR_TYPE__ARC_EMULATOR:
				return aRCEmulator != null;
			case devicesPackage.PROCESSOR_TYPE__INSTRUCTION_TO_SELECT_ADI:
				return INSTRUCTION_TO_SELECT_ADI_EDEFAULT == null ? instructionToSelectADI != null : !INSTRUCTION_TO_SELECT_ADI_EDEFAULT.equals(instructionToSelectADI);
			case devicesPackage.PROCESSOR_TYPE__MDMAP:
				return mDMAP != null;
			case devicesPackage.PROCESSOR_TYPE__ESCAPE_SEQUENCE_TYPE:
				return isSetEscapeSequenceType();
			case devicesPackage.PROCESSOR_TYPE__JTAG_SCAN_CHAIN:
				return jTAGScanChain != null;
			case devicesPackage.PROCESSOR_TYPE__CORE_INFO:
				return coreInfo != null;
			case devicesPackage.PROCESSOR_TYPE__MULTI_CORE_SUPPORTED:
				return isSetMultiCoreSupported();
			case devicesPackage.PROCESSOR_TYPE__USE_NON_STOP_MODE:
				return isSetUseNonStopMode();
			case devicesPackage.PROCESSOR_TYPE__DEFAULT_TAP:
				return isSetDefaultTAP();
			case devicesPackage.PROCESSOR_TYPE__DEVICE:
				return DEVICE_EDEFAULT == null ? device != null : !DEVICE_EDEFAULT.equals(device);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (cSFunnelBaseAddress: ");
		result.append(cSFunnelBaseAddress);
		result.append(", cSETFBaseAddress: ");
		result.append(cSETFBaseAddress);
		result.append(", cSETRBaseAddress: ");
		result.append(cSETRBaseAddress);
		result.append(", cSTPIUBaseAddress: ");
		result.append(cSTPIUBaseAddress);
		result.append(", cSSTMBaseAddress: ");
		result.append(cSSTMBaseAddress);
		result.append(", cSSTMFunnelPortIndex: ");
		if (cSSTMFunnelPortIndexESet) result.append(cSSTMFunnelPortIndex); else result.append("<unset>");
		result.append(", cSTSBaseAddress: ");
		result.append(cSTSBaseAddress);
		result.append(", internalName: ");
		result.append(internalName);
		result.append(", deviceType: ");
		if (deviceTypeESet) result.append(deviceType); else result.append("<unset>");
		result.append(", coresightCompliant: ");
		if (coresightCompliantESet) result.append(coresightCompliant); else result.append("<unset>");
		result.append(", resetType: ");
		result.append(resetType);
		result.append(", instructionToSelectADI: ");
		result.append(instructionToSelectADI);
		result.append(", escapeSequenceType: ");
		if (escapeSequenceTypeESet) result.append(escapeSequenceType); else result.append("<unset>");
		result.append(", multiCoreSupported: ");
		if (multiCoreSupportedESet) result.append(multiCoreSupported); else result.append("<unset>");
		result.append(", useNonStopMode: ");
		if (useNonStopModeESet) result.append(useNonStopMode); else result.append("<unset>");
		result.append(", defaultTAP: ");
		if (defaultTAPESet) result.append(defaultTAP); else result.append("<unset>");
		result.append(", device: ");
		result.append(device);
		result.append(')');
		return result.toString();
	}

} //ProcessorTypeImpl
