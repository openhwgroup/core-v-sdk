package com.ashling.riscfree.debug.opxd.core.scanchain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rahul.Sharma
 *
 */

public class TapDetails {
	private int tapNumber;
	private int irLength;
	private int idCode;
	private String name;
	private int numberOfCores;
	private List<CoreDetails> coreDetails = new ArrayList<>();
	private boolean decimalNumberSystem = false;

	public TapDetails() {
	}

	public boolean isDecimalNumberSystem() {
		return decimalNumberSystem;
	}

	public void setDecimalNumberSystem(boolean decimalNumberSystem) {
		this.decimalNumberSystem = decimalNumberSystem;
	}

	public TapDetails(int tapNumber, int irLenght, int idCode) {
		this.tapNumber = tapNumber;
		this.irLength = irLenght;
		this.idCode = idCode;
	}

	public String getTapNumber() {
		return String.valueOf(tapNumber);
	}

	public void setTapNumber(int tapNumber) {
		this.tapNumber = tapNumber + 1;
	}

	public String getIrLength() {
		return String.valueOf(irLength);
	}

	public void setIrLength(int irLength) {
		this.irLength = irLength;
	}

	public String getIdCode() {
		return String.valueOf(idCode);
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public String getIdCodeInString() {
		if (this.decimalNumberSystem) {
			return Integer.toString(this.idCode);
		} else {
			return "0x" + Integer.toHexString(this.idCode).toUpperCase();
		}

	}

	public String getFormattedIdCodeString() {
		StringBuilder formattedBuffer = new StringBuilder();
		formattedBuffer.append("0x");
		String idCodeHexString = Integer.toHexString(this.idCode);
		//Fill zeros to make 8 digits
		for (int i = idCodeHexString.length()+1; i <= 8; i++) {
			formattedBuffer.append("0");
		}
		formattedBuffer.append(idCodeHexString.toUpperCase());
		return formattedBuffer.toString();
	}

	public List<CoreDetails> getCoreDetails() {
		return coreDetails;
	}

	public void setCoreDetails(List<CoreDetails> coreDetails) {
		this.coreDetails = coreDetails;
	}

	public int getNumberofCores() {
		return numberOfCores;
	}

	public void setNumberofCores(int numberofCores) {
		this.numberOfCores = numberofCores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCoreDetails(CoreDetails coreDetails) {
		this.coreDetails.add(coreDetails);
	}

	@Override
	public String toString() {
		return "TapDetails [tapNumber=" + tapNumber + ", irLength=" + irLength + ", idCode=" + idCode + ", name=" + name
				+ ", numberOfCores=" + numberOfCores + ", decimalNumberSystem="
				+ decimalNumberSystem + "]";
	}
}
