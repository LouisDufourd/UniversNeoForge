package io.github.louisdufourd.core.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum TierInit implements Tier {
    PLATINUM(2561, 10, () -> Ingredient.of(ItemInit.PLATINUM_INGOT), BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
    ;

    private final int maxUses;
    private final int enchantAbility;
    private final Supplier<Ingredient> repairMaterial;
    private final TagKey<Block> incorrectBlocksForDrops;

    private TierInit(int maxUses, int enchantAbility, Supplier<Ingredient> repairMaterial, TagKey<Block> incorrectBlocksForDrops) {
        this.maxUses = maxUses;
        this.enchantAbility = enchantAbility;
        this.repairMaterial = repairMaterial;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
    }


    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantAbility;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }


}
