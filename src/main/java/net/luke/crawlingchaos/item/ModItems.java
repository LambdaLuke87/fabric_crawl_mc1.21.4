package net.luke.crawlingchaos.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DamageResistantComponent;
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

public class ModItems {
    public static final Item BUTTERFLY_WINGS = registerItem("butterfly_wings", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "butterfly_wings")))));
    public static final Item CRYSTALS_OF_VIRUS = registerItem("crystals_of_virus", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "crystals_of_virus")))));
    public static final Item GROWTH_ORGAN = registerItem("growth_organ", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "growth_organ")))));
    public static final Item INSECT_WINGS = registerItem("insect_wings", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "insect_wings")))));
    public static final Item NIGHT_EXOSKELETON = registerItem("night_exoskeleton", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "night_exoskeleton")))));
    public static final Item PARASITE_TOOTH = registerItem("parasite_tooth", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "parasite_tooth")))));
    public static final Item SERUPINEA_EXOSKELETON = registerItem("serupinea_exoskeleton", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_exoskeleton")))));
    public static final Item SMALL_CRYSTALS = registerItem("small_crystals", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "small_crystals")))));
    public static final Item STORAGE_ORGAN = registerItem("storage_organ", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "storage_organ")))));
    public static final Item STORAGE_ORGAN_POISON = registerItem("storage_organ_poison", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "storage_organ_poison")))));
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
    public static final Item HYOUROUGAN = registerItem("hyourougan", new Item(new Item.Settings()
            .food(ModFoodComponents.HYOUROUGAN_COMPONENT, ModFoodComponents.HYOUROUGAN_CONSUMABLE_COMPONENT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "hyourougan")))){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("effect.minecraft.health_boost")
                    .append(Text.literal(" 00:50"))
                    .styled(style -> style.withColor(0xA8C2A8)));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item LUMINOUS_CHICKEN_STEW = registerItem("luminous_chicken_stew", new Item(new Item.Settings().maxCount(1)
            .food(ModFoodComponents.LUMINOUS_CHICKEN_COMPONENT, ModFoodComponents.LUMINOUS_CHICKEN_CONSUMABLE_COMPONENT).useRemainder(Items.BOWL)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "luminous_chicken_stew")))){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("effect.minecraft.night_vision")
                    .append(Text.literal(" 00:40"))
                    .styled(style -> style.withColor(0xA8C2A8)));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    // Smithing Templates and Upgrades Items
    public static final Item SERUPINEA_UPGRADE_SMITHING_TEMPLATE = registerItem("serupinea_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_upgrade_smithing_template"))).rarity(Rarity.UNCOMMON)));
    public static final Item NIGHT_UPGRADE_SMITHING_TEMPLATE = registerItem("night_upgrade_smithing_template", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "night_upgrade_smithing_template"))).rarity(Rarity.UNCOMMON)));

    // Tools Items
    public static final Item SERUPINEA_AXE = registerItem("serupinea_axe",
            new AxeItem(ModToolMaterials.SERUPINEA, 6.5F, -3.1F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_axe")))));
    public static final Item SERUPINEA_HOE = registerItem("serupinea_hoe",
            new HoeItem(ModToolMaterials.SERUPINEA, -2.0F, -1.0F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_hoe")))));
    public static final Item SERUPINEA_PICKAXE = registerItem("serupinea_pickaxe",
            new PickaxeItem(ModToolMaterials.SERUPINEA, 1.5F, -2.8F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_pickaxe")))));
    public static final Item SERUPINEA_SHOVEL = registerItem("serupinea_shovel",
            new ShovelItem(ModToolMaterials.SERUPINEA, 2.0F, -3.0F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_shovel")))));
    public static final Item SERUPINEA_SWORD = registerItem("serupinea_sword",
            new SwordItem(ModToolMaterials.SERUPINEA, 3.5F, -2.4f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_sword")))));

    public static final Item TOOTH_DAGGER = registerItem("tooth_dagger",
            new SwordItem(ToolMaterial.STONE, 3.0F, -2.0F, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "tooth_dagger")))));


    // Armor Items
    public static final Item SERUPINEA_HELMET = registerItem("serupinea_helmet",
            new ArmorItem(SerupineaArmorMaterial.INSTANCE, EquipmentType.HELMET, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_helmet")))));
    public static final Item SERUPINEA_CHESTPLATE = registerItem("serupinea_chestplate",
            new ArmorItem(SerupineaArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_chestplate")))));
    public static final Item SERUPINEA_LEGGINGS = registerItem("serupinea_leggings",
            new ArmorItem(SerupineaArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_leggings")))));
    public static final Item SERUPINEA_BOOTS = registerItem("serupinea_boots",
            new ArmorItem(SerupineaArmorMaterial.INSTANCE, EquipmentType.BOOTS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_boots")))));

    public static final Item NIGHT_HELMET = registerItem("night_helmet",
            new ArmorItem(NightArmorMaterial.INSTANCE, EquipmentType.HELMET, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "night_helmet")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));
    public static final Item NIGHT_CHESTPLATE = registerItem("night_chestplate",
            new ArmorItem(NightArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "night_chestplate")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));
    public static final Item NIGHT_LEGGINGS = registerItem("night_leggings",
            new ArmorItem(NightArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "night_leggings")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));
    public static final Item NIGHT_BOOTS = registerItem("night_boots",
            new ArmorItem(NightArmorMaterial.INSTANCE, EquipmentType.BOOTS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "night_boots")))
                    .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))));

    // SpawnEggs
    public static final Item ERODED_ZOMBIE_SPAWN_EGG = registerItem("eroded_zombie_spawn_egg", new SpawnEggItem(ModEntities.ERODED_ZOMBIE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie_spawn_egg")))));
    public static final Item KNIGHT_BUG_SPAWN_EGG = registerItem("knight_bug_spawn_egg", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "knight_bug_spawn_egg")))));
    public static final Item LONEGER_SPAWN_EGG = registerItem("loneger_spawn_egg", new SpawnEggItem(ModEntities.LONEGER, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "loneger_spawn_egg")))));
    public static final Item PARASITE_WORM_SPAWN_EGG = registerItem("parasite_worm_spawn_egg", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "parasite_worm_spawn_egg")))));
    public static final Item SERUPINEA_SPAWN_EGG = registerItem("serupinea_spawn_egg", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "serupinea_spawn_egg")))));
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
