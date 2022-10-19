package com.ashling.riscfree.debug.osawareness.linux.ui.commands;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.cdt.debug.ui.CDebugUIPlugin;
import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.DsfExecutor;
import org.eclipse.cdt.dsf.concurrent.Query;
import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.datamodel.IDMEvent;
import org.eclipse.cdt.dsf.debug.service.IBreakpointsExtension.IBreakpointHitDMEvent;
import org.eclipse.cdt.dsf.gdb.service.command.IGDBControl;
import org.eclipse.cdt.dsf.mi.service.IMIContainerDMContext;
import org.eclipse.cdt.dsf.mi.service.command.CommandFactory;
import org.eclipse.cdt.dsf.mi.service.command.events.MIBreakpointHitEvent;
import org.eclipse.cdt.dsf.mi.service.command.events.MIErrorEvent;
import org.eclipse.cdt.dsf.mi.service.command.output.MIDataEvaluateExpressionInfo;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;

import com.ashling.riscfree.debug.opxd.core.utils.DSFUtility;
import com.ashling.riscfree.debug.osawareness.linux.Activator;
import com.ashling.riscfree.debug.osawareness.linux.Messages;
import com.ashling.riscfree.debug.osawareness.linux.ui.LoadProcessSymbolDlg;
import com.ashling.riscfree.debug.osawareness.linux.util.BreakAndContinueToken;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;
import com.ashling.riscfree.debug.osawareness.linux.util.TargetHaltListener;

/**
 * Default handler for Debug A Process From Main command.
 *
 */
public class DebugProcessFromMainHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		OSAwarenessDebugUtil.performLinuxAction(this::performDebugProcessFromMain);
		return null;
	}

	private void performDebugProcessFromMain() {
		DsfServicesTracker tracker = OSAwarenessDebugUtil.createDsfServiceTracker();
		LoadProcessSymbolDlg dlg = LoadProcessSymbolDlg.getDefault(CDebugUIPlugin.getActiveWorkbenchShell());
		if (tracker != null && dlg.open() == Window.OK) {
			if(!MessageDialog.openConfirm(CDebugUIPlugin.getActiveWorkbenchShell(), Messages.Run_the_process,
					Messages.Press_ok_and_run_process_from_console)) {
				// If user has cancelled or closed this, 
				// which means user doesn't want to continue this operation
				return;
			}
			final IGDBControl gdbControl = tracker.getService(IGDBControl.class);
			IAdaptable currentDebugContext = DebugUITools.getDebugContext();
			if (gdbControl == null && currentDebugContext == null) {
				DSFUtility.INSTANCE.openError(Messages.Error, Messages.Couldnt_obtain_valid_debug_context, null);
				return;
			}
			IMIContainerDMContext processContext = DMContexts
					.getAncestorOfType(currentDebugContext.getAdapter(IDMContext.class), IMIContainerDMContext.class);
			if (processContext == null) {
				DSFUtility.INSTANCE.openError(Messages.Error, Messages.Couldnt_obtain_valid_debug_context, null);
				return;
			}
			final Job dbgProcjob = fetchDebugProcessJob(tracker, dlg, gdbControl, processContext);
			dbgProcjob.schedule();
		}
	}

	private Job fetchDebugProcessJob(DsfServicesTracker tracker, LoadProcessSymbolDlg dlg, final IGDBControl gdbControl,
			IMIContainerDMContext processContext) {
		return new Job(Messages.Debug_process_from_main_with_dots) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					final File processNameWithPath = dlg.getProcessFile();
					final File rootFileSystemPath = dlg.getRootFile();
					final ArrayList<String> sharedLibraryPath = dlg.getSharedLibSearchList();
					Status errorStatus = waitTillProcessStarted(gdbControl, processContext, monitor,
							processNameWithPath);
					if (errorStatus != null) {
						return errorStatus;
					}
					final String absPath = processNameWithPath.getAbsolutePath().replace('\\', '/');
					OSAwarenessDebugUtil.addProcessSymFile(gdbControl, absPath);
					TargetHaltListener targetHaltListener = new TargetHaltListener(gdbControl.getSession(),
							processContext);
					OSAwarenessDebugUtil.insertBreakAndContinue(new BreakAndContinueToken("main", monitor, gdbControl,
							processContext, targetHaltListener, Messages.Running_to_main_with_dots));
					errorStatus = waitForTargetHalt(monitor, targetHaltListener);
					if (errorStatus != null) {
						return errorStatus;
					}
					IDMEvent stoppedEvent = targetHaltListener.getStopEvent();
					monitor.done();
					processStoppedEvent(gdbControl, monitor, rootFileSystemPath, sharedLibraryPath, stoppedEvent);
				} catch (Exception e) {
					Activator.log(e);
					monitor.done();
					if (e.getMessage() != null) {
						DSFUtility.INSTANCE.openError(Messages.Error, e.getMessage(), null);
					}
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "");
				} finally {
					if (tracker != null) {
						tracker.dispose();
					}
				}
				return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
			}
		};
	}

	private void processStoppedEvent(final IGDBControl gdbControl, IProgressMonitor monitor,
			final File rootFileSystemPath, final ArrayList<String> sharedLibraryPath, IDMEvent stoppedEvent)
			throws Exception {
		if (stoppedEvent instanceof IBreakpointHitDMEvent || stoppedEvent instanceof MIBreakpointHitEvent
				&& (rootFileSystemPath != null || !sharedLibraryPath.isEmpty())) {
			monitor.beginTask(Messages.Setting_shared_library_path_with_dots, IProgressMonitor.UNKNOWN);
			OSAwarenessDebugUtil.setSharedLibraryPath(gdbControl, rootFileSystemPath, sharedLibraryPath);
			monitor.done();
		} else {
			if(stoppedEvent instanceof MIErrorEvent) {
				DSFUtility.INSTANCE.openError(Messages.Error, Messages.Target_continue_failed_with_error_message + " "
						+ ((MIErrorEvent) stoppedEvent).getMessage(), null);
			}
		}
		monitor.done();
	}
	
	/**
	 * This method will wait inside a loop until we get a manual suspend operation
	 * or the correct process is started. An error status is returned when we
	 * complete this method, without having the process inserted.
	 * 
	 * @param gdbControl
	 * @param processContext
	 * @param monitor
	 * @param processNameWithPath
	 * @return
	 * @throws InterruptedException
	 * @throws Exception
	 */
	private Status waitTillProcessStarted(final IGDBControl gdbControl, IMIContainerDMContext processContext,
			IProgressMonitor monitor, final File processNameWithPath) throws InterruptedException, Exception {
		boolean dbgProcessStarted = false;
		while (true) {
			TargetHaltListener targetHaltListener = new TargetHaltListener(gdbControl.getSession(), processContext);
			OSAwarenessDebugUtil.insertBreakAndContinue(new BreakAndContinueToken("set_binfmt", monitor, gdbControl,
					processContext, targetHaltListener, Messages.Waiting_for_process_execution_from_console_with_dots));
			Status errorStatus = waitForTargetHalt(monitor, targetHaltListener);
			if (errorStatus != null) {
				return errorStatus;
			}
			IDMEvent stoppedEvent = targetHaltListener.getStopEvent();
			monitor.done();
			if (stoppedEvent instanceof IBreakpointHitDMEvent || stoppedEvent instanceof MIBreakpointHitEvent) {
				String curTaskName = getCurrentTaskName(gdbControl);
				if (processNameWithPath.getName().toString().contains(curTaskName)) {
					dbgProcessStarted = true;
					break;
				}
			} else {
				// This could be a manual suspend.
				// TODO: Delete the temporary breakpoint set
				// as it is no more required.
				if (stoppedEvent instanceof MIErrorEvent) {
					DSFUtility.INSTANCE.openError(Messages.Error, Messages.Target_continue_failed_with_error_message + " "
							+ ((MIErrorEvent) stoppedEvent).getMessage(), null);
				}
				break;
			}
		}
		if (!dbgProcessStarted) {
			// may be some manual suspend or something happened.
			return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
		}
		return null;
	}

	/**
	 * Wait for the target to halt and return error status if any. If successful
	 * return null status.
	 * 
	 * @param monitor
	 * @param targetHaltListener
	 * @return
	 * @throws InterruptedException
	 */
	private Status waitForTargetHalt(IProgressMonitor monitor, TargetHaltListener targetHaltListener)
			throws InterruptedException {
		boolean targetHalted = targetHaltListener.waitForTargetToHalt(monitor);
		if (!targetHalted) {
			monitor.done();
			// The target halt failed, it should be either of the below cases.
			if (monitor.isCanceled()) {
				return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "");
			} else {
				if (targetHaltListener.getErrorMessage() != null) {
					DSFUtility.INSTANCE.openError(Messages.Error, targetHaltListener.getErrorMessage(), null);
				}
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "");
			}
		}
		return null;
	}

	public String getCurrentTaskName(IGDBControl igdbControl) throws Exception {
		final String procNameExp = "((struct task_struct*)((struct thread_info*)$tp))->comm"; //$NON-NLS-1$
		return evaluateExpression(igdbControl, procNameExp);
	}

	private String evaluateExpression(IGDBControl gdbControl, String expression) throws Exception {
		final CommandFactory fCommandFactory = gdbControl.getCommandFactory();
		final DsfExecutor fExecutor = gdbControl.getExecutor();
		Query<MIDataEvaluateExpressionInfo> evalExpQuery = new Query<MIDataEvaluateExpressionInfo>() {
			protected void execute(DataRequestMonitor<MIDataEvaluateExpressionInfo> rm) {
				gdbControl.queueCommand(
						fCommandFactory.createMIDataEvaluateExpression(gdbControl.getContext(), expression), rm);
			}
		};
		fExecutor.execute(evalExpQuery);
		final MIDataEvaluateExpressionInfo outputdata = evalExpQuery.get();
		String exprValue = outputdata.getValue();
		String[] valueArray = exprValue.split("\\\\");
		valueArray = valueArray[0].split("\"");
		int index = 0;
		if (valueArray.length > 1) {
			index = 1;
		}
		exprValue = valueArray[index].trim();
		return exprValue;
	}
}
