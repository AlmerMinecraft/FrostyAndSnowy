package almer.snowyandfrosty.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent BLUEBERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build();
    public static final FoodComponent BERRY_MIX = new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600), 0.6f).build();
}
