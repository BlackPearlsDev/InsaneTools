package fr.bp.insaneTools;

import fr.bp.insaneTools.init.ModItems;
import fr.bp.insaneTools.init.ModBlocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(InsaneTools.MODID)
public class InsaneTools {

    public static final String MODID = "insanetools";
    public static final Logger LOGGER = LogManager.getLogger();

    public InsaneTools() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(InsaneTools::setup);
        bus.addListener(InsaneTools::clientSetup);
        bus.addListener(InsaneTools::onRegisterCreativeTabs);

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }

    private static void setup(FMLCommonSetupEvent e) {
        // TODO
    }

    private static void clientSetup(FMLClientSetupEvent e) {
        // TODO
    }

    public static void onRegisterCreativeTabs(CreativeModeTabEvent.Register e) {
        ModItems.onRegisterCreativeTabs((loc, item, items) -> e.registerCreativeModeTab(loc, b -> b
        .title(Component.translatable("Insane Tools"))
        .icon(() -> item.get().getDefaultInstance())
        .displayItems((featureFlagSet, output, bl) -> items.forEach(output::accept))
        .build()));
    }
}