package com.temporal.api.core.engine.metadata.strategy.scan;

import com.google.common.reflect.ClassPath;
import com.temporal.api.core.engine.IOLayer;
import com.temporal.api.core.engine.metadata.AnnotationHelper;
import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.engine.metadata.context.Context;
import com.temporal.api.core.engine.metadata.annotation.Injected;

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
                    .filter(aClass -> aClass.getAnnotations().length > 0 && !aClass.isAnnotation())
                    .filter(aClass -> AnnotationHelper.getInstance().isAnnotationPresent(aClass, Injected.class))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
