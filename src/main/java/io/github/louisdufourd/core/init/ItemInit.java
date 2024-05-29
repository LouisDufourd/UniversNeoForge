package io.github.louisdufourd.core.init;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.material.ModArmorMaterial;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Univers.MOD_ID);

    public static final DeferredItem<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATINUM_STICK = ITEMS.register("platinum_stick", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_PLATINUM = ITEMS.register("raw_platinum", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIRE_GEM = ITEMS.register("fire_gem", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WATER_GEM = ITEMS.register("water_gem", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EARTH_GEM = ITEMS.register("earth_gem", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AIR_GEM = ITEMS.register("air_gem", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MAGIC_INK = ITEMS.register("magic_ink", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLANK_SCROLL = ITEMS.register("blank_scroll", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () -> new SwordItem(TierInit.PLATINUM, new Item.Properties().attributes(SwordItem.createAttributes(TierInit.PLATINUM, 3, -2.4f)).stacksTo(1)));
    public static final DeferredItem<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () -> new PickaxeItem(TierInit.PLATINUM, new Item.Properties().attributes(PickaxeItem.createAttributes(TierInit.PLATINUM, 1.0F, -2.8F)).stacksTo(1)));
    public static final DeferredItem<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new AxeItem(TierInit.PLATINUM, new Item.Properties().attributes(AxeItem.createAttributes(TierInit.PLATINUM, 5.0F, -3.0F)).stacksTo(1)));
    public static final DeferredItem<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () -> new ShovelItem(TierInit.PLATINUM, new Item.Properties().attributes(ShovelItem.createAttributes(TierInit.PLATINUM, 1.5F, -3.0F)).stacksTo(1)));
    public static final DeferredItem<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () -> new HoeItem(TierInit.PLATINUM, new Item.Properties().attributes(HoeItem.createAttributes(TierInit.PLATINUM, -3.0F, 0.0F)).stacksTo(1)));

    public static final DeferredItem<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet", () -> new ArmorItem(ModArmorMaterial.PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11))));
    public static final DeferredItem<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate", () -> new ArmorItem(ModArmorMaterial.PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))));
    public static final DeferredItem<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings", () -> new ArmorItem(ModArmorMaterial.PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final DeferredItem<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots", () -> new ArmorItem(ModArmorMaterial.PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(13))));

    public static void register(IEventBus bus) {
        Univers.LOG.info("Registering Items");
        ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void buildContents(@NotNull BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(new ItemStack(BlockInit.PLATINUM_ORE.get().asItem()));
            event.accept(new ItemStack(BlockInit.DEEPSLATE_PLATINUM_ORE.get().asItem()));
            event.accept(new ItemStack(BlockInit.RAW_PLATINUM_BLOCK.get().asItem()));
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(new ItemStack(BlockInit.PLATINUM_BLOCK.get().asItem()));
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(new ItemStack(PLATINUM_PICKAXE.get()));
            event.accept(new ItemStack(PLATINUM_AXE.get()));
            event.accept(new ItemStack(PLATINUM_SHOVEL.get()));
            event.accept(new ItemStack(PLATINUM_HOE.get()));
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(new ItemStack(PLATINUM_SWORD.get()));
        }

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(new ItemStack(PLATINUM_INGOT.get()));
            event.accept(new ItemStack(RAW_PLATINUM.get()));
            event.accept(new ItemStack(PLATINUM_STICK.get()));
            event.accept(new ItemStack(MAGIC_INK.get()));
        }
    }
}
