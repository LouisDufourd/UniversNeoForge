package io.github.louisdufourd.data;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.data.lang.ModEnLangProvider;
import io.github.louisdufourd.data.lang.ModFrLangProvider;
import io.github.louisdufourd.data.lootable.ModLootTables;
import io.github.louisdufourd.data.recipe.MainModRecipeProvider;
import io.github.louisdufourd.data.texture.ModBlockStateProvider;
import io.github.louisdufourd.data.texture.ModItemStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup.Provider;
import java.util.concurrent.CompletableFuture;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = event.getGenerator().getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            CompletableFuture<Provider> lookupProvider = event.getLookupProvider();

            generator.addProvider(true, new ModEnLangProvider(output));
            generator.addProvider(true, new ModFrLangProvider(output));

            generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModLootTables(output, lookupProvider));

            generator.addProvider(true, new MainModRecipeProvider(generator, lookupProvider));

        } catch (RuntimeException e) {
            Univers.LOG.error("Failed to generate data", e);
        }
    }
}
