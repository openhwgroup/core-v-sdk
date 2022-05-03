package org.openhwgroup.corev.ide.wizard.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.eclipse.osgi.util.NLS;
import org.openhwgroup.corev.ide.definition.Activator;


/**
 * LabelsHandle class manage the messages, labels and title for the Dialog.
 * Contributors:Promodkumar (Ashling) - initial implementation 
 */
public class LabelsHandle {
	private static final String LABELS = Activator.PLUGIN_ID + ".wizard.util.Labels"; //$NON-NLS-1$

	static {
		// Initialize resource bundle
		NLS.initializeMessages(LABELS, LabelsHandle.class);
	}

	private static ResourceBundle RESOURCE_BUNDLE;
	static {
		try {
			RESOURCE_BUNDLE = ResourceBundle.getBundle(LABELS);
		} catch (MissingResourceException e) {
			System.console().printf("%s", e); //$NON-NLS-1$
		}
	}

	private LabelsHandle() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}
}