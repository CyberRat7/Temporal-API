package com.temporal.api.core.data;

import com.temporal.api.core.data.loot.LootTableProviderFactory;
import com.temporal.api.core.data.model.block.BlockStateProvider;
import com.temporal.api.core.data.model.item.ItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class ApiDataGenerator implements DataGatherer {
    @Override
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeServer(), LootTableProviderFactory.createWithSelfDrop(packOutput));
        generator.addProvider(event.includeClient(), new BlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelProvider(packOutput, existingFileHelper));
    }
}
