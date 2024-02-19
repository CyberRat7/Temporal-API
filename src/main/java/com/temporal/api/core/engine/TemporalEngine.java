package com.temporal.api.core.engine;

public class TemporalEngine {
    public static void process() {
        LayerContainer.getInstance().processAll();
    }
}
