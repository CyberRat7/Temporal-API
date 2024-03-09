package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.metadata.annotation.Dependency;
import net.minecraftforge.fml.ModList;

import java.lang.reflect.Field;

public class DependencyStrategy implements AnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object, Object... params) throws Exception {
        ModList modList = (ModList) params[0];
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Dependency.class)) {
                field.setAccessible(true);
                Dependency dependency = field.getAnnotation(Dependency.class);
                field.set(null, modList.isLoaded(dependency.value()));
            }
        }
    }
}
