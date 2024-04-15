package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface BowlExtension {
    default RegistryObject<BowlFoodItem> createBowl(String name, int nutrition, float saturation) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<BowlFoodItem>) itemFactory.createTyped(name, () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build())));
    }

    default RegistryObject<? extends BowlFoodItem> createBowl(String name, Supplier<? extends BowlFoodItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<? extends BowlFoodItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
