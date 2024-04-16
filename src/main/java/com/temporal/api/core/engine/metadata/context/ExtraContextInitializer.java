package com.temporal.api.core.engine.metadata.context;

import com.temporal.api.core.engine.metadata.AnnotationExecutor;
import com.temporal.api.core.event.fov.BowFOVModifier;
import com.temporal.api.core.event.tab.SimpleTabAdder;
import com.temporal.api.core.event.trade.SimpleTradeCustomizer;
import com.temporal.api.core.registry.factory.common.*;
import com.temporal.api.core.tag.factory.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ExtraContextInitializer {
    public static void init() {
        Context context = InjectionContext.getInstance();
        context.putObject(FMLJavaModLoadingContext.get().getModEventBus());
        context.putObject(new AnnotationExecutor());

        context.putObject(new ItemFactory());
        context.putObject(new BlockFactory());
        context.putObject(new BiomeFactory());
        context.putObject(new CreativeModeTabFactory());
        context.putObject(new EffectFactory());
        context.putObject(new EntityTypeFactory());
        context.putObject(new PaintingFactory());
        context.putObject(new ParticleFactory());
        context.putObject(new PoiTypeFactory());
        context.putObject(new PotionFactory());
        context.putObject(new SoundEventFactory());
        context.putObject(new VillagerProfessionFactory());

        context.putObject(new ItemTagFactory());
        context.putObject(new BlockTagFactory());
        context.putObject(new BannerPatternTagFactory());
        context.putObject(new BiomeTagFactory());
        context.putObject(new EntityTypeTagFactory());
        context.putObject(new FluidTagFactory());
        context.putObject(new StructureTagFactory());

        context.putObject(new BowFOVModifier());
        context.putObject(new SimpleTabAdder());
        context.putObject(new SimpleTradeCustomizer());

    }
}
