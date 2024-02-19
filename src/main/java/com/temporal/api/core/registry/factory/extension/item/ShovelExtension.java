package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ShovelExtension {
    default RegistryObject<ShovelItem> createShovel(String name, Tier tier, int damage, float speed) {
        return (RegistryObject<ShovelItem>) ItemFactory.getInstance().createTyped(name, () -> new ShovelItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends ShovelItem> createShovel(String name, Supplier<? extends ShovelItem> tTypedSupplier) {
        return (RegistryObject<ShovelItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
