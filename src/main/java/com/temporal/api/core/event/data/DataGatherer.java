package com.temporal.api.core.event.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

public interface DataGatherer {
    void gatherData(GatherDataEvent event);

    void addLootTableProvider(GatherDataEvent event);

    void addModelProvider(GatherDataEvent event);

    void addRecipeProvider(GatherDataEvent event);

    ExistingFileHelper getExistingFileHelper(GatherDataEvent event);

    @NotNull
    PackOutput getPackOutput(GatherDataEvent event);

    DataGenerator getDataGenerator(GatherDataEvent event);
}
