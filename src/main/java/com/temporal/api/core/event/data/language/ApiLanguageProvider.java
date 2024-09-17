package com.temporal.api.core.event.data.language;

import com.temporal.api.core.engine.IOLayer;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Map;

public abstract class ApiLanguageProvider extends LanguageProvider {
    public ApiLanguageProvider(PackOutput output, String locale) {
        super(output, IOLayer.FORGE_MOD.getModId(), locale);
    }

    @Override
    protected void addTranslations() {
        this.getItemTranslations().forEach(this::add);
        this.getBlockTranslations().forEach(this::add);
        this.getEntityTranslations().forEach(this::add);
        this.getEffectTranslations().forEach(this::add);
        this.getEnchantmentTranslations().forEach(this::add);
        this.getOtherTranslations().forEach(this::add);
    }

    public abstract Map<Item, String> getItemTranslations();

    public abstract Map<Block, String> getBlockTranslations();

    public abstract Map<EntityType<?>, String> getEntityTranslations();

    public abstract Map<MobEffect, String> getEffectTranslations();

    public abstract Map<Enchantment, String> getEnchantmentTranslations();

    public abstract Map<String, String> getOtherTranslations();
}
