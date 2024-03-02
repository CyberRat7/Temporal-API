package com.temporal.api.core.engine;

import com.temporal.api.core.engine.io.DependencyInfo;
import com.temporal.api.core.engine.io.strategy.DefaultPropertiesStrategy;
import com.temporal.api.core.engine.io.DependencyPropertiesManager;

public class IOLayer implements EngineLayer {
    public static volatile DependencyInfo DEPENDENCY_INFO;

    @Override
    public void processAllTasks(Class<?> modClass) {
        DEPENDENCY_INFO = new DependencyInfo(new DependencyPropertiesManager(new DefaultPropertiesStrategy(), modClass));
    }
}
