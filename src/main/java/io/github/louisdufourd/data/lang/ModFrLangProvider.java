package io.github.louisdufourd.data.lang;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.CreativeModTabInit;
import io.github.louisdufourd.core.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModFrLangProvider extends LanguageProvider {

    public ModFrLangProvider(PackOutput output) {
        super(output, Univers.MOD_ID, "fr_fr");
    }

    @Override
    protected void addTranslations() {
        //ITEMS
        addItem(ItemInit.PLATINUM_INGOT, "Lingot De Platine");
        addItem(ItemInit.RAW_PLATINUM, "Platine Brut");
        addItem(ItemInit.PLATINUM_STICK, "Bâton de Platine");
        addItem(ItemInit.FIRE_GEM, "Gemme De Feu");
        addItem(ItemInit.WATER_GEM, "Gemme D'Eau");
        addItem(ItemInit.EARTH_GEM, "Gemme De Terre");
        addItem(ItemInit.AIR_GEM, "Gemme D'Air");
        addItem(ItemInit.MAGIC_INK, "Encre Magic");
        addItem(ItemInit.BLANK_SCROLL, "Parchemin Vierge");

        //TOOLS
        addItem(ItemInit.PLATINUM_SWORD, "Épée En Platine");
        addItem(ItemInit.PLATINUM_PICKAXE, "Pioche En Platine");
        addItem(ItemInit.PLATINUM_AXE, "Hache En Platine");
        addItem(ItemInit.PLATINUM_SHOVEL, "Pelle En Platine");
        addItem(ItemInit.PLATINUM_HOE, "Houe En Platine");

        //ARMORS
        addItem(ItemInit.PLATINUM_HELMET, "Casque En Platine");
        addItem(ItemInit.PLATINUM_CHESTPLATE, "Plastron En Platine");
        addItem(ItemInit.PLATINUM_LEGGINGS, "Jambières En Platine");
        addItem(ItemInit.PLATINUM_BOOTS, "Bottes En Platine");

        //BLOCKS
        addBlock(BlockInit.PLATINUM_BLOCK, "Bloc De Platine");
        addBlock(BlockInit.PLATINUM_ORE, "Minerai De Platine");
        addBlock(BlockInit.DEEPSLATE_PLATINUM_ORE, "Minerai De Platine Des Abîmes");
        addBlock(BlockInit.RAW_PLATINUM_BLOCK, "Bloc De Platine Brut");

        //CREATIVE TABS
        add(CreativeModTabInit.MAGIC_TAB_TITLE, "Magique");
        add(CreativeModTabInit.SCROLL_TAB_TITLE, "Parchemins");
    }
}
