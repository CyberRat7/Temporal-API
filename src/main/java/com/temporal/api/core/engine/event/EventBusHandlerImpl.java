package com.temporal.api.core.engine.event;

import com.temporal.api.core.engine.event.strategy.EventHandlingStrategy;
import com.temporal.api.core.engine.event.strategy.FactoryStrategy;
import com.temporal.api.core.registry.factory.common.ObjectFactory;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.List;

public class EventBusHandlerImpl implements EventBusHandler {
    private static volatile EventBusHandlerImpl instance;
    private EventHandlingStrategy<ObjectFactory<?>> factoryStrategy;
    private List<ObjectFactory<?>> factories;

    private EventBusHandlerImpl() {
        this.factoryStrategy = new FactoryStrategy();
    }

    @Override
    public void handleEventBus(IEventBus eventBus) {
        handleEventStrategy(eventBus, factoryStrategy, factories);
    }

    public <T> void handleEventStrategy(IEventBus eventBus, EventHandlingStrategy<T> eventHandlingStrategy, List<T> list) {
        list.forEach(element -> eventHandlingStrategy.execute(eventBus, element));
    }

    public EventHandlingStrategy<ObjectFactory<?>> getFactoryStrategy() {
        return factoryStrategy;
    }

    public void setFactoryStrategy(EventHandlingStrategy<ObjectFactory<?>> factoryStrategy) {
        this.factoryStrategy = factoryStrategy;
    }

    public List<ObjectFactory<?>> getFactories() {
        return factories;
    }

    public void setFactories(List<ObjectFactory<?>> factories) {
        this.factories = factories;
    }

    public static EventBusHandlerImpl getInstance() {
        if (instance == null) {
            synchronized (EventBusHandlerImpl.class) {
                if (instance == null) {
                    instance = new EventBusHandlerImpl();
                }
            }
        }

        return instance;
    }
}
