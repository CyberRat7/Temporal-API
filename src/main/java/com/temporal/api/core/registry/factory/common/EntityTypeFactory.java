package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import com.temporal.api.core.engine.metadata.context.InjectionContext;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class EntityTypeFactory implements TypedFactory<EntityType<?>> {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = EnginedRegisterFactory.create(Registries.ENTITY_TYPE);

    public <T extends Entity> RegistryObject<EntityType<?>> create(String name, EntityType.EntityFactory<T> entityFactory, Rectangle rectangle, MobCategory category) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(entityFactory, category)
                .sized((float) rectangle.getWidth(), (float) rectangle.getHeight())
                .build(name));
    }

    public RegistryObject<EntityType<?>> create(String name, EntityType.Builder<?> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(name));
    }

    @Override
    public RegistryObject<EntityType<?>> create(String name, Supplier<EntityType<?>> entitySupplier) {
        return ENTITY_TYPES.register(name, entitySupplier);
    }

    @Override
    public RegistryObject<? extends EntityType<?>> createTyped(String name, Supplier<? extends EntityType<?>> entitySupplier) {
        return ENTITY_TYPES.register(name, entitySupplier);
    }

    @Override
    public void register() {
        ENTITY_TYPES.register(InjectionContext.getInstance().getObject(IEventBus.class));
    }
}
