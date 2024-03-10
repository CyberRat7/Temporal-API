package com.temporal.api.core.util.forge;

import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;

@Deprecated(since = "1.6.0", forRemoval = true)
public class ModListContainer {
    private static volatile ModListContainer instance;
    private final ModList modList;

    private ModListContainer() {
        this.modList = ModList.get();
    }

    public ModContainer getModContainer(String modId) {
        return modList.getModContainerById(modId).orElseThrow();
    }

    public boolean contains(String modId) {
        return modList.isLoaded(modId);
    }

    public static ModListContainer getInstance() {
        if (instance == null) {
            synchronized (ModListContainer.class) {
                if (instance == null) {
                    instance = new ModListContainer();
                }
            }
        }

        return instance;
    }
}
