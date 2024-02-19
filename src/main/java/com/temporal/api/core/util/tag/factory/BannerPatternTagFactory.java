package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BannerPatternTagFactory implements TagFactory<BannerPattern> {
    private static volatile TagFactory<BannerPattern> instance;

    private BannerPatternTagFactory() {
    }

    @Override
    public TagKey<BannerPattern> createTag(String name) {
        return TagKey.create(Registries.BANNER_PATTERN, new EnginedResourceLocation(name));
    }

    public static TagFactory<BannerPattern> getInstance() {
        if (instance == null) {
            synchronized (BannerPatternTagFactory.class) {
                if (instance == null) {
                    instance = new BannerPatternTagFactory();
                }
            }
        }

        return instance;
    }
}
