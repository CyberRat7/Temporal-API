package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface PressurePlateExtension {
    default RegistryObject<PressurePlateBlock> createPressurePlate(String name, BlockBehaviour.Properties properties, BlockSetType setType, PressurePlateBlock.Sensitivity sensitivity) {
        return (RegistryObject<PressurePlateBlock>) BlockFactory.getInstance().createTyped(name, () -> new PressurePlateBlock(sensitivity, properties, setType));
    }

    default RegistryObject<? extends PressurePlateBlock> createPressurePlate(String name, Supplier<? extends PressurePlateBlock> tTypedSupplier) {
        return (RegistryObject<? extends PressurePlateBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
