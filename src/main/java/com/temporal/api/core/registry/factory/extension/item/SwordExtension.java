package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SwordExtension {
    default RegistryObject<SwordItem> createSword(String name, Tier tier, int damage, float speed) {
        return this.createSword(name, tier, damage, speed, new Item.Properties());
    }

    default RegistryObject<SwordItem> createSword(String name, Tier tier, int damage, float speed, Item.Properties properties) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<SwordItem>) itemFactory.createTyped(name, () -> new SwordItem(tier, damage, speed, properties));
    }

    default RegistryObject<? extends SwordItem> createSword(String name, Supplier<? extends SwordItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<SwordItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
