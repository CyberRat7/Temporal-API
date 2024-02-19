package com.temporal.api.core.registry.factory.common;

import com.google.common.collect.ImmutableSet;
import com.temporal.api.core.engine.io.EnginedRegisterFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.function.Supplier;

public class PoiTypeFactory implements TypedFactory<PoiType> {
    public static final DeferredRegister<PoiType> POI_TYPES = EnginedRegisterFactory.create(Registries.POINT_OF_INTEREST_TYPE);
    private static volatile PoiTypeFactory instance;

    public RegistryObject<PoiType> create(String name, Block block, int maxTickets, int validRange) {
        return create(name, ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), maxTickets, validRange);
    }

    public RegistryObject<PoiType> create(String name, Set<BlockState> matchingStates, int maxTickets, int validRange) {
        return create(name, () -> new PoiType(matchingStates, maxTickets, validRange));
    }

    @Override
    public RegistryObject<PoiType> create(String name, Supplier<PoiType> poiSupplier) {
        return POI_TYPES.register(name, poiSupplier);
    }

    @Override
    public RegistryObject<? extends PoiType> createTyped(String name, Supplier<? extends PoiType> tSupplier) {
        return POI_TYPES.register(name, tSupplier);
    }

    @Override
    public void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
    }

    public static PoiTypeFactory getInstance() {
        if (instance == null) {
            synchronized (PoiTypeFactory.class) {
                if (instance == null) {
                    instance = new PoiTypeFactory();
                }
            }
        }

        return instance;
    }
}
