package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.metadata.AnnotationHelper;
import com.temporal.api.core.engine.metadata.annotation.Factory;
import com.temporal.api.core.engine.metadata.annotation.FactoryRegistry;

public class FactoryRegistryStrategy implements AnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object, Object... params) throws Exception {
        if (clazz.isAnnotationPresent(FactoryRegistry.class)) {
            final AnnotationHelper helper = AnnotationHelper.getInstance();
            helper.executeStrategy(new FactoryStrategy(), clazz, Factory.class, object, params);
        }
    }
}
