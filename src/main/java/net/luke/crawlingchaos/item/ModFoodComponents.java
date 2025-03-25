package net.luke.crawlingchaos.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static FoodComponent BLIGHT_ROTTEN_FLESH_COMPONENT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static FoodComponent LUMINOUS_CHICKEN_COMPONENT = new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).build();
    public static FoodComponent HYOUROUGAN_COMPONENT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static FoodComponent JELLY_APPLE_COMPONENT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).build();
    public static FoodComponent FORMULA_DRINK = new FoodComponent.Builder().nutrition(0).saturationModifier(0.0f).alwaysEdible().build();

    public static final ConsumableComponent BLIGHT_ROTTEN_FLESH_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 30 * 20, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20, 0), 0.5F))
            .build();
    public static ConsumableComponent FORMULA_DRINK_COMPONENT = ConsumableComponents.drink().build();
    public static ConsumableComponent FORMULA_MOONLIGHT_COMPONENT = ConsumableComponents.drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 25 * 20, 0), 1.0f))
            .build();
    public static ConsumableComponent FORMULA_POISON_VERMILION_COMPONENT = ConsumableComponents.drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 120 * 20, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 20, 0), 1.0f))
            .build();
    public static ConsumableComponent FORMULA_PURIFICATION_COMPONENT = ConsumableComponents.drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 120 * 20, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 80 * 20, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 80 * 20, 0), 1.0f))
            .build();
    public static final ConsumableComponent LUMINOUS_CHICKEN_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 40 * 20, 0), 1.0f))
            .build();
    public static final ConsumableComponent HYOUROUGAN_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 50 * 20, 1), 1.0f))
            .build();
}
