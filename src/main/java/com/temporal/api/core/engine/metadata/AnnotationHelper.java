package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;

public class AnnotationHelper {
    private static volatile AnnotationHelper instance;

    private AnnotationHelper() {
    }

    public void executeStrategy(AnnotationStrategy strategy, Set<Class<?>> classes, Class<? extends Annotation> annotation, Object object, Object... params) {
        classes.stream()
                .filter(clazz -> isAnnotationPresent(clazz, annotation))
                .forEach(clazz -> this.executeStrategy(strategy, clazz, annotation, object, params));
    }

    public void executeStrategy(AnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object, Object... params) {
        try {
            strategy.execute(clazz, object, params);
            ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
        } catch (Exception e) {
            ApiMod.LOGGER.warn("{} for {} went wrong!", strategy.getClass().getSimpleName(), annotation.getSimpleName());
        }
    }

    public boolean isAnnotationPresent(Class<?> clazz, Class<? extends Annotation> annotation) {
        if (!clazz.isAnnotationPresent(annotation)) {
            return Arrays.stream(clazz.getAnnotations())
                    .map(Annotation::annotationType)
                    .anyMatch(annotationType -> annotationType.getSimpleName().equals(annotation.getSimpleName()));
        }

        return true;
    }

    public boolean isAnnotationPresent(Field field, Class<? extends Annotation> annotation) {
        if (!field.isAnnotationPresent(annotation)) {
            return Arrays.stream(field.getAnnotations())
                    .map(Annotation::annotationType)
                    .anyMatch(annotationType -> annotationType.getSimpleName().equals(annotation.getSimpleName()));
        }

        return true;
    }

    public static AnnotationHelper getInstance() {
        if (instance == null) {
            synchronized (AnnotationHelper.class) {
                if (instance == null) {
                    instance = new AnnotationHelper();
                }
            }
        }

        return instance;
    }
}
