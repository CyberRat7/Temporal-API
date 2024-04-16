package com.temporal.api.core.engine.metadata.strategy.field;

import com.temporal.api.core.engine.metadata.annotation.Dependency;
import com.temporal.api.core.engine.metadata.context.Context;
import com.temporal.api.core.engine.metadata.context.InjectionContext;
import net.minecraftforge.fml.ModList;

import java.lang.reflect.Field;

public class DependencyStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Dependency dependency = field.getDeclaredAnnotation(Dependency.class);
        field.setBoolean(object, ModList.get().isLoaded(dependency.value()));
        Context context = InjectionContext.getInstance();
        context.putObject(object);
    }
}
