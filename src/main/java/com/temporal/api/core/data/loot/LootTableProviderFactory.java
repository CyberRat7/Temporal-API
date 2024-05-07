package com.temporal.api.core.data.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class LootTableProviderFactory {
    public static LootTableProvider createWithSelfDrop(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(SelfBlockLootTableProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}
