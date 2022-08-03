package com.ashling.riscfree.debug.opxd.registers;

import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.ashling.riscfree.dsf.registers"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * Status code indicating an unexpected internal error.
	 */
	private static final int INTERNAL_ERROR = 150;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
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
	
	public static void failRequest(RequestMonitor rm, int code, String message) {
		rm.setStatus(new Status(IStatus.ERROR, PLUGIN_ID, code, message, null));
		rm.done();
	}
	
	public static void logInfo(String message) {   	 	
    	final IStatus status=new Status(IStatus.INFO,Activator.PLUGIN_ID,message);
    	Activator.getDefault().getLog().log(status);
    }

	/**
	 * Logs the specified status with this plug-in's log.
	 *
	 * @param status
	 *            status to log
	 */
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	/**
	 * Logs an internal error with the specified throwable
	 *
	 * @param e
	 *            the exception to be logged
	 */
	public static void log(Throwable e) {
		log(new Status(IStatus.ERROR, getUniqueIdentifier(), INTERNAL_ERROR,
				"Internal Error", e)); //$NON-NLS-1$
	}

	private static String getUniqueIdentifier() {
		return PLUGIN_ID;
	}

	/**
	 * Logs an internal error with the specified message.
	 *
	 * @param message
	 *            the error message to log
	 */
	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, getUniqueIdentifier(), INTERNAL_ERROR, message, null));
	}
}
