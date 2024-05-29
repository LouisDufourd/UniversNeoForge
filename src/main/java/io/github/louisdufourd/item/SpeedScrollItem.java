package io.github.louisdufourd.item;

import io.github.louisdufourd.core.init.ItemInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SpeedScrollItem extends Item {

    public SpeedScrollItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        var blankScroll = new ItemStack(ItemInit.BLANK_SCROLL.get());
        pPlayer.getItemInHand(pUsedHand).shrink(1);
        pPlayer.getInventory().add(blankScroll);
        pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 18000, 0, false, false));

        pPlayer.getCooldowns().addCooldown(this, 12000);

        return InteractionResultHolder.pass(blankScroll);
    }
}
