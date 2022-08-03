package com.ashling.riscfree.debug.opxd.registers.core;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.cdt.debug.core.ICDTLaunchConfigurationConstants;
import org.eclipse.cdt.dsf.concurrent.DataRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.ImmediateExecutor;
import org.eclipse.cdt.dsf.concurrent.ImmediateRequestMonitor;
import org.eclipse.cdt.dsf.concurrent.RequestMonitor;
import org.eclipse.cdt.dsf.datamodel.AbstractDMContext;
import org.eclipse.cdt.dsf.datamodel.DMContexts;
import org.eclipse.cdt.dsf.datamodel.IDMContext;
import org.eclipse.cdt.dsf.debug.service.IFormattedValues;
import org.eclipse.cdt.dsf.debug.service.IRegisters;
import org.eclipse.cdt.dsf.debug.service.IRegisters2;
import org.eclipse.cdt.dsf.debug.service.IStack.IFrameDMContext;
import org.eclipse.cdt.dsf.gdb.internal.GdbPlugin;
import org.eclipse.cdt.dsf.gdb.service.GDBRegisters;
import org.eclipse.cdt.dsf.gdb.service.IGDBGrouping.IGroupDMContext;
import org.eclipse.cdt.dsf.gdb.service.extensions.GDBRegisters_HEAD;
import org.eclipse.cdt.dsf.mi.service.MIRegisters;
import org.eclipse.cdt.dsf.service.DsfSession;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import com.ashling.riscfree.debug.opxd.registers.Activator;
import com.google.common.primitives.UnsignedLong;

/**
 * @author vinod.appu
 *
 */
public class RiscFreeRegister extends GDBRegisters_HEAD {

	private RegisterDescriptionCache registerDescCache;
	private String rootRegisterFile;
	private String registerDirectory;
	private List<String> registerGroups = new ArrayList<String>();

	/**
	 * @param session
	 */
	public RiscFreeRegister(DsfSession session, String rootRegisterFile, String registerDirectory) {
		super(session);
		this.rootRegisterFile = rootRegisterFile;
		// Ensure the path separator is available in the end
		this.registerDirectory = registerDirectory+File.separator;
	}

	@Override
	public void initialize(final RequestMonitor requestMonitor) {
		super.initialize(new ImmediateRequestMonitor(requestMonitor) {
			@Override
			public void handleSuccess() {
				doInitialize(requestMonitor);
			}
		});
	}

	private void doInitialize(final RequestMonitor requestMonitor) {
		register(
				new String[] { IRegisters.class.getName(), IRegisters2.class.getName(), MIRegisters.class.getName(),
						GDBRegisters.class.getName(), RiscFreeRegister.class.getName() },
				new Hashtable<String, String>());
		if (rootRegisterFile != null && registerDirectory != null) {
			registerDescCache = new RegisterDescriptionCache(new File(rootRegisterFile), registerDirectory);
			registerDescCache.init(new RequestMonitor(getExecutor(), requestMonitor));
			registerGroups.addAll(registerDescCache.getRegisterGroups());
		}
		requestMonitor.done();
	}

	/*
	 * Support class used to construct BitField DMCs.
	 */
	private static class BitFieldDMContext extends AbstractDMContext implements IBitFieldDMContext {

		private BitField fBitField;

		public BitFieldDMContext(DsfSession session, IDMContext[] dmContexts, BitField bitField) {
			super(session, dmContexts);
			this.fBitField = bitField;
		}

		/*
		 * Required common manipulation routines.
		 */
		@Override
		public boolean equals(Object other) {
			if (other instanceof BitFieldDMContext) {
				BitFieldDMContext dmc = (BitFieldDMContext) other;
				return ((super.baseEquals(other)) && (dmc.fBitField.getName().equals(fBitField.getName())));
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			return super.baseHashCode() + fBitField.getName().hashCode();
		}

		@Override
		public String toString() {
			return baseToString() + ".bitfield[" + fBitField.getName() + "]"; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	private static class Mnemonic implements IMnemonic {
		Mnemonic(String name, String value, int numBits) {
			fName = name;
			fValue = Long.valueOf(value.trim());
			this.value = value;
		}

		final private String fName;
		final private String value;
		final private long fValue;

		@Override
		public String getShortName() {
			return value;
		}

		@Override
		public String getLongName() {
			return fName; // $NON-NLS-1$
		}

		public long getValue() {
			return fValue;
		}

		@Override
		public boolean equals(Object element) {
			if (element instanceof Mnemonic) {
				Mnemonic mnem = (Mnemonic) element;
				return (mnem.fName.equals(fName)) && (mnem.value.equals(value));
			}
			return false;
		}
	}

	private class BitFieldDMData implements IBitFieldDMData {

		final private BitField fBitField;
		final private IBitGroup[] fBitGroups;
		final private Mnemonic[] fMnemonics;
		private Mnemonic fMnemonicValue = null;

		public BitFieldDMData(BitField bitField) {
			fBitField = bitField;
			fBitGroups = fBitField.getBitGroupList().toArray(new IBitGroup[fBitField.getBitGroupList().size()]);

			// TODO: Check whether the shortname work for value
			List<Mnemonic> mmemonicList = fBitField.getMnemonics().stream()
					.map(p -> new Mnemonic(p.getLongName(), p.getShortName(), p.getSize()))
					.collect(Collectors.toList());

			fMnemonics = mmemonicList.toArray(new Mnemonic[mmemonicList.size()]);

			fMnemonicValue = mmemonicList.stream().filter(p -> bitField.getValue()!= null && p.getValue() == bitField.getValue()).findAny()
					.orElse(null);
		}

		@Override
		public IBitGroup[] getBitGroup() {
			return fBitGroups;
		}

		@Override
		public IMnemonic[] getMnemonics() {
			return fMnemonics;
		}

		@Override
		public boolean isZeroBasedNumbering() {
			return fBitField.isZerobasedNumbering();
		}

		@Override
		public boolean isZeroBitLeftMost() {
			return fBitField.isZeroBitLeftMost();
		}

		@Override
		public boolean isReadable() {
			return fBitField.isReadable();
		}

		@Override
		public boolean isReadOnce() {
			return fBitField.isReadOnce();
		}

		@Override
		public boolean isWriteable() {
			return fBitField.isWritable();
		}

		@Override
		public boolean isWriteOnce() {
			return fBitField.isWriteOnce();
		}

		@Override
		public boolean hasSideEffects() {
			return false;
		}

		@Override
		public String getName() {
			return fBitField.getName();
		}

		@Override
		public String getDescription() {
			return fBitField.getDescription();
		}

		@Override
		public IMnemonic getCurrentMnemonicValue() {
			return fMnemonicValue;
		}
	}

	@Override
	public void getBitFields(IDMContext regDmc, DataRequestMonitor<IBitFieldDMContext[]> rm) {		
		final MIRegisterDMC registerDmc = DMContexts.getAncestorOfType(regDmc, MIRegisterDMC.class);
		if (registerDmc == null) {
			rm.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, INVALID_HANDLE,
					"Register context not found", null)); //$NON-NLS-1$
			rm.done();
			return;
		}

		try {
			String register_name = registerDmc.getName();
			List<BitField> bitFieldList = registerDescCache.getBitFields(register_name);
			List<BitFieldDMContext> bitFieldDMContext = new ArrayList<BitFieldDMContext>();
			bitFieldList.forEach(p -> {
				bitFieldDMContext.add(new BitFieldDMContext(getSession(), new IDMContext[] { registerDmc }, p));
			});
			rm.setData(bitFieldDMContext.toArray(new BitFieldDMContext[bitFieldList.size()]));
			rm.done();
		} catch (Exception e) {
			super.getBitFields(regDmc, rm);
		}

	}

	@Override
	public void writeBitField(final IBitFieldDMContext bitFieldCtx, String bitFieldValue, String formatId,
			final RequestMonitor rm) {
		if (bitFieldCtx instanceof BitFieldDMContext) {
			MIRegisterDMC registerDmc = DMContexts.getAncestorOfType(bitFieldCtx, MIRegisterDMC.class);
			if (registerDmc == null) {
				// Set value to blank if frame dmc is not present
				rm.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, INVALID_HANDLE,
						"Container context not found", null)); //$NON-NLS-1$
				rm.done();
				return;
			}

			getFormattedExpressionValue(getFormattedValueContext(registerDmc, IFormattedValues.DECIMAL_FORMAT),
					new DataRequestMonitor<FormattedValueDMData>(ImmediateExecutor.getInstance(), rm) {
						@Override
						protected void handleSuccess() {
							BitFieldDMContext bitFieldDMC = ((BitFieldDMContext) bitFieldCtx);
							try {
								long registerValue = Long.parseLong(getData().getFormattedValue());								
								long bitFieldVal = convertToLong(formatId, bitFieldValue);								
								BitGroup bitGroup = bitFieldDMC.fBitField.getBitGroupList().get(0);
								if (bitGroup != null) {
									long repacedRegisterValue = replaceBits(registerValue, bitFieldVal,
											bitGroup.startBit(), bitGroup.bitCount());
									writeRegister(registerDmc, String.valueOf(repacedRegisterValue),
											IFormattedValues.DECIMAL_FORMAT, rm);
								} else {
									rm.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, INVALID_HANDLE,
											"Bitgroup information not found", null)); //$NON-NLS-1$
									rm.done();
								}
							} catch (Exception e) {
								rm.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, INVALID_HANDLE,
										"Failed to convert the format", null)); //$NON-NLS-1$
								rm.done();
							}
						}
					});

		} else {
			Activator.failRequest(rm, INVALID_HANDLE, "Invalid context"); //$NON-NLS-1$
		}
	}

	@Override
	public void writeBitField(IBitFieldDMContext bitFieldCtx, IMnemonic mnemonic, RequestMonitor rm) {
		if (mnemonic instanceof Mnemonic) {
			writeBitField(bitFieldCtx, String.valueOf(((Mnemonic) mnemonic).fValue), NATURAL_FORMAT, rm);
		} else {
			Activator.failRequest(rm, INVALID_HANDLE, "Invalid mnemonic"); //$NON-NLS-1$
		}
	}

	@Override
	public void getBitFieldData(IBitFieldDMContext dmc, final DataRequestMonitor<IBitFieldDMData> rm) {
		if (!(dmc instanceof BitFieldDMContext)) {
			Activator.failRequest(rm, INVALID_HANDLE, "Invalid context"); //$NON-NLS-1$
		}
		
		final IFrameDMContext frameDmc = DMContexts.getAncestorOfType(dmc, IFrameDMContext.class);
        // Create bit field data with name only e.g. not editable.
        if(frameDmc == null){
        	BitField bitField = ((BitFieldDMContext)dmc).fBitField;
        	bitField.isWritable = false;
        	rm.setData(new BitFieldDMData(bitField));
            rm.done();
            return;
        }
		
		BitFieldDMContext bitFieldDmc = (BitFieldDMContext) dmc;
		getBitFieldDataValue((BitFieldDMContext) dmc, DECIMAL_FORMAT,
				new DataRequestMonitor<FormattedValueDMData>(ImmediateExecutor.getInstance(), rm) {
					@Override
					protected void handleSuccess() {
						String formattedValue = getData().getFormattedValue();
						if (!formattedValue.isEmpty()) {
							bitFieldDmc.fBitField.setValue(Long.valueOf(formattedValue));
						}
						else
						{
							bitFieldDmc.fBitField.isWritable = false;
						}
						rm.setData(new BitFieldDMData(bitFieldDmc.fBitField));
						rm.done();
					}
				});
	}

	//Added support for 64 bit (now reads as unsigned)
	private static long extractBits(BigInteger regVal, int startBit, long bitCount) {
		BigInteger bitmask = BigInteger.valueOf(((1 << bitCount) - 1) << startBit);
		return (regVal.and(bitmask)).shiftRight(startBit).longValue();
	}

	private long replaceBits(long registerValue, long bitFieldValue, int startBit, int bitCount) {
		long bitMask = ((1 << bitCount) - 1) << startBit;
		long maskVal = bitFieldValue << startBit;
		return (registerValue & (~bitMask)) | (maskVal);
	}

	@Override
	public FormattedValueDMContext getFormattedValueContext(IFormattedDataDMContext dmc, String formatId) {
		if (dmc instanceof MIRegisterDMC) {
			MIRegisterDMC regDmc = (MIRegisterDMC) dmc;
			return new FormattedValueDMContext(this, regDmc, formatId);
		} else if (dmc instanceof BitFieldDMContext) {
			BitFieldDMContext bitFieldDmc = (BitFieldDMContext) dmc;
			return new FormattedValueDMContext(this, bitFieldDmc, formatId);
		} else {
			return null;
		}
	}

	@Override
	public void getFormattedExpressionValue(FormattedValueDMContext dmc, DataRequestMonitor<FormattedValueDMData> rm) {
		if (dmc.getParents().length == 1 && dmc.getParents()[0] instanceof IBitFieldDMContext) {
			getBitFieldDataValue((BitFieldDMContext) dmc.getParents()[0], dmc.getFormatID(), rm);
		} else {
			super.getFormattedExpressionValue(dmc, rm);
		}

	}

	private void getBitFieldDataValue(BitFieldDMContext bitFieldDMContext, String formatId,
			DataRequestMonitor<FormattedValueDMData> rm) {
		MIRegisterDMC registerDmc = DMContexts.getAncestorOfType(bitFieldDMContext, MIRegisterDMC.class);
		if (registerDmc == null) {
			// Set value to blank if frame dmc is not present
			rm.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, INVALID_HANDLE, "Container context not found", //$NON-NLS-1$
					null));
			rm.done();
			return;
		}

		final IFrameDMContext frameDmc = DMContexts.getAncestorOfType(bitFieldDMContext, IFrameDMContext.class);
        // Create bit field data with name only e.g. not editable.
        if(frameDmc == null){
        	rm.setData( new FormattedValueDMData( BLANK_STRING ));
            rm.done();
            return;
        }
        
		super.getFormattedExpressionValue(getFormattedValueContext(registerDmc, IFormattedValues.HEX_FORMAT),
				new DataRequestMonitor<FormattedValueDMData>(ImmediateExecutor.getInstance(), rm) {
					@Override
					protected void handleSuccess() {
						// Now only 1 bit group expected/handled
						Optional<BitGroup> bitGroup = bitFieldDMContext.fBitField.getBitGroupList().stream()
								.findFirst();
						if (bitGroup.isPresent()) {
							BitGroup p = bitGroup.get();
							FormattedValueDMData data = getData();
							String registerValue = data.getEditableValue();
							if (registerValue.startsWith("0x")) {
								registerValue = registerValue.substring(2);
							}
							try {
								UnsignedLong regVal = UnsignedLong.valueOf(registerValue.trim(), 16);
								long decimalVal = extractBits(regVal.bigIntegerValue(), p.startBit(), p.bitCount());
								String formattedVal = String.valueOf(decimalVal);
								if (HEX_FORMAT.equals(formatId) || STRING_FORMAT.equals(formatId)) {
									formattedVal = "0x" + Long.toHexString(decimalVal); // $NON-NLS-1$ //$NON-NLS-1$
								}
								if (OCTAL_FORMAT.equals(formatId)) {
									formattedVal = Long.toOctalString(decimalVal);
								}
								if (BINARY_FORMAT.equals(formatId)) {
									formattedVal = Long.toBinaryString(decimalVal);
								}

								rm.setData(new FormattedValueDMData(formattedVal));
							} catch (Exception e) {
								rm.setData(new FormattedValueDMData(BLANK_STRING));
								// TODO: Error log
							}

						} else {
							rm.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, INVALID_HANDLE,
									"No BitFieldGroup found not found", null)); //$NON-NLS-1$
						}
						rm.done();
					}
				});
	}

	@Override
	public void removeRegisterGroups(IRegisterGroupDMContext[] groups, RequestMonitor rm) {
		for (IRegisterGroupDMContext group : groups) {
			if (group instanceof MIRegisterGroupDMC) {
				registerGroups.remove(((MIRegisterGroupDMC) group).getName());
			}
		}
		super.removeRegisterGroups(groups, rm);
	}

	@Override
	public void getRegisterGroups(IDMContext ctx, DataRequestMonitor<IRegisterGroupDMContext[]> rm) {
		if(DMContexts.getAncestorOfType(ctx, IGroupDMContext.class) != null) {
			IStatus status = new Status(IStatus.ERROR, GdbPlugin.PLUGIN_ID, INVALID_HANDLE,
					"No register groups are present for group context", null); //$NON-NLS-1$
			rm.setStatus(status);
			rm.done();
			return;
		}
		if (registerDescCache != null) {
			super.getRegisterGroups(ctx,
					new DataRequestMonitor<IRegisters.IRegisterGroupDMContext[]>(getExecutor(), rm) {
						@Override
						protected void handleSuccess() {
							final IRegisterGroupDMContext[] regGroups = getData();
							boolean loadRegisterGroupsFromConfig = true;
							ILaunchConfigurationWorkingCopy wc;
							try {
								wc = getLaunchConfig().getWorkingCopy();
								loadRegisterGroupsFromConfig = wc.getAttribute(
										ICDTLaunchConfigurationConstants.ATTR_DEBUGGER_LOAD_REGISTER_GROUP_PERSISTANCE,
										true);
							} catch (CoreException e) {
							}

							if (!loadRegisterGroupsFromConfig || regGroups.length==1) {

								getRegisters(ctx, new DataRequestMonitor<IRegisterDMContext[]>(getExecutor(), rm) {
									@Override
									protected void handleSuccess() {
										// The resolver to resolve register numbers using gdb register list
										Map<String, Integer> registerNumberResolver = new HashMap<String, Integer>();
										IRegisterDMContext[] registerDMContext = getData();
										if (registerDMContext != null) {
											for (IRegisterDMContext regDMC : registerDMContext) {
												registerNumberResolver.put(((MIRegisterDMC) regDMC).getName(),
														((MIRegisterDMC) regDMC).getRegNo());
											}
										}

										final MIRegisterGroupDMC miGroupDMC = (MIRegisterGroupDMC) regGroups[0];
										registerGroups.stream().sorted((o1, o2) -> {
											
											// Sorting logic used to get order as General purpose, csr then wdc then All regs.
											if (o1.length() != o2.length()) {
												return o1.length() - o2.length();
											} else {
												return o2.compareTo(o1);
											}
										}).forEach(grp -> {
											List<MIRegisterDMC> regDMCLists = registerDescCache.getRegisters(grp)
													.stream()
													.map(p -> new MIRegisterDMC(RiscFreeRegister.this, miGroupDMC,
															null != registerNumberResolver.get(p.getName())
																	? registerNumberResolver.get(p.getName())
																	: Integer.parseInt(p.getRegnum()),
															p.getName()))
													.collect(Collectors.toList());
											addRegisterGroup(ctx, grp,
													regDMCLists.toArray(new MIRegisterDMC[regDMCLists.size()]),
													new ImmediateRequestMonitor());
										});

										rm.setData(regGroups);
										rm.done();
									}

								});

							} else {
								rm.setData(regGroups);
								rm.done();
							}

						}
					});
		} else {
			super.getRegisterGroups(ctx, rm);
		}
	}

	// Override to change the default register group name.
	@Override
	public void getRegisterGroupData(IRegisterGroupDMContext regGroupDmc, DataRequestMonitor<IRegisterGroupDMData> rm) {
		super.getRegisterGroupData(regGroupDmc,
				new DataRequestMonitor<IRegisters.IRegisterGroupDMData>(getExecutor(), rm) {
					@Override
					protected void handleSuccess() {
						IRegisterGroupDMData dmData = getData();
						if (dmData.getName().equalsIgnoreCase(ROOT_GROUP_NAME)
								&& dmData.getDescription().equalsIgnoreCase(ROOT_GROUP_DESCRIPTION)) {
							rm.setData(new IRegisterGroupDMData() {

								@Override
								public String getName() {
									return "All Registers"; //$NON-NLS-1$
								}

								@Override
								public String getDescription() {
									return ""; //$NON-NLS-1$
								}
							});
						} else {
							rm.setData(dmData);
						}
						rm.done();
					}
				});
	}
	
	@Override
	public void getRegisterData(IRegisterDMContext regDmc, DataRequestMonitor<IRegisterDMData> rm) {
		super.getRegisterData(regDmc, new DataRequestMonitor<IRegisters.IRegisterDMData>(getExecutor(), rm) {
			@Override
			protected void handleSuccess() {
				// This is to support register description from the register file
				IRegisterDMData registerDMData = getData();
				final IFrameDMContext frameDmc = DMContexts.getAncestorOfType(regDmc, IFrameDMContext.class);
				if (registerDMData instanceof RegisterData && null != frameDmc) {
					RegisterData regData = ((RegisterData) registerDMData);
					String registerName = regData.getName();
					String registerDescription = registerDescCache.getRegisterDescription(registerName);
					if (null != registerDescription && !registerDescription.isEmpty()) {
						rm.setData(new RegisterData(frameDmc, registerName, registerDescription, regData.isFloat()));
					} else {
						rm.setData(registerDMData);
					}
				} else {
					rm.setData(new RegisterData(null, registerDMData.getName(), BLANK_STRING, false));
				}
				rm.done();
			}
		});
	}
	
	private long convertToLong(String formatId, String bitFieldValue)
	{
		String formattedBitFieldVAlue = bitFieldValue;
		if (formatId.equalsIgnoreCase(IFormattedValues.HEX_FORMAT) || formatId.equalsIgnoreCase(IFormattedValues.STRING_FORMAT)) {
			if (!bitFieldValue.startsWith("0x")) { //$NON-NLS-1$
				formattedBitFieldVAlue = "0x" + bitFieldValue; //$NON-NLS-1$
			}
		} else if (formatId.equalsIgnoreCase(IFormattedValues.OCTAL_FORMAT)) {
			if (!bitFieldValue.startsWith("0")) { //$NON-NLS-1$
				formattedBitFieldVAlue = "0" + bitFieldValue; //$NON-NLS-1$
			}
		}
		long bitFieldVal;
		if (formatId.equalsIgnoreCase(IFormattedValues.BINARY_FORMAT)) {
			bitFieldVal = Long.parseLong(bitFieldValue, 2);
		} else {
			bitFieldVal = Long.decode(formattedBitFieldVAlue);
		}
		return bitFieldVal;
	}
	
	@Override
	public void restoreDefaultGroups(IDMContext selectionContext, RequestMonitor rm) {
		if (registerDescCache != null) {
			registerGroups.clear();
			registerGroups.addAll(registerDescCache.getRegisterGroups());
		}
		super.restoreDefaultGroups(selectionContext, rm);
	}
	
	private ILaunchConfiguration getLaunchConfig() {
		ILaunch launch = (ILaunch) getSession().getModelAdapter(ILaunch.class);
		if (launch == null) {
			// The launch is no longer active
			return null;
		}
		ILaunchConfiguration config = launch.getLaunchConfiguration();
		return config;
	}
}
