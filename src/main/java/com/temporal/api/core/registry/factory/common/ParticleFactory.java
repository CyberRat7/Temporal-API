package com.temporal.api.core.registry.factory.common;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class ParticleFactory implements TypedFactory<ParticleType<SimpleParticleType>> {
    private final DeferredRegister<ParticleType<?>> particleRegister;

    public ParticleFactory(DeferredRegister<ParticleType<?>> particleRegister) {
        this.particleRegister = particleRegister;
    }

    public RegistryObject<ParticleType<SimpleParticleType>> create(String name, boolean overrideLimiter) {
        return particleRegister.register(name, particleRegister.register(name, () -> new SimpleParticleType(overrideLimiter)));
    }

    @Override
    public RegistryObject<ParticleType<SimpleParticleType>> create(String name, Supplier<ParticleType<SimpleParticleType>> particleTypeSupplier) {
        return particleRegister.register(name, particleTypeSupplier);
    }

    @Override
    public RegistryObject<? extends ParticleType<SimpleParticleType>> createTyped(String name, Supplier<? extends ParticleType<SimpleParticleType>> tSupplier) {
        return particleRegister.register(name, tSupplier);
    }
}
