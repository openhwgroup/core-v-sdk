package com.ashling.riscfree.debug.opxd.core.dsf;

import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.command.ICommand;
import org.eclipse.cdt.dsf.debug.service.command.ICommandControlService.ICommandControlDMContext;
import org.eclipse.cdt.dsf.mi.service.command.output.MIInfo;

public interface IAshCommandFactory {

	/**
	 * Create the core dump command
	 * 
	 * @param ctx
	 * @param saveLocation
	 * @return
	 */
	public MICoreDump createCLICoreDump(IDMContext ctx, String saveLocation);

	/**
	 * Create register flush command
	 * 
	 * @param ctx
	 * @return
	 */
	public ICommand<MIInfo> createCLIregisterFlush(IDMContext ctx);

	/**
	 * Create MMU Awareness enable command
	 * 
	 * @param ctx
	 * @return
	 */
	ICommand<MIInfo> createMMUAwareness(ICommandControlDMContext ctx);
	
	/**
	 * Create semi-hosting command.
	 * 
	 * @param ctx
	 * @param enabled
	 * @return
	 */
	ICommand<MIInfo> createSemiHosting(ICommandControlDMContext ctx, boolean enabled);
	
	/**
	 * Create fdc enable command.
	 * 
	 * @param ctx
	 * @param enabled
	 * @param sizeIndex
	 * @return
	 */
	ICommand<MIInfo> createFDCEnabled(ICommandControlDMContext ctx, boolean enabled, String sizeIndex);

}