package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SwordExtension {
    /**
     * @param args = args[0] - tier, args[1] - damage, args[2] - speed
     */
    default RegistryObject<SwordItem> createSword(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<SwordItem>) tTypedFactory.createTyped(name, () -> new SwordItem((Tier) args[0], (Integer) args[1], (Float) args[2], new Item.Properties()));
    }

    default RegistryObject<? extends SwordItem> createSword(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends SwordItem> tTypedSupplier) {
        return (RegistryObject<SwordItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
