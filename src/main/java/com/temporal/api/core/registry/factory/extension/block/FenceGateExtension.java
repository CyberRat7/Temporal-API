package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface FenceGateExtension {
    default RegistryObject<FenceGateBlock> createFenceGate(String name, BlockBehaviour.Properties properties, SoundEvent openSound, SoundEvent closeSound) {
        return (RegistryObject<FenceGateBlock>) BlockFactory.getInstance().createTyped(name, () -> new FenceGateBlock(properties, openSound, closeSound));
    }

    default RegistryObject<? extends FenceGateBlock> createFenceGate(String name, Supplier<? extends FenceGateBlock> tTypedSupplier) {
        return (RegistryObject<? extends FenceGateBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
