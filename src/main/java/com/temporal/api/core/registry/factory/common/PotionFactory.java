package com.temporal.api.core.registry.factory.common;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class PotionFactory implements TypedFactory<Potion> {
    public final DeferredRegister<Potion> potionRegister;

    public PotionFactory(DeferredRegister<Potion> potionRegister) {
        this.potionRegister = potionRegister;
    }

    public RegistryObject<Potion> create(String name, MobEffectInstance mobEffectInstance) {
        return create(name, () -> new Potion(mobEffectInstance));
    }

    public RegistryObject<Potion> create(String name, Supplier<MobEffect> effect, int duration) {
        return create(name, () -> new Potion(new MobEffectInstance(effect.get(), duration)));
    }

    @Override
    public RegistryObject<Potion> create(String name, Supplier<Potion> potionSupplier) {
        return potionRegister.register(name, potionSupplier);
    }

    @Override
    public RegistryObject<? extends Potion> createTyped(String name, Supplier<? extends Potion> tSupplier) {
        return potionRegister.register(name, tSupplier);
    }
}
