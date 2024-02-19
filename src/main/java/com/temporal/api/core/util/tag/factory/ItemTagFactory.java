package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTagFactory implements TagFactory<Item> {
    private static volatile TagFactory<Item> instance;

    private ItemTagFactory() {
    }

    @Override
    public TagKey<Item> createTag(String name) {
        return ItemTags.create(new EnginedResourceLocation(name));
    }

    public static TagFactory<Item> getInstance() {
        if (instance == null) {
            synchronized (BlockTagFactory.class) {
                if (instance == null) {
                    instance = new ItemTagFactory();
                }
            }
        }

        return instance;
    }
}
