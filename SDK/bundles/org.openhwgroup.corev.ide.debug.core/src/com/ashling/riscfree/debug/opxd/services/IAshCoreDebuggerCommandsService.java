package com.ashling.riscfree.debug.opxd.services;

import java.util.List;

import org.eclipse.core.runtime.IStatus;



public interface IAshCoreDebuggerCommandsService {
	
	/**
	 * @param commandsList
	 * @return Status.OK_STATUS or an IStatus object if error.
	 */
	public IStatus addDirectoryCommands(List<String> commandsList);
}
