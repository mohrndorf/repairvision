package org.sidiff.history.repository.svnkit;

import org.sidiff.history.repository.IModelHistory;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelVersion;

public class SVNModelRepository implements IModelRepository {

	@Override
	public IModelHistory getModelVersions(IModelVersion modelVersion) {
		return new SVNModelHistory((SVNModelVersion) modelVersion);
	}
	
}
