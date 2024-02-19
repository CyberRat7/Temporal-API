package com.temporal.api.core.engine.metadata.strategy;

import java.lang.reflect.InvocationTargetException;

public interface ClassAnnotationStrategy {
    void execute(Class<?> clazz) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
