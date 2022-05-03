package org.openhwgroup.corev.ide.wizard;

import java.util.List;
/*
 *Contributors:Promodkumar (Ashling) - initial implementation
 */
public interface ITreeNode
{
	public String getName();

	public List getChildren();

	public boolean hasChildren();

	public ITreeNode getParent();
}