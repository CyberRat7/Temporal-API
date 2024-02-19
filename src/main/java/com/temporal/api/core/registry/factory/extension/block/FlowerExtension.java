package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface FlowerExtension {
    default RegistryObject<FlowerBlock> createFlower(String name, BlockBehaviour.Properties properties, Supplier<MobEffect> mobEffect, int duration) {
        return (RegistryObject<FlowerBlock>) BlockFactory.getInstance().createTyped(name, () -> new FlowerBlock(mobEffect, duration, properties.noOcclusion().noCollission()));
    }
    
    default RegistryObject<? extends FlowerBlock> createFlower(String name, Supplier<? extends FlowerBlock> tTypedSupplier) {
        return (RegistryObject<? extends FlowerBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
