package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import com.temporal.api.core.engine.metadata.annotation.Injected;
import com.temporal.api.core.engine.metadata.annotation.Injection;
import com.temporal.api.core.engine.metadata.context.InjectionContext;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class BlockFactory implements TypedFactory<Block> {
    public static final DeferredRegister<Block> BLOCKS = EnginedRegisterFactory.create(Registries.BLOCK);
    private final ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);

    public RegistryObject<Block> create(String name, BlockBehaviour.Properties properties) {
        return create(name, () -> new Block(properties));
    }

    @Override
    public RegistryObject<Block> create(String name, Supplier<Block> blockSupplier) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        this.itemFactory.createTyped(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    @Override
    public RegistryObject<? extends Block> createTyped(String name, Supplier<? extends Block> typedBlockSupplier) {
        RegistryObject<? extends Block> typedBlock = BLOCKS.register(name, typedBlockSupplier);
        this.itemFactory.createTyped(name, () -> new BlockItem(typedBlock.get(), new Item.Properties()));
        return typedBlock;
    }

    @Override
    public void register() {
        BLOCKS.register(EVENT_BUS);
    }
}
