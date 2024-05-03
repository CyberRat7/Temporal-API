package com.temporal.api.core.engine.io.metadata;

import com.temporal.api.core.engine.io.metadata.strategy.ObjectStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.annotation.Annotation;

public interface AnnotationStrategyExecutor {
    void executeStrategy(ObjectStrategy<?> strategy, Class<? extends Annotation> annotation);

    void executeClass(ClassAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation);

    void executeField(FieldAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object);

    void executeMethod(MethodAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object);
}
