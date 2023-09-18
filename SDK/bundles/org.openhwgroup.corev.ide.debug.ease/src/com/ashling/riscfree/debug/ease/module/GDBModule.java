/**
 * 
 */
package com.ashling.riscfree.debug.ease.module;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.IDsfStatusConstants;
import org.eclipse.cdt.dsf.concurrent.Query;
import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.IExpressions;
import org.eclipse.cdt.dsf.debug.service.IExpressions.IExpressionDMContext;
import org.eclipse.cdt.dsf.debug.service.IFormattedValues;
import org.eclipse.cdt.dsf.debug.service.IFormattedValues.FormattedValueDMContext;
import org.eclipse.cdt.dsf.debug.service.IFormattedValues.FormattedValueDMData;
import org.eclipse.cdt.dsf.debug.service.IMemory;
import org.eclipse.cdt.dsf.debug.service.IMemory.IMemoryDMContext;
import org.eclipse.cdt.dsf.debug.service.IRunControl.IExecutionDMContext;
import org.eclipse.cdt.dsf.debug.service.IStack.IFrameDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommand;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.cdt.dsf.mi.service.MIExpressions;
import org.eclipse.cdt.dsf.mi.service.command.commands.CLICommand;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.cdt.utils.Addr64;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.ease.modules.AbstractScriptModule;
import org.eclipse.ease.modules.WrapToScript;

import com.ashling.riscfree.debug.ease.Activator;
import com.ashling.riscfree.debug.multicore.model.IMulticoreLaunch;

/**
 * @author vinod.appu
 * 
 *         Methods providing GDB access while debugging
 * @param <MiMemory>
 *
 */
public class GDBModule extends AbstractScriptModule {

	/** Module identifier. */
	public static final String MODULE_ID = "GDB Debugging";

	/**
	 * Evaluate given expression and return the result as string
	 * 
	 * @param expression The GDB expression to be evaluated
	 * @param format     The data format, values can be x -> Hex, d -> Decimal,
	 *                   t->binary, s-> String, o->octal
	 * @return
	 */
	@WrapToScript
	public String evaluateExpressionWithFormat(final String expression, final String format) {

		IDMContext dmcontext = getDMContext();
		if (dmcontext == null) {
			return null;
		}
		DsfSession debugSession = DsfSession.getSession(dmcontext.getSessionId());
		DsfServicesTracker dsfServicesTracker = new DsfServicesTracker(
				Activator.getDefault().getBundle().getBundleContext(), debugSession.getId());
		try {
			GetExpressionValueQuery query = new GetExpressionValueQuery(dmcontext, expression, dsfServicesTracker,
					format);
			if (debugSession != null) {
				debugSession.getExecutor().execute(query);
				try {
					FormattedValueDMData data = query.get(60L, TimeUnit.SECONDS);
					if (data != null)
						return data.getFormattedValue();
				} catch (Exception e) {
					Activator.logErrorMessage(MODULE_ID + " Module got an exception while evaluating expression");
					Activator.log(e);
				}
			}
		} finally {
			dsfServicesTracker.dispose();
		}
		return null;

	}

	@WrapToScript
	public String evaluateExpression(final String expression) {
		return evaluateExpressionWithFormat(expression, null);
	}

	/**
	 * Execute given gdb command in and return the result
	 * 
	 * @param command GDB command to be executed
	 * @return GDB reply for the given command
	 * @throws InterruptedException, ExecutionException, TimeoutException 
	 */
	@WrapToScript
	public String executeGDBCommand(String command) throws InterruptedException, ExecutionException, TimeoutException {
		DsfSession session = getActiveDSFSession();
		if (session == null) {
			return "";
		}
		DsfServicesTracker dsfServicesTracker = new DsfServicesTracker(
				Activator.getDefault().getBundle().getBundleContext(), session.getId());
		GetCLIQuery cliQuery = new GetCLIQuery(command, dsfServicesTracker, getDMContext());
		session.getExecutor().execute(cliQuery);
		try {
			// TODO : We need to find a way to do lazy loading or so 
			// rather than waiting here for 1 hour. Created a gitLab#950 
			MIInfo miInfo = cliQuery.get(1, TimeUnit.HOURS);
			return miInfo.toString();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			dsfServicesTracker.dispose();
			Activator.logErrorMessage(MODULE_ID + " Module got an exception while executing gdb command");
			Activator.log(e);
			cliQuery.cancel(true);
			throw e;
		}
	}

	/**
	 * @author Shreshth.Kaushik Evaluate memory block from fStartAddress up to count
	 * 
	 * @param startAddress starting address
	 * @param count        Number of bytes to read
	 * @return memory data as byte array
	 */
	@WrapToScript
	public byte[] getMemory(long startAddress, int count) {
		IDMContext dmcontext = getDMContext();
		if (dmcontext == null) {
			return null;
		}
		DsfSession debugSession = DsfSession.getSession(dmcontext.getSessionId());
		DsfServicesTracker dsfServicesTracker = new DsfServicesTracker(
				Activator.getDefault().getBundle().getBundleContext(), debugSession.getId());
		GetMemoryQuery query = new GetMemoryQuery(dmcontext, dsfServicesTracker, startAddress, count);
		if (debugSession != null) {
			debugSession.getExecutor().execute(query);
			try {
				MemoryByte[] data = query.get(60L, TimeUnit.SECONDS);
				if (data != null) {
					byte[] byteValues = new byte[count];
					for (int byteIndex = 0; byteIndex < data.length; byteIndex++) {
						byteValues[byteIndex] = data[byteIndex].getValue();
					}
					return byteValues;
				}
			} catch (Exception e) {
				Activator.logErrorMessage(MODULE_ID + " Module got an exception while fetching memory");
				Activator.log(e);
			} finally {
				dsfServicesTracker.dispose();
			}
		}
		return null;
	}

	class GetMemoryQuery extends Query<MemoryByte[]> {
		private final Addr64 startAddress;
		private final IDMContext dmcontext;
		private DsfServicesTracker dsfServicesTracker;
		private int offset;

		GetMemoryQuery(IDMContext dmcontext, DsfServicesTracker dsfServicesTracker, long address, int count) {
			this.dmcontext = dmcontext;
			this.dsfServicesTracker = dsfServicesTracker;
			this.startAddress = new Addr64(address);
			this.offset = count;
		}

		@Override
		protected void execute(DataRequestMonitor<MemoryByte[]> rm) {
			DsfSession session = DsfSession.getSession(dmcontext.getSessionId());
			IMemory memory = dsfServicesTracker.getService(IMemory.class);
			IMemoryDMContext memoryDmc = null;
			memoryDmc = DMContexts.getAncestorOfType(dmcontext, IMemoryDMContext.class);
			memory.getMemory(memoryDmc, startAddress, 0, 1, offset,
					new DataRequestMonitor<MemoryByte[]>(session.getExecutor(), rm) {
						@Override
						protected void handleSuccess() {
							rm.setData(getData());
							rm.done();
						}
					});
		}

	}

	private class GetExpressionValueQuery extends Query<FormattedValueDMData> {
		private final IDMContext dmContext;
		private final String expression;
		private DsfServicesTracker dsfServicesTracker;
		private String format;

		public GetExpressionValueQuery(IDMContext dmContext, String expression, DsfServicesTracker dsfServicesTracker,
				String format) {
			this.dmContext = dmContext;
			this.expression = expression;
			this.dsfServicesTracker = dsfServicesTracker;
			this.format = format;
		}

		/**
		 * Returns the type of format that should be used for the hover.
		 */
		protected String getFormat() {
			if (this.format != null) {

				if (this.format.equalsIgnoreCase("x")) {
					return IFormattedValues.HEX_FORMAT;
				} else if (this.format.equalsIgnoreCase("d")) {
					return IFormattedValues.DECIMAL_FORMAT;
				} else if (this.format.equalsIgnoreCase("t")) {
					return IFormattedValues.BINARY_FORMAT;
				} else if (this.format.equalsIgnoreCase("o")) {
					return IFormattedValues.OCTAL_FORMAT;
				} else if (this.format.equalsIgnoreCase("s")) {
					return IFormattedValues.STRING_FORMAT;
				}
			}
			return MIExpressions.DETAILS_FORMAT;

		}

		@Override
		protected void execute(final DataRequestMonitor<FormattedValueDMData> rm) {
			DsfSession session = DsfSession.getSession(dmContext.getSessionId());
			IExpressions expressions = dsfServicesTracker.getService(IExpressions.class);
			if (expressions == null) {
				rm.setStatus(
						Activator.newErrorStatus(IDsfStatusConstants.REQUEST_FAILED, "No expression service", null)); //$NON-NLS-1$
				rm.done();
				return;
			}
			IExpressionDMContext expressionDMC = expressions.createExpression(dmContext, expression);
			FormattedValueDMContext formattedValueContext = expressions.getFormattedValueContext(expressionDMC,
					getFormat());
			expressions.getFormattedExpressionValue(formattedValueContext,
					new DataRequestMonitor<FormattedValueDMData>(session.getExecutor(), rm) {
						@Override
						protected void handleSuccess() {
							rm.setData(getData());
							rm.done();
						}

						@Override
						protected void handleFailure() {
							rm.done();
						}
					});
		}
	}

	private class GetCLIQuery extends Query<MIInfo> {
		private String str;
		private DsfServicesTracker dsfServicesTracker;
		IDMContext dmContext;

		public GetCLIQuery(String str, DsfServicesTracker dsfServicesTracker, IDMContext dmContext) {
			this.str = str;
			this.dsfServicesTracker = dsfServicesTracker;
			this.dmContext = dmContext;
		}

		@Override
		protected void execute(DataRequestMonitor<MIInfo> rm) {

			// Do not use the interpreter-exec for stepping operation the UI will fall out
			// of step.
			// Also, do not use "interpreter-exec console" for MI commands.
			ICommandControlDMContext fContext = DMContexts.getAncestorOfType(dmContext, ICommandControlDMContext.class);
			ICommand<MIInfo> cmd = new CLICommand<>(fContext, str);

			// TODO: for print command would be nice to redirect to gdb console
			ICommandControlService commandControl = dsfServicesTracker.getService(ICommandControlService.class);
			if (commandControl != null) {
				commandControl.queueCommand(cmd, rm);
			} else {
				// Should not happen, so log the situation but then ignore it
				rm.setStatus(
						new Status(IStatus.INFO, Activator.PLUGIN_ID, "Unable to find service to execute CLI command")); //$NON-NLS-1$
			}

		}

	}

	// Don't call this function from non UI thread, it may cause UI hang
	private IDMContext getDMContext() {
		IAdaptable context = DebugUITools.getDebugContext();
		if (context != null) {
			IExecutionDMContext executionDMContext = context.getAdapter(IExecutionDMContext.class);
			return executionDMContext != null ? executionDMContext : context.getAdapter(IFrameDMContext.class);
		}
		return null;
	}

	private DsfSession getActiveDSFSession() {
		IAdaptable currentDebugContext = DebugUITools.getDebugContext();
		if (currentDebugContext == null) {
			return null;
		}

		ILaunch activeLaunch = null;
		if (currentDebugContext instanceof IDebugElement) {
			activeLaunch = ((IDebugElement) currentDebugContext).getLaunch();
		} else if (currentDebugContext instanceof ILaunch) {
			IDebugTarget debugTarget = ((ILaunch) currentDebugContext).getDebugTarget();
			if (debugTarget != null) {
				activeLaunch = debugTarget.getLaunch();
			}
		} else {
			activeLaunch = currentDebugContext.getAdapter(ILaunch.class);
		}

		if (activeLaunch != null) {
			if (activeLaunch instanceof GdbLaunch) {
				return ((GdbLaunch) activeLaunch).getSession();
			}
			else if (activeLaunch instanceof IMulticoreLaunch) {
				return ((IMulticoreLaunch) activeLaunch).getSession();
			}
		}
		return null;
	}

}
