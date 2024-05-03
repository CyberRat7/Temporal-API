package com.temporal.api.core.engine.io.resource;

import com.temporal.api.core.engine.IOLayer;
import net.minecraft.resources.ResourceLocation;

public class InjectedResourceLocation extends ResourceLocation {
    public InjectedResourceLocation(String name) {
        super(IOLayer.FORGE_MOD.getModId(), name);
    }
}
