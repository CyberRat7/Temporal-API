package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SlabExtension {
    default RegistryObject<SlabBlock> createSlab(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<SlabBlock>) BlockFactory.getInstance().createTyped(name, () -> new SlabBlock(properties));
    }

    default RegistryObject<? extends SlabBlock> createSlab(String name, Supplier<? extends SlabBlock> tTypedSupplier) {
        return (RegistryObject<? extends SlabBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
