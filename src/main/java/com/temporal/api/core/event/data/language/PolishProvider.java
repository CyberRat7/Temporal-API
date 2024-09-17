package com.temporal.api.core.event.data.language;

import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class PolishProvider extends ApiLanguageProvider {
    public static final Map<Item, String> ITEM_TRANSLATIONS = new HashMap<>();
    public static final Map<Block, String> BLOCK_TRANSLATIONS = new HashMap<>();
    public static final Map<EntityType<?>, String> ENTITY_TRANSLATIONS = new HashMap<>();
    public static final Map<MobEffect, String> EFFECT_TRANSLATIONS = new HashMap<>();
    public static final Map<Enchantment, String> ENCHANTMENT_TRANSLATIONS = new HashMap<>();
    public static final Map<String, String> OTHER_TRANSLATIONS = new HashMap<>();

    public PolishProvider(PackOutput output) {
        super(output, "pl-pl");
    }

    @Override
    public Map<Item, String> getItemTranslations() {
        return ITEM_TRANSLATIONS;
    }

    @Override
    public Map<Block, String> getBlockTranslations() {
        return BLOCK_TRANSLATIONS;
    }

    @Override
    public Map<EntityType<?>, String> getEntityTranslations() {
        return ENTITY_TRANSLATIONS;
    }

    @Override
    public Map<MobEffect, String> getEffectTranslations() {
        return EFFECT_TRANSLATIONS;
    }

    @Override
    public Map<Enchantment, String> getEnchantmentTranslations() {
        return ENCHANTMENT_TRANSLATIONS;
    }

    @Override
    public Map<String, String> getOtherTranslations() {
        return OTHER_TRANSLATIONS;
    }
}