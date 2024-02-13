package com.temporal.api.core.event.tab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

public class SimpleTabAdder implements TabAdder {
    private final BuildCreativeModeTabContentsEvent event;

    public SimpleTabAdder(BuildCreativeModeTabContentsEvent event) {
        this.event = event;
    }

    @Override
    @SafeVarargs
    public final TabAdder addAllToTab(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike>... registries) {
        for (Supplier<? extends ItemLike> registry : registries) {
            addToTab(tab, registry);
        }

        return this;
    }

    @Override
    public void addToTab(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike> registryObject) {
        if (event.getTabKey() == tab) event.accept(registryObject);
    }
}
