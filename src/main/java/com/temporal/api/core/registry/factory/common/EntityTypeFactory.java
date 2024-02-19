package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EntityTypeFactory implements TypedFactory<EntityType<?>> {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = EnginedRegisterFactory.create(Registries.ENTITY_TYPE);
    private static volatile EntityTypeFactory instance;

    @Override
    public RegistryObject<EntityType<?>> create(String name, Supplier<EntityType<?>> entitySupplier) {
        return ENTITY_TYPES.register(name, entitySupplier);
    }

    @Override
    public RegistryObject<? extends EntityType<?>> createTyped(String name, Supplier<? extends EntityType<?>> entitySupplier) {
        return ENTITY_TYPES.register(name, entitySupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static EntityTypeFactory getInstance() {
        if (instance == null) {
            synchronized (EntityTypeFactory.class) {
                if (instance == null) {
                    instance = new EntityTypeFactory();
                }
            }
        }

        return instance;
    }
}
