package com.temporal.api.core.engine.io.metadata.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BlockDataGeneration {
    Model model() default @Model;
    LootTable lootTable() default @LootTable;

    @interface Model {
        enum Type {
            CUBED_BLOCK
        }

        Type type() default Type.CUBED_BLOCK;
    }

    @interface LootTable {
    }
}