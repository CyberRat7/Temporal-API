package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;

import java.util.Map;
import java.util.TreeMap;

public class LayerContainer {
    private static volatile LayerContainer instance;
    private final Map<Integer, EngineLayer> LAYERS = new TreeMap<>();

    private LayerContainer() {
        put(1, new IOLayer());
        put(2, new MetadataLayer());
    }

    public void put(Integer priority, EngineLayer engineLayer) {
        LAYERS.put(priority, engineLayer);
    }

    public void putAll(Map<Integer, EngineLayer> engineLayers) {
        LAYERS.putAll(engineLayers);
    }

    public void processAll() {
        LAYERS.forEach((priority, engineLayer) -> {
            engineLayer.processAllTasks();
            ApiMod.LOGGER.info("{} engine has finished initialization!", engineLayer.getClass().getSimpleName().toUpperCase());
        });
    }

    public EngineLayer getEngineLayer(Integer id) {
        return LAYERS.get(id);
    }

    public static LayerContainer getInstance() {
        if (instance == null) {
            synchronized (LayerContainer.class) {
                if (instance == null) {
                    instance = new LayerContainer();
                }
            }
        }

        return instance;
    }
}
