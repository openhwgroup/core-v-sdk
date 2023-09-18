package com.ashling.riscfree.debug.opxd.core.dsf;

import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.mi.service.command.commands.MIInterpreterExecConsole;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;

public class CLIRegisterFLush extends MIInterpreterExecConsole<MIInfo> {

	public static final String TARGET_DESC_COMMAND = "set tdesc filename"; //$NON-NLS-1$

	public CLIRegisterFLush(IDMContext ctx) {
		super(ctx, "flushregs"); //$NON-NLS-1$
	}

}