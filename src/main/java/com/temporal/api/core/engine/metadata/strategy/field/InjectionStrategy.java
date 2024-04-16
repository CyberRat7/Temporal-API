package com.temporal.api.core.engine.metadata.strategy.field;

import com.temporal.api.core.engine.metadata.context.Context;
import com.temporal.api.core.engine.metadata.context.InjectionContext;

import java.lang.reflect.Field;

public class InjectionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Context context = InjectionContext.getInstance();
        field.set(object, context.getObject(field.getType()));
        context.putObject(object);
    }
}
