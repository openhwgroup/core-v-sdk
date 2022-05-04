package org.openhwgroup.corev.ide.wizard;

/*
 *Contributors:Promodkumar (Ashling) - initial implementation
 */
import java.util.ArrayList;
import java.util.List;

public abstract class TreeNode implements ITreeNode
{
	protected ITreeNode fParent;
	protected List fChildren;

	public TreeNode(ITreeNode parent) {
			fParent = parent;
		}

	public boolean hasChildren() {
		return true;
	}

	public ITreeNode getParent() {
		return fParent;
	}

	public List getChildren() 
	{
		if( fChildren != null )
			return fChildren;

		fChildren = new ArrayList();
		createChildren(fChildren);

		return fChildren;
	}

	/* subclasses should override this method and add the child nodes */
	protected abstract void createChildren(List children);
}


