package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.common.block.FlammableRotatedPillarBlock;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface FlammableRotatedPillarBlockExtension {
    default RegistryObject<FlammableRotatedPillarBlock> createFlammableRotatedPillar(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<FlammableRotatedPillarBlock>) BlockFactory.getInstance().createTyped(name, () -> new FlammableRotatedPillarBlock(properties));
    }

    default RegistryObject<? extends FlammableRotatedPillarBlock> createFlammableRotatedPillar(String name, Supplier<? extends FlammableRotatedPillarBlock> tTypedSupplier) {
        return (RegistryObject<? extends FlammableRotatedPillarBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
