package net.feral.fractureddepths.worldgen.biome;

import net.feral.fractureddepths.FracturedDepths;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(FracturedDepths.MOD_ID, "overworld"), 5));
    }
}
