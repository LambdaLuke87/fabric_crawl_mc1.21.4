package net.luke.crawlingchaos.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.ModEntities;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DamageResistantComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.function.Consumer;

public class ModItems {
    public static final int tooltip_effect_color = 0xA8C2A8;

    public static final Item ACARUS_CHITIN = registerItem("acarus_chitin", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "acarus_chitin")))));
    public static final Item BUTTERFLY_WINGS = registerItem("butterfly_wings", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "butterfly_wings")))));
    public static final Item CRYSTALS_OF_VIRUS = registerItem("crystals_of_virus", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "crystals_of_virus")))));
    public static final Item CRYSTALS_OF_VIRUS_SHARD = registerItem("crystals_of_virus_shard", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "crystals_of_virus_shard")))));
    public static final Item GROWTH_ORGAN = registerItem("growth_organ", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "growth_organ")))));
    public static final Item INSECT_WINGS = registerItem("insect_wings", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "insect_wings")))));
    public static final Item KNIGHT_EXOSKELETON = registerItem("knight_exoskeleton", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_exoskeleton")))));
    public static final Item PARASITE_TOOTH = registerItem("parasite_tooth", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "parasite_tooth")))));
    public static final Item SERUPINEA_EXOSKELETON = registerItem("serupinea_exoskeleton", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_exoskeleton")))));
    public static final Item STORAGE_ORGAN = registerItem("storage_organ", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "storage_organ")))));
    public static final Item STORAGE_ORGAN_POISON = registerItem("storage_organ_poison", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "storage_organ_poison")))));
    public static final Item TEST_TUBE = registerItem("test_tube", new TestTubeItem(new Item.Settings().maxCount(16)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "test_tube")))));
    public static final Item VIRUS_TEMPLATE = registerItem("virus_template", new VirusTemplateItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_template")))));
    public static final Item VIRUS_A = registerItem("virus_a", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_a")))));
    public static final Item VIRUS_B = registerItem("virus_b", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_b")))));
    public static final Item VIRUS_BUDS = registerItem("virus_buds", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_buds")))));
    public static final Item VIRUS_C = registerItem("virus_c", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_c")))));
    public static final Item VIRUS_SEEDS = registerItem("virus_seeds", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_seeds")))));
    public static final Item VIRUS_SPROUTS = registerItem("virus_sprouts", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_sprouts")))));

    // Foods
    public static final Item BLIGHT_ROTTEN_FLESH = registerItem("blight_rotten_flesh", new Item(new Item.Settings()
            .food(ModFoodComponents.BLIGHT_ROTTEN_FLESH_COMPONENT, ModFoodComponents.BLIGHT_ROTTEN_FLESH_CONSUMABLE_COMPONENT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "blight_rotten_flesh")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.hunger")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 00:30"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.poison")
                    .append(Text.literal(" 00:15"))
                    .append(Text.literal(" "))
                    .append(Text.literal("in 50%"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item TEST_TUBE_WATER = registerItem("test_tube_water", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_DRINK_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "test_tube_water")))));
    public static final Item FORMULA_ABYSSAL_GAZE = registerItem("formula_abyssal_gaze", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_ABYSSAL_GAZE_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_abyssal_gaze")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.water_breathing")
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.night_vision")
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.blindness")
                    .append(Text.literal(" 01:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item FORMULA_CRIMSON_BURST = registerItem("formula_crimson_burst", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_CRIMSON_BURST_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_crimson_burst")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.speed")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.haste")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.hunger")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 01:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item FORMULA_MOONLIGHT = registerItem("formula_moonlight", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_MOONLIGHT_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_moonlight")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.night_vision")
                    .append(Text.literal(" 00:25"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item FORMULA_PHANTOM_LIMBS = registerItem("formula_phantom_limbs", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_PHANTOM_LIMBS_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_phantom_limbs")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.jump_boost")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.2"))
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.slow_falling")
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.weakness")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 01:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item FORMULA_POISON_VERMILION = registerItem("formula_poison_vermilion", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_POISON_VERMILION_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_poison_vermilion")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.strength")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.poison")
                            .append(Text.literal(" 00:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item FORMULA_PURIFICATION = registerItem("formula_purification", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_PURIFICATION_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_purification")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.health_boost")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.2"))
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.slowness")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 01:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.mining_fatigue")
                    .append(Text.literal(" 01:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item FORMULA_VOLTAIC_SURGE = registerItem("formula_voltaic_surge", new Item(new Item.Settings().maxCount(16)
            .food(ModFoodComponents.FORMULA_DRINK, ModFoodComponents.FORMULA_VOLTAIC_SURGE_COMPONENT).useRemainder(TEST_TUBE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "formula_voltaic_surge")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.speed")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.2"))
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.resistance")
                    .append(Text.literal(" 02:00"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            textConsumer.accept(Text.translatable("effect.minecraft.weakness")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 01:20"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item HYOUROUGAN = registerItem("hyourougan", new Item(new Item.Settings()
            .food(ModFoodComponents.HYOUROUGAN_COMPONENT, ModFoodComponents.HYOUROUGAN_CONSUMABLE_COMPONENT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "hyourougan")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.health_boost")
                    .append(Text.literal(" "))
                    .append(Text.translatable("potion.potency.1"))
                    .append(Text.literal(" 00:50"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });
    public static final Item JELLY_APPLE = registerItem("jelly_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.JELLY_APPLE_COMPONENT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "jelly_apple")))));
    public static final Item LUMINOUS_CHICKEN_STEW = registerItem("luminous_chicken_stew", new Item(new Item.Settings().maxCount(1)
            .food(ModFoodComponents.LUMINOUS_CHICKEN_COMPONENT, ModFoodComponents.LUMINOUS_CHICKEN_CONSUMABLE_COMPONENT).useRemainder(Items.BOWL)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "luminous_chicken_stew")))){
        /*@Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("effect.minecraft.night_vision")
                    .append(Text.literal(" 00:40"))
                    .styled(style -> style.withColor(tooltip_effect_color)));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }*/
    });

    // Smithing Templates and Upgrades Items
    public static final Item SERUPINEA_UPGRADE_SMITHING_TEMPLATE = registerItem("serupinea_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_upgrade_smithing_template"))).rarity(Rarity.UNCOMMON)));
    public static final Item KNIGHT_UPGRADE_SMITHING_TEMPLATE = registerItem("knight_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_upgrade_smithing_template"))).rarity(Rarity.UNCOMMON)));

    // Tools Items
    public static final Item SERUPINEA_AXE = registerItem("serupinea_axe",
            new AxeItem(ModToolMaterials.SERUPINEA, 6.5F, -3.1F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_axe")))));
    public static final Item SERUPINEA_HOE = registerItem("serupinea_hoe",
            new HoeItem(ModToolMaterials.SERUPINEA, -2.0F, -1.0F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_hoe")))));
    public static final Item SERUPINEA_PICKAXE = registerItem("serupinea_pickaxe",
            new Item(new Item.Settings().pickaxe(ModToolMaterials.SERUPINEA, 1.5F, -2.8F)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_pickaxe")))));
    public static final Item SERUPINEA_SHOVEL = registerItem("serupinea_shovel",
            new ShovelItem(ModToolMaterials.SERUPINEA, 2.0F, -3.0F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_shovel")))));
    public static final Item SERUPINEA_SWORD = registerItem("serupinea_sword",
            new Item(new Item.Settings().sword(ModToolMaterials.SERUPINEA, 3.5F, -2.4f)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_sword")))));

    public static final Item TOOTH_DAGGER = registerItem("tooth_dagger",
            new Item(new Item.Settings().sword(ToolMaterial.STONE, 3.0F, -2.0F)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "tooth_dagger")))));


    // Armor Items
    public static final Item SERUPINEA_HELMET = registerItem("serupinea_helmet",
            new Item(new Item.Settings().armor(SerupineaArmorMaterial.INSTANCE, EquipmentType.HELMET)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_helmet")))));
    public static final Item SERUPINEA_CHESTPLATE = registerItem("serupinea_chestplate",
            new Item(new Item.Settings().armor(SerupineaArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_chestplate")))));
    public static final Item SERUPINEA_LEGGINGS = registerItem("serupinea_leggings",
            new Item(new Item.Settings().armor(SerupineaArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_leggings")))));
    public static final Item SERUPINEA_BOOTS = registerItem("serupinea_boots",
            new Item(new Item.Settings().armor(SerupineaArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_boots")))));

    public static final Item KNIGHT_HELMET = registerItem("knight_helmet",
            new Item(new Item.Settings().armor(KnightArmorMaterial.INSTANCE, EquipmentType.HELMET)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_helmet")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));
    public static final Item KNIGHT_CHESTPLATE = registerItem("knight_chestplate",
            new Item(new Item.Settings().armor(KnightArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_chestplate")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));
    public static final Item KNIGHT_LEGGINGS = registerItem("knight_leggings",
            new Item(new Item.Settings().armor(KnightArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_leggings")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));
    public static final Item KNIGHT_BOOTS = registerItem("knight_boots",
            new Item(new Item.Settings().armor(KnightArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_boots")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));

    // SpawnEggs
    public static final Item ACARUS_SPAWN_EGG = registerItem("acarus_spawn_egg", new SpawnEggItem(ModEntities.ACARUS, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "acarus_spawn_egg")))));
    public static final Item CARRIER_BUG_SPAWN_EGG = registerItem("carrier_bug_spawn_egg", new SpawnEggItem(ModEntities.CARRIER_BUG, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "carrier_bug_spawn_egg")))));
    public static final Item ERODED_ZOMBIE_SPAWN_EGG = registerItem("eroded_zombie_spawn_egg", new SpawnEggItem(ModEntities.ERODED_ZOMBIE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie_spawn_egg")))));
    public static final Item HELENA_SPAWN_EGG = registerItem("helena_spawn_egg", new SpawnEggItem(ModEntities.HELENA, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "helena_spawn_egg")))));
    public static final Item KNIGHT_BUG_SPAWN_EGG = registerItem("knight_bug_spawn_egg", new SpawnEggItem(ModEntities.KNIGHT_BUG, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_bug_spawn_egg")))));
    public static final Item LONEGER_SPAWN_EGG = registerItem("loneger_spawn_egg", new SpawnEggItem(ModEntities.LONEGER, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "loneger_spawn_egg")))));
    public static final Item PARASITE_WORM_SPAWN_EGG = registerItem("parasite_worm_spawn_egg", new SpawnEggItem(ModEntities.PARASITE_WORM, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "parasite_worm_spawn_egg")))));
    public static final Item SERUPINEA_SPAWN_EGG = registerItem("serupinea_spawn_egg", new SpawnEggItem(ModEntities.SERUPINEA, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_spawn_egg")))));
    public static final Item PRISM_FROG_SPAWN_EGG = registerItem("prism_frog_spawn_egg", new SpawnEggItem(ModEntities.PRISM_FROG, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "prism_frog_spawn_egg")))));
    public static final Item SKELETON_FRIEND_SPAWN_EGG = registerItem("skeleton_friend_spawn_egg", new SpawnEggItem(ModEntities.SKELETON_FRIEND, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend_spawn_egg")))));

    // Boats
    public static final Identifier BUG_OAK_BOATS_ID = Identifier.of(CrawlingChaos.MOD_ID, "bug_oak");

    public static final BoatItem BUG_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(BUG_OAK_BOATS_ID, false);
    public static final BoatItem BUG_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BUG_OAK_BOATS_ID, true);

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CrawlingChaos.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CrawlingChaos.LOGGER.info("Registering Mod Items for " + CrawlingChaos.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            // Don´t show mod items in Ingredients
            // entries.add(WING_TEST);
        });
    }
}
