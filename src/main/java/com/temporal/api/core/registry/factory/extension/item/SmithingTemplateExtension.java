package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SmithingTemplateExtension {
    default RegistryObject<SmithingTemplateItem> createSmithingTemplate(String name) {
        return (RegistryObject<SmithingTemplateItem>) ItemFactory.getInstance().createTyped(name, () -> SmithingTemplateItem.createArmorTrimTemplate(new EnginedResourceLocation(name)));
    }

    default RegistryObject<? extends SmithingTemplateItem> createSmithingTemplate(String name, Supplier<? extends SmithingTemplateItem> tTypedSupplier) {
        return (RegistryObject<? extends SmithingTemplateItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
