package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.annotation.UkrainianTranslation;
import com.temporal.api.core.event.data.language.EnglishProvider;
import com.temporal.api.core.event.data.language.UkrainianProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class UkrainianTranslationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(UkrainianTranslation.class)) {
            field.setAccessible(true);
            UkrainianTranslation translation = field.getDeclaredAnnotation(UkrainianTranslation.class);
            if (!translation.id().isBlank()) {
                UkrainianProvider.OTHER_TRANSLATIONS.put(translation.id(), translation.value());
            } else {
                RegistryObject<? extends Item> registryObject = (RegistryObject<? extends Item>) field.get(object);
                UkrainianProvider.ITEM_TRANSLATIONS.put(registryObject, translation.value());
            }
        }
    }
}
