package com.temporal.api.core.util.tag.factory;

import net.minecraft.tags.TagKey;

public interface TagFactory<T> {
    TagKey<T> createTag(String name);
}
