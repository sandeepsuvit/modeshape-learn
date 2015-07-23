/**
 * 
 */
package com.dotedlabs.app.coffer.services;


/**
 * @author Sandeep
 *
 */
public interface FolderService {
	/**
	 * Create a folder in the repository
	 * 
	 * @param folderName
	 */
	public Object createFolder(Object session, String folderName);
}
