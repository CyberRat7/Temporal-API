package com.temporal.api.core.util.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ConfiguredFeatureUtils {
    private static volatile ConfiguredFeatureUtils instance;

    private ConfiguredFeatureUtils() {
    }

    public ResourceKey<ConfiguredFeature<?, ?>> createKey(String name, String modId) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(modId, name));
    }

    public <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static ConfiguredFeatureUtils getInstance() {
        if (instance == null) {
            synchronized (ConfiguredFeatureUtils.class) {
                if (instance == null) {
                    instance = new ConfiguredFeatureUtils();
                }
            }
        }

        return instance;
    }
}