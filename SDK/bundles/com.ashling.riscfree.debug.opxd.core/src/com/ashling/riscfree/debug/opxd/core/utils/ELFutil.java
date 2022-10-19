/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.utils;

import java.io.IOException;

import org.eclipse.cdt.utils.elf.Elf;
import org.eclipse.cdt.utils.elf.Elf.ELFhdr;
import org.eclipse.cdt.utils.elf.ElfHelper;

/**
 * @author vinod.appu
 *
 */
public class ELFutil {

	private static final String TEXT_SECTION = ".text";

	/**
	 * Return the .text section start address
	 * @param elfPath
	 * @return
	 * @throws IOException 
	 */
	//TODO: Check always ".text" is always correct or not
	//TODO: How to do it for other formats for .bin, .srec
	public static String textSectionAddress(String elfPath)
	{
		try
		{
		ElfHelper elfHelper = new ElfHelper(elfPath);
		Elf elf = elfHelper.getElf();
		return elf.getSectionByName(TEXT_SECTION).sh_addr.toHexAddressString();
		}
		catch (IOException e)
		{
			return "0x0";
		}
	}
	
	/**
	 * Check whether the given elf is 64 bit or not
	 * @param elfPath
	 * @return
	 * @throws IOException
	 */
	public static boolean is64bitElf(String elfPath) throws IOException
	{
		try (ElfHelper elfHelper = new ElfHelper(elfPath)) {
			Elf elf = elfHelper.getElf();
			return elf.getELFhdr().e_ident[ELFhdr.EI_CLASS] == ELFhdr.ELFCLASS64;
		}
	}
}
