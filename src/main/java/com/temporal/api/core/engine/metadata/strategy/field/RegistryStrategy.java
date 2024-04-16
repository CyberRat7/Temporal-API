package com.temporal.api.core.engine.metadata.strategy.field;

import com.temporal.api.core.registry.factory.common.ObjectFactory;

import java.lang.reflect.Field;

public class RegistryStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        ObjectFactory<?> objectFactory = (ObjectFactory<?>) field.get(object);
        objectFactory.register();
    }
}
