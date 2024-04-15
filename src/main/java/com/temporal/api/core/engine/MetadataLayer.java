package com.temporal.api.core.engine;

import com.temporal.api.core.engine.metadata.AnnotationExecutor;
import com.temporal.api.core.engine.metadata.context.ExtraContextInitializer;
import com.temporal.api.core.engine.metadata.context.InjectionContext;

public class MetadataLayer implements EngineLayer {
    @Override
    public void processAllTasks() {
        ExtraContextInitializer.init();
        InjectionContext.getInstance().getObject(AnnotationExecutor.class).execute();
    }
}
