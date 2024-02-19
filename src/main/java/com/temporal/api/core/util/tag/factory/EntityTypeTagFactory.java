package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class EntityTypeTagFactory implements TagFactory<EntityType<?>> {
    private static volatile TagFactory<EntityType<?>> instance;

    private EntityTypeTagFactory() {
    }

    @Override
    public TagKey<EntityType<?>> createTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new EnginedResourceLocation(name));
    }

    public static TagFactory<EntityType<?>> getInstance() {
        if (instance == null) {
            synchronized (EntityTypeTagFactory.class) {
                if (instance == null) {
                    instance = new EntityTypeTagFactory();
                }
            }
        }

        return instance;
    }
}
