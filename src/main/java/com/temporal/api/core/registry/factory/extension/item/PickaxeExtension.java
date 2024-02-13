package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface PickaxeExtension {
    default RegistryObject<PickaxeItem> createPickaxe(String name, TypedFactory<Item> tTypedFactory, Tier tier, int damage, float speed) {
        return (RegistryObject<PickaxeItem>) tTypedFactory.createTyped(name, () -> new PickaxeItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends PickaxeItem> createPickaxe(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends PickaxeItem> tTypedSupplier) {
        return (RegistryObject<PickaxeItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
