package com.temporal.api.core.engine.metadata.strategy;

import com.google.common.reflect.ClassPath;
import com.temporal.api.core.engine.IOLayer;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleAnnotationScanStrategy implements AnnotationScanStrategy {
    public Set<Class<?>> scan() {
        try {
            String path = IOLayer.DEPENDENCY_INFO.getModClass().getPackageName();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            return ClassPath.from(classLoader)
                    .getAllClasses()
                    .stream()
                    .filter(classInfo -> classInfo.getPackageName().contains(path))
                    .map(ClassPath.ClassInfo::load)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
