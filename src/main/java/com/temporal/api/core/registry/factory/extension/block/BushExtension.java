package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BushExtension {
    default RegistryObject<BushBlock> createBush(String name, TypedFactory<Block> tTypedFactory, BlockBehaviour.Properties properties) {
        return (RegistryObject<BushBlock>) tTypedFactory.createTyped(name, () -> new BushBlock((properties.noOcclusion().noCollission())));
    }

    default RegistryObject<? extends BushBlock> createBush(String name, TypedFactory<Block> tTypedFactory, Supplier<? extends BushBlock> tTypedSupplier) {
        return (RegistryObject<? extends BushBlock>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
