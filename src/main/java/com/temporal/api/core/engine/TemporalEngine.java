package com.temporal.api.core.engine;

public class TemporalEngine {
    public static void process(Class<?> modClass) {
        System.out.println(
                """
                   _________ _________ ___     ___ _________
                   ---- ---- |   ----| |  \\   / | |  ___  |
                      | |    |  |      | | \\ /| | |  | |  |
                      | |    |   --|   | |    | | |  ---  |
                      | |    |   --|   | |    | | |  -----|
                      | |    |  |      | |    | | | |
                      | |    |  -----| | |    | | | |
                      |-|    --------| |-|    |-| |-|
                """);
        LayerContainer.getInstance().processAll(modClass);
    }
}
