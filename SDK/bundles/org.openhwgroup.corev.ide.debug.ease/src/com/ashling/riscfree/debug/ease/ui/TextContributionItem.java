package com.ashling.riscfree.debug.ease.ui;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Promodkumar
 * This is a custom text control which used in the menu 
 */
public class TextContributionItem extends ControlContribution {

    private final int style;
    private Text text;

    public TextContributionItem(String id) {
        this(id, SWT.BORDER | SWT.SINGLE);
    }

    public TextContributionItem(String id, int style) {
        super(id);
        this.style = style;
    }

    @Override
    protected Control createControl(Composite parent) {
        text = new Text(parent, style);
        return text;
    }
    public Text getTextControl() {
        return text;
    }
    
    public String getText() {
    	return text.getText();
    }
    
    @Override
    public int computeWidth(Control control) {
        return 100;
    }
}