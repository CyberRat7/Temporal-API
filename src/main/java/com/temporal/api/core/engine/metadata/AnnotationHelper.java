package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;

public class AnnotationHelper {
    private static volatile AnnotationHelper instance;

    private AnnotationHelper() {
    }

    public void executeStrategy(AnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object, Object... params) {
        try {
            strategy.execute(clazz, object, params);
            ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
        } catch (Exception e) {
            ApiMod.LOGGER.warn("{} for {} went wrong!", strategy.getClass().getSimpleName(), annotation.getSimpleName());
        }
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
