package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface ItemNameBlockItemExtension {
    default RegistryObject<ItemNameBlockItem> createItemNameBlockName(String name, Item.Properties properties, Block block) {
        return (RegistryObject<ItemNameBlockItem>) ItemFactory.getInstance().createTyped(name, () -> new ItemNameBlockItem(block, properties));
    }

    default RegistryObject<? extends ItemNameBlockItem> createItemNameBlockName(String name, Supplier<? extends ItemNameBlockItem> tTypedSupplier) {
        return (RegistryObject<? extends ItemNameBlockItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
