package com.temporal.api.test;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.engine.io.metadata.annotation.BlockDataGeneration;
import com.temporal.api.core.engine.io.metadata.annotation.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

@Injected(isContextObject = false)
public class ModBlocks {
    @Registry
    public static final SlabBlockFactory BLOCK_FACTORY = InjectionContext.getInstance().getObject(SlabBlockFactory.class);
    @BlockDataGeneration
    public static final RegistryObject<Block> TEST_BLOCK_1 = BLOCK_FACTORY.create("test_block_1", BlockBehaviour.Properties.of());
    @BlockDataGeneration
    public static final RegistryObject<Block> TEST_BLOCK_2 = BLOCK_FACTORY.create("test_block_2", BlockBehaviour.Properties.of());
    @BlockDataGeneration(
            model = @BlockDataGeneration.Model(type = BlockDataGeneration.Model.Type.SLAB)
    )
    public static final RegistryObject<SlabBlock> TEST_BLOCK_1_SLAB = BLOCK_FACTORY.createSlab("test_block_1_slab", BlockBehaviour.Properties.of());
}
