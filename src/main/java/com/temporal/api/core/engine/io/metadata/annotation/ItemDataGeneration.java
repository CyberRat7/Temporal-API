package com.temporal.api.core.engine.io.metadata.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ItemDataGeneration {
    Model model() default @Model;

    @interface Model {
        enum Type {
            SIMPLE,
            HANDHELD
        }

        Type type() default Type.SIMPLE;
    }
}