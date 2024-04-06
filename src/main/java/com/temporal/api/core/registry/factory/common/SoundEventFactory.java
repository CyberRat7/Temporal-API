package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class SoundEventFactory implements TypedFactory<SoundEvent> {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = EnginedRegisterFactory.create(Registries.SOUND_EVENT);
    private static volatile SoundEventFactory instance;

    public RegistryObject<SoundEvent> create(String name) {
        return create(name, () -> SoundEvent.createVariableRangeEvent(new EnginedResourceLocation(name)));
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
    public void register() {
        SOUND_EVENTS.register(EVENT_BUS);
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
