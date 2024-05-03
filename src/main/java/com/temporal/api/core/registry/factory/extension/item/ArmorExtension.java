package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ArmorExtension {
    default RegistryObject<ArmorItem> createArmor(String name, ArmorMaterial material, ArmorItem.Type type) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<ArmorItem>) itemFactory.createTyped(name, () -> new ArmorItem(material, type, new Item.Properties()));
    }

    default RegistryObject<? extends ArmorItem> createArmor(String name, Supplier<? extends ArrowItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<? extends ArmorItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
