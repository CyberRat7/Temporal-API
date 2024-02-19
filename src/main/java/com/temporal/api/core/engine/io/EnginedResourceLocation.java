package com.temporal.api.core.engine.io;

import com.temporal.api.core.engine.IOLayer;
import net.minecraft.resources.ResourceLocation;

public class EnginedResourceLocation extends ResourceLocation {
    public EnginedResourceLocation(String name) {
        super(IOLayer.DEPENDENCY_PROPERTIES_MANAGER.getModId(), name);
    }
}
