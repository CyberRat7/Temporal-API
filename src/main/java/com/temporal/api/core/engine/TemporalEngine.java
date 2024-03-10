package com.temporal.api.core.engine;

import java.util.ArrayList;
import java.util.List;

public class TemporalEngine {
    private static final String BANNER = """
                       _________ _________ ___     ___ _________
                       ---- ---- |   ----| |  \\   / | |  ___  |
                          | |    |  |      | | \\ /| | |  | |  |
                          | |    |   --|   | |    | | |  ---  |
                          | |    |   --|   | |    | | |  -----|
                          | |    |  |      | |    | | | |
                          | |    |  -----| | |    | | | |
                          |-|    --------| |-|    |-| |-|
                    """;

    @Deprecated(since = "1.6.0", forRemoval = true)
    public static void process(Class<?> modClass) {
        System.out.println(BANNER);
        LayerContainer.getInstance().processAll(modClass);
    }

    public static Configurator config() {
        return new Configurator();
    }

    public static class Configurator {
        private final LayerContainer layerContainer = LayerContainer.getInstance();
        private final List<EngineLayer> enabled = new ArrayList<>();
        private final List<Class<? extends EngineLayer>> disabled = new ArrayList<>();

        private Configurator() {
        }

        public Configurator addLayer(EngineLayer engineLayer) {
            enabled.add(engineLayer);
            return this;
        }

        public Configurator disableLayer(Class<? extends EngineLayer> engineLayerClass) {
            disabled.add(engineLayerClass);
            return this;
        }

        public void build(Class<?> modClass) {
            layerContainer.deleteAll(disabled);
            layerContainer.addAll(enabled);
            System.out.println(BANNER);
            LayerContainer.getInstance().processAll(modClass);
        }
    }
}
