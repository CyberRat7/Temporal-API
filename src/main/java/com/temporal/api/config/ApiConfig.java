package com.temporal.api.config;

import com.temporal.api.ApiMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ApiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ApiConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {
    }
}
