package com.temporal.api.core.util.tag.factory;

public abstract class AbstractTagFactory<T> implements TagFactory<T> {
    private final String modId;

    public AbstractTagFactory(String modId) {
        this.modId = modId;
    }

    protected String getModId() {
        return modId;
    }
}
