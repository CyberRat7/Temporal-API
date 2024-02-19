package com.temporal.api.core.engine.io.strategy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DefaultPropertiesStrategy implements PropertiesStrategy {
    @Override
    public Properties findProperties() {
        Properties properties = new Properties();

        try {
            Path path = Path.of(ClassLoader.getSystemResource("api.properties").toURI());
            properties.load(Files.newBufferedReader(path));
        } catch (URISyntaxException e) {
            throw new FileSystemNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
