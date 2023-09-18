package com.ashling.riscfree.debug.opxd.core.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

import com.ashling.riscfree.debug.opxd.core.Activator;

public class Messages {
	private static final String MESSAGES = Activator.PLUGIN_ID + ".ui.messages"; //$NON-NLS-1$

	static {
		// Initialize resource bundle
		NLS.initializeMessages(MESSAGES, Messages.class);
	}

	private static ResourceBundle RESOURCE_BUNDLE;
	static {
		try {
			RESOURCE_BUNDLE = ResourceBundle.getBundle(MESSAGES);
		} catch (MissingResourceException e) {
			System.console().printf("%s", e);
		}
	}

	private Messages() {
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