package com.temporal.api.core.engine.io.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.context.Context;
import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.engine.io.metadata.strategy.ObjectStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class DefaultAnnotationStrategyExecutor implements AnnotationStrategyExecutor {
    private static volatile DefaultAnnotationStrategyExecutor instance;
    private final Set<? extends Class<?>> classes;

    private DefaultAnnotationStrategyExecutor(Set<? extends Class<?>> classes) {
        this.classes = classes;
    }

    @Override
    public void executeStrategy(ObjectStrategy<?> strategy, Class<? extends Annotation> annotation) {
        final Context injectionContext = InjectionContext.getInstance();
        this.classes.forEach(clazz -> {
            try {
                if (strategy instanceof ClassAnnotationStrategy) {
                    this.executeClass((ClassAnnotationStrategy) strategy, clazz, annotation);
                } else if (strategy instanceof FieldAnnotationStrategy) {
                    this.executeField((FieldAnnotationStrategy) strategy, clazz, annotation, injectionContext.getObject(clazz));
                } else if (strategy instanceof MethodAnnotationStrategy) {
                    this.executeMethod((MethodAnnotationStrategy) strategy, clazz, annotation, injectionContext.getObject(clazz));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void executeClass(ClassAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation) {
        try {
            strategy.execute(clazz, null);
            ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
        } catch (Exception e) {
            logException(e, strategy, clazz, annotation);
        }
    }

    @Override
    public void executeField(FieldAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object) {
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                strategy.execute(field, object);
                ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
                return;
            }

            throw new Exception();
        } catch (Exception e) {
            logException(e, strategy, clazz, annotation);
        }
    }

    @Override
    public void executeMethod(MethodAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object) {
        try {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                strategy.execute(method, object);
                ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
                return;
            }

            throw new Exception();
        } catch (Exception e) {
            logException(e, strategy, clazz, annotation);
        }
    }

    private void logException(Exception e, ObjectStrategy<?> strategy, Class<?> clazz, Class<? extends Annotation> annotation) {
        ApiMod.LOGGER.warn("{} for {} in {} went wrong! - {}",
                strategy.getClass().getSimpleName(),
                annotation.getSimpleName(),
                clazz.getSimpleName(),
                e.getMessage()
        );
    }

    public static DefaultAnnotationStrategyExecutor getInstance(Set<? extends Class<?>> classes) {
        if (instance == null) {
            synchronized (DefaultAnnotationStrategyExecutor.class) {
                if (instance == null) {
                    instance = new DefaultAnnotationStrategyExecutor(classes);
                }
            }
        }

        return instance;
    }
}
