/*******************************************************************************
 * Copyright (c) 2013 Liviu Ionescu.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Liviu Ionescu - initial version
 *******************************************************************************/

package org.eclipse.embedcdt.debug.gdbjtag.openocd.core.dsf;

import java.io.File;

import org.eclipse.cdt.dsf.debug.service.IRegisters;
import org.eclipse.cdt.dsf.mi.service.IMIBackend;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuDebuggerCommandsService;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuGdbServerBackend;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuServicesFactory;
import org.eclipse.embedcdt.debug.gdbjtag.openocd.core.ConfigurationAttributes;
import org.eclipse.embedcdt.internal.debug.gdbjtag.openocd.core.Activator;

import com.ashling.riscfree.debug.opxd.registers.core.RiscFreeRegister;

public class ServicesFactory extends GnuMcuServicesFactory {

	// ------------------------------------------------------------------------

	@SuppressWarnings("unused")
	private final String fVersion;
	ILaunchConfiguration lConfig;

	// ------------------------------------------------------------------------

	public ServicesFactory(ILaunchConfiguration config, String version, String mode) {
		this(version, mode);
		lConfig = config;
	}

	public ServicesFactory(String version, String mode) {
		super(version, mode);

		if (Activator.getInstance().isDebugging()) {
			System.out.println("openocd.ServicesFactory(" + version + "," + mode + ") " + this);
		}
		fVersion = version;
	}

	// ------------------------------------------------------------------------

	@Override
	protected IMIBackend createBackendGDBService(DsfSession session, ILaunchConfiguration lc) {
		return new GdbBackend(session, lc);
	}

	@Override
	protected GnuMcuGdbServerBackend createGdbServerBackendService(DsfSession session, ILaunchConfiguration lc) {
		return new GdbServerBackend(session, lc);
	}

	@Override
	protected GnuMcuDebuggerCommandsService createDebuggerCommandsService(DsfSession session, ILaunchConfiguration lc,
			String mode) {
		return new DebuggerCommands(session, lc, mode);
	}

	@Override
	protected IRegisters createRegistersService(DsfSession session) {
		String regFilename;
		try {
			regFilename = resolvePath(lConfig.getAttribute(ConfigurationAttributes.GDB_SERVER_TARGET_REG_FILE, ""));
		} catch (CoreException e) {
			regFilename = "";
		}
		if (!regFilename.isEmpty()) {
			Path regfilename = Path.forWindows(resolvePath(regFilename));
			Path regdir = Path.forWindows(new File(regFilename).getParent() + "/");
			return new RiscFreeRegister(session, regfilename.toOSString(), regdir.toOSString());
		} else {
			return super.createRegistersService(session);
		}
	}

	public String resolvePath(String value) {
		try {
			// Do not report undefined variables
			value = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(value, false)
					.trim();
		} catch (CoreException e) {

			Activator.log(e);
		}
		return value;
	}
	// ------------------------------------------------------------------------
}
