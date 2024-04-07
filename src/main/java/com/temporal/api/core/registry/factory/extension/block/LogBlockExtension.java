package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.common.block.LogBlock;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface LogBlockExtension {
    default RegistryObject<LogBlock> createLog(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<LogBlock>) BlockFactory.getInstance().createTyped(name, () -> new LogBlock(properties));
    }

    default RegistryObject<? extends LogBlock> createLog(String name, Supplier<? extends LogBlock> tTypedSupplier) {
        return (RegistryObject<? extends LogBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
