package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SpawnEggExtension {
    default RegistryObject<ForgeSpawnEggItem> createSpawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int foregroundColor) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<ForgeSpawnEggItem>) itemFactory.createTyped(name, () -> new ForgeSpawnEggItem(type, backgroundColor, foregroundColor, new Item.Properties()));
    }

    default RegistryObject<? extends ForgeSpawnEggItem> createSpawnEgg(String name, Supplier<? extends ForgeSpawnEggItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<? extends ForgeSpawnEggItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
