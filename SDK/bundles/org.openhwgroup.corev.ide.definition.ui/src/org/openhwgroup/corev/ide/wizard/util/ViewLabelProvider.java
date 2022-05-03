package org.openhwgroup.corev.ide.wizard.util;

import org.eclipse.jface.viewers.LabelProvider;

import org.openhwgroup.corev.ide.wizard.ITreeNode;

public class ViewLabelProvider extends LabelProvider 
{
	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		return ((ITreeNode)element).getName();

	}
}
