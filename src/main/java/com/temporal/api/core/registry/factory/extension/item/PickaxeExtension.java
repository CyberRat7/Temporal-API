package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface PickaxeExtension {
    /**
     * @param args = args[0] - tier, args[1] - damage, args[2] - speed
     */
    default RegistryObject<PickaxeItem> createPickaxe(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<PickaxeItem>) tTypedFactory.createTyped(name, () -> new PickaxeItem((Tier) args[0], (Integer) args[1], (Float) args[2], new Item.Properties()));
    }

    default RegistryObject<? extends PickaxeItem> createPickaxe(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends PickaxeItem> tTypedSupplier) {
        return (RegistryObject<PickaxeItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
