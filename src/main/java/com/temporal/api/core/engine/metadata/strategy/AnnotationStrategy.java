package com.temporal.api.core.engine.metadata.strategy;

public interface AnnotationStrategy {
    void execute(Class<?> clazz, Object object, Object... params) throws Exception;
}
