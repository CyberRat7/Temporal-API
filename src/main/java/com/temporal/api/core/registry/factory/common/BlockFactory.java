package com.temporal.api.core.registry.factory.common;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class BlockFactory implements TypedFactory<Block> {
    private final DeferredRegister<Block> blockRegister;
    private final TypedFactory<Item> itemFactory;

    public BlockFactory(DeferredRegister<Block> blockRegister, TypedFactory<Item> itemFactory) {
        this.blockRegister = blockRegister;
        this.itemFactory = itemFactory;
    }

    public RegistryObject<Block> create(String name, BlockBehaviour.Properties properties) {
        return create(name, () -> new Block(properties));
    }

    @Override
    public RegistryObject<Block> create(String name, Supplier<Block> blockSupplier) {
        RegistryObject<Block> block = blockRegister.register(name, blockSupplier);
        itemFactory.createTyped(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    @Override
    public RegistryObject<? extends Block> createTyped(String name, Supplier<? extends Block> typedBlockSupplier) {
        RegistryObject<? extends Block> typedBlock = blockRegister.register(name, typedBlockSupplier);
        itemFactory.createTyped(name, () -> new BlockItem(typedBlock.get(), new Item.Properties()));
        return typedBlock;
    }
}
