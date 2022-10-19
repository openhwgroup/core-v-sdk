package com.ashling.riscfree.debug.osawareness.freertos;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.ashling.riscfree.debud.osawareness.freertos"; //$NON-NLS-1$
	private static final int INTERNAL_ERROR = 10005;

	// The shared instance
	private static Activator plugin;
	
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
	
	 /**
     * Logs the specified status with this plug-in's log.
     * 
     * @param status status to log
     */
    public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }

    /**
     * Logs the specified throwable with this plug-in's log.
     * 
     * @param t throwable to log 
     */
    public static void log(Throwable t) {
        log(newErrorStatus(INTERNAL_ERROR, "Error logged from Debug UI: ", t)); //$NON-NLS-1$
    }
    
    /**
     * Logs an internal error with the specified message.
     * 
     * @param message the error message to log
     */
    public static void logErrorMessage(String message) {
        // this message is intentionally not internationalized, as an exception may
        // be due to the resource bundle itself
        log(newErrorStatus(INTERNAL_ERROR, "Internal message logged from Debug UI: " + message, null)); //$NON-NLS-1$   
    }
    
    /**
     * Returns a new error status for this plug-in with the given message
     * 
     * @param message the message to be included in the status
     * @param error code
     * @param exception the exception to be included in the status or <code>null</code> if none
     * @return a new error status
     * 
     * @since 2.0
     */
    public static IStatus newErrorStatus(int code, String message, Throwable exception) {
        return new Status(IStatus.ERROR, Activator.PLUGIN_ID, code, message, exception);
    }
}
