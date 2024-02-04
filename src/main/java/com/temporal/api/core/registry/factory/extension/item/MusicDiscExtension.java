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
    /**
     * @param args = args[0] - comparator value, args[1] - soundEvent supplier, args[2] - length in ticks
     */
    default RegistryObject<RecordItem> createMusicDisc(String name, TypedFactory<Item> tTypedFactory, Object... args) {
        return (RegistryObject<RecordItem>) tTypedFactory.createTyped(name, () -> new RecordItem((Integer) args[0], (Supplier<SoundEvent>) args[1], new Item.Properties().stacksTo(1).rarity(Rarity.RARE), (Integer) args[2]));
    }

    default RegistryObject<? extends RecordItem> createMusicDisc(String name, TypedFactory<Item> tTypedFactory, Supplier<? extends RecordItem> tTypedSupplier) {
        return (RegistryObject<? extends RecordItem>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
