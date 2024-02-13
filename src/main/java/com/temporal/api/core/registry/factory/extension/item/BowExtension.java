package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BowExtension {
    default RegistryObject<BowItem> createBow(String name, TypedFactory<Item> tTypedFactory, Item.Properties properties) {
        return (RegistryObject<BowItem>) tTypedFactory.createTyped(name, () -> new BowItem(properties));
    }

    default RegistryObject<? extends BowItem> createBow(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends BowItem> tTypedSupplier) {
        return (RegistryObject<? extends BowItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
