package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import com.temporal.api.core.registry.factory.extension.FactoryExtension;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface PottedFlowerExtension extends FactoryExtension<FlowerPotBlock, Block> {
    /**
     * @param args = args[0] - flower supplier, args[1] - block properties
     */
    @Override
    default RegistryObject<FlowerPotBlock> createExtension(String name, TypedFactory<Block> tTypedFactory, Object... args) {
        return (RegistryObject<FlowerPotBlock>) tTypedFactory.createTyped(name, () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), (Supplier<? extends Block>) args[0], ((BlockBehaviour.Properties) args[1]).noOcclusion().noCollission()));
    }

    @Override
    default RegistryObject<? extends FlowerPotBlock> createExtension(String name, TypedFactory<Block> tTypedFactory, Supplier<? extends FlowerPotBlock> tTypedSupplier) {
        return (RegistryObject<? extends FlowerPotBlock>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
