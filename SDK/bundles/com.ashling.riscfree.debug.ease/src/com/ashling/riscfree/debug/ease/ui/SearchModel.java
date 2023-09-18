package com.ashling.riscfree.debug.ease.ui;

import org.eclipse.swt.widgets.TreeItem;

/*
 * 
 * This is a model class which is used to store the
 * TreeItem and column which contain the search text 
 */
public class SearchModel {

	TreeItem treeItem;
	int columnIndex;

	public SearchModel(TreeItem treeItem, int columnIndex) {
		this.treeItem = treeItem;
		this.columnIndex = columnIndex;
	}

	public TreeItem getTreeItem() {
		return treeItem;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SearchModel) {
			SearchModel temp = (SearchModel) obj;
			if (this.treeItem == temp.treeItem && this.columnIndex == temp.columnIndex)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.treeItem.hashCode());
	}
}
