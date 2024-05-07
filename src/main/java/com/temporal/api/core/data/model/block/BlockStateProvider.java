package com.temporal.api.core.data.model.block;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class BlockStateProvider extends ApiBlockStateProvider {
    public static final List<RegistryObject<Block>> BLOCKS = new ArrayList<>();

    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BLOCKS.forEach(this::registerCubedBlock);
    }

    private void registerCubedBlock(RegistryObject<Block> blockSupplier) {
        Block block = blockSupplier.get();
        this.simpleBlockWithItem(block, this.cubeAll(block));
    }
}
