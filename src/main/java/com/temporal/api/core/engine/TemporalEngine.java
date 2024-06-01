package com.temporal.api.core.engine;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.io.context.ContextInitializer;
import com.temporal.api.core.engine.io.context.ExtraContextInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

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
                .processIOLayer(modClass, new ExtraContextInitializer())
                .build();
    }

    public static Configurator config() {
        return new Configurator();
    }

    public static class Configurator {
        private static final String LOAD_MESSAGE = "{} has been loaded!";
        private final LayerContainer layerContainer = LayerContainer.getInstance();
        private final List<Runnable> tasks = new ArrayList<>(2);

        private Configurator() {
        }

        public Configurator addLayer(EngineLayer engineLayer) {
            Runnable addLayerTask = () -> layerContainer.add(engineLayer);
            tasks.add(addLayerTask);
            return this;
        }

        public Configurator disableLayer(Class<? extends EngineLayer> engineLayerClass) {
            Runnable deleteLayerTask = () -> layerContainer.delete(engineLayerClass);
            tasks.add(deleteLayerTask);
            return this;
        }

        public Configurator processIOLayer(Class<?> modClass, ContextInitializer... contextInitializers) {
            Runnable ioSetupTask = () -> {
                IOLayer ioLayer = layerContainer.getLayer(IOLayer.class);
                ioLayer.setModClass(modClass);
                ioLayer.setContextInitializers(List.of(contextInitializers));
                ioLayer.processAllTasks();
                this.logLayerProcession(ioLayer);
            };

            tasks.add(ioSetupTask);
            return this;
        }

        public Configurator processEventLayer() {
            //Nothing's here
            return this;
        }

        public LayerContainer build() {
            System.out.println(BANNER);
            tasks.forEach(task -> new FutureTask<>(task, null).run());
            return this.layerContainer;
        }

        private void logLayerProcession(EngineLayer engineLayer) {
            engineLayer.processAllTasks();
            ApiMod.LOGGER.info(LOAD_MESSAGE, engineLayer.getClass().getSimpleName());
        }
    }
}
