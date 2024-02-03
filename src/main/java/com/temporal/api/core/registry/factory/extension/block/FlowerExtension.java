package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.TypedFactory;
import com.temporal.api.core.registry.factory.extension.FactoryExtension;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface FlowerExtension extends FactoryExtension<FlowerBlock, Block> {
    /**
     * @param args =  args[0] - block properties, args[1] - mob effect, args[2] - duration
     */
    @Override
    default RegistryObject<FlowerBlock> createExtension(String name, TypedFactory<Block> tTypedFactory, Object... args) {
        return (RegistryObject<FlowerBlock>) tTypedFactory.createTyped(name, () -> new FlowerBlock((Supplier<MobEffect>) args[1], (Integer) args[2], ((BlockBehaviour.Properties) args[0]).noOcclusion().noCollission()));
    }

    @Override
    default RegistryObject<? extends FlowerBlock> createExtension(String name, TypedFactory<Block> tTypedFactory, Supplier<? extends FlowerBlock> tTypedSupplier) {
        return (RegistryObject<? extends FlowerBlock>) tTypedFactory.createTyped(name, tTypedSupplier);
    }
}
