package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SwordExtension {
    default RegistryObject<SwordItem> createSword(String name, TypedFactory<Item> tTypedFactory, Tier tier, int damage, float speed) {
        return (RegistryObject<SwordItem>) tTypedFactory.createTyped(name, () -> new SwordItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends SwordItem> createSword(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends SwordItem> tTypedSupplier) {
        return (RegistryObject<SwordItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
