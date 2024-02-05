package com.temporal.api.core.util.tag.factory;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class BlockTagFactory extends AbstractTagFactory<Item> {
    public BlockTagFactory(String modId) {
        super(modId);
    }

    @Override
    public TagKey<Item> createTag(String name) {
        return ItemTags.create(new ResourceLocation(this.getModId(), name));
    }
}
