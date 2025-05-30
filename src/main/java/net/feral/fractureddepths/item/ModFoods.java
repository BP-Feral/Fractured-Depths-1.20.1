package net.feral.fractureddepths.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();

    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200), 0.1f).build();
}
