package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.annotation.GermanTranslation;
import com.temporal.api.core.event.data.language.GermanProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

public class GermanTranslationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(GermanTranslation.class)) {
            field.setAccessible(true);
            GermanTranslation translation = field.getDeclaredAnnotation(GermanTranslation.class);
            if (translation.id() != null) {
                GermanProvider.OTHER_TRANSLATIONS.put(translation.id(), translation.value());
            } else {
                RegistryObject<?> registryObject = (RegistryObject<?>) field.get(object);
                Object capturedObject = registryObject.get();
                if (capturedObject instanceof Item item) {
                    GermanProvider.ITEM_TRANSLATIONS.put(item, translation.value());
                } else if (capturedObject instanceof Block block) {
                    GermanProvider.BLOCK_TRANSLATIONS.put(block, translation.value());
                } else if (capturedObject instanceof EntityType<?> entityType) {
                    GermanProvider.ENTITY_TRANSLATIONS.put(entityType, translation.value());
                } else if (capturedObject instanceof MobEffect mobEffect) {
                    GermanProvider.EFFECT_TRANSLATIONS.put(mobEffect, translation.value());
                } else if (capturedObject instanceof Enchantment enchantment) {
                    GermanProvider.ENCHANTMENT_TRANSLATIONS.put(enchantment, translation.value());
                }
            }
        }
    }
}
