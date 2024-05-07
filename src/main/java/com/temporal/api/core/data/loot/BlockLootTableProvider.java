package com.temporal.api.core.data.loot;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class BlockLootTableProvider extends ApiBlockLootTableProvider {
    public static final List<RegistryObject<Block>> DROPS = new ArrayList<>();

    @Override
    protected void generate() {
        DROPS.forEach(blockRegistry -> this.dropSelf(blockRegistry.get()));
    }
}
