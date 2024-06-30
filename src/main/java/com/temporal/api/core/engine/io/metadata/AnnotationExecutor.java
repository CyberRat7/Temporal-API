package com.temporal.api.core.engine.io.metadata;

import com.temporal.api.ApiMod;

public interface AnnotationExecutor {
    default void execute(Class<?> dependencyClass) {
        try {
            prepareBeforeExecution(dependencyClass);
            executeClassAnnotations();
            executeFieldAnnotations();
            executeMethodAnnotations();
            executeDataGenerationAnnotations();
        } catch (Exception e) {
            ApiMod.LOGGER.error(e.getMessage());
        }
    }

    void prepareBeforeExecution(Class<?> dependencyClass);

    void executeClassAnnotations();

    void executeFieldAnnotations();

    void executeMethodAnnotations();

    void executeDataGenerationAnnotations();
}
