package com.temporal.api.core.engine.event.strategy;

import com.temporal.api.core.registry.factory.common.ObjectFactory;
import net.minecraftforge.eventbus.api.IEventBus;

public class FactoryStrategy implements EventHandlingStrategy<ObjectFactory<?>> {
    @Override
    public void execute(IEventBus eventBus, ObjectFactory<?> objectFactory) {
        objectFactory.register(eventBus);
    }
}
