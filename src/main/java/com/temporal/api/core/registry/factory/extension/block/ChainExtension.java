package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ChainExtension {
    default RegistryObject<ChainBlock> createBush(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<ChainBlock>) BlockFactory.getInstance().createTyped(name, () -> new ChainBlock(properties.sound(SoundType.CHAIN).noOcclusion()));
    }

    default RegistryObject<? extends ChainBlock> createBush(String name, Supplier<? extends ChainBlock> tTypedSupplier) {
        return (RegistryObject<? extends ChainBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
