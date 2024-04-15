package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.metadata.context.Context;
import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.engine.metadata.strategy.ObjectStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotationHelper {
    private static volatile AnnotationHelper instance;
    private Set<? extends Class<?>> classes;

    private AnnotationHelper() {
    }

    public void executeStrategy(ObjectStrategy<?> strategy, Class<? extends Annotation> annotation) {
        final Context injectionContext = InjectionContext.getInstance();
        this.classes.forEach(clazz -> {
            try {
                if (strategy instanceof ClassAnnotationStrategy) {
                    this.executeClass((ClassAnnotationStrategy) strategy, clazz, annotation);
                } else if (strategy instanceof FieldAnnotationStrategy) {
                    this.executeFields((FieldAnnotationStrategy) strategy, clazz, annotation, injectionContext.getObject(clazz));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void executeClass(ClassAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation) {
        try {
            if (this.isAnnotationPresent(clazz, annotation)) {
                strategy.execute(clazz, null);
                ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            logException(e, strategy, clazz, annotation);
        }
    }

    private void executeFields(FieldAnnotationStrategy strategy, Class<?> clazz, Class<? extends Annotation> annotation, Object object) {
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (this.isAnnotationPresent(field, annotation)) {
                    strategy.execute(field, object);
                    ApiMod.LOGGER.info("Scanned: strategy - {}, class - {}", strategy.getClass().getSimpleName(), clazz.getSimpleName());
                    return;
                }
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

    public void setClasses(Set<Class<?>> classes) {
        this.classes = classes.stream().map(clazz -> {
            try {
                String clazzName = clazz.getName();
                String nameWithoutHash = clazzName.split("@")[0];
                return Class.forName(nameWithoutHash);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());
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
