package com.ashling.riscfree.debug.ease.ui;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Promodkumar This is a custom combo control which used in the menu
 */
class ComboContributionItem extends ControlContribution {

	private Combo combo;
	private String toolTipText;

	public ComboContributionItem(String id) {
		super(id);
		toolTipText = id;
	}

	@Override
	protected Control createControl(Composite parent) {
		combo = new Combo(parent, SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL);
		combo.setToolTipText(toolTipText);
		return combo;
	}

	public Combo getComboControl() {
		return combo;
	}

	@Override
	public int computeWidth(Control control) {
		// The widget is now 100 pixels. You can new GC gc = new GC(control) and
		// use the gc.stringExtent(String) method to help compute a more dynamic
		// width.
		return 100;
	}
}