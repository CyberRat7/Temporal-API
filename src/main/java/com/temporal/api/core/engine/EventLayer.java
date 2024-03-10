package com.temporal.api.core.engine;

import com.temporal.api.core.engine.event.EventBusHandlerImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class EventLayer implements EngineLayer {
    public static final IEventBus EVENT_BUS =  FMLJavaModLoadingContext.get().getModEventBus();
    public static final EventBusHandlerImpl EVENT_BUS_HANDLER = EventBusHandlerImpl.getInstance();

    @Override
    public void processAllTasks() {
        EVENT_BUS_HANDLER.handleEventBus(EVENT_BUS);
    }
}
