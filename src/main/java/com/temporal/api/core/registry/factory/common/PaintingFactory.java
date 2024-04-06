package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class PaintingFactory implements TypedFactory<PaintingVariant> {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = EnginedRegisterFactory.create(Registries.PAINTING_VARIANT);
    private static volatile PaintingFactory instance;

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
        return PAINTING_VARIANTS.register(name, paintingVariantSupplier);
    }

    @Override
    public RegistryObject<? extends PaintingVariant> createTyped(String name, Supplier<? extends PaintingVariant> tSupplier) {
        return PAINTING_VARIANTS.register(name, tSupplier);
    }

    @Override
    public void register() {
        PAINTING_VARIANTS.register(EVENT_BUS);
    }

    public static PaintingFactory getInstance() {
        if (instance == null) {
            synchronized (PaintingFactory.class) {
                if (instance == null) {
                    instance = new PaintingFactory();
                }
            }
        }

        return instance;
    }
}
