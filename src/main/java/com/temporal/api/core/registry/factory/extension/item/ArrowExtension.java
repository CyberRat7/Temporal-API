package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ArrowExtension {
    default RegistryObject<ArrowItem> createArrow(String name, TypedFactory<Item> tTypedFactory, Item.Properties properties) {
        return (RegistryObject<ArrowItem>) tTypedFactory.createTyped(name, () -> new ArrowItem(properties));
    }

    default RegistryObject<? extends ArrowItem> createArrow(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends ArrowItem> tTypedSupplier) {
        return (RegistryObject<? extends ArrowItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
