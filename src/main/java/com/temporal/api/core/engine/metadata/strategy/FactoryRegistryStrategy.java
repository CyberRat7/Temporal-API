package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.metadata.AnnotationHelper;
import com.temporal.api.core.engine.metadata.annotation.Factory;

public class FactoryRegistryStrategy implements AnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object, Object... params) throws Exception {
        AnnotationHelper.getInstance().executeStrategy(new FactoryStrategy(), clazz, Factory.class, object, params);
    }
}
