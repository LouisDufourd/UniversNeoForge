package io.github.louisdufourd.data.lang;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.CreativeModTabInit;
import io.github.louisdufourd.core.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {

    public ModEnLangProvider(PackOutput output) {
        super(output, Univers.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //ITEMS
        addItem(ItemInit.PLATINUM_INGOT, "Platinum Ingot");
        addItem(ItemInit.RAW_PLATINUM, "Raw Platinum");
        addItem(ItemInit.PLATINUM_STICK, "Platinum Stick");
        addItem(ItemInit.FIRE_GEM, "Fire Gem");
        addItem(ItemInit.WATER_GEM, "Water Gem");
        addItem(ItemInit.EARTH_GEM, "Earth Gem");
        addItem(ItemInit.AIR_GEM, "Air Gem");
        addItem(ItemInit.MAGIC_INK, "Magic Ink");
        addItem(ItemInit.BLANK_SCROLL, "Blank Scroll");

        //TOOLS
        addItem(ItemInit.PLATINUM_SWORD, "Platinum Sword");
        addItem(ItemInit.PLATINUM_PICKAXE, "Platinum Pickaxe");
        addItem(ItemInit.PLATINUM_AXE, "Platinum Axe");
        addItem(ItemInit.PLATINUM_SHOVEL, "Platinum Shovel");
        addItem(ItemInit.PLATINUM_HOE, "Platinum Hoe");

        //ARMORS
        addItem(ItemInit.PLATINUM_HELMET, "Platinum Helmet");
        addItem(ItemInit.PLATINUM_CHESTPLATE, "Platinum Chestplate");
        addItem(ItemInit.PLATINUM_LEGGINGS, "Platinum Leggings");
        addItem(ItemInit.PLATINUM_BOOTS, "Platinum Boots");

        //BLOCKS
        addBlock(BlockInit.PLATINUM_BLOCK, "Platinum Block");
        addBlock(BlockInit.PLATINUM_ORE, "Platinum Ore");
        addBlock(BlockInit.DEEPSLATE_PLATINUM_ORE, "Deepslate Platinum Ore");
        addBlock(BlockInit.RAW_PLATINUM_BLOCK, "Raw Platinum Block");

        //CREATIVE TABS
        add(CreativeModTabInit.MAGIC_TAB_TITLE, "Magic");
        add(CreativeModTabInit.SCROLL_TAB_TITLE, "Scrolls");
    }
}
