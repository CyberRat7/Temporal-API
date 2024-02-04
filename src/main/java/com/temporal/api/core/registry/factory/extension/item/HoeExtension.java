package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface HoeExtension {
    /**
     * @param args = args[0] - tier, args[1] - damage, args[2] - speed
     */
    default RegistryObject<HoeItem> createHoe(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<HoeItem>) tTypedFactory.createTyped(name, () -> new HoeItem((Tier) args[0], (Integer) args[1], (Float) args[2], new Item.Properties()));
    }

    default RegistryObject<? extends HoeItem> createHoe(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends HoeItem> tTypedSupplier) {
        return (RegistryObject<HoeItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
