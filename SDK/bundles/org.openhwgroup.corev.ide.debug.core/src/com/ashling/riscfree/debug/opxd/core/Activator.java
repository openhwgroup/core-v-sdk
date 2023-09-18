package com.ashling.riscfree.debug.opxd.core;

import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.internal.ui.DebugUIMessages;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.progress.IProgressConstants2;
import org.osgi.framework.BundleContext;

import com.ashling.riscfree.debug.opxd.core.preferences.DefaultPreferences;
import com.ashling.riscfree.debug.opxd.core.preferences.PersistentPreferences;

public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.ashling.riscfree.debug.opxd.core"; //$NON-NLS-1$

	/**
	 * Status code indicating an unexpected internal error.
	 */
	private static final int INTERNAL_ERROR = 150;

	// The shared instance
	private static Activator plugin;

	// the preference
	private static PersistentPreferences fPersistentPreferences;

	private static DefaultPreferences fDefaultPreferences;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		processArguments();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		/*
		 * TODO: Need to check do we need the next line. Commenting it to solve null
		 * pointer exception while shutdown sequence.
		 */

		// plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Logs the specified status with this plug-in's log.
	 *
	 * @param status status to log
	 */
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}
	
	/**
	 * Logs the specified message with this plug-in's log.
	 *
	 * @param status status to log
	 */
	public static void logInfo(String message) {   	
    	final IStatus status=new Status(IStatus.INFO,Activator.PLUGIN_ID,message);
		log(status);
    }

	/**
	 * Logs an internal error with the specified throwable
	 *
	 * @param e the exception to be logged
	 */
	public static void log(Throwable e) {
		log(new Status(IStatus.ERROR, getUniqueIdentifier(), INTERNAL_ERROR, "Internal Error", e)); //$NON-NLS-1$
	}

	public static String getUniqueIdentifier() {
		return PLUGIN_ID;
	}

	/**
	 * Logs an internal error with the specified message.
	 *
	 * @param message the error message to log
	 */
	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getUniqueIdentifier(), INTERNAL_ERROR, message, null));
	}

	public static BundleContext getBundleContext() {
		return getDefault().getBundle().getBundleContext();
	}

	public PersistentPreferences getPersistentPreferences() {

		if (fPersistentPreferences == null) {
			fPersistentPreferences = new PersistentPreferences(PLUGIN_ID);
		}
		return fPersistentPreferences;
	}

	public DefaultPreferences getDefaultPreferences() {

		if (fDefaultPreferences == null) {
			fDefaultPreferences = new DefaultPreferences(PLUGIN_ID);
		}
		return fDefaultPreferences;
	}

	private void processArguments() {
		// NOTE: current thread is assumed to be UI thread.
		// Look for special arguments that we support:
		// -launch "launchName"
		String args[] = Platform.getApplicationArgs();
		for (int i = 0; i < args.length; i++) {
			if ("-launch".equals(args[i]) && i + 1 < args.length) {
				final String launchName = args[i + 1];
				ILaunchConfiguration config = findLaunchConfig(launchName);
				final IWorkbench wb = PlatformUI.getWorkbench();
				if (config == null && wb != null) {
					wb.getDisplay().asyncExec(new Runnable() {
						@Override
						public void run() {
							String name = launchName;
							if (name.indexOf(' ') >= 0)
								name = "\"" + launchName + "\"";
							MessageDialog.openError(wb.getDisplay().getActiveShell(), "Command-line error",
									"The command line arguments:\n   -launch " + name + "\nfailed during processing."
											+ " No launch configuration exists with the\nspecified name. The arguments will be ignored.");
						}
					});

				} else {
					Job job = new Job(MessageFormat.format(DebugUIMessages.DebugUIPlugin_25, new Object[] {config.getName()})) {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							try {
								config.launch(ILaunchManager.DEBUG_MODE, monitor);
							} catch (CoreException e) {
								return new Status(e.getStatus().getSeverity(), Activator.PLUGIN_ID,
										"Command-line error", e);

							}
							return Status.OK_STATUS;
						}
						
					};
					job.setPriority(Job.INTERACTIVE);
					job.setProperty(IProgressConstants2.SHOW_IN_TASKBAR_ICON_PROPERTY, Boolean.TRUE);
					job.schedule();
				}
			}
		}
	}

	private static ILaunchConfiguration findLaunchConfig(String name) {
		try {
			for (ILaunchConfiguration config : DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations()) {
				if (config.getName().equals(name))
					return config;
			}
		} catch (CoreException e) {
			log(e);
		}
		return null;
	}
}
