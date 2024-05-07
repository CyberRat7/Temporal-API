package com.temporal.api.test;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.engine.io.metadata.annotation.BlockDataGeneration;
import com.temporal.api.core.engine.io.metadata.annotation.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.Registry;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

@Injected(isContextObject = false)
public class ModBlocks {
    @Registry
    public static final BlockFactory BLOCK_FACTORY = InjectionContext.getInstance().getObject(BlockFactory.class);
    @BlockDataGeneration
    public static final RegistryObject<Block> TEST_BLOCK_1 = BLOCK_FACTORY.create("test_block_1", BlockBehaviour.Properties.of());
    @BlockDataGeneration
    public static final RegistryObject<Block> TEST_BLOCK_2 = BLOCK_FACTORY.create("test_block_2", BlockBehaviour.Properties.of());
}
