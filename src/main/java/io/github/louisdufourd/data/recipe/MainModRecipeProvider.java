package io.github.louisdufourd.data.recipe;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.data.recipe.provider.FurnaceRecipeProvider;
import io.github.louisdufourd.data.recipe.provider.NormalCraftingTableRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MainModRecipeProvider extends RecipeProvider {

    protected final DataGenerator generator;
    protected final CompletableFuture<HolderLookup.Provider> lookupProvider;

    public MainModRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(generator.getPackOutput(), lookupProvider);
        this.generator = generator;
        this.lookupProvider = lookupProvider;
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        new NormalCraftingTableRecipeProvider(generator, lookupProvider, recipeOutput).build();
        new FurnaceRecipeProvider(generator, lookupProvider, recipeOutput).build();
    }

    public ResourceLocation getModId(String path) {
        return new ResourceLocation(Univers.MOD_ID, path);
    }
}
