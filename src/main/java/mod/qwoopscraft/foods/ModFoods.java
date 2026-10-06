package mod.qwoopscraft.foods;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties BACON                 = registerFoodProperties(5,0.1F);
    public static final Consumable BACON_CONSUME             = registerConsumable(1F);
    public static final FoodProperties BACON_RAW             = registerFoodProperties(2,0.01F);
    public static final Consumable BACON_RAW_CONSUME         = registerConsumableEffect(1,MobEffects.HUNGER,60,2,1);
    public static final FoodProperties UNCLEAN_RICE          = registerFoodProperties(1,0.01F);
    public static final Consumable UNCLEAN_RICE_CONSUME      = registerConsumableEffect(1,MobEffects.HUNGER,60,2,1);
    public static final FoodProperties CLEAN_RICE            = registerFoodProperties(5,0.3F);
    public static final Consumable CLEAN_RICE_CONSUME        = registerConsumable(1F);
    public static final FoodProperties COOKED_RICE           = registerFoodProperties(6,0.39F);
    public static final Consumable COOKED_RICE_CONSUME       = registerConsumableEffect(1,MobEffects.SATURATION,20,1,0.075F);
    public static final FoodProperties COOKED_BACON_RICE     = registerFoodProperties(10,0.67F);
    public static final Consumable COOKED_BACON_RICE_CONSUME = registerConsumableEffect(1,MobEffects.SATURATION,30,1,0.10F);
    public static final FoodProperties CHEESE                = registerFoodProperties(5,0.25F);
    public static final Consumable CHEESE_CONSUME            = registerConsumableEffect(1,MobEffects.GLOWING,20,1,0.2F);
    public static final FoodProperties PATTY                 = registerFoodProperties(4,0.15F);
    public static final Consumable PATTY_CONSUME             = registerConsumable(1F);
    public static final FoodProperties PATTY_RAW             = registerFoodProperties(3,0.01F);
    public static final Consumable PATTY_RAW_CONSUME         = registerConsumableEffect(1,MobEffects.HUNGER,20,2,1F);
    public static final FoodProperties BURGER                = registerFoodProperties(7,0.5F);
    public static final Consumable BURGER_CONSUME            = registerConsumableEffect(1,MobEffects.SATURATION,30,1,0.075F);
    public static final FoodProperties BURGER_CHEESE         = registerFoodProperties(10,0.67F);
    public static final Consumable BURGER_CHEESE_CONSUME     = registerConsumableEffect(1,MobEffects.SATURATION,30,1,0.10F);

    public static FoodProperties registerFoodProperties(int sat, float sat_float){
        return (new FoodProperties.Builder()).nutrition((int) (sat*1.15F)).saturationModifier(sat_float).build();
    }

    public static Consumable registerConsumable(float cons_sec){
        return (Consumables.defaultFood().consumeSeconds(cons_sec).build());
    }
    public static Consumable registerConsumableEffect(float cons_sec, Holder<MobEffect> effect, int dur,int ampl, float prob){
        return (Consumables.defaultFood().consumeSeconds(cons_sec).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect,dur,ampl,true,false), prob)).build());
    }
}
