package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import com.temporal.api.core.engine.metadata.annotation.Injected;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class ItemFactory implements TypedFactory<Item> {
    public static final DeferredRegister<Item> ITEMS = EnginedRegisterFactory.create(Registries.ITEM);

    public RegistryObject<Item> create(String name) {
        return create(name, () -> new Item(new Item.Properties()));
    }

    public RegistryObject<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    @Override
    public RegistryObject<Item> create(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    @Override
    public RegistryObject<? extends Item> createTyped(String name, Supplier<? extends Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    @Override
    public void register() {
        ITEMS.register(EVENT_BUS);
    }
}
