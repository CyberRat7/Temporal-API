package com.temporal.api.core.registry.factory.common;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class EntityFactory implements TypedFactory<Entity> {
    private final DeferredRegister<Entity> entityRegister;

    public EntityFactory(DeferredRegister<Entity> entityRegister) {
        this.entityRegister = entityRegister;
    }

    @Override
    public RegistryObject<Entity> create(String name, Supplier<Entity> entitySupplier) {
        return entityRegister.register(name, entitySupplier);
    }

    @Override
    public RegistryObject<? extends Entity> createTyped(String name, Supplier<? extends Entity> entitySupplier) {
        return entityRegister.register(name, entitySupplier);
    }
}
