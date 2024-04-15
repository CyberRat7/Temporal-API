package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface PickaxeExtension {
    default RegistryObject<PickaxeItem> createPickaxe(String name, Tier tier, int damage, float speed) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<PickaxeItem>) itemFactory.createTyped(name, () -> new PickaxeItem(tier, damage, speed, new Item.Properties()));
    }

    default RegistryObject<? extends PickaxeItem> createPickaxe(String name, Supplier<? extends PickaxeItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<PickaxeItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
