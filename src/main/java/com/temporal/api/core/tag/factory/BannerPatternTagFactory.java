package com.temporal.api.core.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import com.temporal.api.core.engine.metadata.annotation.Injected;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BannerPatternTagFactory implements TagFactory<BannerPattern> {
    @Override
    public TagKey<BannerPattern> createTag(String name) {
        return TagKey.create(Registries.BANNER_PATTERN, new EnginedResourceLocation(name));
    }
}
