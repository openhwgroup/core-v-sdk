/**
 * 
 */
package com.ashling.riscfree.debug.opxd.core.comrv;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ashling.riscfree.debug.opxd.core.Activator;

/**
 * @author vinod.appu
 *
 */
public class MapFileParser {

	private static final String OVERLAY_SECTION_END_STRING = "Overlay thunk summary";
	private static final String OVERLAY_SECTION_START_STRING = "Overlay summary";
	private Map<String, OverlaySymbol> overlaySymbolMap = new HashMap<>();
	private Map<String, String> symbolsMap = new HashMap<>();

	public List<OverlayGroup> parseOverlayMapFile(String mapFilePath) {
		List<OverlayGroup> overlayGroups = new LinkedList<>();
		File f = new File(mapFilePath);
		if (f.exists()) {
			try (Scanner sc = new Scanner(f)) {
				boolean overlaySectionStarted = false;
				while (sc.hasNextLine()) {
					String line = sc.nextLine();

					if (line.startsWith(OVERLAY_SECTION_END_STRING)) {
						break; // Overlay section ends here
					} else if (line.startsWith(OVERLAY_SECTION_START_STRING)) {
						overlaySectionStarted = true;
					} else {
						line = removeExtraSpace(line);
						if (overlaySectionStarted) {
							if (line.startsWith("Group")) {
								OverlayGroup overlayGroup = createOverlaygroup(line);
								overlayGroups.add(overlayGroup);
							} else if (line.startsWith("Padding")) {
								// Updating last created overlays padding here
								overlayGroups.get(overlayGroups.size() - 1)
										.setPadding(Long.valueOf(line.split("\\s")[3].trim()));
							} else if (line.startsWith("CRC:")) {
								// Updating last created overlays crc here
								overlayGroups.get(overlayGroups.size() - 1)
										.setCRC(Long.valueOf(line.split("\\s")[1].trim(), 16));
							} else if (line.startsWith(">")) {
								OverlayGroup presentGroup = overlayGroups.get(overlayGroups.size() - 1);
								OverlaySymbol overlaySymbol = parseOverlaySymbols(presentGroup, line);								
								presentGroup.addOverlaySymbol(overlaySymbol);
							}
						}
					}
				}
			} catch (IOException ex) {
				Activator.log(ex);
			}
		}
		return overlayGroups;
	}

	private OverlaySymbol parseOverlaySymbols(OverlayGroup group, String symbolLine) {
		String[] symbolInfo = symbolLine.split("\\s");
		String symbolName = symbolInfo[2];
		OverlaySymbol overlaySymbol = overlaySymbolMap.get(symbolName);
		String virtualAddress = symbolInfo[1].substring(0, symbolInfo[1].length() - 1);
		String token = symbolInfo[4].substring(0, symbolInfo[4].length() - 1);
		symbolsMap.put(symbolName, virtualAddress);
		OverlayGroupInfo overlayGroupInfo = new OverlayGroupInfo(Long.parseLong(virtualAddress, 16), token, group);
		if (overlaySymbol != null) {
			overlaySymbol.addGroupInfo(overlayGroupInfo);
		} else {
			overlaySymbol = new OverlaySymbol(symbolName, overlayGroupInfo);
			overlaySymbolMap.put(symbolName, overlaySymbol);
		}

		return overlaySymbol;
	}

	private String removeExtraSpace(String inputString) {
		return inputString.trim().replaceAll("( )+", " ");
	}

	private OverlayGroup createOverlaygroup(String groupLine) {
		String[] groupLineStrings = groupLine.split("\\s+");
		String[] startEnd = groupLineStrings[2].split("-");
		return new OverlayGroup(Integer.parseInt(groupLineStrings[1]), Long.parseLong(startEnd[0].substring(1), 16),
				Long.parseLong(startEnd[1].substring(0, startEnd[1].length() - 1), 16),
				Long.parseLong(groupLineStrings[3], 16));
	}

	public Map<String, String> getSymbolMap() {
		return symbolsMap;
	}

}
