package com.temporal.api.core.engine.event.strategy;

import net.minecraftforge.eventbus.api.IEventBus;

public interface EventHandlingStrategy<T> {
    void execute(IEventBus eventBus, T t);
}
