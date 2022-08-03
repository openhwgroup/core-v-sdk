package com.ashling.riscfree.debug.opxd.registers.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.core.runtime.Status;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.ashling.riscfree.debug.opxd.registers.Activator;
import com.ashling.riscfree.debug.opxd.registers.generated.Field;
import com.ashling.riscfree.debug.opxd.registers.generated.Flags;
import com.ashling.riscfree.debug.opxd.registers.generated.Reg;
import com.ashling.riscfree.debug.opxd.registers.generated.Struct;
import com.ashling.riscfree.debug.opxd.registers.generated.Target;
import com.ashling.riscfree.debug.opxd.registers.generated.Union;
import com.ashling.riscfree.debug.opxd.registers.generated.Vector;

import jakarta.xml.bind.JAXB;

import com.ashling.riscfree.debug.opxd.registers.generated.Enum;

class RegisterDescriptionCache {

	private File rootRegFile;
	private String registerDirectory;
	private Map<String, List<BitField>> registerToBitFieldMap = new HashMap<String, List<BitField>>();
	private Map<String, Struct> structMap = new HashMap<String, Struct>();
	private Map<String, Enum> enumMap = new HashMap<String, Enum>();
	private Map<String, Reg> regMap = new HashMap<String, Reg>();
	private Map<String, List<Reg>> registerGroupMap = new HashMap<String, List<Reg>>();
	private Map<String, Union> unionMap = new HashMap<String, Union>();
	private Map<String, Vector> vectorMAp = new HashMap<String, Vector>();
	private Map<String, Flags> flagsMap = new HashMap<String, Flags>();
	private static final String GENERAL_PURPOSE_REGISTERS = "General Purpose Registers"; //$NON-NLS-1$
	private static int previousRegNumber;

	public RegisterDescriptionCache(File rootRegFile, String registerDirectory) {
		this.rootRegFile = rootRegFile;
		this.registerDirectory = registerDirectory;
	}

	public void init(RequestMonitor rm) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setXIncludeAware(true);
			spf.setNamespaceAware(true);
			XMLReader xr = spf.newSAXParser().getXMLReader();
//			be sure validation is "off" or the feature to ignore DTD's will not apply
			xr.setFeature("http://xml.org/sax/features/validation", false); //$NON-NLS-1$
			xr.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false); //$NON-NLS-1$
			FileInputStream xmlStream = new FileInputStream(rootRegFile);
			SAXSource src = new SAXSource(xr, new InputSource(xmlStream));
			src.setSystemId(registerDirectory);
			Target target = JAXB.unmarshal(src, Target.class);
			target.getFeature().forEach(ftr -> {

				// Put all registers to register group Map
				// Register number generation logic implemented here
				previousRegNumber = 0;
				ftr.getReg().forEach(reg -> {
					if (reg.getRegnum() != null) {
						previousRegNumber = Integer.parseInt(reg.getRegnum());
					} else {
						previousRegNumber++;
						reg.setRegnum(String.valueOf(previousRegNumber));
					}

					regMap.put(reg.getName(), reg);
					String regGroupName = reg.getGroup();
					if(regGroupName == null)
					{
						regGroupName = GENERAL_PURPOSE_REGISTERS;
					}					
					List<Reg> regList = registerGroupMap.get(regGroupName);
					if (regList == null) {
						regList = new ArrayList<Reg>();
						registerGroupMap.put(regGroupName, regList);
					}
					regList.add(reg);
				});

				ftr.getVectorOrFlagsOrStructOrUnionOrEnum().forEach(p -> {

					if (p instanceof Enum) {
						enumMap.put(((Enum) p).getId(), (Enum) p);
					} else if (p instanceof Struct) {
						structMap.put(((Struct) p).getId(), (Struct) p);
					} else if (p instanceof Union) {
						unionMap.put(((Union) p).getId(), (Union) p);
					} else if (p instanceof Vector) {
						vectorMAp.put(((Vector) p).getId(), (Vector) p);
					} else if (p instanceof Flags) {
						flagsMap.put(((Flags) p).getId(), (Flags) p);
					} else {
						rm.setStatus(new Status(Status.ERROR, Activator.PLUGIN_ID, "The type is not supported")); //$NON-NLS-1$
					}
				});
			});
			rm.done();
		} catch (SAXException | ParserConfigurationException | FileNotFoundException ex) {
			Status errorStatus = new Status(Status.ERROR, Activator.PLUGIN_ID,
					"Invalid register description file", ex); //$NON-NLS-1$
			Activator.getDefault().getLog().log(errorStatus);
			rm.setStatus(errorStatus);
		}

	}

	public List<BitField> getBitFields(String registerName) {
		List<BitField> bitFieldList = registerToBitFieldMap.get(registerName);
		if (null == bitFieldList) {
			bitFieldList = findBitFields(registerName);
			registerToBitFieldMap.put(registerName, bitFieldList);
		}
		return bitFieldList;
	}

	private List<BitField> findBitFields(String registerName) {
		List<BitField> bitFieldList = new ArrayList<BitField>();
		Reg reg = regMap.get(registerName);
		if (null != reg) {
			Struct struct = structMap.get(reg.getType());
			if (struct != null) {
				struct.getField().forEach(p -> bitFieldList.add(createBitField(p)));
			} else {
				// TODO: LOG to file
			}
		} else {
			//TODO LOG to file
		}

		return bitFieldList;
	}

	private BitField createBitField(Field field) {
		String fieldDesc = field.getDescription();
		BitField bitField = new BitField(field.getName(), fieldDesc == null ? "" : fieldDesc); //$NON-NLS-1$
		// TODO: Need to add/support few fields in the description file
		bitField.hasSideEffects = false;
		bitField.isZerobasedNumbering = false;
		bitField.isZeroBitLeftMost = false;
		bitField.isWritableOnce = false;
		bitField.isWritable = true;
		bitField.isReadable = true;
		bitField.isReadOnce = false;
		bitField.setBitGroupList(Arrays.asList(
				new BitGroup[] { new BitGroup(Integer.parseInt(field.getStart()), Integer.parseInt(field.getEnd())) }));
		Enum enumVal = enumMap.get(field.getType());
		if (enumVal != null) {
			List<Mnemonic> mnemonics = new ArrayList<Mnemonic>();
			// TODO: Check is short name is correct or not
			enumVal.getEvalue().forEach(val -> mnemonics.add(
					new Mnemonic(String.valueOf(val.getValue()), val.getName(), Integer.parseInt(enumVal.getSize()))));
			bitField.setMnemonics(mnemonics);
		}

		return bitField;
	}

	public List<Reg> getRegisters(String registerGroup) {
		return registerGroupMap.get(registerGroup);
	}

	public Set<String> getRegisterGroups() {
		return registerGroupMap.keySet();
	}
	
	public String getRegisterDescription(String registerName) {
		Reg register = regMap.get(registerName);
		if (register != null) {
			return register.getDescription();
		}
		return null;
	}
}