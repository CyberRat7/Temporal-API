package com.temporal.api.core.engine.io.metadata.strategy.method;

import com.temporal.api.core.engine.io.metadata.annotation.Execution;

import java.lang.reflect.Method;

public class ExecutionStrategy implements MethodAnnotationStrategy {
    @Override
    public void execute(Method method, Object object) throws Exception {
        if (method.isAnnotationPresent(Execution.class)) {
            method.setAccessible(true);
            method.invoke(object);
        }
    }
}
