package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BowlExtension {
    /**
     * @param args = args[0] - nutrition, args[1] - saturation
     */
    default RegistryObject<BowlFoodItem> createBowl(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<BowlFoodItem>) tTypedFactory.createTyped(name, () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition((Integer) args[0]).saturationMod((Float) args[1]).build())));
    }

    default RegistryObject<? extends BowlFoodItem> createBowl(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends BowlFoodItem> tTypedSupplier) {
        return (RegistryObject<? extends BowlFoodItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
