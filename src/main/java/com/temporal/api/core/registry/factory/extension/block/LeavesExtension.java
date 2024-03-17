package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface LeavesExtension {
    default RegistryObject<LeavesBlock> createLeaves(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<LeavesBlock>) BlockFactory.getInstance().createTyped(name, () -> new LeavesBlock(properties.noOcclusion()));
    }

    default RegistryObject<? extends LeavesBlock> createLeaves(String name, Supplier<? extends LeavesBlock> tTypedSupplier) {
        return (RegistryObject<? extends LeavesBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
