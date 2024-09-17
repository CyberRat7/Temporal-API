package com.temporal.api.core.engine.io.metadata.strategy.field;

import com.temporal.api.core.engine.io.metadata.annotation.FrenchTranslation;
import com.temporal.api.core.event.data.language.FrenchProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

public class FrenchTranslationStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(FrenchTranslation.class)) {
            field.setAccessible(true);
            FrenchTranslation translation = field.getDeclaredAnnotation(FrenchTranslation.class);
            if (!translation.id().isBlank()) {
                FrenchProvider.OTHER_TRANSLATIONS.put(translation.id(), translation.value());
            } else {
                RegistryObject<?> registryObject = (RegistryObject<?>) field.get(object);
                Object capturedObject = registryObject.get();
                if (capturedObject instanceof Item item) {
                    FrenchProvider.ITEM_TRANSLATIONS.put(item, translation.value());
                } else if (capturedObject instanceof Block block) {
                    FrenchProvider.BLOCK_TRANSLATIONS.put(block, translation.value());
                } else if (capturedObject instanceof EntityType<?> entityType) {
                    FrenchProvider.ENTITY_TRANSLATIONS.put(entityType, translation.value());
                } else if (capturedObject instanceof MobEffect mobEffect) {
                    FrenchProvider.EFFECT_TRANSLATIONS.put(mobEffect, translation.value());
                } else if (capturedObject instanceof Enchantment enchantment) {
                    FrenchProvider.ENCHANTMENT_TRANSLATIONS.put(enchantment, translation.value());
                }
            }
        }
    }
}
