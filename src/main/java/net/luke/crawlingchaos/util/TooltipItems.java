package net.luke.crawlingchaos.util;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.luke.crawlingchaos.item.ModItems;
import net.minecraft.text.Text;

public class TooltipItems {
    public static final int tooltip_effect_color = 0xA8C2A8;

    public static void registerTooltipItems() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.BLIGHT_ROTTEN_FLESH)) {
                list.add(Text.translatable("effect.minecraft.hunger")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 00:30"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.poison")
                        .append(Text.literal(" 00:15"))
                        .append(Text.literal(" "))
                        .append(Text.literal("in 50%"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_ABYSSAL_GAZE)) {
                list.add(Text.translatable("effect.minecraft.water_breathing")
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.night_vision")
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.blindness")
                        .append(Text.literal(" 01:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_CRIMSON_BURST)) {
                list.add(Text.translatable("effect.minecraft.speed")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.haste")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.hunger")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 01:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_MOONLIGHT)) {
                list.add(Text.translatable("effect.minecraft.night_vision")
                        .append(Text.literal(" 00:25"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_PHANTOM_LIMBS)) {
                list.add(Text.translatable("effect.minecraft.jump_boost")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.2"))
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.slow_falling")
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.weakness")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 01:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_POISON_VERMILION)) {
                list.add(Text.translatable("effect.minecraft.strength")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.poison")
                        .append(Text.literal(" 00:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_PURIFICATION)) {
                list.add(Text.translatable("effect.minecraft.health_boost")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.2"))
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.slowness")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 01:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.mining_fatigue")
                        .append(Text.literal(" 01:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.FORMULA_VOLTAIC_SURGE)) {
                list.add(Text.translatable("effect.minecraft.speed")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.2"))
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.resistance")
                        .append(Text.literal(" 02:00"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
                list.add(Text.translatable("effect.minecraft.weakness")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 01:20"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.HYOUROUGAN)) {
                list.add(Text.translatable("effect.minecraft.health_boost")
                        .append(Text.literal(" "))
                        .append(Text.translatable("potion.potency.1"))
                        .append(Text.literal(" 00:50"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
            else if (itemStack.isOf(ModItems.LUMINOUS_CHICKEN_STEW)) {
                list.add(Text.translatable("effect.minecraft.night_vision")
                        .append(Text.literal(" 00:40"))
                        .styled(style -> style.withColor(tooltip_effect_color)));
            }
        });
    }
}
