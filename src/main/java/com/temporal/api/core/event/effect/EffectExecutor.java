package com.temporal.api.core.event.effect;

import net.minecraftforge.event.entity.living.MobEffectEvent;

public interface EffectExecutor {
    void execute(MobEffectEvent event);
}
