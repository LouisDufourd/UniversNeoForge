package io.github.louisdufourd.data.recipe.provider;

import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class FurnaceRecipeProvider extends MainModRecipeProvider {

    private final RecipeOutput output;

    public FurnaceRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput output) {
        super(generator, lookupProvider);
        this.output = output;
    }

    public void build() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.RAW_PLATINUM.get()), RecipeCategory.MISC, ItemInit.PLATINUM_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("platinum_ingot_from_raw_platinum_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ItemInit.RAW_PLATINUM.get()), RecipeCategory.MISC, ItemInit.PLATINUM_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("platinum_ingot_from_raw_platinum_blasting"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PLATINUM_ORE.get()), RecipeCategory.MISC, ItemInit.PLATINUM_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("platinum_ingot_from_platinum_ore_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PLATINUM_ORE.get()), RecipeCategory.MISC, ItemInit.PLATINUM_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("platinum_ingot_from_platinum_ore_blasting"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.DEEPSLATE_PLATINUM_ORE.get()), RecipeCategory.MISC, ItemInit.PLATINUM_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("platinum_ingot_from_deepslate_platinum_ore_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(BlockInit.DEEPSLATE_PLATINUM_ORE.get()), RecipeCategory.MISC, ItemInit.PLATINUM_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("platinum_ingot_from_deepslate_platinum_ore_blasting"));
    }
}
