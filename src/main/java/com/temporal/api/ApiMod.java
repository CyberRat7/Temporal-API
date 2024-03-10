package com.temporal.api;

import com.mojang.logging.LogUtils;
import com.temporal.api.core.engine.TemporalEngine;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ApiMod.MOD_ID)
public class ApiMod {
    public static final String MOD_ID = "temporalapi";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ApiMod() {
        TemporalEngine.config()
                .build(ApiMod.class);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
