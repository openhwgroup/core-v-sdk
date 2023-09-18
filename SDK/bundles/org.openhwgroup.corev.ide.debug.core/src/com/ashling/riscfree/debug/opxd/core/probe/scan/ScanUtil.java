package com.ashling.riscfree.debug.opxd.core.probe.scan;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.ashling.riscfree.debug.opxd.core.Activator;
import com.ashling.riscfree.debug.opxd.core.scanchain.ScanChain;

/**
 * ScanUtil is a Singleton utility class which provides API for scanning debug
 * probes: {@link ScanUtil#scanDebugProbes(ProbeNames, CommunicationMedium)}. A
 * usage example follows:
 * 
 * <pre>
 *  {@code 
 *  package test;
 *  
 *  import com.ashling.pf.tm.utils.probe.DebugProbe;
 *  import com.ashling.pf.tm.utils.probe.ProbeNames;
 *  import com.ashling.pf.tm.utils.scan.ScanUtil;
 *  
 *  public class TestScan {
 *  
 *  	public static void main(String[] args) {
 *  		ScanUtil provider = ScanUtil.getDefault();
 *  		DebugProbe[] probes = provider.scanDebugProbes(ProbeNames.OPELLA_XD);
 *  		if (null != probes) {
 *  			for (DebugProbe probe : probes) {
 *  				// print serial number of probe
 *  				System.out.println("Serial number = " + probe.getSerialNumber());
 *  			}
 *  		}
 *  	}
 *  }
 * }
 * </pre>
 * 
 * </code>
 * 
 * @author vinod.appu
 * 
 */

//TODO: Change name of this class. This will be using for all the native calls
public class ScanUtil {
	private static final String OS_LINUX = "linux";
	private static final String OS_WIN32 = "win32";
	private static final String WIN32_DLL_NAME = "guiopxdif.dll"; //$NON-NLS-1$
	private static final String LINUX_SO_NAME = "libguiopxdif.so"; //$NON-NLS-1$
	private static final String DLL_PATH = "debugger"; //$NON-NLS-1$
	private static String scanLibpath = null;
	private static ScanUtil scanUtil = null;

	// Native(c++) functions for scanning Opella-XD
	private native short scanOppellaXDInstance(DebugProbe[] opella, String gdbServerPath, String [] jniErrorMessage);

	private native int openDevice(String serialNumber);

	private native int closeDevice(String serialNumber);
	
	private native int isCoreRunning(String serialNumber, int coreType, int tapNumber, TargetState targetStatus);	
	
    private native int detectScanChain(String serialNumber, ScanChain sc, String jtagFreq, int tapReset);
		
	public native int updateScanChain(String serialNumber, int ulNumberOfTap , int[] byPassInstructions, int[] irLengths);       
	
	/**
	 * Thread safe API for getting the instance of ScanUtil class, to be used for
	 * scanning Ashling debug probes. Will return null if any Exception or Error
	 * occurs
	 * 
	 * @return the instance of <code>ScanUtil.</code>
	 */
	public static ScanUtil getDefault() {
		try {
			if (null == scanUtil) {
				synchronized (ScanUtil.class) {
					if (null == scanUtil) {
						scanUtil = new ScanUtil(Paths.get(computeInstallLocation().toString(), DLL_PATH).toAbsolutePath().toString());
						load();
					}
				}
			}
		} catch (Exception e) {
			Activator.logErrorMessage("Failed to load guiopxd.dll");
			Activator.log(e);
			scanUtil = null;
		}
		return scanUtil;
	}
	
    public static File computeInstallLocation(){
        URL url = Platform.getInstallLocation().getURL();
        return url == null?new File("."):new File(url.getPath()).getParentFile();
    }
    
	/**
	 * private constructor
	 * 
	 * @param libPath library path of scan DLL, path should need to contain
	 *                interface DLL
	 */
	private ScanUtil(String libPath) {
		ScanUtil.scanLibpath = libPath;
	}

	/**
	 * loads dll libraty
	 */
	private static void load() throws Exception {
		String OSName = Platform.getOS();
		if (OSName.compareTo(OS_WIN32) == 0) { // $NON-NLS-1$
			System.load(scanLibpath + "/" + WIN32_DLL_NAME);
		} else if (OSName.compareTo(OS_LINUX) == 0) { // $NON-NLS-1$
			System.load(scanLibpath + "/" + LINUX_SO_NAME);
		}
	}

	/**
	 * Returns the path of Ashling libraries.
	 * 
	 * @return Ashling library path
	 */
	public String getLibraryPath() {
		return scanLibpath;
	}

	/**
	 * This API initiates scanning of debug probes according to the given arguments
	 * and returns an array of scanned debug probes.
	 * 
	 * @param probName the type of Ashling probe to be scanned.
	 * @param medium   the communication interface used.
	 * @return An array of {@link DebugProbe} objects, if the scan completed
	 *         successfully; null otherwise.
	 */
	public synchronized DebugProbe[] scanDebugProbes(ProbeNames probName) {
		if ((null != scanLibpath) && (null != probName)) {
			if (probName.equals(ProbeNames.OPELLA_XD)) {
				return scanOpellaInstance(scanLibpath);
			} else {
				throw new UnsupportedOperationException("Unsupported debug probe : " + probName.toString());
			}
		}
		return null;
	}
	
	/**
	 * This API which will invoke the jtagserver for configure USB Blaster driver
	 */
	public synchronized void invokeJTAGServer() {
		if (null != scanLibpath) {
			scanOpellaInstance(scanLibpath);
		}
	}
	
	/**
	 * This API initiates scanning of debug probes according to the given arguments
	 * and returns serial number of first found debug probes.
	 * 
	 * @param probName the type of Ashling probe to be scanned.
	 * @param medium   the communication interface used.
	 * @return An array of {@link DebugProbe} objects, if the scan completed
	 *         successfully; null otherwise.
	 */
	public synchronized String firstFoundDebugProbe(ProbeNames probName) {
		DebugProbe debugProbes[];
		debugProbes = scanDebugProbes(ProbeNames.OPELLA_XD);
		if(debugProbes != null)
		{
			return debugProbes[0].getSerialNumber();
		}
		return null;
	}

	/**
	 * Loads the DLL and reads connected Opella-XD details from it.
	 * 
	 * @param GDB Server path
	 */
	private DebugProbe[] scanOpellaInstance(String path) {
		Activator.logInfo("Scanning debug probes");
		try {
			DebugProbe[] opellaInstance = new DebugProbe[16];
			DebugProbe[] retunProbes = null;
			String[] errorString = new String[1];
			short probeCount = scanOppellaXDInstance(opellaInstance, path, errorString);
			if (probeCount > 0) {
				retunProbes = new DebugProbe[probeCount];
				for (int i = 0; i < probeCount; i++) {
					Activator.logInfo(opellaInstance[i].toString());
					retunProbes[i] = opellaInstance[i];
				}
			}
			// TODO: Is there a better approach to separate UI related items?
			if (errorString[0] != null && !errorString[0].isBlank()) {
				Activator.logErrorMessage("Scanning debug probes failed with error : " + errorString[0]);
				Display.getDefault().asyncExec(() -> {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", errorString[0]);
				});
			} else if (probeCount == 0) {
				Activator.logInfo("No Debug probes found");
			}
			return retunProbes;
		}catch(Throwable e) {
			Activator.log(e);
			throw e;
		}
	}

	public synchronized boolean openOpellaDevice(String serialNumber) {
		Activator.logInfo("Opening device with serialNumber=" + Optional.ofNullable(serialNumber).orElse(""));
		try {
			int openDevice = openDevice(serialNumber);
			Activator.logInfo("Result of openDevice call with serialNumber=" + Optional.ofNullable(serialNumber).orElse("")
					+ " is " + openDevice);
			return openDevice == 0 ? true : false;
		}catch(Throwable e) {
			Activator.log(e);
			throw e;
		}
	}

	public synchronized boolean closeOpellaDevice(String serialNumber) {
		Activator.logInfo("Closing device with serialNumber=" + Optional.ofNullable(serialNumber).orElse(""));
		try {
			int closeDevice = closeDevice(serialNumber);
			Activator.logInfo("Result of closeDevice call with serialNumber="
					+ Optional.ofNullable(serialNumber).orElse("") + " is " + closeDevice);
			return closeDevice == 0 ? true : false;
		} catch (Throwable e) {
			Activator.log(e);
			throw e;
		}
	}
	
	public synchronized ScanChain detectScanChain(String serialNumber, String jtagFreq, int tapReset) {
		Activator.logInfo("Detecting scan chain for serial number=" + Optional.ofNullable(serialNumber).orElse("")
				+ " jtagFreq=" + jtagFreq + " tapReset=" + tapReset);
		try {
			ScanChain scanChain = new ScanChain();
			int result = detectScanChain(serialNumber, scanChain, jtagFreq, tapReset);
			logDetectScanchainResponse(result, scanChain);
			// TODO : need to handle error case if -1 is coming as result- ie- message to
			// user
			if (result != 0 || scanChain.getTaps().isEmpty()) {
				return null;
			}
			return scanChain;
		} catch (Throwable e) {
			Activator.log(e);
			throw e;
		}
	}
	
	private void logDetectScanchainResponse(int result, ScanChain scanChain) {
		if (result != 0) {
			Activator.logErrorMessage("Detecting scan chain failed with result=" + result);
		} else {
			if(scanChain == null || scanChain.getTaps().isEmpty()) {
				Activator.logInfo("No taps found");
				return;
			}
			scanChain.getTaps().forEach(tapDet -> {
				Activator.logInfo(tapDet.toString());
				tapDet.getCoreDetails().forEach(coreDet->{
					Activator.logInfo(coreDet.toString());
				});
			});
		}
	}

	public synchronized TargetState getTargetStatus(String serialNumber, CoreType coreType, int tapNumber) {
		Activator.logInfo("Fetching target status with serialNumber=" + Optional.ofNullable(serialNumber).orElse("")
				+ " tapNumber=" + tapNumber + " coreType=" + coreType.getValue());
		try {
			TargetState targetStatus = new TargetState();
			isCoreRunning(serialNumber, coreType.getValue(), tapNumber, targetStatus);
			Optional.ofNullable(targetStatus).ifPresent(ts -> {
				Activator.logInfo(ts.toString());
			});
			return targetStatus;
		} catch (Throwable e) {
			Activator.log(e);
			throw e;
		}
	}
}
