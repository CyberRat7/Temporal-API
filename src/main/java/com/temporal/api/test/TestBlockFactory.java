package com.temporal.api.test;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.extension.block.LogBlockExtension;
import com.temporal.api.core.registry.factory.extension.block.StrippableLogBlockExtension;

public class TestBlockFactory extends BlockFactory implements LogBlockExtension, StrippableLogBlockExtension {
    public static TestBlockFactory getInstance() {
        return new TestBlockFactory();
    }
}
