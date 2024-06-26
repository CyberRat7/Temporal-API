package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface AxeExtension {
    default RegistryObject<AxeItem> createAxe(String name, Tier tier, float damage, float speed) {
        return this.createAxe(name, tier, damage, speed, new Item.Properties());
    }

    default RegistryObject<AxeItem> createAxe(String name, Tier tier, float damage, float speed, Item.Properties properties) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<AxeItem>) itemFactory.createTyped(name, () -> new AxeItem(tier, damage, speed, properties));
    }

    default RegistryObject<? extends AxeItem> createAxe(String name, Supplier<? extends AxeItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<AxeItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
