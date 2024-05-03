package com.temporal.api.core.engine.io;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.stream.Collectors;

public class IOHelper {
    public static Set<Class<?>> getAllClasses(Class<?> dependencyClass, Class<? extends Annotation> annotationClass) {
        return ModList.get()
                .getAllScanData()
                .stream()
                .flatMap(modFileScanData -> modFileScanData.getAnnotations()
                        .stream()
                        .filter(annotation -> annotation.annotationType().equals(Type.getType(annotationClass)))
                        .map(ModFileScanData.AnnotationData::clazz)
                        .map(clazz -> IOHelper.forType(clazz, dependencyClass)))
                .collect(Collectors.toSet());
    }

    public static Class<?> forType(Type type, Class<?> dependencyClass) {
        return forName(type.getClassName(), dependencyClass);
    }

    public static Class<?> forName(String name, Class<?> dependencyClass) {
        try {
            return Class.forName(name, false, dependencyClass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
