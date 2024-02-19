package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SpawnEggExtension {
    default RegistryObject<ForgeSpawnEggItem> createBowl(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int foregroundColor) {
        return (RegistryObject<ForgeSpawnEggItem>) ItemFactory.getInstance().createTyped(name, () -> new ForgeSpawnEggItem(type, backgroundColor, foregroundColor, new Item.Properties()));
    }

    default RegistryObject<? extends ForgeSpawnEggItem> createBowl(String name, Supplier<? extends ForgeSpawnEggItem> tTypedSupplier) {
        return (RegistryObject<? extends ForgeSpawnEggItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
