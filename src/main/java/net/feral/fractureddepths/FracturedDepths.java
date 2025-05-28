package net.feral.fractureddepths;

import com.mojang.logging.LogUtils;
import net.feral.fractureddepths.block.ModBlocks;
import net.feral.fractureddepths.block.entity.ModBlockEntities;
import net.feral.fractureddepths.entity.ModEntities;
import net.feral.fractureddepths.entity.client.RhinoRenderer;
import net.feral.fractureddepths.item.ModCreativeModTabs;
import net.feral.fractureddepths.item.ModItems;
import net.feral.fractureddepths.loot.ModLootModifiers;
import net.feral.fractureddepths.screen.GemPolishingStationScreen;
import net.feral.fractureddepths.screen.ModMenuTypes;
import net.feral.fractureddepths.sound.ModSounds;
import net.feral.fractureddepths.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FracturedDepths.MOD_ID)
public class FracturedDepths {
    public static final String MOD_ID = "fractureddepths";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FracturedDepths(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the creative mode tab
        ModCreativeModTabs.register(modEventBus);

        // Register custom items
        ModItems.register(modEventBus);

        // Register custom blocks
        ModBlocks.register(modEventBus);

        // Register loottables
        ModLootModifiers.register(modEventBus);

        // Register custom vilalgers
        ModVillagers.register(modEventBus);

        // Register custom entities
        ModEntities.register(modEventBus);

        // Register custom block entities
        ModBlockEntities.register(modEventBus);

        // Register custom block menu
        ModMenuTypes.register(modEventBus);

        // Register custom sounds | IMPORTANT: HAS TO BE MONO AND .OGG
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CATMINT.getId(), ModBlocks.POTTED_CATMINT);
        });
    }

    // Add the sapphire item to the creative tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);

            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        }
    }
}
