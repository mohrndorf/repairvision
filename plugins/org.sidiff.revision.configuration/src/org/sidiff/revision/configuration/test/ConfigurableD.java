package org.sidiff.revision.configuration.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;

public class ConfigurableD implements Configurable {

	@ConfigProperties
	public enum Properties {
		PROPERTY_D1,
		PROPERTY_D2,
	}
	
	@ConfigField
	public Configuration config;
	
	@ConfigSettings
	public Settings<Properties> settings;
	
	public ConfigurableD(Configuration config) {
		configure(config);
	}

	@Override
	public void configureDefaultSettings(Configuration config) {
		settings.setProperty(Properties.PROPERTY_D1, "Hallo");
		settings.setProperty(Properties.PROPERTY_D1, "Welt");
	}
	
	@Override
	public void configureDefaultFactories(Configuration config) {
		settings.setFactory(List.class, ArrayList.class);
		settings.setFactory(Set.class, HashSet.class);
	}
	
	@Override
	public void configureDefaultSingletons(Configuration config) {
		settings.setSingleton(List.class, Collections.singletonList("Hallo"));
		settings.setSingleton(Set.class, Collections.singleton("Welt"));
	}
	
	public Configuration getConfig() {
		return config;
	}

	public Settings<Properties> getSettings() {
		return settings;
	}
}
