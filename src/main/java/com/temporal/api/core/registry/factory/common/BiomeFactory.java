package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BiomeFactory implements TypedFactory<Biome> {
    public static final DeferredRegister<Biome> BIOMES = EnginedRegisterFactory.create(Registries.BIOME);
    private static volatile BiomeFactory instance;

    @Override
    public RegistryObject<Biome> create(String name, Supplier<Biome> potionSupplier) {
        return BIOMES.register(name, potionSupplier);
    }

    @Override
    public RegistryObject<? extends Biome> createTyped(String name, Supplier<? extends Biome> tSupplier) {
        return BIOMES.register(name, tSupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

    public static BiomeFactory getInstance() {
        if (instance == null) {
            synchronized (BiomeFactory.class) {
                if (instance == null) {
                    instance = new BiomeFactory();
                }
            }
        }

        return instance;
    }
}
