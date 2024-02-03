package com.temporal.api.core.registry.factory.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class SoundEventFactory implements TypedFactory<SoundEvent> {
    private final DeferredRegister<SoundEvent> soundRegister;

    public SoundEventFactory(DeferredRegister<SoundEvent> soundRegister) {
        this.soundRegister = soundRegister;
    }

    public RegistryObject<SoundEvent> create(String name, String modId) {
        return create(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(modId, name)));
    }

    @Override
    public RegistryObject<SoundEvent> create(String name, Supplier<SoundEvent> soundEventSupplier) {
        return soundRegister.register(name, soundEventSupplier);
    }

    @Override
    public RegistryObject<? extends SoundEvent> createTyped(String name, Supplier<? extends SoundEvent> tSupplier) {
        return soundRegister.register(name, tSupplier);
    }
}
