package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.annotation.Translation;
import com.temporal.api.core.event.data.language.ApiLanguageProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

public class TranslationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(Translation.class)) {
            field.setAccessible(true);
            Translation translation = field.getDeclaredAnnotation(Translation.class);
            if (translation.id() != null) {
                ApiLanguageProvider.OTHER_TRANSLATIONS.put(translation.id(), translation.value());
            } else {
                RegistryObject<?> registryObject = (RegistryObject<?>) field.get(object);
                Object capturedObject = registryObject.get();
                if (capturedObject instanceof Item item) {
                    ApiLanguageProvider.ITEM_TRANSLATIONS.put(item, translation.value());
                } else if (capturedObject instanceof Block block) {
                    ApiLanguageProvider.BLOCK_TRANSLATIONS.put(block, translation.value());
                } else if (capturedObject instanceof EntityType<?> entityType) {
                    ApiLanguageProvider.ENTITY_TRANSLATIONS.put(entityType, translation.value());
                } else if (capturedObject instanceof MobEffect mobEffect) {
                    ApiLanguageProvider.EFFECT_TRANSLATIONS.put(mobEffect, translation.value());
                } else if (capturedObject instanceof Enchantment enchantment) {
                    ApiLanguageProvider.ENCHANTMENT_TRANSLATIONS.put(enchantment, translation.value());
                }
            }
        }
    }
}
