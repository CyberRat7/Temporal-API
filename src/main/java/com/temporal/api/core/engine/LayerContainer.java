package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;

import java.util.ArrayList;
import java.util.List;

public class LayerContainer {
    private static volatile LayerContainer instance;
    private final List<EngineLayer> LAYERS = new ArrayList<>();

    private LayerContainer() {
        add(new IOLayer());
        add(new MetadataLayer());
    }

    public void processAll(Class<?> modClass) {
        LAYERS.forEach(engineLayer -> {
            ApiMod.LOGGER.info("{} engine has started initialization!", engineLayer.getClass().getSimpleName().toUpperCase());
            engineLayer.processAllTasks(modClass);
            ApiMod.LOGGER.info("{} engine has finished initialization!", engineLayer.getClass().getSimpleName().toUpperCase());
        });
    }

    public void add(EngineLayer engineLayer) {
        LAYERS.add(engineLayer);
    }

    public void putAll(List<EngineLayer> engineLayers) {
        LAYERS.addAll(engineLayers);
    }

    public EngineLayer getLayer(Integer id) {
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
