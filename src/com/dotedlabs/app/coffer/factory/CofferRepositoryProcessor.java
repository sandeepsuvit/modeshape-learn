package com.dotedlabs.app.coffer.factory;

import java.net.URL;

import org.modeshape.common.collection.Problems;
import org.modeshape.example.sequencing.ModeShapeExample;
import org.modeshape.jcr.RepositoryConfiguration;

public class CofferRepositoryProcessor implements RepositoryProcessor {
	private static final String CONFIG_FILE = "com/dotedlabs/app/coffer/config/coffer-repository-config.json";

	/**
	 * Get the repository configured
	 * 
	 * @return
	 */
	public RepositoryConfiguration getConfig() {
		RepositoryConfiguration config = null;
		try {
			URL url = ModeShapeExample.class.getClassLoader().getResource(
					CONFIG_FILE);
			config = RepositoryConfiguration.read(url);

			// Verify the configuration for the repository ...
			Problems problems = config.validate();
			if (problems.hasErrors()) {
				throw new Exception("Problems starting the engine. " + problems);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return config;
	}

	/**
	 * Get the repository configured based on the configuration file
	 * 
	 * TODO Modify the interface to accept config file name
	 * 
	 * @param configFile
	 * @return
	 */
	public RepositoryConfiguration getConfig(String configFile) {
		RepositoryConfiguration config = null;
		try {
			URL url = ModeShapeExample.class.getClassLoader().getResource(
					configFile);
			config = RepositoryConfiguration.read(url);

			// Verify the configuration for the repository ...
			Problems problems = config.validate();
			if (problems.hasErrors()) {
				throw new Exception("Problems starting the engine. " + problems);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return config;
	}

}
