package com.ashling.riscfree.debug.osawareness.linux.ui.commands;

import java.io.File;

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
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
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
import com.ashling.riscfree.debug.osawareness.linux.ui.DebugModuleFromInitDialog;
import com.ashling.riscfree.debug.osawareness.linux.util.BreakAndContinueToken;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;
import com.ashling.riscfree.debug.osawareness.linux.util.TargetHaltListener;

/**
 * Default handler for Debug A Module From Initialization command.
 *
 */
public class DebugModuleFromInitHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		OSAwarenessDebugUtil.performLinuxAction(this::performModuleInit);
		return null;
	}

	private void performModuleInit() {
		DsfServicesTracker tracker = OSAwarenessDebugUtil.createDsfServiceTracker();
		final DebugModuleFromInitDialog dlg = DebugModuleFromInitDialog
				.getDefault(CDebugUIPlugin.getActiveWorkbenchShell());
		if (tracker != null && dlg.open() == Window.OK) {
			if(!MessageDialog.openConfirm(CDebugUIPlugin.getActiveWorkbenchShell(), Messages.Insert_the_module,
					Messages.Press_ok_and_insert_module_via_console)) {
				// If user has cancelled or closed this, 
				// which means user doesn't want to continue this operation
				return;
			}
			final File moduleName = dlg.getText();
			final IGDBControl gdbControl = tracker.getService(IGDBControl.class);
			IAdaptable currentDebugContext = DebugUITools.getDebugContext();
			if (gdbControl == null || currentDebugContext == null) {
				DSFUtility.INSTANCE.openError(Messages.Error, Messages.Couldnt_obtain_valid_debug_context, null);
				return;
			}
			IMIContainerDMContext processContext = DMContexts
					.getAncestorOfType(currentDebugContext.getAdapter(IDMContext.class), IMIContainerDMContext.class);
			if (processContext == null) {
				DSFUtility.INSTANCE.openError(Messages.Error, Messages.Couldnt_obtain_valid_debug_context, null);
				return;
			}
			final Job dbgModInitob = fetchInitJob(tracker, moduleName, gdbControl, processContext);
			dbgModInitob.schedule();
		}
	}
	
	private Job fetchInitJob(DsfServicesTracker tracker, final File moduleName, final IGDBControl gdbControl,
			IMIContainerDMContext processContext) {
		return new Job(Messages.Debug_module_from_init_with_dots) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					Status errorStatus = waitTillModuleInserted(moduleName, gdbControl, processContext, monitor);
					if(errorStatus != null) {
						return errorStatus;
					}
					TargetHaltListener targetHaltListener = new TargetHaltListener(gdbControl.getSession(),
							processContext);
					addSymbolsAndRunToInit(moduleName, new BreakAndContinueToken(null, monitor, gdbControl,
							processContext, targetHaltListener, null));
					errorStatus = waitForTargetHalt(monitor, targetHaltListener);
					if(errorStatus != null) {
						return errorStatus;
					}
					monitor.done();
				} catch (Exception e) {
					Activator.log(e);
					monitor.done();
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
	
	/**
	 * This method will wait inside a loop until we get a manual suspend operation or the correct module is inserted.
	 * An error status is returned when we complete this method, without having the module inserted.
	 * 
	 * @param moduleName
	 * @param gdbControl
	 * @param processContext
	 * @param monitor
	 * @return
	 * @throws Exception
	 */
	private Status waitTillModuleInserted(final File moduleName, final IGDBControl gdbControl,
			IMIContainerDMContext processContext, IProgressMonitor monitor)
			throws Exception {
		boolean dbgModInserted = false;
		String curModule = ""; 
		while (!dbgModInserted) {
			TargetHaltListener targetHaltListener = new TargetHaltListener(gdbControl.getSession(),
					processContext);
			OSAwarenessDebugUtil.insertBreakAndContinue(
					new BreakAndContinueToken("do_init_module", monitor, gdbControl, processContext,
							targetHaltListener, Messages.Wait_for_module_insertion_from_console_with_dots));
			Status errorStatus = waitForTargetHalt(monitor, targetHaltListener);
			if(errorStatus != null) {
				return errorStatus;
			}
			IDMEvent stoppedEvent = targetHaltListener.getStopEvent();
			monitor.done();
			if (!(stoppedEvent instanceof IBreakpointHitDMEvent
					|| stoppedEvent instanceof MIBreakpointHitEvent)) {
				// if this is not a breakpoint hit
				// This could be a manual suspend or some error event
				// TODO: Delete the temporary breakpoint set
				// as it is no more required.
				if (stoppedEvent instanceof MIErrorEvent) {
					DSFUtility.INSTANCE.openError(Messages.Error,
							Messages.Target_continue_failed_with_error_message + " "
									+ ((MIErrorEvent) stoppedEvent).getMessage(),
							null);
				}
				break;
			}
			curModule = getCurrentModuleName(gdbControl);
			if (moduleName.getName().contains(curModule)) {
				dbgModInserted = true;
			}
		}
		if (!dbgModInserted) {
			// may be some manual suspend or something happened.
			return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
		}
		return null;
	}
	
	/**
	 * Wait for the target to halt and return error status if any. If successful return null status.
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
					DSFUtility.INSTANCE.openError(Messages.Error, targetHaltListener.getErrorMessage(),
							null);
				}
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "");
			}
		}
		return null;
	}
	
	private void addSymbolsAndRunToInit(final File moduleName, BreakAndContinueToken breakAndContinueToken)
			throws Exception {
		String modname = moduleName.getPath();
		modname = modname.replace('\\', '/');
		// Add symbol sections and address to gdb
		breakAndContinueToken.getMonitor().beginTask(Messages.Adding_symbol_info_of_module_with_dots,
				IProgressMonitor.UNKNOWN);
		final DataRequestMonitor<MIInfo> execInfo = new DataRequestMonitor<MIInfo>(
				breakAndContinueToken.getGdbControl().getExecutor(), null) {
			@Override
			protected void handleCompleted() {
				if (isSuccess()) {
					breakAndContinueToken.getMonitor().done();
					runToInit(breakAndContinueToken);
				} else {
					breakAndContinueToken.getTargetHaltListener().reportError(Messages.Adding_symbol_sections_failed);
				}
				super.handleCompleted();
			}
		};
		OSAwarenessDebugUtil.addSymSections(breakAndContinueToken.getGdbControl(), modname, "mod", execInfo);
	}

	private void runToInit(BreakAndContinueToken breakAndContinueToken) {
		final DataRequestMonitor<MIDataEvaluateExpressionInfo> initAddrExpRm = new DataRequestMonitor<MIDataEvaluateExpressionInfo>(
				breakAndContinueToken.getGdbControl().getExecutor(), null) {
			@Override
			protected void handleCompleted() {
				if (isSuccess()) {
					breakAndContinueToken.getTargetHaltListener().startListening();
					MIDataEvaluateExpressionInfo expOut = getData();
					if (expOut != null) {
						String initAddr = "*" + expOut.getValue().split(" ")[0];
						breakAndContinueToken.setBreakLocation(initAddr);
						breakAndContinueToken.setWaitingMonitorTaskText(Messages.Run_to_init_with_dots);
						OSAwarenessDebugUtil.insertBreakAndContinue(breakAndContinueToken);
					}
				} else {
					breakAndContinueToken.getTargetHaltListener().reportError(Messages.Eval_of_init_addr_failed);
				}
				super.handleCompleted();
			}
		};
		final String initAddrExp = "((struct module *)mod)->init"; //$NON-NLS-1$
		breakAndContinueToken.getGdbControl().queueCommand(breakAndContinueToken.getGdbControl().getCommandFactory()
				.createMIDataEvaluateExpression(breakAndContinueToken.getGdbControl().getContext(), initAddrExp),
				initAddrExpRm);
	}

	public String getCurrentModuleName(IGDBControl gdbControl) throws Exception {
		final CommandFactory fCommandFactory = gdbControl.getCommandFactory();
		final DsfExecutor fExecutor = gdbControl.getExecutor();
		Query<MIDataEvaluateExpressionInfo> evalExpQuery = new Query<MIDataEvaluateExpressionInfo>() {
			protected void execute(DataRequestMonitor<MIDataEvaluateExpressionInfo> rm) {
				final String moduleName = "((struct module*)mod)->name"; //$NON-NLS-1$
				gdbControl.queueCommand(
						fCommandFactory.createMIDataEvaluateExpression(gdbControl.getContext(), moduleName), rm);
			}
		};
		fExecutor.execute(evalExpQuery);
		final MIDataEvaluateExpressionInfo outputdata = evalExpQuery.get();
		String curModName = outputdata.getValue();
		final String[] modulename = curModName.split("\"");
		curModName = modulename[1].trim();
		return curModName;
	}
}
