package io.github.louisdufourd.util;

import io.github.louisdufourd.core.init.MobEffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import org.jetbrains.annotations.NotNull;

public class EventHandler {
    @SubscribeEvent
    public static void onGainExp(@NotNull LivingExperienceDropEvent event) {
        if(event.getAttackingPlayer() != null) {
            Player player = event.getAttackingPlayer();
            if (player.hasEffect(MobEffectInit.EXP_BOOST_EFFECT)) {
                MobEffectInstance effect = player.getEffect(MobEffectInit.EXP_BOOST_EFFECT);
                int exp = (int) Math.round(event.getDroppedExperience() * (1.2 * effect.getAmplifier()));
                event.setDroppedExperience(exp);
            }
        }
    }
}
