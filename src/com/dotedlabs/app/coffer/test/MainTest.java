package com.dotedlabs.app.coffer.test;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;

import org.modeshape.jcr.RepositoryConfiguration;

import com.dotedlabs.app.coffer.engine.CofferEngine;
import com.dotedlabs.app.coffer.factory.RepositoryFactory;
import com.dotedlabs.app.coffer.services.FolderService;
import com.dotedlabs.app.coffer.services.impl.CofferFolderService;

public class MainTest {

	public static void main(String[] args) throws Exception {
		

		Repository repository = null;
		String repositoryName = null;

		RepositoryConfiguration configuration = (RepositoryConfiguration) RepositoryFactory
				.getInstance("COFFER_REPO").getConfig();

		CofferEngine engine = new CofferEngine();
		
		try {
			// Deploy the repository ...
			repository = engine.start().deploy(configuration);
			repositoryName = configuration.getName();

		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
			return;
		}
		
		//repository = engine.getRepository(repositoryName);
		// Create a session ...
		Session session = repository.login("default");
		
		FolderService folderService = new CofferFolderService();
		Node test = (Node) folderService.createFolder(session, "Image");
		
		System.out.println(test.getProperty("jcr:createdBy").getString());
		System.out.println(test.getProperty("jcr:created").getDate());
		
		if (session != null) session.logout();
		System.out.println("Shutting down engine ...");
		engine.shutDown();
	}

}
