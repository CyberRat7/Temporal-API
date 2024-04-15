package com.temporal.api.core.engine.metadata.strategy.field;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import net.minecraftforge.fml.ModList;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class InjectionStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        Annotation declaredAnnotation = Arrays.stream(declaredAnnotations)
                .filter(annotation -> annotation.toString().contains("Injection"))
                .findAny()
                .orElseThrow();
        field.set(object, InjectionContext.getInstance().getObject(field.getType()));
        InjectionContext.getInstance().putObject(object);
    }
}
