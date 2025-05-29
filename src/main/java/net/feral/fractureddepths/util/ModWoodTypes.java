package net.feral.fractureddepths.util;

import net.feral.fractureddepths.FracturedDepths;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(FracturedDepths.MOD_ID + ":pine", BlockSetType.OAK));

}
