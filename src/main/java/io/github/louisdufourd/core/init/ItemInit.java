package io.github.louisdufourd.core.init;

import io.github.louisdufourd.Univers;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.util.MutableHashedLinkedMap;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(new ItemStack(PLATINUM_INGOT.get()));
            event.accept(new ItemStack(RAW_PLATINUM.get()));
            event.accept(new ItemStack(PLATINUM_STICK.get()));
            event.accept(new ItemStack(MAGIC_INK.get()));
        }
    }
}
