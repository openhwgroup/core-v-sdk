package com.ashling.riscfree.debug.opxd.core.dsf;

import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommand;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.mi.service.command.commands.CLICommand;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;
import org.eclipse.embedcdt.debug.gdbjtag.core.dsf.GnuMcuCommandFactory;

/**
 * @author vinod.appu
 *
 */
public class AshCommandFactory extends GnuMcuCommandFactory implements IAshCommandFactory {

	@Override
	public MICoreDump createCLICoreDump(IDMContext ctx, String saveLocation) {
		return new MICoreDump(ctx, saveLocation);
	}

	@Override
	public ICommand<MIInfo> createCLIregisterFlush(IDMContext ctx) {
		return new CLIRegisterFLush(ctx);
	}
	
	@Override
	public ICommand<MIInfo> createMMUAwareness(ICommandControlDMContext ctx) {
		return new CLICommand<>(ctx, "monitor mmuenable 1");
	}

	@Override
	public ICommand<MIInfo> createSemiHosting(ICommandControlDMContext ctx, boolean enabled) {
		if(enabled) {
			return new CLICommand<>(ctx, "monitor semi-hosting on");
		}
		return new CLICommand<>(ctx, "monitor semi-hosting off");
	}

	@Override
	public ICommand<MIInfo> createFDCEnabled(ICommandControlDMContext ctx, boolean enabled, String sizeIndex) {
		if(enabled) {
			return new CLICommand<>(ctx, "monitor fdcenable " + sizeIndex);
		}
		return new CLICommand<>(ctx, "monitor fdcenable 0");
	}
}
