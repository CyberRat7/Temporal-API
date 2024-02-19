package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BowlExtension {
    default RegistryObject<BowlFoodItem> createBowl(String name, int nutrition, float saturation) {
        return (RegistryObject<BowlFoodItem>) ItemFactory.getInstance().createTyped(name, () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build())));
    }

    default RegistryObject<? extends BowlFoodItem> createBowl(String name, Supplier<? extends BowlFoodItem> tTypedSupplier) {
        return (RegistryObject<? extends BowlFoodItem>) ItemFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
