package com.temporal.api.core.event.tab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface TabAdder {
    TabAdder addAllToTab(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike>... registries);

    void addToTab(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike> registryObject);
}
