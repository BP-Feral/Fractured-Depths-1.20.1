package net.feral.fractureddepths.item;

import net.feral.fractureddepths.FracturedDepths;
import net.feral.fractureddepths.block.ModBlocks;
import net.feral.fractureddepths.entity.ModEntities;
import net.feral.fractureddepths.item.custom.FuelItem;
import net.feral.fractureddepths.item.custom.MetalDetectorItem;
import net.feral.fractureddepths.item.custom.ModArmorItem;
import net.feral.fractureddepths.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // Long list of items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FracturedDepths.MOD_ID);


    // Minerals / Materials -> MISC
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));


    // Food and Crop Seeds
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));


    // Handheld Items
    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));


    // Tools
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));


    // One of the armor items is of type ModArmorItem. One is enough to check for the rest since it has to be all 4 equipped
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static final RegistryObject<Item> BEWITCHED_MUSIC_DISC = ITEMS.register("bewitched_music_disc",
            () -> new RecordItem(6, ModSounds.BEWITCHED, new Item.Properties().stacksTo(1), 2920));
    public static final RegistryObject<Item> NO_ESCAPE_MUSIC_DISC = ITEMS.register("no_escape_music_disc",
            () -> new RecordItem(6, ModSounds.NO_ESCAPE, new Item.Properties().stacksTo(1), 2960));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5, new Item.Properties()));

    public static final RegistryObject<Item> PINE_SIGN = ITEMS.register("pine_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PINE_SIGN.get(), ModBlocks.PINE_WALL_SIGN.get()));
    public static final RegistryObject<Item> PINE_HANGING_SIGN = ITEMS.register("pine_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}