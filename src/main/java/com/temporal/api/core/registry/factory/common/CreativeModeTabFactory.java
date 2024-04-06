package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class CreativeModeTabFactory implements ObjectFactory<CreativeModeTab> {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = EnginedRegisterFactory.create(Registries.CREATIVE_MODE_TAB);
    private static volatile CreativeModeTabFactory instance;

    public RegistryObject<CreativeModeTab> create(String name, Item icon, String translationId, Item... items) {
        return create(name, () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(translationId))
                .displayItems((displayParameters, output) -> {
                    for (Item item : items) {
                        output.accept(item);
                    }
                }).build());
    }

    public RegistryObject<CreativeModeTab> create(String name, Item icon, String translationId, Collection<ItemStack> items) {
        return create(name, () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(icon))
                .title(Component.translatable(translationId))
                .displayItems((displayParameters, output) -> output.acceptAll(items))
                .build());
    }

    @Override
    public RegistryObject<CreativeModeTab> create(String name, Supplier<CreativeModeTab> creativeModeTabSupplier) {
        return CREATIVE_MODE_TABS.register(name, creativeModeTabSupplier);
    }

    @Override
    public void register() {
        CREATIVE_MODE_TABS.register(EVENT_BUS);
    }

    public static CreativeModeTabFactory getInstance() {
        if (instance == null) {
            synchronized (CreativeModeTabFactory.class) {
                if (instance == null) {
                    instance = new CreativeModeTabFactory();
                }
            }
        }

        return instance;
    }
}
