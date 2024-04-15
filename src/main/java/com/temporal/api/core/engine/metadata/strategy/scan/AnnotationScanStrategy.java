package com.temporal.api.core.engine.metadata.strategy.scan;

import java.util.Set;

public interface AnnotationScanStrategy {
    Set<Class<?>> scan();
}
