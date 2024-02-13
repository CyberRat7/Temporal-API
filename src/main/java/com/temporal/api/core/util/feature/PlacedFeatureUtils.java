package com.temporal.api.core.util.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class PlacedFeatureUtils {
    private static volatile PlacedFeatureUtils instance;

    private PlacedFeatureUtils() {
    }

    public ResourceKey<PlacedFeature> createKey(String name, String modId) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(modId, name));
    }

    public void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    public static PlacedFeatureUtils getInstance() {
        if (instance == null) {
            synchronized (PlacedFeatureUtils.class) {
                if (instance == null) {
                    instance = new PlacedFeatureUtils();
                }
            }
        }

        return instance;
    }
}