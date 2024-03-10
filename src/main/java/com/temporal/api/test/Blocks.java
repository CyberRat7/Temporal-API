package com.temporal.api.test;

import com.temporal.api.core.engine.metadata.annotation.Factory;
import com.temporal.api.core.engine.metadata.annotation.FactoryRegistry;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

@FactoryRegistry
public class Blocks {
    @Factory
    public static final BlockFactory BLOCK_FACTORY = BlockFactory.getInstance();

    public static final RegistryObject<Block> ITEM_1 = BLOCK_FACTORY.create("block_1", BlockBehaviour.Properties.of());
    public static final RegistryObject<Block> ITEM_2 = BLOCK_FACTORY.create("block_2", BlockBehaviour.Properties.of());
}
