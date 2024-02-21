package com.temporal.api.core.engine.io;

import com.temporal.api.core.engine.IOLayer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.DeferredRegister;

public class EnginedRegisterFactory {
    public static <T> DeferredRegister<T> create(ResourceKey<Registry<T>> registry) {
        return DeferredRegister.create(registry, IOLayer.DEPENDENCY_INFO.getModId());
    }
}
