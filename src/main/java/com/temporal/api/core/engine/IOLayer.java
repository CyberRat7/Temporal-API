package com.temporal.api.core.engine;

import com.temporal.api.core.engine.io.DependencyInfo;
import com.temporal.api.core.engine.io.strategy.DefaultPropertiesStrategy;
import com.temporal.api.core.engine.io.DependencyPropertiesManager;

public class IOLayer implements EngineLayer {
    public static final DependencyPropertiesManager DEPENDENCY_PROPERTIES_MANAGER = new DependencyPropertiesManager(new DefaultPropertiesStrategy());
    public static volatile DependencyInfo DEPENDENCY_INFO = new DependencyInfo(DEPENDENCY_PROPERTIES_MANAGER);

    @Override
    public void processAllTasks() {
        DEPENDENCY_INFO = new DependencyInfo(DEPENDENCY_PROPERTIES_MANAGER);
    }
}
