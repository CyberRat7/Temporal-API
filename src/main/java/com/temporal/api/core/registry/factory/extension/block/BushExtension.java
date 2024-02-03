package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import com.temporal.api.core.registry.factory.extension.FactoryExtension;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BushExtension extends FactoryExtension<BushBlock, Block> {
    /**
     * @param args = args[0] - block properties
     */
    @Override
    default RegistryObject<BushBlock> createExtension(String name, TypedFactory<Block> tTypedFactory, Object... args) {
        return (RegistryObject<BushBlock>) tTypedFactory.createTyped(name, () -> new BushBlock(((BlockBehaviour.Properties) args[0]).noOcclusion().noCollission()));
    }

    @Override
    default RegistryObject<? extends BushBlock> createExtension(String name, TypedFactory<Block> tTypedFactory, Supplier<? extends BushBlock> tTypedSupplier) {
        return (RegistryObject<? extends BushBlock>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
