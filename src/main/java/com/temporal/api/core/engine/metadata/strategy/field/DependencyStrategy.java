package com.temporal.api.core.engine.metadata.strategy.field;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import net.minecraftforge.fml.ModList;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DependencyStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        String value = Arrays.stream(declaredAnnotations)
                .map(Annotation::toString)
                .filter(annotation -> annotation.contains("Dependency"))
                .map(annotation -> {
                    int beginIndex = annotation.indexOf("\"") + 1;
                    return annotation.substring(beginIndex, annotation.length() - 2);
                }).findAny()
                .orElseThrow();

        field.setBoolean(object, ModList.get().isLoaded(value));
        InjectionContext.getInstance().putObject(object);
    }
}
