package com.temporal.api.core.engine;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class EventLayer implements EngineLayer {
    public static volatile IEventBus EVENT_BUS;

    @Override
    public void processAllTasks() {
        EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
