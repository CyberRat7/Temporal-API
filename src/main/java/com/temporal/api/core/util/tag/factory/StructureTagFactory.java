package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class StructureTagFactory implements TagFactory<Structure> {
    private static volatile TagFactory<Structure> instance;

    private StructureTagFactory() {
    }

    @Override
    public TagKey<Structure> createTag(String name) {
        return TagKey.create(Registries.STRUCTURE, new EnginedResourceLocation(name));
    }

    public static TagFactory<Structure> getInstance() {
        if (instance == null) {
            synchronized (StructureTagFactory.class) {
                if (instance == null) {
                    instance = new StructureTagFactory();
                }
            }
        }

        return instance;
    }
}
