package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ParticleFactory implements TypedFactory<ParticleType<SimpleParticleType>> {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = EnginedRegisterFactory.create(Registries.PARTICLE_TYPE);
    private static volatile ParticleFactory instance;

    public RegistryObject<ParticleType<SimpleParticleType>> create(String name, boolean overrideLimiter) {
        return create(name, () -> new SimpleParticleType(overrideLimiter));
    }

    @Override
    public RegistryObject<ParticleType<SimpleParticleType>> create(String name, Supplier<ParticleType<SimpleParticleType>> particleTypeSupplier) {
        return PARTICLE_TYPES.register(name, particleTypeSupplier);
    }

    @Override
    public RegistryObject<? extends ParticleType<SimpleParticleType>> createTyped(String name, Supplier<? extends ParticleType<SimpleParticleType>> tSupplier) {
        return PARTICLE_TYPES.register(name, tSupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    public static ParticleFactory getInstance() {
        if (instance == null) {
            synchronized (ParticleFactory.class) {
                if (instance == null) {
                    instance = new ParticleFactory();
                }
            }
        }

        return instance;
    }
}
