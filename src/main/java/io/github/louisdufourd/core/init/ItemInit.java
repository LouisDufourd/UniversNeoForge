package io.github.louisdufourd.core.init;

import io.github.louisdufourd.Univers;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
}
