package com.temporal.api.core.engine;

import com.temporal.api.core.engine.metadata.AnnotationExecutor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MetadataLayer implements EngineLayer {
    public static final IEventBus EVENT_BUS =  FMLJavaModLoadingContext.get().getModEventBus();
    public static final AnnotationExecutor ANNOTATION_EXECUTOR = AnnotationExecutor.getInstance();

    @Override
    public void processAllTasks(Class<?> modClass) {
        ANNOTATION_EXECUTOR.execute();
    }
}
