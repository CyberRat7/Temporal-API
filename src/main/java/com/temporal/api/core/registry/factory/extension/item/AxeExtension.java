package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface AxeExtension {
    default RegistryObject<AxeItem> createAxe(String name, TypedFactory<Item> tTypedFactory, Tier tier, int damage, float speed) {
        return (RegistryObject<AxeItem>) tTypedFactory.createTyped(name, () -> new AxeItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends AxeItem> createAxe(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends AxeItem> tTypedSupplier) {
        return (RegistryObject<AxeItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
