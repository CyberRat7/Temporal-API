package com.temporal.api.core.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LayerContainer {
    private static volatile LayerContainer instance;
    private final List<EngineLayer> layers = new ArrayList<>();

    private LayerContainer() {
        this.addAll(List.of(
                new IOLayer(), new EventLayer(), new MetadataLayer()
        ));
    }

    protected void addAll(Collection<EngineLayer> engineLayers) {
        layers.addAll(engineLayers);
    }

    protected void add(EngineLayer engineLayer) {
        layers.add(engineLayer);
    }

    public List<EngineLayer> getLayers() {
        return layers;
    }

    public EngineLayer getLayer(Integer id) {
        return layers.get(id);
    }

    protected void delete(Class<? extends EngineLayer> layer) {
        layers.removeIf(engineLayer -> engineLayer.getClass().equals(layer));
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
