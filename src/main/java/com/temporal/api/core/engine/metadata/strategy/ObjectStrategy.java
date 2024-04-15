package com.temporal.api.core.engine.metadata.strategy;

public interface ObjectStrategy<T> {
    void execute(T t, Object object) throws Exception;
}
