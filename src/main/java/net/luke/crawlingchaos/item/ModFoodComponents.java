package net.luke.crawlingchaos.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static FoodComponent LUMINOUS_CHICKEN_COMPONENT = new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).build();
    public static FoodComponent HYOUROUGAN_COMPONENT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();

    public static final ConsumableComponent LUMINOUS_CHICKEN_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 40 * 20, 1), 1.0f))
            .build();
    public static final ConsumableComponent HYOUROUGAN_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 50 * 20, 1), 1.0f))
            .build();
}
