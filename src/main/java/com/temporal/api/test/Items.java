package com.temporal.api.test;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final ItemFactory ITEM_FACTORY = ItemFactory.getInstance();

    public static final RegistryObject<Item> ITEM_1 = ITEM_FACTORY.create("item_1");
    public static final RegistryObject<Item> ITEM_2 = ITEM_FACTORY.create("item_2");
}
