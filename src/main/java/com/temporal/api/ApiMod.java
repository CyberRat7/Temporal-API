package com.temporal.api;

import com.mojang.logging.LogUtils;
import com.temporal.api.config.ApiConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ApiMod.MOD_ID)
public class ApiMod {
    public static final String MOD_ID = "temporalapi";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ApiMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ApiConfig.SPEC);
    }
}
