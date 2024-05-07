package com.temporal.api.test;

import com.temporal.api.core.engine.io.metadata.annotation.Injected;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.extension.block.SlabExtension;

@Injected
public class SlabBlockFactory extends BlockFactory implements SlabExtension {
}
