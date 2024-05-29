package io.github.louisdufourd.core.init;

import io.github.louisdufourd.Univers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jline.utils.Log;

public class CreativeModTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Univers.MOD_ID);

    //tab title
    public static final String MAGIC_TAB_TITLE = "creativetab.univers.magictab";
    public static final String SCROLL_TAB_TITLE = "creativetab.univers.scrolltab";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGIC_TAB = CREATIVE_MODE_TABS.register("magic_tab", () -> {
        var builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplayParameters, output) -> {
           output.accept(new ItemStack(ItemInit.MAGIC_INK.get()));
           output.accept(new ItemStack(ItemInit.FIRE_GEM.get()));
           output.accept(new ItemStack(ItemInit.WATER_GEM.get()));
           output.accept(new ItemStack(ItemInit.EARTH_GEM.get()));
           output.accept(new ItemStack(ItemInit.AIR_GEM.get()));
        });

        builder.icon(() -> new ItemStack(ItemInit.MAGIC_INK.get()));
        builder.title(Component.translatable(MAGIC_TAB_TITLE));

        return builder.build();
    });

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCROLL_TAB = CREATIVE_MODE_TABS.register("scroll_tab", () -> {
        var builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplayParameters, output) -> {
            output.accept(new ItemStack(ItemInit.BLANK_SCROLL.get()));
            output.accept(new ItemStack(ItemInit.SPEED_SCROLL.get()));
        });

        builder.icon(() -> new ItemStack(ItemInit.BLANK_SCROLL.get()));
        builder.title(Component.translatable(SCROLL_TAB_TITLE));

        return builder.build();
    });

    public static void register(IEventBus bus) {
        Log.info("Registering creative tabs");

        CREATIVE_MODE_TABS.register(bus);
    }
}
