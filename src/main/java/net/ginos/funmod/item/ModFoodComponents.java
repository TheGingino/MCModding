package net.ginos.funmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent FRIKANDEL = new FoodComponent.Builder().nutrition(10).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,150), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 1.0f)
            .build();

    public static final FoodComponent RAW_HORSE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).build();
    public static final FoodComponent COOKED_HORSE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();

    public static final FoodComponent BLUEBERRY = new FoodComponent.Builder().nutrition(2).
            saturationModifier(0.5f).snack().build();
}
