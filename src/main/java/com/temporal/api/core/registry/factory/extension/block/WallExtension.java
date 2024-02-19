package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface WallExtension {
    default RegistryObject<WallBlock> createWall(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<WallBlock>) BlockFactory.getInstance().createTyped(name, () -> new WallBlock(properties));
    }

    default RegistryObject<? extends WallBlock> createWall(String name, Supplier<? extends WallBlock> tTypedSupplier) {
        return (RegistryObject<? extends WallBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
