package com.temporal.api.core.engine.io.metadata;

import com.temporal.api.core.engine.io.IOHelper;
import com.temporal.api.core.engine.io.metadata.annotation.*;
import com.temporal.api.core.engine.io.metadata.strategy.field.*;
import com.temporal.api.core.engine.io.metadata.strategy.method.ExecutionStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.InjectedStrategy;

import java.util.Set;

public class DefaultAnnotationExecutor implements AnnotationExecutor {
    @Override
    public void execute(Class<?> dependencyClass) {
        Set<Class<?>> classes = IOHelper.getAllClasses(dependencyClass, Injected.class);
        AnnotationStrategyExecutor strategyExecutor = DefaultAnnotationStrategyExecutor.getInstance(classes);
        strategyExecutor.executeStrategy(new InjectedStrategy(), Injected.class);
        strategyExecutor.executeStrategy(new InjectionStrategy(), Injection.class);
        strategyExecutor.executeStrategy(new DependencyStrategy(), Dependency.class);
        strategyExecutor.executeStrategy(new RegistryStrategy(), Registry.class);
        strategyExecutor.executeStrategy(new ExecutionStrategy(), Execution.class);
        strategyExecutor.executeStrategy(new BlockDataGenerationStrategy(), BlockDataGeneration.class);
        strategyExecutor.executeStrategy(new ItemDataGenerationStrategy(), ItemDataGeneration.class);
    }
}
