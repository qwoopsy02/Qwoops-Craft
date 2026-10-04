package mod.qwoopscraft.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties BACON = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final Consumable BACON_CONSUMABLE = Consumables.defaultFood().consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION,30), 0.05f)).build();

}
