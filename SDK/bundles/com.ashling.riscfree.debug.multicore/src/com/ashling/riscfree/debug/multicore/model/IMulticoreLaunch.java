/**
 *
 */
package com.ashling.riscfree.debug.multicore.model;

import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

/**
 * @author vinod.appu
 *
 *Base interface for a multicore launch
 */
public interface IMulticoreLaunch extends ILaunch {

	/**
	 * Return launch multicore debug configuration
	 * @return
	 */
	public MulticoreDebugConfiguration getMulticoreConfiguration();

	/**
	 * Return the DsfSession in which the launch happening
	 * @return
	 */
	public DsfSession getSession();

	/**
	 * This should return MulticoreLaunchConfiguration.java object, which will act
	 * like a proxy, filter core specific configuration
	 * 
	 * @param coreId
	 * @return
	 */
	public ILaunchConfiguration getLaunchConfiguration(String coreId);

	/**
	 * Convenient way to get the debugger name from launch itself
	 * 
	 * @param coreDebugConfiguration
	 * @return
	 */
	public String getDebuggerName(CoreDebugConfiguration coreDebugConfiguration);

	/**
	 * Convenient way to get the debugger path from launch itself
	 * 
	 * @param coreDebugConfiguration
	 * @return
	 */
	public String getDebuggerPath(CoreDebugConfiguration coreDebugConfiguration);

	/**
	 * Convenient way to get the debugger version
	 * @param coreDebugConfiguration
	 * @return
	 */
	String getDebuggerVersion(CoreDebugConfiguration coreDebugConfiguration);
}
