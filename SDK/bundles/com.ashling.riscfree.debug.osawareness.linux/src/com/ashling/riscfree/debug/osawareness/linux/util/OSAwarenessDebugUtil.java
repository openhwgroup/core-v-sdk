package com.ashling.riscfree.debug.osawareness.linux.util;

import java.io.File;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.DsfExecutor;
import org.eclipse.cdt.dsf.concurrent.Query;
import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.IBreakpoints.IBreakpointsTargetDMContext;
import org.eclipse.cdt.dsf.debug.service.IRunControl;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IContainerDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.mi.service.command.CommandFactory;
import org.eclipse.cdt.dsf.mi.service.command.commands.CLICommand;
import org.eclipse.cdt.dsf.mi.service.command.output.MIBreakInsertInfo;
import org.eclipse.cdt.dsf.mi.service.command.output.MIDataEvaluateExpressionInfo;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.DebugUITools;

import com.ashling.riscfree.debug.multicore.dsf.CoreDsfServicesTracker;
import com.ashling.riscfree.debug.multicore.model.IMulticoreLaunch;
import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.preferences.DefaultPreferences;
import com.ashling.riscfree.debug.opxd.core.utils.DSFUtility;
import com.ashling.riscfree.debug.osawareness.linux.Activator;
import com.ashling.riscfree.debug.osawareness.linux.Messages;

/**
 * Utility class for dealing with launch and launch configuration.
 *
 */
public class OSAwarenessDebugUtil {

	private static final List<String> validSections = Arrays.asList(".data", ".data..read_mostly", ".rodata", ".bss",
			".text", ".text.hot", ".text.unlikely", ".init.text");
	
	private static final Map<IContainerDMContext, String> sessionToPrevLoadedProcSym = new HashMap<>();

	public static boolean isCurrentContextSuspended() {
		DsfServicesTracker tracker = createDsfServiceTracker();
		try {
			IContainerDMContext processCtx = getCurrentProcessContext();
			if (processCtx != null && tracker != null) {
				IRunControl runControl = tracker.getService(IRunControl.class);
				return runControl.isSuspended(processCtx);
			}
		} finally {
			if (tracker != null) {
				tracker.dispose();
			}
		}
		return false;
	}

	private static IContainerDMContext getCurrentProcessContext() {
		IAdaptable currentDebugContext = DebugUITools.getDebugContext();
		if (currentDebugContext != null) {
			return DMContexts
					.getAncestorOfType(currentDebugContext.getAdapter(IDMContext.class), IContainerDMContext.class);
		}
		return null;
	}
	
	public static boolean isLinuxDebugging() {
		return isDebugLaunchLinuxAware(getLaunchConfiguration(Optional.empty()));
	}

	public static ILaunchConfiguration getLaunchConfiguration(Optional<IAdaptable> currentDebugContext) {
		ILaunchConfiguration launchConfiguration = null;
		ILaunch activeLaunch = getActiveLaunch();
		if (activeLaunch instanceof GdbLaunch) {
			launchConfiguration = activeLaunch.getLaunchConfiguration();
		}
		return launchConfiguration;
	}

	public static boolean isDebugLaunchLinuxAware(ILaunchConfiguration launchConfiguration) {
		boolean isRtosDebugging = false;
		String osName = "";
		if (launchConfiguration != null) {
			try {
				isRtosDebugging = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_DEBUG,
						DefaultPreferences.OS_AWARENESS_RTOS_DEBUGGING);
				osName = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_TYPE, "");
			} catch (CoreException e) {
				Activator.log(e);
			}
			if (isRtosDebugging && osName.equalsIgnoreCase("linux")) {
				return true;
			}
		}
		return false;
	}

	public static ILaunch getActiveLaunch() {
		IAdaptable currentDebugContext = DebugUITools.getDebugContext();
		if (currentDebugContext == null) {
			return null;
		}

		ILaunch launch = null;
		if (currentDebugContext instanceof IDebugElement) {
			launch = ((IDebugElement) currentDebugContext).getLaunch();
		} else if (currentDebugContext instanceof ILaunch) {
			IDebugTarget debugTarget = ((ILaunch) currentDebugContext).getDebugTarget();
			if (debugTarget != null) {
				launch = debugTarget.getLaunch();
			}
		} else {
			launch = currentDebugContext.getAdapter(ILaunch.class);
		}
		return launch;
	}

	/**
	 * The consumers of this method are responsible for disposing the tracker after
	 * use.
	 * 
	 * @return tracker
	 */
	public static DsfServicesTracker createDsfServiceTracker() {
		DsfServicesTracker tracker = null;
		IAdaptable currentDebugContext = DebugUITools.getDebugContext();
		ILaunch launch = currentDebugContext.getAdapter(ILaunch.class);
		ICommandControlDMContext commandContext = DMContexts
				.getAncestorOfType(currentDebugContext.getAdapter(IDMContext.class), ICommandControlDMContext.class);
		if (commandContext != null) {
			if (launch instanceof IMulticoreLaunch) {
				// We've to track core specific service since it's a multicore launch
				// commandContext.getCommandControlId() will give core id
				tracker = new CoreDsfServicesTracker(Activator.getDefault().getBundle().getBundleContext(),
						commandContext.getSessionId(), commandContext.getCommandControlId());
			} else {
				tracker = new DsfServicesTracker(Activator.getDefault().getBundle().getBundleContext(),
						commandContext.getSessionId());
			}
		}
		return tracker;

	}

	public static void addSymSections(final IGDBControl gdbControl, String symbolFile, String address,
			DataRequestMonitor<MIInfo> requestMonitor) throws Exception {
		final CommandFactory fCommandFactory = gdbControl.getCommandFactory();
		final DsfExecutor fExecutor = gdbControl.getExecutor();
		List<String> sectionNamesAndAddr = new CopyOnWriteArrayList<>();
//		String textAddr = ""; // for Linux 2.6
		Query<MIDataEvaluateExpressionInfo> evalExpQuery = new Query<MIDataEvaluateExpressionInfo>() {
			protected void execute(DataRequestMonitor<MIDataEvaluateExpressionInfo> rm) {
				final String sectionsExp = "(*(*(struct module *)" + address + ")->sect_attrs)->nsections"; //$NON-NLS-1$
				gdbControl.queueCommand(
						fCommandFactory.createMIDataEvaluateExpression(gdbControl.getContext(), sectionsExp), rm);
			}
		};
		fExecutor.execute(evalExpQuery);
		final MIDataEvaluateExpressionInfo outputdata = evalExpQuery.get();
		int noOfSecs = Integer.parseInt(outputdata.getValue());
		for (int i = 1; i <= noOfSecs; i++) {
			int secInd = i;
			Query<MIDataEvaluateExpressionInfo> secNameEvalQuery = new Query<MIDataEvaluateExpressionInfo>() {
				protected void execute(DataRequestMonitor<MIDataEvaluateExpressionInfo> rm) {
					final String secNameExp = "(*(*(struct module *)"+ address +")->sect_attrs)->attrs[" + secInd + "]->name"; //$NON-NLS-1$
					gdbControl.queueCommand(
							fCommandFactory.createMIDataEvaluateExpression(gdbControl.getContext(), secNameExp), rm);
				}
			};
			fExecutor.execute(secNameEvalQuery);
			final MIDataEvaluateExpressionInfo secNamedata = secNameEvalQuery.get();
			String secName = secNamedata.getValue();
			final String[] secNameSplitted = secName.split("\"");
			Optional<String> secValidName = Optional.empty();
			if (secNameSplitted.length >= 2) {
				secValidName = Optional.ofNullable(secNameSplitted[1].trim());
			}
			if (secValidName.isPresent()) {
				if (!validSections.contains(secValidName.get())) {
					continue;
				}
				Query<MIDataEvaluateExpressionInfo> secAddrEvalQuery = new Query<MIDataEvaluateExpressionInfo>() {
					protected void execute(DataRequestMonitor<MIDataEvaluateExpressionInfo> rm) {
						final String secNameExp = "(*(*(struct module *)"+ address +")->sect_attrs)->attrs[" + secInd //$NON-NLS-1$
								+ "]->address";
						gdbControl.queueCommand(
								fCommandFactory.createMIDataEvaluateExpression(gdbControl.getContext(), secNameExp),
								rm);
					}
				};
				fExecutor.execute(secAddrEvalQuery);
				final MIDataEvaluateExpressionInfo secAddrdata = secAddrEvalQuery.get();
				String secAddr = "0x" + new BigInteger(secAddrdata.getValue()).toString(16);
//				if(secValidName.get().equals(".text")) { //For Linux 2.6
//					textAddr = secAddr;
//					continue;
//				}
				sectionNamesAndAddr.add(secValidName.get() + " " + secAddr);
			}
		}
		String otherSecDet = "";
		if (!sectionNamesAndAddr.isEmpty()) {
			otherSecDet += " -s " + String.join(" -s ", sectionNamesAndAddr.toArray(new String[0])); // Linux 5.4
//			otherSecDet += textAddr + " -s " + String.join(" -s ", sectionNamesAndAddr.toArray(new String[0])); // Linux 2.6
		}
		gdbControl.queueCommand(new CLICommand<MIInfo>(gdbControl.getContext(),
				"add-symbol-file" + " " + symbolFile + " " + otherSecDet), requestMonitor);
	}

	public static void addProcessSymFile(IGDBControl gdbControl, String processNameFullPath) throws Exception {
		IContainerDMContext processCtx = getCurrentProcessContext();
		if (processCtx != null) {
			Query<MIInfo> addSymQuery = new Query<MIInfo>() {
				protected void execute(DataRequestMonitor<MIInfo> rm) {
					String execPath = new Path(processNameFullPath).toPortableString();
					sessionToPrevLoadedProcSym.put(processCtx, processNameFullPath);
					gdbControl.queueCommand(new CLICommand<MIInfo>(gdbControl.getContext(), "add-symbol-file " + execPath),
							rm);
				}
			};
			String prevSymFile = sessionToPrevLoadedProcSym.get(processCtx);
			if (prevSymFile != null) {
				DataRequestMonitor<MIInfo> removeSymInfo = new DataRequestMonitor<MIInfo>(gdbControl.getExecutor(), null) {
					@Override
					protected void handleCompleted() {
						gdbControl.getExecutor().execute(addSymQuery);
						super.handleCompleted();
					}
				};
				gdbControl.queueCommand(
						new CLICommand<MIInfo>(gdbControl.getContext(), "remove-symbol-file " + prevSymFile),
						removeSymInfo);
			} else {
				gdbControl.getExecutor().execute(addSymQuery);
			}
			addSymQuery.get();
		}
	}

	public static void setSharedLibraryPath(IGDBControl gdbControl, File rootFileSystemPath,
			List<String> sharedLibraryPath) throws Exception {
		try {
			final CommandFactory fCommandFactory = gdbControl.getCommandFactory();
			final DsfExecutor fExecutor = gdbControl.getExecutor();
			if ((null != rootFileSystemPath) && !rootFileSystemPath.toString().isEmpty()) {
				final String rootFileSys = "solib-absolute-prefix"; //$NON-NLS-1$
				String rootFSSysPath = rootFileSystemPath.toString();
				rootFSSysPath = rootFSSysPath.replace('\\', '/');
				final String[] miSetCmdParms = { rootFileSys, rootFSSysPath };
				final DataRequestMonitor<MIInfo> miInfo = new DataRequestMonitor<MIInfo>(fExecutor, null);
				gdbControl.queueCommand(fCommandFactory.createMIGDBSet(gdbControl.getContext(), miSetCmdParms), miInfo);
			}
			if (!sharedLibraryPath.isEmpty()) {
				final String pathArray[] = sharedLibraryPath.toArray(new String[sharedLibraryPath.size()]);
				final DataRequestMonitor<MIInfo> miInfo = new DataRequestMonitor<MIInfo>(fExecutor, null);
				gdbControl.queueCommand(
						fCommandFactory.createMIGDBSetSolibSearchPath(gdbControl.getContext(), pathArray), miInfo);
			}
		} catch (final Exception exp) {
			throw new Exception("Error occurred while initializing GDB for library debugging");
		}
	}

	/**
	 * This function will do some preconditions checks and run the passed action.
	 * 
	 */
	public static void performLinuxAction(Runnable action) {
		if (OSAwarenessDebugUtil.isLinuxDebugging()) {
			if (OSAwarenessDebugUtil.isCurrentContextSuspended()) {
				action.run();
			} else {
				DSFUtility.INSTANCE.openWarning(Messages.Debug_context_not_suspended,
						Messages.Selected_debug_context_not_suspended, null);
			}
		} else {
			DSFUtility.INSTANCE.openWarning(Messages.No_active_linux_aware_debugging,
					Messages.Selected_context_not_part_of_linux_aware_debugging, null);
		}
	}

	public static void insertBreakAndContinue(BreakAndContinueToken breakAndContinueToken) {
		final IBreakpointsTargetDMContext breakContext = DMContexts
				.getAncestorOfType(breakAndContinueToken.getProcessContext(), IBreakpointsTargetDMContext.class);
		Optional<String> breakSymbol = breakAndContinueToken.getBreakLocation();
		if (breakContext != null && breakSymbol.isPresent()) {
			// use this for linux 5.4
			final DataRequestMonitor<MIBreakInsertInfo> breakinfo = new DataRequestMonitor<MIBreakInsertInfo>(
					breakAndContinueToken.getGdbControl().getExecutor(), null) {
				@Override
				protected void handleCompleted() {
					if (isSuccess()) {
						final DataRequestMonitor<MIInfo> execContInfo = new DataRequestMonitor<MIInfo>(
								breakAndContinueToken.getGdbControl().getExecutor(), null) {
							@Override
							protected void handleCompleted() {
								if (isSuccess()) {
									breakAndContinueToken.getTargetHaltListener().startListening();
									breakAndContinueToken.getWaitingMonitorTaskText().ifPresent(txt -> {
										breakAndContinueToken.getMonitor().beginTask(txt, IProgressMonitor.UNKNOWN);
									});
								} else {
									breakAndContinueToken.getTargetHaltListener()
											.reportError(Messages.Target_continue_command_failed);
								}
								super.handleCompleted();
							}
						};
						breakAndContinueToken.getGdbControl().queueCommand(breakAndContinueToken.getGdbControl()
								.getCommandFactory().createMIExecContinue(breakAndContinueToken.getProcessContext()),
								execContInfo);
					} else {
						breakAndContinueToken.getTargetHaltListener()
								.reportError(MessageFormat.format(Messages.Setting_breakpoint_at_location_failed,
										breakAndContinueToken.getBreakLocation()));
					}
					super.handleCompleted();
				}
			};
			breakAndContinueToken.getGdbControl().queueCommand(breakAndContinueToken.getGdbControl().getCommandFactory()
					.createMIBreakInsert(breakContext, true, false, null, 0, breakSymbol.get(), "0"), breakinfo);
		} else {
			throw new IllegalStateException("Cannot obtain a breakpoint context");
		}
	}
}
