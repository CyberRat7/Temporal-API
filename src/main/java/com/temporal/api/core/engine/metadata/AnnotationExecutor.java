package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.engine.metadata.strategy.*;

import java.util.Set;

public class AnnotationExecutor {
    private static volatile AnnotationExecutor instance;
    private AnnotationScanStrategy annotationScanStrategy;
    private ClassAnnotationStrategy loggingRegistryAnnotationStrategy;

    private AnnotationExecutor() {
        this.annotationScanStrategy = new SimpleAnnotationScanStrategy();
    }

    public void execute() {
        try {
            AnnotationHelper helper = AnnotationHelper.getInstance();
            Class<?> modClass = IOLayer.DEPENDENCY_INFO.getModClass();
            if (helper.checkAnnotationPresented(modClass, AnnotationScan.class)) {
                ApiMod.LOGGER.info("Annotation Strategy has been started: strategy - {}, class - {}", annotationScanStrategy.getClass().getSimpleName(), modClass.getSimpleName());
                Set<Class<?>> classes = this.annotationScanStrategy.execute(modClass);
            } else {
                ApiMod.LOGGER.warn("Annotation Scan hasn't been performed!");
            }
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

    public ClassAnnotationStrategy getLoggingRegistryAnnotationStrategy() {
        return loggingRegistryAnnotationStrategy;
    }

    public void setLoggingRegistryAnnotationStrategy(ClassAnnotationStrategy loggingRegistryAnnotationStrategy) {
        this.loggingRegistryAnnotationStrategy = loggingRegistryAnnotationStrategy;
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
