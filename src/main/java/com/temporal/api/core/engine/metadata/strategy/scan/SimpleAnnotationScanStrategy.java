package com.temporal.api.core.engine.metadata.strategy.scan;

import com.google.common.reflect.ClassPath;
import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.engine.io.ClassHelper;
import com.temporal.api.core.engine.metadata.annotation.Injected;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleAnnotationScanStrategy implements AnnotationScanStrategy {
    public Set<Class<?>> scan() {
        try {
            String path = IOLayer.DEPENDENCY_INFO.getModClass().getPackageName();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Set<Class<?>> classes = ClassPath.from(classLoader)
                    .getAllClasses()
                    .stream()
                    .filter(classInfo -> classInfo.getPackageName().contains(path))
                    .map(ClassPath.ClassInfo::load)
                    .collect(Collectors.toSet());
            return classes.parallelStream()
                    .map(clazz -> ClassHelper.forName(clazz.getName()))
                    .filter(clazz -> clazz.isAnnotationPresent(Injected.class))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
