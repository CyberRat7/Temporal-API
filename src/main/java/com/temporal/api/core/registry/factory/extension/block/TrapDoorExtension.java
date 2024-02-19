package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface TrapDoorExtension {
    default RegistryObject<TrapDoorBlock> createTrapDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return (RegistryObject<TrapDoorBlock>) BlockFactory.getInstance().createTyped(name, () -> new TrapDoorBlock(properties, setType));
    }

    default RegistryObject<? extends TrapDoorBlock> createTrapDoor(String name, Supplier<? extends TrapDoorBlock> tTypedSupplier) {
        return (RegistryObject<? extends TrapDoorBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
