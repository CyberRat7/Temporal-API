package com.temporal.api.common.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class StrippableFlammableRotatedPillarBlock extends FlammableRotatedPillarBlock {
    public final Block strippedResult;

    public StrippableFlammableRotatedPillarBlock(Block strippedResult, Properties properties) {
        super(properties);
        this.strippedResult = strippedResult;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction.equals(ToolActions.AXE_STRIP) && this.strippedResult != null) {
            return this.strippedResult.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
