package com.temporal.api.test;

import com.temporal.api.common.block.LogBlock;
import com.temporal.api.common.block.StrippableLogBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {
    public static final TestBlockFactory BLOCK_FACTORY = TestBlockFactory.getInstance();

    public static final RegistryObject<Block> BLOCK_1 = BLOCK_FACTORY.create("block_1", BlockBehaviour.Properties.of());
    public static final RegistryObject<Block> BLOCK_2 = BLOCK_FACTORY.create("block_2", BlockBehaviour.Properties.of());
    public static final RegistryObject<LogBlock> STRIPPED_LOG_1 = BLOCK_FACTORY.createLog("stripped_log_1", BlockBehaviour.Properties.of());
    public static final RegistryObject<StrippableLogBlock> LOG_1 = BLOCK_FACTORY.createStrippableLog("log_1", BlockBehaviour.Properties.of(), STRIPPED_LOG_1);

    public static void register() {
        BLOCK_FACTORY.register();
    }
}
