package com.temporal.api.core.engine.metadata.strategy;

import java.lang.reflect.InvocationTargetException;

public interface FieldAnnotationStrategy {
    void execute(Class<?> clazz, Object object) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
