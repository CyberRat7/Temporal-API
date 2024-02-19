package com.temporal.api.core.util.tag.factory;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagFactory implements TagFactory<Block> {
    private static volatile TagFactory<Block> instance;

    private BlockTagFactory() {
    }

    @Override
    public TagKey<Block> createTag(String name) {
        return BlockTags.create(new EnginedResourceLocation(name));
    }

    public static TagFactory<Block> getInstance() {
        if (instance == null) {
            synchronized (BlockTagFactory.class) {
                if (instance == null) {
                    instance = new BlockTagFactory();
                }
            }
        }

        return instance;
    }
}
