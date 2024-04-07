package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.common.block.StrippableLogBlock;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface StrippableLogBlockExtension {
    default RegistryObject<StrippableLogBlock> createStrippableLog(String name, BlockBehaviour.Properties properties, Supplier<? extends Block> strippedBlock) {
        return (RegistryObject<StrippableLogBlock>) BlockFactory.getInstance().createTyped(name, () -> new StrippableLogBlock(strippedBlock.get(), properties));
    }

    default RegistryObject<? extends StrippableLogBlock> createStrippableLog(String name, Supplier<? extends StrippableLogBlock> tTypedSupplier) {
        return (RegistryObject<? extends StrippableLogBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
