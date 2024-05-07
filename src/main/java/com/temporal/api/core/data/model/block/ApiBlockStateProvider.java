package com.temporal.api.core.data.model.block;

import com.temporal.api.core.engine.IOLayer;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public abstract class ApiBlockStateProvider extends BlockStateProvider {
    public ApiBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IOLayer.FORGE_MOD.getModId(), exFileHelper);
    }
}
