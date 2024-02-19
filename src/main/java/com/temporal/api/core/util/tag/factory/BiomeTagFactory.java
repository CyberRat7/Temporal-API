package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeTagFactory implements TagFactory<Biome> {
    private static volatile TagFactory<Biome> instance;

    private BiomeTagFactory() {
    }

    @Override
    public TagKey<Biome> createTag(String name) {
        return TagKey.create(Registries.BIOME, new EnginedResourceLocation(name));
    }

    public static TagFactory<Biome> getInstance() {
        if (instance == null) {
            synchronized (BiomeTagFactory.class) {
                if (instance == null) {
                    instance = new BiomeTagFactory();
                }
            }
        }

        return instance;
    }
}
