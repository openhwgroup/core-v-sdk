/**
 */
package com.ashling.riscfree.debug.opxd.emf.devices.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see devicesPackage.DevicesPackage
 * @generated
 */
public class devicesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static devicesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public devicesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = devicesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected devicesSwitch<Adapter> modelSwitch =
		new devicesSwitch<Adapter>() {
			@Override
			public Adapter caseARCEmulatorType(ARCEmulatorType object) {
				return createARCEmulatorTypeAdapter();
			}
			@Override
			public Adapter caseAshlingProcessorDataBaseType(AshlingProcessorDataBaseType object) {
				return createAshlingProcessorDataBaseTypeAdapter();
			}
			@Override
			public Adapter caseCoreInfoType(CoreInfoType object) {
				return createCoreInfoTypeAdapter();
			}
			@Override
			public Adapter caseCoreType(CoreType object) {
				return createCoreTypeAdapter();
			}
			@Override
			public Adapter caseDAPType(DAPType object) {
				return createDAPTypeAdapter();
			}
			@Override
			public Adapter caseDebuggerControlType(DebuggerControlType object) {
				return createDebuggerControlTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseJTAGDPType(JTAGDPType object) {
				return createJTAGDPTypeAdapter();
			}
			@Override
			public Adapter caseJTAGScanChainType(JTAGScanChainType object) {
				return createJTAGScanChainTypeAdapter();
			}
			@Override
			public Adapter caseMDMAPType(MDMAPType object) {
				return createMDMAPTypeAdapter();
			}
			@Override
			public Adapter caseMemAreaType(MemAreaType object) {
				return createMemAreaTypeAdapter();
			}
			@Override
			public Adapter caseMemoryType(MemoryType object) {
				return createMemoryTypeAdapter();
			}
			@Override
			public Adapter caseProcessorType(ProcessorType object) {
				return createProcessorTypeAdapter();
			}
			@Override
			public Adapter caseTapType(TapType object) {
				return createTapTypeAdapter();
			}
			@Override
			public Adapter caseTapType1(TapType1 object) {
				return createTapType1Adapter();
			}
			@Override
			public Adapter caseTargetVoltageType(TargetVoltageType object) {
				return createTargetVoltageTypeAdapter();
			}
			@Override
			public Adapter caseVJTAGType(VJTAGType object) {
				return createVJTAGTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Devices.ARCEmulatorType <em>ARC Emulator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.ARCEmulatorType
	 * @generated
	 */
	public Adapter createARCEmulatorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.AshlingProcessorDataBaseType <em>Ashling Processor Data Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.AshlingProcessorDataBaseType
	 * @generated
	 */
	public Adapter createAshlingProcessorDataBaseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.CoreInfoType <em>Core Info Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.CoreInfoType
	 * @generated
	 */
	public Adapter createCoreInfoTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.CoreType <em>Core Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.CoreType
	 * @generated
	 */
	public Adapter createCoreTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.DAPType <em>DAP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.DAPType
	 * @generated
	 */
	public Adapter createDAPTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.DebuggerControlType <em>Debugger Control Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.DebuggerControlType
	 * @generated
	 */
	public Adapter createDebuggerControlTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.JTAGDPType <em>JTAGDP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.JTAGDPType
	 * @generated
	 */
	public Adapter createJTAGDPTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.JTAGScanChainType <em>JTAG Scan Chain Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.JTAGScanChainType
	 * @generated
	 */
	public Adapter createJTAGScanChainTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.MDMAPType <em>MDMAP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.MDMAPType
	 * @generated
	 */
	public Adapter createMDMAPTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.MemAreaType <em>Mem Area Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.MemAreaType
	 * @generated
	 */
	public Adapter createMemAreaTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.MemoryType <em>Memory Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.MemoryType
	 * @generated
	 */
	public Adapter createMemoryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.ProcessorType <em>Processor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.ProcessorType
	 * @generated
	 */
	public Adapter createProcessorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.TapType <em>Tap Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.TapType
	 * @generated
	 */
	public Adapter createTapTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.TapType1 <em>Tap Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.TapType1
	 * @generated
	 */
	public Adapter createTapType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.TargetVoltageType <em>Target Voltage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.TargetVoltageType
	 * @generated
	 */
	public Adapter createTargetVoltageTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Devices.VJTAGType <em>VJTAG Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Devices.VJTAGType
	 * @generated
	 */
	public Adapter createVJTAGTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DevicesAdapterFactory
