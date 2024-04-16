package com.temporal.api.core.engine.metadata.strategy.method;

import com.temporal.api.core.engine.metadata.strategy.ObjectStrategy;

import java.lang.reflect.Method;

public interface MethodAnnotationStrategy extends ObjectStrategy<Method> {
    void execute(Method method, Object object) throws Exception;
}
