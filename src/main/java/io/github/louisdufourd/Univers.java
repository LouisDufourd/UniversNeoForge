package io.github.louisdufourd;

import com.mojang.logging.LogUtils;
import io.github.louisdufourd.core.init.BlockInit;
import io.github.louisdufourd.core.init.CreativeModTabInit;
import io.github.louisdufourd.core.init.ItemInit;
import io.github.louisdufourd.core.init.MobEffectInit;
import io.github.louisdufourd.data.DataGenerators;
import io.github.louisdufourd.util.EventHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod("univers")
public class Univers {

    public static final String MOD_ID = "univers";

    public static final Logger LOG = LogUtils.getLogger();

    public Univers(IEventBus bus) {
        //registers
        ItemInit.register(bus);
        BlockInit.register(bus);
        CreativeModTabInit.register(bus);
        MobEffectInit.register(bus);

        //listeners
        bus.addListener(DataGenerators::gatherData);
        bus.addListener(ItemInit::buildContents);
        NeoForge.EVENT_BUS.addListener(EventHandler::onGainExp);
    }
}
