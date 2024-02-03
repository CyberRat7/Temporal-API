package com.temporal.api.core.registry.factory.common;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class ParticleFactory implements TypedFactory<ParticleType<?>> {
    private final DeferredRegister<ParticleType<?>> particleRegister;

    public ParticleFactory(DeferredRegister<ParticleType<?>> particleRegister) {
        this.particleRegister = particleRegister;
    }

    public RegistryObject<ParticleType<?>> create(String name, boolean overrideLimiter) {
        return particleRegister.register(name, particleRegister.register(name, () -> new SimpleParticleType(overrideLimiter)));
    }

    @Override
    public RegistryObject<ParticleType<?>> create(String name, Supplier<ParticleType<?>> particleTypeSupplier) {
        return particleRegister.register(name, particleTypeSupplier);
    }

    @Override
    public RegistryObject<? extends ParticleType<?>> createTyped(String name, Supplier<? extends ParticleType<?>> tSupplier) {
        return particleRegister.register(name, tSupplier);
    }
}
