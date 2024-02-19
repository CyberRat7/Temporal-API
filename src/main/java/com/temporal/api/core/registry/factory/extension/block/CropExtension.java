package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public interface CropExtension {
    default RegistryObject<CropBlock> createCrop(String name, BlockBehaviour.Properties properties) {
        return (RegistryObject<CropBlock>) BlockFactory.getInstance().createTyped(name, () -> new CropBlock(properties.noOcclusion().noCollission()));
    }

    default RegistryObject<? extends CropBlock> createCrop(String name, Supplier<? extends CropBlock> tTypedSupplier) {
        return (RegistryObject<? extends CropBlock>) BlockFactory.getInstance().createTyped(name, tTypedSupplier);
    }
}
