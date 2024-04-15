package com.temporal.api.core.event.tab;

import com.temporal.api.core.engine.metadata.annotation.Injected;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

public class SimpleTabAdder implements TabAdder {
    @Override
    @SafeVarargs
    public final TabAdder addAllToTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike>... registries) {
        for (Supplier<? extends ItemLike> registry : registries) {
            addToTab(event, tab, registry);
        }

        return this;
    }

    @Override
    public void addToTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike> registryObject) {
        if (event.getTabKey() == tab) event.accept(registryObject);
    }
}
