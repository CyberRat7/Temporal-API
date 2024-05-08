package com.temporal.api.test;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.engine.io.metadata.annotation.BlockLootTable;
import com.temporal.api.core.engine.io.metadata.annotation.BlockModel;
import com.temporal.api.core.engine.io.metadata.annotation.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.Registry;
import com.temporal.api.core.registry.properties.BlockPropertiesFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.registries.RegistryObject;

@Injected(isContextObject = false)
public class ModBlocks {
    @Registry
    public static final SlabBlockFactory BLOCK_FACTORY = InjectionContext.getInstance().getObject(SlabBlockFactory.class);
    @BlockModel
    @BlockLootTable(type = BlockLootTable.Type.OTHER, itemId = "test_item")
    public static final RegistryObject<Block> TEST_BLOCK_1 = BLOCK_FACTORY.create("test_block_1", BlockPropertiesFactory.woolLike());
    @BlockModel
    @BlockLootTable
    public static final RegistryObject<Block> TEST_BLOCK_2 = BLOCK_FACTORY.create("test_block_2", BlockPropertiesFactory.deepslateLike());
    @BlockModel(type = BlockModel.Type.SLAB)
    public static final RegistryObject<SlabBlock> TEST_BLOCK_1_SLAB = BLOCK_FACTORY.createSlab("test_block_1_slab", BlockPropertiesFactory.woodLike().noLootTable());
}
