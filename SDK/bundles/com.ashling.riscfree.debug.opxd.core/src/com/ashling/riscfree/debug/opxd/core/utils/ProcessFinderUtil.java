package com.ashling.riscfree.debug.opxd.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ashling.riscfree.debug.opxd.core.Activator;
import com.ashling.riscfree.debug.opxd.core.utils.OSUtil.OS;

/*
 *  @author promod.kumar
 *  
 *  @implNote - This class is created to find a process is running or not
 *  
 */
public class ProcessFinderUtil {

	/*
     * Check the system OS and delegate to the method to find the OS specific process
     * @param ProcessEnum
     * @return true if process is running
     *
     */
	public static boolean isProcessAvailable(ProcessEnum process) {
		return OSUtil.getOS() == OS.WINDOWS ? findWinProcess(process.getWinProcessName())
				: findLinProcess(process.getLinProcessName());
	}

	/*
     * Find whether the specified process is running in windows
     * @param process name to find
     * @return true if process is running
     *
     */
	private static boolean findWinProcess(String findProcess) {
		String filenameFilter = "/nh /fi \"Imagename eq " + findProcess + "\"";
		String tasksCmd = System.getenv("windir") + "/system32/tasklist.exe " + filenameFilter;
		try {
			Process p = Runtime.getRuntime().exec(tasksCmd);
			return checkProcess(p, findProcess);

		} catch (Exception e) {
			Activator.logErrorMessage(e.toString());
		}
		return false;

	}

	/*
     * Find whether the specified process is running in linux
     * @param process name to find
     * @return true if process is running
     *
     */
	private static boolean findLinProcess(String findProcess) {
		Process p;
		try {
			p = Runtime.getRuntime().exec(new String[] { "sh", "-c", "ps -ef | grep jtagd | grep -v grep" });
			return checkProcess(p, findProcess);
		} catch (IOException e) {
			Activator.logErrorMessage(e.toString());
		}
		return false;

	}

	/*
     * Process the Process object recieved from runtime executor and check whether the specified 
     * process is running or not
     * @param process name to find
     * @param Process object with information whether the specified process is running 
     * @return true if process is running
     *
     */
	private static boolean checkProcess(Process p, String processName) {
		boolean processFound = false;
		String line;
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			ArrayList<String> procs = new ArrayList<String>();
			while ((line = input.readLine()) != null) {
				procs.add(line);
			}
			input.close();
			processFound = procs.stream().filter(row -> row.indexOf(processName) > -1).count() > 0;
		} catch (Exception err) {
			Activator.logErrorMessage(err.toString());
		}
		return processFound;
	}
}
