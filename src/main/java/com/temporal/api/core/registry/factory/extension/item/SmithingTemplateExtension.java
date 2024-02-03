package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import com.temporal.api.core.registry.factory.extension.FactoryExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface SmithingTemplateExtension extends FactoryExtension<SmithingTemplateItem, Item> {
    /**
     * @param args = arg[0] - MOD_ID
     */
    @Override
    default RegistryObject<SmithingTemplateItem> createExtension(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<SmithingTemplateItem>) tTypedFactory.createTyped(name, () -> SmithingTemplateItem.createArmorTrimTemplate(new ResourceLocation(args[0].toString(), name)));
    }

    @Override
    default RegistryObject<? extends SmithingTemplateItem> createExtension(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends SmithingTemplateItem> tTypedSupplier) {
        return (RegistryObject<? extends SmithingTemplateItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
