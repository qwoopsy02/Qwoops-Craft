package mod.qwoopscraft.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties BACON = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final Consumable BACON_CONSUME = Consumables.defaultFood().consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION,30), 0.05f)).build();
    public static final FoodProperties UNCLEAN_RICE = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final Consumable UNCLEAN_RICE_CONSUME = Consumables.defaultFood().consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION,30), 0.05f)).build();
    public static final FoodProperties CLEAN_RICE = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final Consumable CLEAN_RICE_CONSUME = Consumables.defaultFood().consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION,30), 0.05f)).build();
    public static final FoodProperties COOKED_RICE = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final Consumable COOKED_RICE_CONSUME = Consumables.defaultFood().consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION,30), 0.05f)).build();
    public static final FoodProperties COOKED_BACON_RICE = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final Consumable COOKED_BACON_RICE_CONSUME = Consumables.defaultFood().consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION,30), 0.05f)).build();


}
