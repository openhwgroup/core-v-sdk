package org.openhwgroup.corev.ide.wizard;

import java.util.List;

/*
 *Contributors:Promodkumar (Ashling) - initial implementation
 */
public class FileNode extends TreeNode
{
	private String name; /* actual data object */

	public FileNode(ITreeNode parent, String name) {
		super(parent);
		String nameWithoutextension = name.split("\\.")[0]; //$NON-NLS-1$
		this.name = nameWithoutextension;
	}

	public String getName() {
		return this.name;
	}

	protected void createChildren(List children) {
		// empty
	}

	public boolean hasChildren() {
		return false;
	}
}