package com.temporal.api.core.event.data.language;

import com.temporal.api.core.engine.IOLayer;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.HashMap;
import java.util.Map;

public class ApiLanguageProvider extends LanguageProvider {
    public static final Map<Item, String> ITEM_TRANSLATIONS = new HashMap<>();
    public static final Map<Block, String> BLOCK_TRANSLATIONS = new HashMap<>();
    public static final Map<EntityType<?>, String> ENTITY_TRANSLATIONS = new HashMap<>();
    public static final Map<MobEffect, String> EFFECT_TRANSLATIONS = new HashMap<>();
    public static final Map<Enchantment, String> ENCHANTMENT_TRANSLATIONS = new HashMap<>();
    public static final Map<String, String> OTHER_TRANSLATIONS = new HashMap<>();

    public ApiLanguageProvider(PackOutput output) {
        this(output, "en-us");
    }

    public ApiLanguageProvider(PackOutput output, String locale) {
        super(output, IOLayer.FORGE_MOD.getModId(), locale);
    }

    @Override
    protected void addTranslations() {
        ITEM_TRANSLATIONS.forEach(this::add);
        BLOCK_TRANSLATIONS.forEach(this::add);
        ENTITY_TRANSLATIONS.forEach(this::add);
        EFFECT_TRANSLATIONS.forEach(this::add);
        ENCHANTMENT_TRANSLATIONS.forEach(this::add);
        OTHER_TRANSLATIONS.forEach(this::add);
    }
}
