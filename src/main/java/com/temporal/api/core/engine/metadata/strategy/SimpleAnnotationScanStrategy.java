package com.temporal.api.core.engine.metadata.strategy;

import com.google.common.reflect.ClassPath;
import com.temporal.api.core.engine.metadata.AnnotationScan;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleAnnotationScanStrategy implements AnnotationScanStrategy {
    public Set<Class<?>> execute(Class<?> clazz) {
        try {
            AnnotationScan annotation = clazz.getAnnotation(AnnotationScan.class);
            String path = annotation.value();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            return ClassPath.from(classLoader)
                    .getAllClasses()
                    .stream()
                    .filter(classInfo -> classInfo.getPackageName().equalsIgnoreCase(path))
                    .map(ClassPath.ClassInfo::load)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
