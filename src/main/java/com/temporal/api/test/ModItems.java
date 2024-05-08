package com.temporal.api.test;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.engine.io.metadata.annotation.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.ItemModel;
import com.temporal.api.core.engine.io.metadata.annotation.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.RegistryObject;

@Injected(isContextObject = false)
public class ModItems {
    @Registry
    public static final SwordItemFactory ITEM_FACTORY = InjectionContext.getInstance().getObject(SwordItemFactory.class);
    @ItemModel
    public static final RegistryObject<Item> TEST_ITEM = ITEM_FACTORY.create("test_item");
    @ItemModel(type = ItemModel.Type.HANDHELD)
    public static final RegistryObject<SwordItem> TEST_SWORD = ITEM_FACTORY.createSword("test_sword", Tiers.GOLD, 5, 7.9f);
}
