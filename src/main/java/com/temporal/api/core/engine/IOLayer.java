package com.temporal.api.core.engine;

import com.temporal.api.core.engine.io.strategy.DefaultPropertiesStrategy;
import com.temporal.api.core.engine.io.DependencyPropertiesManager;

public class IOLayer implements EngineLayer {
    public static final DependencyPropertiesManager DEPENDENCY_PROPERTIES_MANAGER = new DependencyPropertiesManager(new DefaultPropertiesStrategy());

    @Override
    public void processAllTasks() {
        DEPENDENCY_PROPERTIES_MANAGER.processLookingUp();
    }
}
