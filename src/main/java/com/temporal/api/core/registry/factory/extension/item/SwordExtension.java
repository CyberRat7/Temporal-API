package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SwordExtension {
    default RegistryObject<SwordItem> createSword(String name, Tier tier, int damage, float speed) {
        return (RegistryObject<SwordItem>) ItemFactory.getInstance().createTyped(name, () -> new SwordItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends SwordItem> createSword(String name, Supplier<? extends SwordItem> tTypedSupplier) {
        return (RegistryObject<SwordItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
