package com.temporal.api.core.engine;

import com.temporal.api.core.engine.io.DependencyInfo;
import com.temporal.api.core.engine.io.strategy.DefaultPropertiesStrategy;
import com.temporal.api.core.engine.io.DependencyPropertiesManager;

public class IOLayer implements EngineLayer {
    public static volatile DependencyInfo DEPENDENCY_INFO;
    private Class<?> modClass;

    @Override
    public void processAllTasks() {
        DEPENDENCY_INFO = new DependencyInfo(new DependencyPropertiesManager(new DefaultPropertiesStrategy(), modClass));
    }

    public Class<?> getModClass() {
        return modClass;
    }

    public void setModClass(Class<?> modClass) {
        this.modClass = modClass;
    }
}
