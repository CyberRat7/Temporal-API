package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;
import com.temporal.api.core.registry.factory.common.ObjectFactory;

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

    public static Configurator config() {
        return new Configurator();
    }

    public static class Configurator {
        private final LayerContainer layerContainer = LayerContainer.getInstance();
        private final String loadMessage = "{} has been loaded!";

        private Configurator() {
        }

        public Configurator addLayer(EngineLayer engineLayer) {
            layerContainer.add(engineLayer);
            return this;
        }

        public Configurator disableLayer(Class<? extends EngineLayer> engineLayerClass) {
            layerContainer.delete(engineLayerClass);
            return this;
        }

        public Configurator setupIOLayer(Class<?> modClass) {
            IOLayer ioLayer = (IOLayer) layerContainer.getLayer(0);
            ioLayer.setModClass(modClass);
            ioLayer.processAllTasks();
            ApiMod.LOGGER.info(this.loadMessage, "IOLayer");
            return this;
        }

        public Configurator setupEventLayer(ObjectFactory<?>... factories) {
            EventLayer eventLayer = (EventLayer) layerContainer.getLayer(1);
            EventLayer.EVENT_BUS_HANDLER.setFactories(List.of(factories));
            eventLayer.processAllTasks();
            ApiMod.LOGGER.info(this.loadMessage, "EventLayer");
            return this;
        }

        public Configurator setupMetadataLayer() {
            MetadataLayer metadataLayer = (MetadataLayer) layerContainer.getLayer(2);
            metadataLayer.processAllTasks();
            ApiMod.LOGGER.info(this.loadMessage, "MetadataLayer");
            return this;
        }

        public LayerContainer build() {
            System.out.println(BANNER);
            return this.layerContainer;
        }
    }
}
