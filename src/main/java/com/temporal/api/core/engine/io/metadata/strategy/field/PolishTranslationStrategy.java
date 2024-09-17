package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.annotation.PolishTranslation;
import com.temporal.api.core.event.data.language.EnglishProvider;
import com.temporal.api.core.event.data.language.PolishProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class PolishTranslationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(PolishTranslation.class)) {
            field.setAccessible(true);
            PolishTranslation translation = field.getDeclaredAnnotation(PolishTranslation.class);
            if (!translation.id().isBlank()) {
                PolishProvider.OTHER_TRANSLATIONS.put(translation.id(), translation.value());
            } else {
                RegistryObject<? extends Item> registryObject = (RegistryObject<? extends Item>) field.get(object);
                PolishProvider.ITEM_TRANSLATIONS.put(registryObject, translation.value());
            }
        }
    }
}
