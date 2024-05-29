package io.github.louisdufourd.item;

import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.core.init.MobEffectInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class FlyScrollItem extends Item {
    public FlyScrollItem() {
        super(new Properties().rarity(Rarity.RARE).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        var blankScroll = new ItemStack(ItemInit.BLANK_SCROLL.get());
        pPlayer.getItemInHand(pUsedHand).shrink(1);
        pPlayer.getInventory().add(blankScroll);
        pPlayer.addEffect(new MobEffectInstance(MobEffectInit.FLY_EFFECT, 300, 0, false, false));

        pPlayer.getCooldowns().addCooldown(this, 12000);

        return InteractionResultHolder.pass(blankScroll);
    }
}
