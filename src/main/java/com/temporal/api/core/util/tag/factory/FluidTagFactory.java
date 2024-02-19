package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class FluidTagFactory implements TagFactory<Fluid> {
    private static volatile TagFactory<Fluid> instance;

    private FluidTagFactory() {
    }

    @Override
    public TagKey<Fluid> createTag(String name) {
        return FluidTags.create(new EnginedResourceLocation(name));
    }

    public static TagFactory<Fluid> getInstance() {
        if (instance == null) {
            synchronized (FluidTagFactory.class) {
                if (instance == null) {
                    instance = new FluidTagFactory();
                }
            }
        }

        return instance;
    }
}
