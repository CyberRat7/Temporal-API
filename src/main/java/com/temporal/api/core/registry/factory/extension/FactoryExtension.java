package com.temporal.api.core.registry.factory.extension;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public interface FactoryExtension<T, F> {
    RegistryObject<T> createExtension(String name, TypedFactory<F> tTypedFactory, Object... args);

    RegistryObject<? extends T> createExtension(String name, TypedFactory<F> tTypedFactory, Supplier<? extends T> tTypedSupplier);
}
