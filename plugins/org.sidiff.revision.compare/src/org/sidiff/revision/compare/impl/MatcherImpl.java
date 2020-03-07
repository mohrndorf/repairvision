package org.sidiff.revision.compare.impl;

import org.sidiff.revision.compare.Match;
import org.sidiff.revision.compare.Matcher;
import org.sidiff.revision.compare.matching.Matching;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;
import org.sidiff.revision.model.ModelSet;

/**
 * A basic configurable matcher implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class MatcherImpl implements Matcher {

	@ConfigProperties
	public enum Properties {
	}

	@ConfigField
	protected Configuration config;

	@ConfigSettings
	protected Settings<Properties> settings;

	/**
	 * @param config An un- or a pre-configured configuration for this component.
	 */
	public MatcherImpl(Configuration config) {
		configure(config);
	}
	
	public MatcherImpl() {
		this(null);
	}

	@Override
	public void configureDefaultFactories(Configuration config) {
		settings.setFactory(Matching.class, Matching.class);
	}

	@Override
	public boolean canHandle(ModelSet model) {
		return true; // TODO: Based on doc-type
	}

	@Override
	public Match match(ModelSet modelA, ModelSet modelB) {
		Matching matching = settings.create(Matching.class, modelA, modelB, config);
		return matching.match();
	}

}
