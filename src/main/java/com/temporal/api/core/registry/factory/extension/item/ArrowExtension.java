package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import com.temporal.api.core.registry.factory.extension.FactoryExtension;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ArrowExtension extends FactoryExtension<ArrowItem, Item> {
    /**
     * @param args = args[0] - item properties
     */
    @Override
    default RegistryObject<ArrowItem> createExtension(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<ArrowItem>) tTypedFactory.createTyped(name, () -> new ArrowItem((Item.Properties) args[0]));
    }

    @Override
    default RegistryObject<? extends ArrowItem> createExtension(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends ArrowItem> tTypedSupplier) {
        return (RegistryObject<? extends ArrowItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
