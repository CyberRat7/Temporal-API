package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SoundEventFactory implements TypedFactory<SoundEvent> {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = EnginedRegisterFactory.create(Registries.SOUND_EVENT);
    private static volatile SoundEventFactory instance;

    public RegistryObject<SoundEvent> create(String name, String modId) {
        return create(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(modId, name)));
    }

    @Override
    public RegistryObject<SoundEvent> create(String name, Supplier<SoundEvent> soundEventSupplier) {
        return SOUND_EVENTS.register(name, soundEventSupplier);
    }

    @Override
    public RegistryObject<? extends SoundEvent> createTyped(String name, Supplier<? extends SoundEvent> tSupplier) {
        return SOUND_EVENTS.register(name, tSupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    public static SoundEventFactory getInstance() {
        if (instance == null) {
            synchronized (SoundEventFactory.class) {
                if (instance == null) {
                    instance = new SoundEventFactory();
                }
            }
        }

        return instance;
    }
}
