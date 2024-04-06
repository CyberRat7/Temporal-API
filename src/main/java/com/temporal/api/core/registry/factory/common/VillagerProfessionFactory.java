package com.temporal.api.core.registry.factory.common;

import com.google.common.collect.ImmutableSet;
import com.temporal.api.core.engine.event.registry.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.temporal.api.core.engine.EventLayer.EVENT_BUS;

public class VillagerProfessionFactory implements TypedFactory<VillagerProfession> {
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = EnginedRegisterFactory.create(Registries.VILLAGER_PROFESSION);
    private static volatile VillagerProfessionFactory instance;

    public RegistryObject<VillagerProfession> create(String name, String professionName, PoiType heldJobSite, SoundEvent workSound) {
        return create(name, () -> new VillagerProfession(professionName, holder -> holder.get() == heldJobSite, holder -> holder.get() == heldJobSite, ImmutableSet.of(), ImmutableSet.of(), workSound));
    }

    public RegistryObject<VillagerProfession> create(String name, String professionName, PoiType heldJobSite, PoiType acquirableJobSite, SoundEvent workSound) {
        return create(name, () -> new VillagerProfession(professionName, holder -> holder.get() == heldJobSite, holder -> holder.get() == acquirableJobSite, ImmutableSet.of(), ImmutableSet.of(), workSound));
    }

    public RegistryObject<VillagerProfession> create(String name, String professionName, PoiType heldJobSite, PoiType acquirableJobSite, ImmutableSet<Item> requestedItems, ImmutableSet<Block> secondaryPoi, SoundEvent workSound) {
        return create(name, () -> new VillagerProfession(professionName, holder -> holder.get() == heldJobSite, holder -> holder.get() == acquirableJobSite, requestedItems, secondaryPoi, workSound));
    }

    @Override
    public RegistryObject<VillagerProfession> create(String name, Supplier<VillagerProfession> villagerProfessionSupplier) {
        return VILLAGER_PROFESSIONS.register(name, villagerProfessionSupplier);
    }

    @Override
    public RegistryObject<? extends VillagerProfession> createTyped(String name, Supplier<? extends VillagerProfession> tSupplier) {
        return VILLAGER_PROFESSIONS.register(name, tSupplier);
    }

    @Override
    public void register() {
        VILLAGER_PROFESSIONS.register(EVENT_BUS);
    }

    public static VillagerProfessionFactory getInstance() {
        if (instance == null) {
            synchronized (VillagerProfessionFactory.class) {
                if (instance == null) {
                    instance = new VillagerProfessionFactory();
                }
            }
        }

        return instance;
    }
}
