package com.temporal.api.core.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LayerContainer {
    private static volatile LayerContainer instance;
    private final List<EngineLayer> LAYERS = new ArrayList<>();

    private LayerContainer() {
        this.addAll(List.of(
                new IOLayer(), new EventLayer(), new MetadataLayer()
        ));
    }

    protected void addAll(Collection<EngineLayer> engineLayers) {
        LAYERS.addAll(engineLayers);
    }

    protected void add(EngineLayer engineLayer) {
        LAYERS.add(engineLayer);
    }

    public EngineLayer getLayer(Integer id) {
        return LAYERS.get(id);
    }

    protected void delete(Class<? extends EngineLayer> layer) {
        LAYERS.removeIf(engineLayer -> engineLayer.getClass().equals(layer));
    }

    protected void deleteAll(Collection<Class<? extends EngineLayer>> layers) {
        layers.forEach(this::delete);
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
