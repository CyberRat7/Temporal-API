package com.temporal.api;

import com.mojang.logging.LogUtils;
import com.temporal.api.core.engine.TemporalEngine;
import com.temporal.api.core.engine.metadata.annotation.Dependency;
import com.temporal.api.core.engine.metadata.context.Context;
import com.temporal.api.core.engine.metadata.context.InjectionContext;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.registry.factory.common.ObjectFactory;
import com.temporal.api.core.tag.factory.ItemTagFactory;
import com.temporal.api.core.test.Dependencies;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.List;

@Mod(ApiMod.MOD_ID)
public class ApiMod {
    public static final String MOD_ID = "temporalapi";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ApiMod() {
        TemporalEngine.run(ApiMod.class);

        Context context = InjectionContext.getInstance();
        context.getAllObjects().forEach(System.out::println);

        ItemFactory itemFactory = context.getObject(ItemFactory.class);
        System.out.println(itemFactory);
        ItemTagFactory itemTagFactory = context.getObject(ItemTagFactory.class);
        System.out.println(itemTagFactory);
        Dependencies dependencies = context.getObject(Dependencies.class);
        System.out.println(dependencies);
        dependencies.test();
        List<?> objects = context.getObjects(ObjectFactory.class);
        System.out.println(objects);;

        MinecraftForge.EVENT_BUS.register(this);
    }
}
