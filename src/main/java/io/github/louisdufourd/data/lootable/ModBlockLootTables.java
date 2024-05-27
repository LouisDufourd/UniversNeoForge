package io.github.louisdufourd.data.lootable;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        add(BlockInit.PLATINUM_ORE.get(), createOreDrop(BlockInit.PLATINUM_ORE.get(), ItemInit.RAW_PLATINUM.get()));
        add(BlockInit.DEEPSLATE_PLATINUM_ORE.get(), createOreDrop(BlockInit.DEEPSLATE_PLATINUM_ORE.get(), ItemInit.RAW_PLATINUM.get()));
        dropSelf(BlockInit.PLATINUM_BLOCK.get());
        dropSelf(BlockInit.RAW_PLATINUM_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(Univers.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
