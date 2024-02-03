package com.temporal.api.core.registry.factory.common;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class EffectFactory implements TypedFactory<MobEffect> {
    private final DeferredRegister<MobEffect> effectRegister;

    public EffectFactory(DeferredRegister<MobEffect> effectRegister) {
        this.effectRegister = effectRegister;
    }

    @Override
    public RegistryObject<MobEffect> create(String name, Supplier<MobEffect> mobEffectSupplier) {
        return effectRegister.register(name, mobEffectSupplier);
    }

    @Override
    public RegistryObject<? extends MobEffect> createTyped(String name, Supplier<? extends MobEffect> mobEffectSupplier) {
        return effectRegister.register(name, mobEffectSupplier);
    }
}
