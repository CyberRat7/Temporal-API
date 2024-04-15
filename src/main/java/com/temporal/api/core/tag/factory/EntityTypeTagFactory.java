package com.temporal.api.core.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import com.temporal.api.core.engine.metadata.annotation.Injected;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class EntityTypeTagFactory implements TagFactory<EntityType<?>> {
    @Override
    public TagKey<EntityType<?>> createTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new EnginedResourceLocation(name));
    }
}
