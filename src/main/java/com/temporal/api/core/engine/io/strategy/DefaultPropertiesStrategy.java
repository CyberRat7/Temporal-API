package com.temporal.api.core.engine.io.strategy;

import com.temporal.api.core.engine.exception.InvalidNamingException;

import java.util.Properties;

public class DefaultPropertiesStrategy implements PropertiesStrategy {
    @Override
    public Properties findProperties(Class<?> modClass) {
        Properties properties = new Properties();
        try {
            properties.put("modId", modClass.getDeclaredField("MOD_ID").get(null));
            properties.put("modClass", modClass.getName());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new InvalidNamingException("Mod ID field should be named as \"MOD_ID\"!" + e.getMessage());
        }

        return properties;
    }
}
