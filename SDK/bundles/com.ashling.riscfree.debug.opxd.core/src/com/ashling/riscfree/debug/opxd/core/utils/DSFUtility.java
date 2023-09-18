/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.utils;

import org.eclipse.cdt.debug.gdbjtag.core.Activator;
import org.eclipse.cdt.debug.ui.CDebugUIPlugin;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.service.DsfServicesTracker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.progress.UIJob;

import com.ashling.riscfree.debug.opxd.core.comrv.IComRVService;
import com.ashling.riscfree.debug.multicore.util.MulticoreServiceUtility;

/**
 * @author vinod.appu
 *
 */
public enum DSFUtility {

	INSTANCE;

	public IComRVService getComRVService(IDMContext dmc) {
		DsfServicesTracker serviceTracker = new DsfServicesTracker(Activator.getBundleContext(), dmc.getSessionId());
		IComRVService comRVService = null;
		MulticoreServiceUtility.trackCoreService(IComRVService.class, serviceTracker, dmc);
		if (comRVService == null) {
			// Could be a normal launch, trying to track core service
			comRVService = serviceTracker.getService(IComRVService.class);
		}
		serviceTracker.dispose();
		return comRVService;
	}
	

	/**
	 * Helper function to open an error dialog.
	 * @param title
	 * @param message
	 * @param e
	 */
	public void openError(final String title, final String message, final Exception e) {
		UIJob uiJob = new UIJob("open error") { //$NON-NLS-1$

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				// open error for the exception
				String detail = ""; //$NON-NLS-1$
				if (e != null)
					detail = e.getMessage();

				Shell shell = CDebugUIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();

				MessageDialog.openError(shell, title, message + "\n" + detail); //$NON-NLS-1$
				return Status.OK_STATUS;
			}
		};
		uiJob.setSystem(true);
		uiJob.schedule();
	}
	
	/**
	 * Helper function to open an error dialog.
	 * @param title
	 * @param message
	 * @param e
	 */
	public void openWarning(final String title, final String message, final Exception e) {
		UIJob uiJob = new UIJob("open warning") { //$NON-NLS-1$

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				// open error for the exception
				String detail = ""; //$NON-NLS-1$
				if (e != null)
					detail = e.getMessage();

				Shell shell = CDebugUIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();

				MessageDialog.openWarning(shell, title, message + "\n" + detail); //$NON-NLS-1$
				return Status.OK_STATUS;
			}
		};
		uiJob.setSystem(true);
		uiJob.schedule();
	}
}
