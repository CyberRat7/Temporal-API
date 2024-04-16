package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;

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

    public static LayerContainer run(Class<?> modClass) {
        return config()
                .setupIOLayer(modClass)
                .processAllLayers()
                .build();
    }

    public static Configurator config() {
        return new Configurator();
    }

    public static class Configurator {
        private final LayerContainer layerContainer = LayerContainer.getInstance();
        private final String loadMessage = "{} has been loaded!";
        private final List<ConfiguratorTask> tasks = new ArrayList<>(4);

        private Configurator() {
        }

        public Configurator addLayer(EngineLayer engineLayer) {
            ConfiguratorTask addLayerTask = () -> layerContainer.add(engineLayer);
            tasks.add(addLayerTask);
            return this;
        }

        public Configurator disableLayer(Class<? extends EngineLayer> engineLayerClass) {
            ConfiguratorTask deleteLayerTask = () -> layerContainer.delete(engineLayerClass);
            tasks.add(deleteLayerTask);
            return this;
        }

        public Configurator setupIOLayer(Class<?> modClass) {
            ConfiguratorTask ioSetupTask = () -> {
                IOLayer ioLayer = (IOLayer) layerContainer.getLayer(0);
                ioLayer.setModClass(modClass);
            };
            tasks.add(ioSetupTask);
            return this;
        }

        public Configurator setupEventLayer() {
            //Nothing's here
            return this;
        }

        public Configurator setupMetadataLayer() {
            //Nothing's here
            return this;
        }

        public Configurator processAllLayers() {
            ConfiguratorTask processLayersTask = () -> {
                layerContainer.getLayers().forEach(engineLayer -> {
                    engineLayer.processAllTasks();
                    ApiMod.LOGGER.info(this.loadMessage, engineLayer.getClass().getSimpleName());
                });
            };
            tasks.add(processLayersTask);
            return this;
        }

        public LayerContainer build() {
            System.out.println(BANNER);
            tasks.forEach(ConfiguratorTask::execute);
            return this.layerContainer;
        }
    }
}
