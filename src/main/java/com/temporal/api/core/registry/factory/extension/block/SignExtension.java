package com.temporal.api.core.registry.factory.extension.block;

import com.temporal.api.core.engine.io.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public interface SignExtension {
    default RegistryObject<?> createStandingSign(String name, float strength, WoodType woodType) {
        BlockFactory factory = InjectionContext.getInstance().getObject(BlockFactory.class);
        return factory.createTyped(name, () -> new StandingSignBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .strength(strength)
                .ignitedByLava(), woodType));
    }

    default RegistryObject<?> createHangingSign(String name, MapColor color, float strength, WoodType woodType) {
        BlockFactory factory = InjectionContext.getInstance().getObject(BlockFactory.class);
        return factory.createTyped(name, () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of()
                .mapColor(color)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .strength(strength)
                .ignitedByLava(), woodType));
    }

    default RegistryObject<?> createWallSign(String name, Supplier<Block> dropBlock, float strength, WoodType woodType) {
        BlockFactory factory = InjectionContext.getInstance().getObject(BlockFactory.class);
        return factory.createTyped(name, () ->  new WallSignBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollission()
                .lootFrom(dropBlock)
                .strength(strength)
                .ignitedByLava(), woodType));
    }
}
