package com.ashling.riscfree.debug.opxd.core.dsf;

import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.mi.service.command.commands.MIInterpreterExecConsole;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;

/**
 * @author vinod.appu
 *
 */
public class MICoreDump extends MIInterpreterExecConsole<MIInfo>{

	public MICoreDump(IDMContext ctx, String saveLocation) {
		super(ctx, "gcore " + saveLocation);
	}
}
