package io.github.louisdufourd.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.extensions.IPlayerExtension;

public class FlyEffect extends MobEffect {
    public FlyEffect() {
        super(MobEffectCategory.NEUTRAL, 0xfffff);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity instanceof Player player) {
            if(player.mayFly()) {
                player.getAbilities().flying = true;
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return pDuration%2==0;
    }

    @Override
    public void onEffectAdded(LivingEntity pLivingEntity, int pAmplifier) {
        super.onEffectAdded(pLivingEntity, pAmplifier);
    }

    @Override
    public void onMobRemoved(LivingEntity pLivingEntity, int pAmplifier, Entity.RemovalReason pReason) {
        if(pLivingEntity instanceof Player player) {
            if(!player.mayFly()) {
                player.getAbilities().flying = false;
            }
        }
        super.onMobRemoved(pLivingEntity, pAmplifier, pReason);
    }
}
