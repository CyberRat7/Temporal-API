package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.metadata.strategy.ClassAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.StrategyType;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class AnnotationHelper {
    private static volatile AnnotationHelper instance;

    private AnnotationHelper() {
    }

    public void executeStrategy(ClassAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        final boolean isAnnotationPresented = checkAnnotationPresented(clazz, annotation);
        if (isAnnotationPresented) {
            strategy.execute(clazz);
            ApiMod.LOGGER.debug("Scanned: strategy - {}, class - {}, type - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName(), StrategyType.CLASS_ANNOTATION);
        }
    }

    public void executeStrategy(FieldAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        final boolean isAnnotationPresented = checkAnnotationPresented(clazz, annotation);
        if (isAnnotationPresented) {
            strategy.execute(clazz, object);
            ApiMod.LOGGER.debug("Scanned: strategy - {}, class - {}, type - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName(), StrategyType.FIELD_ANNOTATION);
        }
    }

    public boolean checkAnnotationPresented(Class<?> clazz, Class<? extends Annotation> annotation) {
        return clazz != null && clazz.isAnnotationPresent(annotation);
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
