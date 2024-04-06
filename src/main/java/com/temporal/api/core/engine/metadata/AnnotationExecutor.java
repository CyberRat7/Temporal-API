package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.engine.metadata.annotation.DependencyContainer;
import com.temporal.api.core.engine.metadata.strategy.*;

import java.util.Set;

public class AnnotationExecutor {
    private static volatile AnnotationExecutor instance;
    private AnnotationScanStrategy annotationScanStrategy;
    private AnnotationStrategy dependencyContainerStrategy;

    private AnnotationExecutor() {
        this.annotationScanStrategy = new SimpleAnnotationScanStrategy();
        this.dependencyContainerStrategy = new DependencyContainerStrategy();
    }

    public void execute() {
        try {
            ApiMod.LOGGER.info("Annotation Strategy has been started: strategy - {}, class - {}", annotationScanStrategy.getClass().getSimpleName(), IOLayer.DEPENDENCY_INFO.getModClass().getSimpleName());
            Set<Class<?>> classes = this.annotationScanStrategy.scan();
            AnnotationHelper helper = AnnotationHelper.getInstance();
            helper.executeStrategy(this.dependencyContainerStrategy, classes, DependencyContainer.class, null);
        } catch (Exception e) {
            ApiMod.LOGGER.error(e.getMessage());
        }
    }

    public AnnotationScanStrategy getAnnotationScanStrategy() {
        return annotationScanStrategy;
    }

    public void setAnnotationScanStrategy(AnnotationScanStrategy annotationScanStrategy) {
        this.annotationScanStrategy = annotationScanStrategy;
    }

    public AnnotationStrategy getDependencyContainerStrategy() {
        return dependencyContainerStrategy;
    }

    public void setDependencyContainerStrategy(AnnotationStrategy dependencyContainerStrategy) {
        this.dependencyContainerStrategy = dependencyContainerStrategy;
    }

    public static AnnotationExecutor getInstance() {
        if (instance == null) {
            synchronized (AnnotationExecutor.class) {
                if (instance == null) {
                    instance = new AnnotationExecutor();
                }
            }
        }

        return instance;
    }
}
