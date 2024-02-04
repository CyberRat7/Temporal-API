package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface AxeExtension {
    /**
     * @param args = args[0] - tier, args[1] - damage, args[2] - speed
     */
    default RegistryObject<AxeItem> createAxe(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<AxeItem>) tTypedFactory.createTyped(name, () -> new AxeItem((Tier) args[0], (Integer) args[1], (Float) args[2], new Item.Properties()));
    }

    default RegistryObject<? extends AxeItem> createAxe(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends AxeItem> tTypedSupplier) {
        return (RegistryObject<AxeItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
