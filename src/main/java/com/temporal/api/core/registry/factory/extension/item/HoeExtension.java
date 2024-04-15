package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface HoeExtension {
    default RegistryObject<HoeItem> createHoe(String name, Tier tier, int damage, float speed) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<HoeItem>) itemFactory.createTyped(name, () -> new HoeItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends HoeItem> createHoe(String name, Supplier<? extends HoeItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<HoeItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
