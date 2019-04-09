package org.sidiff.history.repository;

import org.eclipse.emf.common.util.URI;

public interface IModelRepositoryConnector {

	/**
	 * @param resource
	 *            A model resource.
	 * @return <code>true</code> if the resource is connected to the repository;
	 *         <code>false</code> otherwise.
	 */
	boolean canHandle(URI resource);
	
	/**
	 * @param resource
	 *            A model resource.
	 * @return The associated repository version.
	 */
	IModelVersion getModelVersion(URI resource);
}
