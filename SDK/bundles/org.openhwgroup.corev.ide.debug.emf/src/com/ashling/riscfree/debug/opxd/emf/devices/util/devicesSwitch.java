/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.ashling.riscfree.debug.opxd.emf.devices.ARCEmulatorType;
import com.ashling.riscfree.debug.opxd.emf.devices.AshlingProcessorDataBaseType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreInfoType;
import com.ashling.riscfree.debug.opxd.emf.devices.CoreType;
import com.ashling.riscfree.debug.opxd.emf.devices.DAPType;
import com.ashling.riscfree.debug.opxd.emf.devices.DebuggerControlType;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see devicesPackage.DevicesPackage
 * @generated
 */
public class devicesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static devicesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public devicesSwitch() {
		if (modelPackage == null) {
			modelPackage = devicesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case devicesPackage.ARC_EMULATOR_TYPE: {
				ARCEmulatorType arcEmulatorType = (ARCEmulatorType)theEObject;
				T result = caseARCEmulatorType(arcEmulatorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.ASHLING_PROCESSOR_DATA_BASE_TYPE: {
				AshlingProcessorDataBaseType ashlingProcessorDataBaseType = (AshlingProcessorDataBaseType)theEObject;
				T result = caseAshlingProcessorDataBaseType(ashlingProcessorDataBaseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.CORE_INFO_TYPE: {
				CoreInfoType coreInfoType = (CoreInfoType)theEObject;
				T result = caseCoreInfoType(coreInfoType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.CORE_TYPE: {
				CoreType coreType = (CoreType)theEObject;
				T result = caseCoreType(coreType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.DAP_TYPE: {
				DAPType dapType = (DAPType)theEObject;
				T result = caseDAPType(dapType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.DEBUGGER_CONTROL_TYPE: {
				DebuggerControlType debuggerControlType = (DebuggerControlType)theEObject;
				T result = caseDebuggerControlType(debuggerControlType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.JTAGDP_TYPE: {
				JTAGDPType jtagdpType = (JTAGDPType)theEObject;
				T result = caseJTAGDPType(jtagdpType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.JTAG_SCAN_CHAIN_TYPE: {
				JTAGScanChainType jtagScanChainType = (JTAGScanChainType)theEObject;
				T result = caseJTAGScanChainType(jtagScanChainType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.MDMAP_TYPE: {
				MDMAPType mdmapType = (MDMAPType)theEObject;
				T result = caseMDMAPType(mdmapType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.MEM_AREA_TYPE: {
				MemAreaType memAreaType = (MemAreaType)theEObject;
				T result = caseMemAreaType(memAreaType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.MEMORY_TYPE: {
				MemoryType memoryType = (MemoryType)theEObject;
				T result = caseMemoryType(memoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.PROCESSOR_TYPE: {
				ProcessorType processorType = (ProcessorType)theEObject;
				T result = caseProcessorType(processorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.TAP_TYPE: {
				TapType tapType = (TapType)theEObject;
				T result = caseTapType(tapType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.TAP_TYPE1: {
				TapType1 tapType1 = (TapType1)theEObject;
				T result = caseTapType1(tapType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.TARGET_VOLTAGE_TYPE: {
				TargetVoltageType targetVoltageType = (TargetVoltageType)theEObject;
				T result = caseTargetVoltageType(targetVoltageType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case devicesPackage.VJTAG_TYPE: {
				VJTAGType vjtagType = (VJTAGType)theEObject;
				T result = caseVJTAGType(vjtagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ARC Emulator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ARC Emulator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseARCEmulatorType(ARCEmulatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ashling Processor Data Base Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ashling Processor Data Base Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAshlingProcessorDataBaseType(AshlingProcessorDataBaseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Info Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Info Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreInfoType(CoreInfoType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreType(CoreType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DAP Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DAP Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDAPType(DAPType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Debugger Control Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Debugger Control Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDebuggerControlType(DebuggerControlType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JTAGDP Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JTAGDP Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJTAGDPType(JTAGDPType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JTAG Scan Chain Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JTAG Scan Chain Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJTAGScanChainType(JTAGScanChainType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MDMAP Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MDMAP Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMDMAPType(MDMAPType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mem Area Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mem Area Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemAreaType(MemAreaType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryType(MemoryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorType(ProcessorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tap Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tap Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTapType(TapType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tap Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tap Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTapType1(TapType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Voltage Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Voltage Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetVoltageType(TargetVoltageType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VJTAG Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VJTAG Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVJTAGType(VJTAGType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DevicesSwitch
