package com.temporal.api.core.engine.metadata.strategy.field;

import com.temporal.api.core.engine.metadata.strategy.ObjectStrategy;

import java.lang.reflect.Field;

public interface FieldAnnotationStrategy extends ObjectStrategy<Field> {
    void execute(Field field, Object object) throws Exception;
}
