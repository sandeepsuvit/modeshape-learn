/**
 * 
 */
package com.dotedlabs.app.coffer.services.impl;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.dotedlabs.app.coffer.services.FolderService;

/**
 * @author Sandeep
 *
 */
public class CofferFolderService implements FolderService {

	
	/* (non-Javadoc)
	 * @see com.dotedlabs.app.coffer.services.FolderService#createFolder(java.lang.String)
	 */
	@Override
	public Object createFolder(Object session, String folderName) {
		Node filesNode = null;
		// Create the '/files' node that is an 'nt:folder' ...
		try {
			Node root = ((Session) session).getRootNode();
			filesNode = root.addNode(folderName, "nt:folder");
			((Session) session).save();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Node) filesNode;
	}

}
