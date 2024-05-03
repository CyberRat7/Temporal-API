package com.temporal.api.core.tag.factory;

import com.temporal.api.core.engine.io.resource.InjectedResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTagFactory implements TagFactory<Item> {
    @Override
    public TagKey<Item> createTag(String name) {
        return ItemTags.create(new InjectedResourceLocation(name));
    }
}
