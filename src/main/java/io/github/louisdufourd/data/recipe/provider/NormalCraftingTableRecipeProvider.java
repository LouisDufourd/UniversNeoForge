package io.github.louisdufourd.data.recipe.provider;

import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {

    private final RecipeOutput output;

    public NormalCraftingTableRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput output) {
        super(generator, lookupProvider);
        this.output = output;
    }

    public void build() {
        //ShapedRecipeBuilder has to be crafted in a certain from like a sword
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.PLATINUM_STICK, 4)
                .define('#', ItemInit.PLATINUM_INGOT.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_item", has(ItemInit.PLATINUM_INGOT.get()))
                .save(output, getModId("platinum_ingot_to_platinum_stick"));

        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), ItemInit.PLATINUM_STICK.get(), ItemInit.PLATINUM_SWORD.get(), Type.SWORD, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), ItemInit.PLATINUM_STICK.get(), ItemInit.PLATINUM_PICKAXE.get(), Type.PICKAXE, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), ItemInit.PLATINUM_STICK.get(), ItemInit.PLATINUM_AXE.get(), Type.AXE, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), ItemInit.PLATINUM_STICK.get(), ItemInit.PLATINUM_SHOVEL.get(), Type.SHOVEL, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), ItemInit.PLATINUM_STICK.get(), ItemInit.PLATINUM_HOE.get(), Type.HOE, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), null, ItemInit.PLATINUM_HELMET.get(), Type.HELMET, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), null, ItemInit.PLATINUM_CHESTPLATE.get(), Type.CHESTPLATE, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), null, ItemInit.PLATINUM_LEGGINGS.get(), Type.LEGGINGS, "platinum");
        toolArmorRecipe(ItemInit.PLATINUM_INGOT.get(), null, ItemInit.PLATINUM_BOOTS.get(), Type.BOOTS, "platinum");


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

    private void toolArmorRecipe(@NotNull Item material, @Nullable Item stick, @NotNull Item result, @NotNull Type type, @NotNull String materialName) {
        if(stick == null) {
            switch (type) {
                case HELMET -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                        .define('#', material)
                        .pattern("###")
                        .pattern("# #")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_helmet"));
                case CHESTPLATE -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                        .define('#', material)
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_chestplate"));
                case LEGGINGS -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                        .define('#', material)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_leggings"));
                case BOOTS -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                        .define('#', material)
                        .pattern("# #")
                        .pattern("# #")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_boots"));
            }
        } else {
            switch (type) {
                case SWORD -> ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                        .define('#', material)
                        .define('|', stick)
                        .pattern(" # ")
                        .pattern(" # ")
                        .pattern(" | ")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_sword"));
                case PICKAXE -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                        .define('#', material)
                        .define('|', stick)
                        .pattern("###")
                        .pattern(" | ")
                        .pattern(" | ")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_pickaxe"));
                case AXE -> {
                    ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                            .define('#', material)
                            .define('|', stick)
                            .pattern("## ")
                            .pattern("#| ")
                            .pattern(" | ")
                            .unlockedBy("has_item", has(material))
                            .save(output, getModId(materialName + "axe_left"));

                    ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                            .define('#', material)
                            .define('|', stick)
                            .pattern(" ##")
                            .pattern(" |#")
                            .pattern(" | ")
                            .unlockedBy("has_item", has(material))
                            .save(output, getModId(materialName + "axe_right"));
                }
                case SHOVEL -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                        .define('#', material)
                        .define('|', stick)
                        .pattern(" # ")
                        .pattern(" | ")
                        .pattern(" | ")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_shovel"));
                case HOE -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                        .define('#', material)
                        .define('|', stick)
                        .pattern("## ")
                        .pattern(" | ")
                        .pattern(" | ")
                        .unlockedBy("has_item", has(material))
                        .save(output, getModId(materialName + "_hoe"));
            }
        }
    }

    private enum Type {
        SWORD, AXE, SHOVEL, HOE, PICKAXE, HELMET, CHESTPLATE, LEGGINGS, BOOTS
    }
}
