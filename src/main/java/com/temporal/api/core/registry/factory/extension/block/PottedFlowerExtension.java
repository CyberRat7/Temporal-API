package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface PottedFlowerExtension {
    default RegistryObject<FlowerPotBlock> createPot(String name, TypedFactory<Block> tTypedFactory, BlockBehaviour.Properties properties, Supplier<? extends Block> flower) {
        return (RegistryObject<FlowerPotBlock>) tTypedFactory.createTyped(name, () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), flower, properties.noOcclusion().noCollission()));
    }

    default RegistryObject<? extends FlowerPotBlock> createPot(String name, TypedFactory<Block> tTypedFactory, Supplier<? extends FlowerPotBlock> tTypedSupplier) {
        return (RegistryObject<? extends FlowerPotBlock>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
