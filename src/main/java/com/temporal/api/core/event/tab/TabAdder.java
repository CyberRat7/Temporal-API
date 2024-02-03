package com.temporal.api.core.event.tab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public interface TabAdder {
    void addToTab(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike> registryObject);
}
