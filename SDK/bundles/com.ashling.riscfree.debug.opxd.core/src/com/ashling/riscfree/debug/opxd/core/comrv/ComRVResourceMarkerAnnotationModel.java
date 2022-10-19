package com.ashling.riscfree.debug.opxd.core.comrv;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import com.ashling.riscfree.debug.opxd.core.ui.Messages;

public class ComRVResourceMarkerAnnotationModel {

	public static final String MARKER_ID = "com.ashling.comrv.marker";

	public static IMarker createMarker(IResource res, int line) throws CoreException {

		IMarker marker = null;
		// note: you use the id that is defined in your plugin.xml

		if (res != null) {
			marker = res.createMarker(MARKER_ID);
			marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			marker.setAttribute(IMarker.MESSAGE, Messages.getString("Comrv.marker_message"));
			marker.setAttribute(IMarker.LINE_NUMBER, line);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		}
		return marker;

	}

}