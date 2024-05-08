package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.data.loot.BlockLootTableProvider;
import com.temporal.api.core.engine.io.metadata.annotation.BlockLootTable;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class BlockLootTableStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(BlockLootTable.class)) {
            field.setAccessible(true);
            RegistryObject<?> registryObject = (RegistryObject<?>) field.get(object);
            BlockLootTable blockLootTable = field.getDeclaredAnnotation(BlockLootTable.class);
            BlockLootTableProvider.DROPS.add((RegistryObject<Block>) registryObject);
        }
    }
}
