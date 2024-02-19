package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface FenceExtension {
    default RegistryObject<FenceBlock> createFence(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<FenceBlock>) BlockFactory.getInstance().createTyped(name, () -> new FenceBlock(properties));
    }

    default RegistryObject<? extends FenceBlock> createFence(String name, Supplier<? extends FenceBlock> tTypedSupplier) {
        return (RegistryObject<? extends FenceBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
