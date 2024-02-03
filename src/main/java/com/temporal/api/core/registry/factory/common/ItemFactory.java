package com.temporal.api.core.registry.factory.common;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class ItemFactory implements TypedFactory<Item> {
    private final DeferredRegister<Item> itemRegister;

    public ItemFactory(DeferredRegister<Item> itemRegister) {
        this.itemRegister = itemRegister;
    }

    public RegistryObject<Item> create(String name) {
        return create(name, () -> new Item(new Item.Properties()));
    }

    public RegistryObject<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    @Override
    public RegistryObject<Item> create(String name, Supplier<Item> itemSupplier) {
        return itemRegister.register(name, itemSupplier);
    }

    @Override
    public RegistryObject<? extends Item> createTyped(String name, Supplier<? extends Item> itemSupplier) {
        return itemRegister.register(name, itemSupplier);
    }
}
