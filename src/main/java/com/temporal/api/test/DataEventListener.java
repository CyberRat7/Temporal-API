package com.temporal.api.test;

import com.temporal.api.ApiMod;
import com.temporal.api.core.data.ApiDataGenerator;
import com.temporal.api.core.data.DataGatherer;
import com.temporal.api.core.engine.io.context.Context;
import com.temporal.api.core.engine.io.context.InjectionContext;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ApiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataEventListener {
    @SubscribeEvent
    public static void gather(GatherDataEvent event) {
        Context context = InjectionContext.getInstance();
        DataGatherer dataGatherer = context.getObject(ApiDataGenerator.class);
        dataGatherer.gatherData(event);
    }
}
