package org.openhwgroup.corev.ide.wizard;

import java.io.File;
import java.util.List;

import org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileManipulations;
import org.openhwgroup.corev.ide.wizard.util.LabelsHandle;

/*
 *Contributors:Promodkumar (Ashling) - initial implementation
 */
public class FolderNode extends TreeNode {
	private File fFolder; /* actual data object */

	public FolderNode(File folder) {
		this(null, folder);
	}

	public FolderNode(ITreeNode parent, File folder) {
		super(parent);
		fFolder = folder;
	}

	public String getName() {
		return fFolder.getName();
	}

	@Override
	protected void createChildren(List children) {
		File[] childFiles = fFolder.listFiles();

		for (File childFile : childFiles) {
			if (childFile.toString()
					.contains(LabelsHandle.getString("ImportWizard.SampleProjectSelectionWizard.FolderName"))) { //$NON-NLS-1$
				if (childFile.isDirectory()) {
					children.add(new FolderNode(this, childFile));
				} else if (ArchiveFileManipulations.isTarFile(childFile.getPath())
						|| ArchiveFileManipulations.isZipFile(childFile.getPath())) {
					children.add(new FileNode(this, childFile.getName()));
				}
			}

		}
	}
}
