package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import com.temporal.api.core.engine.metadata.annotation.Injected;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class BiomeFactory implements TypedFactory<Biome> {
    public static final DeferredRegister<Biome> BIOMES = EnginedRegisterFactory.create(Registries.BIOME);

    @Override
    public RegistryObject<Biome> create(String name, Supplier<Biome> potionSupplier) {
        return BIOMES.register(name, potionSupplier);
    }

    @Override
    public RegistryObject<? extends Biome> createTyped(String name, Supplier<? extends Biome> tSupplier) {
        return BIOMES.register(name, tSupplier);
    }

    @Override
    public void register() {
        BIOMES.register(EVENT_BUS);
    }
}
