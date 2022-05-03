package org.openhwgroup.corev.ide.wizard;

/*
 *Contributors:Promodkumar (Ashling) - initial implementation
 */

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.openhwgroup.corev.ide.wizard.util.LabelsHandle;

public class ImportWizard extends Wizard implements IImportWizard {
	
	private SampleProjectSelectionWizard mainPage;

	public ImportWizard() {
		super();
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(LabelsHandle.getString("ImportWizard.Sample.WizardTitle")); //NON-NLS-1 //$NON-NLS-1$
		setNeedsProgressMonitor(true);
		mainPage = new SampleProjectSelectionWizard(LabelsHandle.getString("ImportWizard.Sample.WizardTitle"),selection); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }
    @Override
    public boolean performFinish() {
        mainPage.performFinish();
        return true;
    }

}