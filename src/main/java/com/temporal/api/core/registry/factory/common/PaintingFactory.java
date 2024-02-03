package com.temporal.api.core.registry.factory.common;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public abstract class PaintingFactory implements TypedFactory<PaintingVariant> {
    private final DeferredRegister<PaintingVariant> paintingRegister;

    public PaintingFactory(DeferredRegister<PaintingVariant> paintingRegister) {
        this.paintingRegister = paintingRegister;
    }

    public RegistryObject<PaintingVariant> create16x16(String name) {
        return create(name, 16, 16);
    }

    public RegistryObject<PaintingVariant> create16x32(String name) {
        return create(name, 16, 32);
    }

    public RegistryObject<PaintingVariant> create32x16(String name) {
        return create(name, 32, 16);
    }

    public RegistryObject<PaintingVariant> create32x32(String name) {
        return create(name, 32, 32);
    }

    public RegistryObject<PaintingVariant> create(String name, int width, int height) {
        return create(name, () -> new PaintingVariant(width, height));
    }

    @Override
    public RegistryObject<PaintingVariant> create(String name, Supplier<PaintingVariant> paintingVariantSupplier) {
        return paintingRegister.register(name, paintingVariantSupplier);
    }

    @Override
    public RegistryObject<? extends PaintingVariant> createTyped(String name, Supplier<? extends PaintingVariant> tSupplier) {
        return paintingRegister.register(name, tSupplier);
    }
}
