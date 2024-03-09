package com.temporal.api.core.engine.metadata.strategy;

import com.temporal.api.core.engine.metadata.AnnotationHelper;
import com.temporal.api.core.engine.metadata.annotation.Dependency;
import com.temporal.api.core.engine.metadata.annotation.DependencyContainer;
import net.minecraftforge.fml.ModList;

public class DependencyContainerStrategy implements AnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object, Object... params) throws Exception {
        if (clazz.isAnnotationPresent(DependencyContainer.class)) {
            final AnnotationHelper helper = AnnotationHelper.getInstance();
            helper.executeStrategy(new DependencyStrategy(), clazz, Dependency.class, null, ModList.get());
        }
    }
}
