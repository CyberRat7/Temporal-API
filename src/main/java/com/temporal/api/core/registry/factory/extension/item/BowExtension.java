package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BowExtension {
    /**
     * @param args = args[0] - item properties
     */
    default RegistryObject<BowItem> createBow(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<BowItem>) tTypedFactory.createTyped(name, () -> new BowItem((Item.Properties) args[0]));
    }

    default RegistryObject<? extends BowItem> createBow(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends BowItem> tTypedSupplier) {
        return (RegistryObject<? extends BowItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
