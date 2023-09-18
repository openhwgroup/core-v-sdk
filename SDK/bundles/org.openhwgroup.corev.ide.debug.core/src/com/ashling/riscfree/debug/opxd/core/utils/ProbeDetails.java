package com.ashling.riscfree.debug.opxd.core.utils;

import java.util.Optional;

/*
 * @author Promodkumar
 * @implNote Class to handle the probe details
 */
public class ProbeDetails {

	private String number;
	private String name;
	private boolean isAutoClockSupported;

	public ProbeDetails(String probeNumber, String probeName, String isAutoClockSupported) {
		this.number = probeNumber;
		this.name = probeName;
		this.isAutoClockSupported = Optional.ofNullable(isAutoClockSupported).map(Boolean::valueOf).orElse(false);
	}

	public String getProbeNumber() {
		return number;
	}

	public String getProbeName() {
		return name;
	}

	public boolean isAutoClockSupported() {
		return isAutoClockSupported;
	}
}
