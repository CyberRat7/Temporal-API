package com.temporal.api.core.engine.io.metadata;

import com.temporal.api.core.engine.io.IOHelper;
import com.temporal.api.core.engine.io.metadata.annotation.*;
import com.temporal.api.core.engine.io.metadata.strategy.field.DependencyStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.InjectionStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.RegistryStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.ExecutionStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.InjectedStrategy;

import java.util.Set;

public class DefaultAnnotationExecutor implements AnnotationExecutor {
    @Override
    public void execute(Class<?> dependencyClass) {
        Set<Class<?>> classes = IOHelper.getAllClasses(dependencyClass, Injected.class);
        AnnotationStrategyExecutor helper = DefaultAnnotationStrategyExecutor.getInstance(classes);
        helper.executeStrategy(new InjectedStrategy(), Injected.class);
        helper.executeStrategy(new InjectionStrategy(), Injection.class);
        helper.executeStrategy(new DependencyStrategy(), Dependency.class);
        helper.executeStrategy(new RegistryStrategy(), Registry.class);
        helper.executeStrategy(new ExecutionStrategy(), Execution.class);
    }
}
