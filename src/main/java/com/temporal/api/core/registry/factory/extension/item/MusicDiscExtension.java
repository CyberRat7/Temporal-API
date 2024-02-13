package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface MusicDiscExtension {
    default RegistryObject<RecordItem> createMusicDisc(String name, TypedFactory<Item> tTypedFactory, int comparatorValue, Supplier<SoundEvent> soundEvent, int lengthInTicks) {
        return (RegistryObject<RecordItem>) tTypedFactory.createTyped(name, () -> new RecordItem(comparatorValue, soundEvent, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), lengthInTicks));
    }

    default RegistryObject<? extends RecordItem> createMusicDisc(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends RecordItem> tTypedSupplier) {
        return (RegistryObject<? extends RecordItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
