package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.data.loot.SelfBlockLootTableProvider;
import com.temporal.api.core.data.model.block.BlockStateProvider;
import com.temporal.api.core.engine.io.metadata.annotation.BlockDataGeneration;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class BlockDataGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(BlockDataGeneration.class)) {
            field.setAccessible(true);
            RegistryObject<Block> registryObject = (RegistryObject<Block>) field.get(object);
            BlockDataGeneration blockDataGeneration = field.getDeclaredAnnotation(BlockDataGeneration.class);
            if (blockDataGeneration.model() != null) {
                BlockDataGeneration.Model model = blockDataGeneration.model();
                switch (model.type()) {
                    case CUBED_BLOCK -> BlockStateProvider.BLOCKS.add(registryObject);
                }
            }

            if (blockDataGeneration.lootTable() != null) {
                BlockDataGeneration.LootTable lootTable = blockDataGeneration.lootTable();
                SelfBlockLootTableProvider.DROPS.add(registryObject);
            }
        }
    }
}
