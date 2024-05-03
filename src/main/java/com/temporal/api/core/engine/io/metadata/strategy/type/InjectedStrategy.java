package com.temporal.api.core.engine.io.metadata.strategy.type;

import com.temporal.api.core.engine.io.context.Context;
import com.temporal.api.core.engine.io.context.InjectionContext;

public class InjectedStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        Context context = InjectionContext.getInstance();
        context.putObject(clazz);
    }
}
