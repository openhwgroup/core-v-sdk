package com.ashling.riscfree.debug.osawareness.linux.view;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ashling.riscfree.debug.awareness.util.OSInfoManager;
import com.ashling.riscfree.debug.ease.ui.EASEDebugView;
import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.utils.ConfigurationHelper;
import com.ashling.riscfree.debug.osawareness.linux.Activator;
import com.ashling.riscfree.debug.osawareness.linux.util.OSAwarenessDebugUtil;

/**
 * Ease View class for Linux views
 *
 */
public class OSAwareLinuxDebugView extends EASEDebugView {

	private TreeViewer viewer;
	
	@Override
	protected boolean canPopulateView(IAdaptable currentDebugContext) {
		if (OSAwarenessDebugUtil.isDebugLaunchLinuxAware(
				OSAwarenessDebugUtil.getLaunchConfiguration(Optional.ofNullable(currentDebugContext)))) {
			return super.canPopulateView(currentDebugContext);
		}
		return false;
	}
	
	@Override
	protected TreeViewer makeViewer(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		return viewer;
	}

	public void showExpressionsView() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart part = page.findView(IDebugUIConstants.ID_EXPRESSION_VIEW);
		if (part == null) {
			try {
				page.showView(IDebugUIConstants.ID_EXPRESSION_VIEW);
			} catch (PartInitException e) {
			}
		} else {
			page.bringToTop(part);
		}
	}
	
	@Override
	protected String getViewConfigurationScriptID() {
		String scriptLocation = getLinuxScriptlocation();
		if (!scriptLocation.isEmpty()) {
			return scriptLocation + File.separator + super.getViewConfigurationScriptID();
		}
		return super.getViewConfigurationScriptID();
	}
	
	@Override
	protected String getViewPopulationScriptID() {
		String scriptLocation = getLinuxScriptlocation();
		if (!scriptLocation.isEmpty()) {
			return scriptLocation + File.separator + super.getViewPopulationScriptID();
		}
		return super.getViewPopulationScriptID();
	}

	private String getLinuxScriptlocation() {
		String rtosScriptRootLocation = "";
		try {
			ILaunch activeLaunch = getActiveLaunch();
			if (activeLaunch != null) {
				ILaunchConfiguration launchConfiguration = OSAwarenessDebugUtil.getLaunchConfiguration(Optional.empty());
				String rtosType = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_TYPE,
						OSInfoManager.INSTANCE.getDefaultOSType().orElse(""));
				URL url = Platform.getInstallLocation().getURL();

				File installationLocation = url == null ? new File(".") : new File(url.getPath()).getParentFile();

				if (installationLocation != null) {
					rtosScriptRootLocation = Paths
							.get(installationLocation.getAbsolutePath(), ConfigurationHelper.SCRIPT_FOLDER_NAME,
									ConfigurationHelper.RTOS_SCRIPT_FOLDER_NAME, rtosType)
							.toAbsolutePath().toString();
				} else {
					Activator.logErrorMessage("No folder named rtos in the installation location");
				}
			}
		} catch (Exception e) {
			Activator.log(e);
		}
		return rtosScriptRootLocation;
	}
}
