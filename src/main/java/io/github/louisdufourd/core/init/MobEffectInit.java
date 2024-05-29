package io.github.louisdufourd.core.init;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.effect.ExpBoostEffect;
import io.github.louisdufourd.effect.FlyEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobEffectInit {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Univers.MOD_ID);

    public static final DeferredHolder<MobEffect, FlyEffect> FLY_EFFECT = MOB_EFFECTS.register("fly_effect", FlyEffect::new);
    public static final DeferredHolder<MobEffect, ExpBoostEffect> EXP_BOOST_EFFECT = MOB_EFFECTS.register("exp_boost_effect", ExpBoostEffect::new);

    public static void register(IEventBus bus) {
        Univers.LOG.info("Registering Mob Effects");
        MOB_EFFECTS.register(bus);
    }
}
