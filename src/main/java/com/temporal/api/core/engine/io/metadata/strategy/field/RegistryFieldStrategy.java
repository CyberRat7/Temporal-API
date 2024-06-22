package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.annotation.Registry;
import com.temporal.api.core.registry.factory.common.ObjectFactory;

import java.lang.reflect.Field;

public class RegistryFieldStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(Registry.class)) {
            field.setAccessible(true);
            ObjectFactory<?> objectFactory = (ObjectFactory<?>) field.get(object);
            objectFactory.register();
        }
    }
}
