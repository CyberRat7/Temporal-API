package com.temporal.api.test;

import com.temporal.api.core.engine.io.metadata.annotation.Injected;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.registry.factory.extension.item.SwordExtension;

@Injected
public class SwordItemFactory extends ItemFactory implements SwordExtension {
}
