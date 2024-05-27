package io.github.louisdufourd.util;

import io.github.louisdufourd.Univers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NameUtility {
    public static @NotNull String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(Univers.MOD_ID + ":", "");
    }

    public static @NotNull String getBlockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).toString().replace(Univers.MOD_ID + ":", "");
    }
}
