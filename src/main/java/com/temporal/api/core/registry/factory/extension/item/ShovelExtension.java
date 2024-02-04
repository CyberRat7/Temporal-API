package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ShovelExtension {
    /**
     * @param args = args[0] - tier, args[1] - damage, args[2] - speed
     */
    default RegistryObject<ShovelItem> createShovel(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<ShovelItem>) tTypedFactory.createTyped(name, () -> new ShovelItem((Tier) args[0], (Integer) args[1], (Float) args[2], new Item.Properties()));
    }

    default RegistryObject<? extends ShovelItem> createShovel(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends ShovelItem> tTypedSupplier) {
        return (RegistryObject<ShovelItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
