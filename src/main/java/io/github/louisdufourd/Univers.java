package io.github.louisdufourd;

import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.CreativeModTabInit;
import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.data.DataGenerators;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("univers")
public class Univers {

    public static final String MOD_ID = "univers";

    public static final Logger LOG = LoggerFactory.getLogger(Univers.class);

    public Univers(IEventBus bus) {
        //registers
        ItemInit.register(bus);
        BlockInit.register(bus);
        CreativeModTabInit.register(bus);

        //listeners
        bus.addListener(DataGenerators::gatherData);
    }

    @SubscribeEvent
    public static void buildContents(@NotNull BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockInit.PLATINUM_ORE.get());
            event.accept(BlockInit.DEEPSLATE_PLATINUM_ORE.get());
            event.accept(BlockInit.RAW_PLATINUM_BLOCK.get());
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockInit.PLATINUM_BLOCK.get());
        }

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.RAW_PLATINUM.get());
            event.accept(ItemInit.PLATINUM_INGOT.get());
            event.accept(ItemInit.PLATINUM_STICK.get());
            event.accept(ItemInit.MAGIC_INK.get());
        }
    }
}
