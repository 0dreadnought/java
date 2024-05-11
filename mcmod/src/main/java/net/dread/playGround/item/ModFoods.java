package net.dread.playGround.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.1f)
            .effect(()-> new MobEffectInstance(MobEffects.BLINDNESS, 20, 1),0.33f)
            .effect(()-> new MobEffectInstance(MobEffects.POISON, 60, 1),0.33f)
            .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 80, 1),0.33f)
            .build();

}
