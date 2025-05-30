package net.feral.fractureddepths.datagen;

import net.feral.fractureddepths.FracturedDepths;
import net.feral.fractureddepths.item.ModItems;
import net.feral.fractureddepths.loot.AddItemModifier;
import net.feral.fractureddepths.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FracturedDepths.MOD_ID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.PINE_CONE.get()));

        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[] {
        new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft","entities/creeper")).build() }, ModItems.PINE_CONE.get()));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
        new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft","chests/jungle_temple")).build() }, ModItems.METAL_DETECTOR.get()));

        add("metal_detector_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[] {
        new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft","archaeology/desert_pyramid")).build() }, ModItems.METAL_DETECTOR.get()));


    }
}
