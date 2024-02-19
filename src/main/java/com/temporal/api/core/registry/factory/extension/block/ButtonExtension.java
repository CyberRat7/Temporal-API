package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ButtonExtension {
    default RegistryObject<ButtonBlock> createButton(String name, BlockBehaviour.Properties properties, BlockSetType setType, int ticksToStayPressed, boolean canArrowPress) {
        return (RegistryObject<ButtonBlock>) BlockFactory.getInstance().createTyped(name, () -> new ButtonBlock(properties, setType, ticksToStayPressed, canArrowPress));
    }

    default RegistryObject<? extends ButtonBlock> createButton(String name, Supplier<? extends ButtonBlock> tTypedSupplier) {
        return (RegistryObject<? extends ButtonBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
