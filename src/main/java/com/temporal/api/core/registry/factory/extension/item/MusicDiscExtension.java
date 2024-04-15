package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface MusicDiscExtension {
    default RegistryObject<RecordItem> createMusicDisc(String name, int comparatorValue, Supplier<SoundEvent> soundEvent, int lengthInTicks) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<RecordItem>) itemFactory.createTyped(name, () -> new RecordItem(comparatorValue, soundEvent, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), lengthInTicks));
    }

    default RegistryObject<? extends RecordItem> createMusicDisc(String name, Supplier<? extends RecordItem> tTypedSupplier) {
        ItemFactory itemFactory = InjectionContext.getInstance().getObject(ItemFactory.class);
        return (RegistryObject<? extends RecordItem>) itemFactory.createTyped(name, tTypedSupplier);
    }
}
