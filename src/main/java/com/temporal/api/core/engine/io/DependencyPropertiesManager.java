package com.temporal.api.core.engine.io;

import com.temporal.api.core.engine.io.strategy.PropertiesStrategy;

import java.util.Properties;

public class DependencyPropertiesManager {
    private PropertiesStrategy propertiesStrategy;
    private Properties properties;

    public DependencyPropertiesManager(PropertiesStrategy propertiesStrategy) {
        this.propertiesStrategy = propertiesStrategy;
    }

    public void processLookingUp() {
        this.setProperties(propertiesStrategy.findProperties());
    }

    public final String getModId() {
        return (String) properties.get("modId");
    }

    public final Class<?> getModClass() {
        try {
            return Class.forName((String) properties.get("modClass"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PropertiesStrategy getPropertiesStrategy() {
        return propertiesStrategy;
    }

    public void setPropertiesStrategy(PropertiesStrategy propertiesStrategy) {
        this.propertiesStrategy = propertiesStrategy;
    }

    public Properties getProperties() {
        return properties;
    }

    private void setProperties(Properties properties) {
        this.properties = properties;
    }
}
