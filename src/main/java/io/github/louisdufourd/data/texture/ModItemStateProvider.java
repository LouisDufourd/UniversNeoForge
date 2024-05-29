package io.github.louisdufourd.data.texture;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.util.NameUtility;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemStateProvider extends ItemModelProvider
{
    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Univers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ItemInit.PLATINUM_INGOT.get());
        item(ItemInit.RAW_PLATINUM.get());
        item(ItemInit.PLATINUM_STICK.get());
        item(ItemInit.FIRE_GEM.get());
        item(ItemInit.WATER_GEM.get());
        item(ItemInit.EARTH_GEM.get());
        item(ItemInit.AIR_GEM.get());
        item(ItemInit.MAGIC_INK.get());
        item(ItemInit.BLANK_SCROLL.get());

        //TOOLS
        tool(ItemInit.PLATINUM_SWORD.get());
        tool(ItemInit.PLATINUM_PICKAXE.get());
        tool(ItemInit.PLATINUM_AXE.get());
        tool(ItemInit.PLATINUM_SHOVEL.get());
        tool(ItemInit.PLATINUM_HOE.get());

        //ARMORS
        item(ItemInit.PLATINUM_HELMET.get());
        item(ItemInit.PLATINUM_CHESTPLATE.get());
        item(ItemInit.PLATINUM_LEGGINGS.get());
        item(ItemInit.PLATINUM_BOOTS.get());
    }

    private void tool(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + name);
    }

    private void item(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/" + name));
    }

    private void writtenScrollItem(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/written_scroll"));
    }
}
