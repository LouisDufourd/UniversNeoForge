package io.github.louisdufourd.data.lootable;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTables extends LootTableProvider {

    public ModLootTables(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, Set.of(), List.of(new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)), pRegistries);
    }

    @Override
    protected void validate(@NotNull WritableRegistry<LootTable> writableRegistry, @NotNull ValidationContext validationContext, ProblemReporter.@NotNull Collector problemReporter) {
        writableRegistry.forEach(lootTable -> lootTable.validate(validationContext));
    }
}
