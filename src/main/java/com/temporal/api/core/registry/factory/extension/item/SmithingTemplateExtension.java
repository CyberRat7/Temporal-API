package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SmithingTemplateExtension {
    default RegistryObject<SmithingTemplateItem> createSmithingTemplate(String name, TypedFactory<Item> tTypedFactory, String modId) {
        return (RegistryObject<SmithingTemplateItem>) tTypedFactory.createTyped(name, () -> SmithingTemplateItem.createArmorTrimTemplate(new ResourceLocation(modId, name)));
    }

    default RegistryObject<? extends SmithingTemplateItem> createSmithingTemplate(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends SmithingTemplateItem> tTypedSupplier) {
        return (RegistryObject<? extends SmithingTemplateItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
