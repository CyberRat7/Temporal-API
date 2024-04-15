package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import com.temporal.api.core.engine.metadata.annotation.Injected;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class EntityTypeFactory implements TypedFactory<EntityType<?>> {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = EnginedRegisterFactory.create(Registries.ENTITY_TYPE);

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
        ENTITY_TYPES.register(EVENT_BUS);
    }
}
