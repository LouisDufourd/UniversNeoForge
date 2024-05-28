package io.github.louisdufourd.data.recipe.provider;

import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;

import java.util.concurrent.CompletableFuture;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {

    private final RecipeOutput output;

    public NormalCraftingTableRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput output) {
        super(generator, lookupProvider);
        this.output = output;
    }

    public void build() {
        //ShapedRecipeBuilder has to be crafted in a certain from like a sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_STICK, 4)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_ingot_to_platinum_stick"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_PICKAXE)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .define('|', ItemInit.PLATINUM_STICK.get())
                .pattern("###")
                .pattern(" | ")
                .pattern(" | ")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_SHOVEL)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .define('|', ItemInit.PLATINUM_STICK.get())
                .pattern(" # ")
                .pattern(" | ")
                .pattern(" | ")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_AXE)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .define('|', ItemInit.PLATINUM_STICK.get())
                .pattern("## ")
                .pattern("#| ")
                .pattern(" | ")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_axe_left"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_AXE)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .define('|', ItemInit.PLATINUM_STICK.get())
                .pattern(" ##")
                .pattern(" |#")
                .pattern(" | ")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_axe_right"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_SWORD)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .define('|', ItemInit.PLATINUM_STICK.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" | ")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PLATINUM_HOE)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .define('|', ItemInit.PLATINUM_STICK.get())
                .pattern("## ")
                .pattern(" | ")
                .pattern(" | ")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_hoe"));


        //ShapelessRecipeBuilder can be place however you want like an iron block.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemInit.PLATINUM_INGOT.get(), 9)
                .requires(BlockInit.PLATINUM_BLOCK.get())
                .unlockedBy("has_item", has(BlockInit.RAW_PLATINUM_BLOCK.get()))
                .save(output, getModId("block_to_platinum_ingot_recipe"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemInit.RAW_PLATINUM.get(), 9)
                .requires(BlockInit.RAW_PLATINUM_BLOCK.get())
                .unlockedBy("has_item", has(BlockInit.RAW_PLATINUM_BLOCK.get()))
                .save(output, getModId("block_to_raw_platinum_recipe"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.PLATINUM_BLOCK.get())
                .requires(ItemInit.PLATINUM_INGOT.get(), 9)
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_ingot_to_block_recipe"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.RAW_PLATINUM_BLOCK.get())
                .requires(ItemInit.RAW_PLATINUM.get(), 9)
                .unlockedBy("has_item", has(ItemInit.RAW_PLATINUM.get()))
                .save(output, getModId("raw_platinum_to_block_recipe"));
    }
}
