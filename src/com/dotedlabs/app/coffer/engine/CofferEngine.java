/**
 * 
 */
package com.dotedlabs.app.coffer.engine;

import java.util.concurrent.ExecutionException;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;

import org.modeshape.jcr.ConfigurationException;
import org.modeshape.jcr.ModeShapeEngine;
import org.modeshape.jcr.NoSuchRepositoryException;
import org.modeshape.jcr.RepositoryConfiguration;

/**
 * @author Sandeep
 *
 */
public class CofferEngine {

	private ModeShapeEngine engine;

	/**
	 * Method to start the Coffer engine
	 * 
	 * @return
	 */
	public ModeShapeEngine start() {
		// Create and start the engine ...
		engine = new ModeShapeEngine();
		engine.start();
		return engine;
	}

	/**
	 * Force shutdown of the Coffer engine
	 * 
	 * @return
	 */
	public Boolean shutDown() {
		try {
			return engine.shutdown(true).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Deploy Repository in the engine using the configuration
	 * 
	 * Not required
	 * 
	 * @param configuration
	 * @return
	 */
	public Repository deploy(RepositoryConfiguration configuration) {
		try {
			return engine.deploy(configuration);
		} catch (ConfigurationException | RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns the repository details based on the repository name that is
	 * passed
	 * 
	 * @param repositoryName
	 * @return
	 */
	public Repository getRepository(String repositoryName) {
		try {
			return engine.getRepository(repositoryName);
		} catch (NoSuchRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
