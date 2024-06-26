package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ShovelExtension {
    default RegistryObject<ShovelItem> createShovel(String name, Tier tier, float damage, float speed) {
        return this.createShovel(name, tier, damage, speed, new Item.Properties());
    }

    default RegistryObject<ShovelItem> createShovel(String name, Tier tier, float damage, float speed, Item.Properties properties) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<ShovelItem>) itemFactory.createTyped(name, () -> new ShovelItem(tier, damage, speed, properties));
    }

    default RegistryObject<? extends ShovelItem> createShovel(String name, Supplier<? extends ShovelItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<ShovelItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
