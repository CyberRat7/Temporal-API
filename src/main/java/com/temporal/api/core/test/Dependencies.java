package com.temporal.api.core.test;

import com.temporal.api.core.engine.metadata.annotation.Dependency;
import com.temporal.api.core.engine.metadata.annotation.Injected;

@Injected
public class Dependencies {
    @Dependency("temporalapi")
    private boolean hasTemporalApi;
    @Dependency("fadfafadf")
    private boolean hasTest;

    public void test() {
        System.out.println(hasTemporalApi + " - true");
        System.out.println(hasTest + " - false");
    }
}
