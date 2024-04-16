package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.engine.metadata.annotation.*;
import com.temporal.api.core.engine.metadata.strategy.field.DependencyStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.InjectionStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.RegistryStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.ExecutionStrategy;
import com.temporal.api.core.engine.metadata.strategy.scan.AnnotationScanStrategy;
import com.temporal.api.core.engine.metadata.strategy.scan.SimpleAnnotationScanStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.InjectedStrategy;

import java.util.Set;

public class AnnotationExecutor {
    private AnnotationScanStrategy annotationScanStrategy;
    private ClassAnnotationStrategy injectedStrategy;
    private FieldAnnotationStrategy injectionStrategy;
    private FieldAnnotationStrategy registryStrategy;
    private FieldAnnotationStrategy dependencyStrategy;
    private MethodAnnotationStrategy executionStrategy;

    public AnnotationExecutor() {
        this.annotationScanStrategy = new SimpleAnnotationScanStrategy();
        this.injectedStrategy = new InjectedStrategy();
        this.injectionStrategy = new InjectionStrategy();
        this.registryStrategy = new RegistryStrategy();
        this.dependencyStrategy = new DependencyStrategy();
        this.executionStrategy = new ExecutionStrategy();
    }

    public void execute() {
        try {
            ApiMod.LOGGER.info("Annotation Strategy has been started: strategy - {}, class - {}", annotationScanStrategy.getClass().getSimpleName(), IOLayer.DEPENDENCY_INFO.getModClass().getSimpleName());
            Set<Class<?>> classes = this.annotationScanStrategy.scan();
            AnnotationHelper helper = AnnotationHelper.getInstance();
            helper.setClasses(classes);
            helper.executeStrategy(this.injectedStrategy, Injected.class);
            helper.executeStrategy(this.injectionStrategy, Injection.class);
            helper.executeStrategy(this.registryStrategy, Registry.class);
            helper.executeStrategy(this.dependencyStrategy, Dependency.class);
            helper.executeStrategy(this.executionStrategy, Execution.class);
        } catch (Exception e) {
            ApiMod.LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public AnnotationScanStrategy getAnnotationScanStrategy() {
        return annotationScanStrategy;
    }

    public void setAnnotationScanStrategy(AnnotationScanStrategy annotationScanStrategy) {
        this.annotationScanStrategy = annotationScanStrategy;
    }

    public ClassAnnotationStrategy getInjectedStrategy() {
        return injectedStrategy;
    }

    public void setInjectedStrategy(ClassAnnotationStrategy injectedStrategy) {
        this.injectedStrategy = injectedStrategy;
    }

    public FieldAnnotationStrategy getInjectionStrategy() {
        return injectionStrategy;
    }

    public void setInjectionStrategy(FieldAnnotationStrategy injectionStrategy) {
        this.injectionStrategy = injectionStrategy;
    }

    public FieldAnnotationStrategy getRegistryStrategy() {
        return registryStrategy;
    }

    public void setRegistryStrategy(FieldAnnotationStrategy registryStrategy) {
        this.registryStrategy = registryStrategy;
    }

    public FieldAnnotationStrategy getDependencyStrategy() {
        return dependencyStrategy;
    }

    public void setDependencyStrategy(FieldAnnotationStrategy dependencyStrategy) {
        this.dependencyStrategy = dependencyStrategy;
    }

    public MethodAnnotationStrategy getExecutionStrategy() {
        return executionStrategy;
    }

    public void setExecutionStrategy(MethodAnnotationStrategy executionStrategy) {
        this.executionStrategy = executionStrategy;
    }
}