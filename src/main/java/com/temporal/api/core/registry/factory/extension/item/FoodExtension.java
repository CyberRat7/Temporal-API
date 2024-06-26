package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unchecked")
public interface FoodExtension {
    default RegistryObject<Item> createFood(String name, int nutrition, float saturation) {
        return createFood(name, new Item.Properties(), nutrition, saturation);
    }

    default RegistryObject<Item> createFood(String name, int nutrition, float saturation, MobEffect effect, float effectDuration) {
        return createFood(name, new Item.Properties(), nutrition, saturation, effect, effectDuration);
    }

    default RegistryObject<Item> createFood(String name, Item.Properties properties, int nutrition, float saturation) {
        return createFood(name, properties, new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build());
    }

    default RegistryObject<Item> createFood(String name, Item.Properties properties, int nutrition, float saturation, MobEffect effect, float effectDuration) {
        return createFood(name, properties, new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).effect(() -> new MobEffectInstance(effect), effectDuration).build());
    }

    default RegistryObject<Item> createFood(String name, Item.Properties properties, FoodProperties foodProperties) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<Item>) itemFactory.createTyped(name, () -> new Item(properties.food(foodProperties)));
    }
}
