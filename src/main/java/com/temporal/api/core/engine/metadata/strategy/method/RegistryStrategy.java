package com.temporal.api.core.engine.metadata.strategy.method;

import java.lang.reflect.Method;

public class RegistryStrategy implements MethodAnnotationStrategy {
    @Override
    public void execute(Method method, Object object) throws Exception {
        method.setAccessible(true);
        method.invoke(object);
    }
}
