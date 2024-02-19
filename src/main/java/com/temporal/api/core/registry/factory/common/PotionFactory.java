package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PotionFactory implements TypedFactory<Potion> {
    public static final DeferredRegister<Potion> POTIONS = EnginedRegisterFactory.create(Registries.POTION);
    private static volatile PotionFactory instance;

    public RegistryObject<Potion> create(String name, MobEffectInstance mobEffectInstance) {
        return create(name, () -> new Potion(mobEffectInstance));
    }

    public RegistryObject<Potion> create(String name, Supplier<MobEffect> effect, int duration) {
        return create(name, () -> new Potion(new MobEffectInstance(effect.get(), duration)));
    }

    @Override
    public RegistryObject<Potion> create(String name, Supplier<Potion> potionSupplier) {
        return POTIONS.register(name, potionSupplier);
    }

    @Override
    public RegistryObject<? extends Potion> createTyped(String name, Supplier<? extends Potion> tSupplier) {
        return POTIONS.register(name, tSupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    public static PotionFactory getInstance() {
        if (instance == null) {
            synchronized (PotionFactory.class) {
                if (instance == null) {
                    instance = new PotionFactory();
                }
            }
        }

        return instance;
    }
}
