package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BushExtension {
    /**
     * @param args = args[0] - block properties
     */
    default RegistryObject<BushBlock> createBush(String name, TypedFactory<Block> tTypedFactory, Object... args) {
        return (RegistryObject<BushBlock>) tTypedFactory.createTyped(name, () -> new BushBlock(((BlockBehaviour.Properties) args[0]).noOcclusion().noCollission()));
    }

    default RegistryObject<? extends BushBlock> createBush(String name, TypedFactory<Block> tTypedFactory, Supplier<? extends BushBlock> tTypedSupplier) {
        return (RegistryObject<? extends BushBlock>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
