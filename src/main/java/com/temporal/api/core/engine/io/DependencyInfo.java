package com.temporal.api.core.engine.io;

import java.util.Properties;

public class DependencyInfo {
    private final Properties properties;

    public DependencyInfo(DependencyPropertiesManager dependencyPropertiesManager) {
        dependencyPropertiesManager.processLookingUp();
        this.properties = dependencyPropertiesManager.getProperties();
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
}
