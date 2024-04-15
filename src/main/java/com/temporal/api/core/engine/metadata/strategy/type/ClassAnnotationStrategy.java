package com.temporal.api.core.engine.metadata.strategy.type;

import com.temporal.api.core.engine.metadata.strategy.ObjectStrategy;

public interface ClassAnnotationStrategy extends ObjectStrategy<Class<?>> {
    void execute(Class<?> clazz, Object object) throws Exception;
}
