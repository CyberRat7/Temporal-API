package com.temporal.api.core.registry.factory.common;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

public abstract class CreativeTabFactory implements ObjectFactory<CreativeModeTab> {
    private final DeferredRegister<CreativeModeTab> creativeTabRegister;

    public CreativeTabFactory(DeferredRegister<CreativeModeTab> creativeTabRegister) {
        this.creativeTabRegister = creativeTabRegister;
    }

    public RegistryObject<CreativeModeTab> create(String name, ItemStack icon, String translationId, ItemStack... items) {
        return create(name, () -> CreativeModeTab.builder()
                .icon(() -> icon)
                .title(Component.translatable(translationId))
                .displayItems((displayParameters, output) -> {
                    for (ItemStack item : items) {
                        output.accept(item);
                    }
                }).build());
    }

    public RegistryObject<CreativeModeTab> create(String name, ItemStack icon, String translationId, Collection<ItemStack> items) {
        return create(name, () -> CreativeModeTab.builder()
                .icon(() -> icon)
                .title(Component.translatable(translationId))
                .displayItems((displayParameters, output) -> output.acceptAll(items))
                .build());
    }

    @Override
    public RegistryObject<CreativeModeTab> create(String name, Supplier<CreativeModeTab> creativeModeTabSupplier) {
        return creativeTabRegister.register(name, creativeModeTabSupplier);
    }
}
