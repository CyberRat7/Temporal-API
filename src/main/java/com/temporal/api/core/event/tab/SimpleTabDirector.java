package com.temporal.api.core.event.tab;

import com.temporal.api.ApiMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

public class SimpleTabDirector implements TabDirector {
    private final TabAdder tabAdder;
    private final BuildCreativeModeTabContentsEvent event;

    public SimpleTabDirector(TabAdder tabAdder, BuildCreativeModeTabContentsEvent event) {
        this.tabAdder = tabAdder;
        this.event = event;
    }

    public static SimpleTabDirector create(BuildCreativeModeTabContentsEvent event) {
        return new SimpleTabDirector(new SimpleTabAdder(), event);
    }

    @SafeVarargs
    public final TabDirector direct(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike>... registries) {
        try {
            this.tabAdder.addAllToTab(this.event, tab, registries);
        } catch (Exception e) {
            ApiMod.LOGGER.error("Tab adding gone wrong!", e);
        }

        return this;
    }
}
