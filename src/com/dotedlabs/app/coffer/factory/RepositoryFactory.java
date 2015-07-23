package com.dotedlabs.app.coffer.factory;

/**
 * 
 * @author Sandeep
 *
 */
public class RepositoryFactory {
	private static RepositoryProcessor instance;

	/**
	 * @return the instance
	 * @throws Exception
	 */
	public static RepositoryProcessor getInstance(String repositoryInstance)
			throws Exception {
		switch (repositoryInstance) {

		case "COFFER_REPO":
			instance = new CofferRepositoryProcessor();
			break;

		// Add other repositories here

		default:
			throw new Exception("No Repository of name " + repositoryInstance
					+ " found.");
		}
		return instance;
	}

}
