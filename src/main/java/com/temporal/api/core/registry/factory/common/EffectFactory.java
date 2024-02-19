package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EffectFactory implements TypedFactory<MobEffect> {
    public static final DeferredRegister<MobEffect> EFFECTS = EnginedRegisterFactory.create(Registries.MOB_EFFECT);
    private static volatile EffectFactory instance;

    @Override
    public RegistryObject<MobEffect> create(String name, Supplier<MobEffect> mobEffectSupplier) {
        return EFFECTS.register(name, mobEffectSupplier);
    }

    @Override
    public RegistryObject<? extends MobEffect> createTyped(String name, Supplier<? extends MobEffect> mobEffectSupplier) {
        return EFFECTS.register(name, mobEffectSupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    public static EffectFactory getInstance() {
        if (instance == null) {
            synchronized (EffectFactory.class) {
                if (instance == null) {
                    instance = new EffectFactory();
                }
            }
        }

        return instance;
    }
}
