package com.temporal.api.core.engine;

import com.temporal.api.core.engine.metadata.AnnotationExecutor;

public class MetadataLayer implements EngineLayer {
    public static final AnnotationExecutor ANNOTATION_EXECUTOR = AnnotationExecutor.getInstance();

    @Override
    public void processAllTasks(Class<?> modClass) {
        ANNOTATION_EXECUTOR.execute();
    }
}
