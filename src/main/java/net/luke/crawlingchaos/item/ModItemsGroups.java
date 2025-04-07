package net.luke.crawlingchaos.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {
    public static final ItemGroup CRAWLINGCHAOS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrawlingChaos.MOD_ID, "crawling_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VIRUS_SPROUTS))
                    .displayName(Text.translatable("pack.crawling")
                            .styled(style -> style.withColor(0x622DBD)))
                    .entries((displayContext, entries) -> {

                        // Normal Items
                        entries.add(ModItems.ACARUS_CHITIN);
                        entries.add(ModItems.BUTTERFLY_WINGS);
                        entries.add(ModItems.CRYSTALS_OF_VIRUS);
                        entries.add(ModItems.CRYSTALS_OF_VIRUS_SHARD);
                        entries.add(ModItems.GROWTH_ORGAN);
                        entries.add(ModItems.INSECT_WINGS);
                        entries.add(ModItems.KNIGHT_EXOSKELETON);
                        entries.add(ModItems.PARASITE_TOOTH);
                        entries.add(ModItems.SERUPINEA_EXOSKELETON);
                        entries.add(ModItems.STORAGE_ORGAN);
                        entries.add(ModItems.STORAGE_ORGAN_POISON);
                        entries.add(ModItems.TEST_TUBE);
                        entries.add(ModItems.VIRUS_TEMPLATE);
                        entries.add(ModItems.VIRUS_A);
                        entries.add(ModItems.VIRUS_B);
                        entries.add(ModItems.VIRUS_C);
                        entries.add(ModItems.VIRUS_BUDS);
                        entries.add(ModItems.VIRUS_SEEDS);
                        entries.add(ModItems.VIRUS_SPROUTS);

                        // Foods
                        entries.add(ModItems.BLIGHT_ROTTEN_FLESH);
                        entries.add(ModItems.HYOUROUGAN);
                        entries.add(ModItems.JELLY_APPLE);
                        entries.add(ModItems.LUMINOUS_CHICKEN_STEW);

                        // Drinks
                        entries.add(ModItems.TEST_TUBE_WATER);
                        entries.add(ModItems.FORMULA_ABYSSAL_GAZE);
                        entries.add(ModItems.FORMULA_CRIMSON_BURST);
                        entries.add(ModItems.FORMULA_MOONLIGHT);
                        entries.add(ModItems.FORMULA_PHANTOM_LIMBS);
                        entries.add(ModItems.FORMULA_POISON_VERMILION);
                        entries.add(ModItems.FORMULA_PURIFICATION);
                        entries.add(ModItems.FORMULA_VOLTAIC_SURGE);

                        // Smithing Templates and Upgrades Items
                        entries.add(ModItems.SERUPINEA_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.KNIGHT_UPGRADE_SMITHING_TEMPLATE);

                        // Tools Items
                        entries.add(ModItems.SERUPINEA_AXE);
                        entries.add(ModItems.SERUPINEA_HOE);
                        entries.add(ModItems.SERUPINEA_PICKAXE);
                        entries.add(ModItems.SERUPINEA_SHOVEL);
                        entries.add(ModItems.SERUPINEA_SWORD);
                        entries.add(ModItems.TOOTH_DAGGER);

                        // Armor Items
                        entries.add(ModItems.SERUPINEA_HELMET);
                        entries.add(ModItems.SERUPINEA_CHESTPLATE);
                        entries.add(ModItems.SERUPINEA_LEGGINGS);
                        entries.add(ModItems.SERUPINEA_BOOTS);
                        entries.add(ModItems.KNIGHT_HELMET);
                        entries.add(ModItems.KNIGHT_CHESTPLATE);
                        entries.add(ModItems.KNIGHT_LEGGINGS);
                        entries.add(ModItems.KNIGHT_BOOTS);

                        // Spawn Eggs
                        entries.add(ModItems.ACARUS_SPAWN_EGG);
                        entries.add(ModItems.CARRIER_BUG_SPAWN_EGG);
                        entries.add(ModItems.ERODED_ZOMBIE_SPAWN_EGG);
                        entries.add(ModItems.HELENA_SPAWN_EGG);
                        entries.add(ModItems.KNIGHT_BUG_SPAWN_EGG);
                        entries.add(ModItems.LONEGER_SPAWN_EGG);
                        entries.add(ModItems.PARASITE_WORM_SPAWN_EGG);
                        entries.add(ModItems.SERUPINEA_SPAWN_EGG);
                        entries.add(ModItems.PRISM_FROG_SPAWN_EGG);
                        entries.add(ModItems.SKELETON_FRIEND_SPAWN_EGG);

                        // Blocks
                        entries.add(ModBlocks.BUG_OAK_LOG);
                        entries.add(ModBlocks.BUG_OAK_WOOD);
                        entries.add(ModBlocks.STRIPPED_BUG_OAK_LOG);
                        entries.add(ModBlocks.STRIPPED_BUG_OAK_WOOD);
                        entries.add(ModBlocks.BUG_OAK_PLANKS);
                        entries.add(ModBlocks.BUG_OAK_STAIRS);
                        entries.add(ModBlocks.BUG_OAK_SLAB);
                        entries.add(ModBlocks.BUG_OAK_FENCE);
                        entries.add(ModBlocks.BUG_OAK_FENCE_GATE);
                        entries.add(ModBlocks.BUG_OAK_DOOR);
                        entries.add(ModBlocks.BUG_OAK_TRAPDOOR);
                        entries.add(ModBlocks.BUG_OAK_PRESSURE_PLATE);
                        entries.add(ModBlocks.BUG_OAK_BUTTON);
                        entries.add(ModBlocks.BUG_OAK_LEAVES);
                        entries.add(ModBlocks.BUG_OAK_SAPLING);
                        entries.add(ModBlocks.BUG_OAK_SIGN);
                        entries.add(ModBlocks.BUG_OAK_HANGING_SIGN);
                        entries.add(ModItems.BUG_OAK_BOAT); // Not Block but listed here
                        entries.add(ModItems.BUG_OAK_CHEST_BOAT); // Not Block but listed here
                        entries.add(ModBlocks.MYCENA_CHLOROPHOS);
                        entries.add(ModBlocks.BIOLLANTA);
                        entries.add(ModBlocks.TERAPIA);
                        entries.add(ModBlocks.POISON_VINE);
                        entries.add(ModBlocks.FERTILE_SLIME);
                        entries.add(ModBlocks.SOULBONE_CAULDRON);
                        entries.add(ModBlocks.LAMP_BLOCK);
                        entries.add(ModBlocks.SOUL_LAMP_BLOCK);
                        entries.add(ModBlocks.PATTERN_GLASS_FIELD_FLOWER);
                        entries.add(ModBlocks.PATTERN_GLASS_RELAXING_MELODY);
                        entries.add(ModBlocks.PATTERN_GLASS_SUNSHINE);
                        entries.add(ModBlocks.PATTERN_GLASS_DARK_GOTHIC_SHADES);
                        entries.add(ModBlocks.PATTERN_GLASS_PANE_FIELD_FLOWER);
                        entries.add(ModBlocks.PATTERN_GLASS_PANE_RELAXING_MELODY);
                        entries.add(ModBlocks.PATTERN_GLASS_PANE_SUNSHINE);
                        entries.add(ModBlocks.PATTERN_GLASS_PANE_DARK_GOTHIC_SHADES);
                    }).build());

    public static void registerItemsGroups() {
        CrawlingChaos.LOGGER.info("Registering Item Groups for " + CrawlingChaos.MOD_ID);
    }
}
