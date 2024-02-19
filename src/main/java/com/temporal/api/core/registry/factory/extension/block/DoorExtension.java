package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface DoorExtension {
    default RegistryObject<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return (RegistryObject<DoorBlock>) BlockFactory.getInstance().createTyped(name, () -> new DoorBlock(properties, setType));
    }

    default RegistryObject<? extends DoorBlock> createDoor(String name, Supplier<? extends DoorBlock> tTypedSupplier) {
        return (RegistryObject<? extends DoorBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
