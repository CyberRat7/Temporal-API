package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ArrowExtension {
    default RegistryObject<ArrowItem> createArrow(String name, Item.Properties properties) {
        return (RegistryObject<ArrowItem>) ItemFactory.getInstance().createTyped(name, () -> new ArrowItem(properties));
    }

    default RegistryObject<? extends ArrowItem> createArrow(String name, Supplier<? extends ArrowItem> tTypedSupplier) {
        return (RegistryObject<? extends ArrowItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
