package io.github.louisdufourd.data.texture;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.init.BlockInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Univers.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(BlockInit.PLATINUM_BLOCK.get());
        normalBlock(BlockInit.RAW_PLATINUM_BLOCK.get());
        normalBlock(BlockInit.DEEPSLATE_PLATINUM_ORE.get());
        normalBlock(BlockInit.PLATINUM_ORE.get());
    }

    private void normalBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block, models().cubeAll(path, modLoc("block/" + path)));
        simpleBlockItem(block, models().cubeAll(path, modLoc("block/" + path)));
    }
}
