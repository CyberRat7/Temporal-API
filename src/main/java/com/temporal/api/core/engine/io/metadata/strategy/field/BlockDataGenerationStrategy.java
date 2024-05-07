package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.common.block.LogBlock;
import com.temporal.api.core.data.loot.BlockLootTableProvider;
import com.temporal.api.core.data.model.block.BlockStateProvider;
import com.temporal.api.core.engine.io.metadata.annotation.BlockDataGeneration;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class BlockDataGenerationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(BlockDataGeneration.class)) {
            field.setAccessible(true);
            RegistryObject<?> registryObject = (RegistryObject<?>) field.get(object);
            BlockDataGeneration blockDataGeneration = field.getDeclaredAnnotation(BlockDataGeneration.class);
            if (blockDataGeneration.model() != null) {
                BlockDataGeneration.Model model = blockDataGeneration.model();
                switch (model.type()) {
                    case CUBED -> BlockStateProvider.BLOCKS.add((RegistryObject<Block>) registryObject);
                    case DOOR -> BlockStateProvider.DOORS.add((RegistryObject<DoorBlock>) registryObject);
                    case BUTTON -> BlockStateProvider.BUTTONS.add((RegistryObject<ButtonBlock>) registryObject);
                    case FENCE -> BlockStateProvider.FENCES.add((RegistryObject<FenceBlock>) registryObject);
                    case FENCE_GATE -> BlockStateProvider.FENCE_GATES.add((RegistryObject<FenceGateBlock>) registryObject);
                    case PRESSURE_PLATE -> BlockStateProvider.PRESSURE_PLATES.add((RegistryObject<PressurePlateBlock>) registryObject);
                    case TRAPDOOR -> BlockStateProvider.TRAPDOORS.add((RegistryObject<TrapDoorBlock>) registryObject);
                    case SLAB -> BlockStateProvider.SLABS.add((RegistryObject<SlabBlock>) registryObject);
                    case STAIRS -> BlockStateProvider.STAIRS.add((RegistryObject<StairBlock>) registryObject);
                    case WALL -> BlockStateProvider.WALLS.add((RegistryObject<WallBlock>) registryObject);
                    case LOG -> BlockStateProvider.LOGS.add((RegistryObject<LogBlock>) registryObject);
                    case ROTATED_PILLAR -> BlockStateProvider.ROTATED_PILLARS.add((RegistryObject<RotatedPillarBlock>) registryObject);
                }
            }

            if (blockDataGeneration.lootTable() != null) {
                BlockDataGeneration.LootTable lootTable = blockDataGeneration.lootTable();
                BlockLootTableProvider.DROPS.add((RegistryObject<Block>) registryObject);
            }
        }
    }
}
