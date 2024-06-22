package com.temporal.api.core.engine.io.metadata.strategy.type;

import com.temporal.api.core.engine.io.metadata.annotation.Registry;
import com.temporal.api.core.registry.factory.common.ObjectFactory;

import java.lang.reflect.Field;

public class RegistryClassStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        if (clazz.isAnnotationPresent(Registry.class)) {
            Field field = clazz.getDeclaredFields()[0];
            field.setAccessible(true);
            ObjectFactory<?> objectFactory = (ObjectFactory<?>) field.get(object);
            objectFactory.register();
        }
    }
}
