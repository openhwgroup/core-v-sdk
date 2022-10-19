package com.ashling.riscfree.debug.opxd.core.scanchain;

/**
 * @author Rahul.Sharma
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ScanChain {

	private List<TapDetails> listOfTaps = new ArrayList<>();

	public ScanChain() {

	}

	public void addTapDetails(TapDetails tapdetails) {
		this.listOfTaps.add(tapdetails);
	}

	public List<TapDetails> getTaps() {
		return this.listOfTaps;

	}

}
