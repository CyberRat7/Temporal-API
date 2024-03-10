package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.MetadataLayer;
import com.temporal.api.core.engine.metadata.AnnotationHelper;
import com.temporal.api.core.engine.metadata.annotation.Factory;
import com.temporal.api.core.registry.factory.common.ObjectFactory;

import java.lang.reflect.Field;

public class FactoryStrategy implements AnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object, Object... params) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (AnnotationHelper.getInstance().isAnnotationPresent(field, Factory.class)) {
                field.setAccessible(true);
                ObjectFactory<?> o = (ObjectFactory<?>) field.get(null);
                o.register(MetadataLayer.EVENT_BUS);
            }
        }
    }
}
