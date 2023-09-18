/**
 * 
 */
package com.ashling.riscfree.debug.ease.ui;

import java.util.List;


/**
 * @author vinod.appu 
 * This view should be passing to the Script layer as a variable. Use
 *         'custom_view' as the name. Using the name the object can be accessed from Script layer
 *  
 *  Script for configuring view should call the API's in following order
 *  setColumnCount(), setIconFolderName(), setColumnHeaders(), setColumnWidthArray(), createView()
 *  
 *  Script for updating the contents should call setInput method. List of list can be used to create a tree view.
 *
 */
public interface IEASEView {

	/**
	 * Specify the number of columns needed for the view via this method
	 * @param columnCount
	 */
	public void setColumnCount(int columnCount);
	
	/**
	 * Set the icon folder for this view using this method. The icon name should be the name of string which is used.
	 * @param folderName
	 */

	public void setIconFolderName(String folderName);

	/**
	 * Sets the column headers. The headers should be in order from first to last
	 * @param columnHeaders
	 */
	public void setColumnHeaders(List<String> columnHeaders);

	/**
	 * Sets the column width of the viewer according to the given list of widths
	 * @param columnWidthArray
	 */
	public void setColumnWidthArray(List<Integer> columnWidthArray);

	/**
	 * Creates the view according to the column headers, column width and column number
	 */
	public void createView();
	
	
	/**
	 * Sets the input to the view, this should update the data in the view
	 * 
	 * {@code} Below is a sample python script usage <br>
	 * columns = ['column header 1', 'column header 2'] <br>
     *
     * taskListColumnWidth = [ <br>
     * 125,  # column header 1 width <br>
     * 80  # column header 2  width <br>
     * ] <br>

     * custom_view.setColumnCount(len(taskListColumns)) <br>
     * custom_view.setColumnWidthArray(taskListColumnWidth) <br>
     * custom_view.setColumnHeaders(taskListColumns) <br>
     * custom_view.setIconFolderName(script_location+"\\icons") <br>
     * custom_view.createView() <br>
     * 
	 * @param viewInput
	 */
	public void setInput(List<?> viewInput);
	
	/**
	 * This is to set the view is auto expanded or not. 
	 * @return true-> Auto expanded view, false-> Not an auto expanding view
	 */
	public boolean isAutoexpandedView();
	
	
	/**
	 * This is to set search for the view
	 * @return true-> Search Enabled, false-> No Search
	 * 
	 */
	public boolean isSearchEnabled();
	
	
	/**
	 * This is to set search tokens for the view
	 * @return String array of columns
	 * 
	 */
	public String[] getSearchFilters();
}
