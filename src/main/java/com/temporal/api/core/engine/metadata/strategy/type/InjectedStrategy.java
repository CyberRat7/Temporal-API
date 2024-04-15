package com.temporal.api.core.engine.metadata.strategy.type;

import com.temporal.api.core.engine.metadata.context.Context;
import com.temporal.api.core.engine.metadata.context.InjectionContext;

public class InjectedStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        Context context = InjectionContext.getInstance();
        context.putObject(clazz);
    }
}
