package com.temporal.api.core.engine.io.metadata;

import com.temporal.api.core.engine.io.IOHelper;
import com.temporal.api.core.engine.io.metadata.annotation.*;
import com.temporal.api.core.engine.io.metadata.strategy.field.*;
import com.temporal.api.core.engine.io.metadata.strategy.method.ExecutionStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.InjectedStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.RegistryClassStrategy;

import java.util.Set;

public class DefaultAnnotationExecutor implements AnnotationExecutor {
    private volatile Set<Class<?>> classes;
    private volatile AnnotationStrategyExecutor strategyExecutor;

    @Override
    public void prepareBeforeExecution(Class<?> dependencyClass) {
        this.classes = IOHelper.getAllClasses(dependencyClass, Injected.class);
        this.strategyExecutor = DefaultAnnotationStrategyExecutor.getInstance();
    }

    @Override
    public void executeClassAnnotations() {
        final ClassAnnotationStrategy injectedStrategy = new InjectedStrategy();
        final ClassAnnotationStrategy registryClassStrategy = new RegistryClassStrategy();
        this.classes.forEach(clazz -> {
            this.strategyExecutor.executeClass(injectedStrategy, clazz);
            this.strategyExecutor.executeClass(registryClassStrategy, clazz);
        });
    }

    @Override
    public void executeFieldAnnotations() {
        final FieldAnnotationStrategy injectionStrategy = new InjectionStrategy();
        final FieldAnnotationStrategy dependencyStrategy = new DependencyStrategy();
        final FieldAnnotationStrategy registryFieldStrategy = new RegistryFieldStrategy();
        this.classes.forEach(clazz -> {
            strategyExecutor.executeField(injectionStrategy, clazz);
            strategyExecutor.executeField(dependencyStrategy, clazz);
            strategyExecutor.executeField(registryFieldStrategy, clazz);
        });
    }

    @Override
    public void executeMethodAnnotations() {
        final MethodAnnotationStrategy executionStrategy = new ExecutionStrategy();
        this.classes.forEach(clazz -> {
            strategyExecutor.executeMethod(executionStrategy, clazz);
        });
    }

    @Override
    public void executeDataGenerationAnnotations() {
        final FieldAnnotationStrategy blockModelStrategy = new BlockModelStrategy();
        final FieldAnnotationStrategy blockLootTableStrategy = new BlockLootTableStrategy();
        final FieldAnnotationStrategy itemModelStrategy = new ItemModelStrategy();
        this.classes.forEach(clazz -> {
            strategyExecutor.executeStaticField(blockModelStrategy, clazz);
            strategyExecutor.executeStaticField(itemModelStrategy, clazz);
            strategyExecutor.executeStaticField(blockLootTableStrategy, clazz);
        });
    }
}
