/**
 * 
 */
package com.ashling.riscfree.debug.osawareness.freertos.view;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.gdb.launching.GdbLaunch;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import com.ashling.riscfree.debug.awareness.util.OSInfoManager;
import com.ashling.riscfree.debug.ease.ui.EASEDebugView;
import com.ashling.riscfree.debug.multicore.model.IMulticoreLaunch;
import com.ashling.riscfree.debug.opxd.core.ConfigurationAttributes;
import com.ashling.riscfree.debug.opxd.core.preferences.DefaultPreferences;
import com.ashling.riscfree.debug.opxd.core.utils.ConfigurationHelper;
import com.ashling.riscfree.debug.osawareness.freertos.Activator;

/**
 * @author vinod.appu
 *
 */
public class OSAwareFreeRTOSDebugView extends EASEDebugView {

	@Override
	protected boolean canPopulateView(IAdaptable currentDebugContext) {
		ILaunch activeLaunch = getActiveLaunch();
		ILaunchConfiguration launchConfiguration = null;
		boolean isRtosDebugging = false;
		if (activeLaunch instanceof GdbLaunch) {
			launchConfiguration = activeLaunch.getLaunchConfiguration();
		} else if (activeLaunch instanceof IMulticoreLaunch) {
			// ICommandControlDMContext.getCommandControlId() should return core id in
			// multicore debug launch
			ICommandControlDMContext commandControlDMContext = DMContexts.getAncestorOfType(
						currentDebugContext.getAdapter(IDMContext.class), ICommandControlDMContext.class);
			if (commandControlDMContext != null) {
				launchConfiguration = ((IMulticoreLaunch) activeLaunch)
						.getLaunchConfiguration(commandControlDMContext.getCommandControlId());
			}
		}
		if (launchConfiguration != null) {
			try {
				isRtosDebugging = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_DEBUG,
						DefaultPreferences.OS_AWARENESS_RTOS_DEBUGGING);
			} catch (CoreException e) {
				// Nothing specific we've to do here
				Activator.logErrorMessage("Unable to read launch configuration attribute - RTOS_DEBUG");
				Activator.log(e);
			}
			if (isRtosDebugging) {
				return super.canPopulateView(currentDebugContext);
			}
		}

		return false;
	}

	@Override
	protected String getViewPopulationScriptID() {
		String scriptLocation = getFreeRTOSScriptlocation();
		if (!scriptLocation.isEmpty()) {
			return scriptLocation + File.separator + super.getViewPopulationScriptID();
		}
		return super.getViewConfigurationScriptID();
	}

	private String getFreeRTOSScriptlocation() {
		String rtosScriptRootLocation = "";
		try {
			ILaunch activeLaunch = getActiveLaunch();
			if (activeLaunch != null) {
				ILaunchConfiguration launchConfiguration = activeLaunch.getLaunchConfiguration();
				boolean isCustomScriptLocation = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_CUSTOM,
						DefaultPreferences.OS_AWARENESS_CUSTOM_RTOS);
				if (isCustomScriptLocation) {
					rtosScriptRootLocation = launchConfiguration
							.getAttribute(ConfigurationAttributes.RTOS_SCRIPT_LOCATION, "");
				} else {
					String rtosVersion = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_VERSION,
							OSInfoManager.INSTANCE.getDefaultOSVersion().orElse(""));
					String rtosType = launchConfiguration.getAttribute(ConfigurationAttributes.RTOS_TYPE,
							OSInfoManager.INSTANCE.getDefaultOSType().orElse(""));
					URL url = Platform.getInstallLocation().getURL();

					File installationLocation = url == null ? new File(".") : new File(url.getPath()).getParentFile();

					if (installationLocation != null) {
						rtosScriptRootLocation = Paths
								.get(installationLocation.getAbsolutePath(), ConfigurationHelper.SCRIPT_FOLDER_NAME,
										ConfigurationHelper.RTOS_SCRIPT_FOLDER_NAME, rtosType, rtosVersion)
								.toAbsolutePath().toString();
					} else {
						Activator.logErrorMessage("No folder named rtos in the installation location");
					}
				}
			}
		} catch (Exception e) {
			Activator.log(e);
		}
		return rtosScriptRootLocation;
	}
}
