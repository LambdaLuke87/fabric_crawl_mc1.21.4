package net.luke.crawlingchaos.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BIOLLANTA = registerBlock("biollanta",
            new FlowerBlock(StatusEffects.REGENERATION, 5.0F,AbstractBlock.Settings.copy(Blocks.POPPY)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "biollanta")))));
    public static final Block TERAPIA = registerBlock("terapia",
            new FlowerBlock(StatusEffects.NAUSEA, 5.0F,AbstractBlock.Settings.copy(Blocks.POPPY)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "terapia")))));
    public static final Block BUG_OAK_SAPLING = registerBlock("bug_oak_sapling",
            new SaplingBlock(ModSaplingGenerators.BUG_OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_sapling")))));
    public static final Block BUG_OAK_LOG = registerBlock("bug_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_log")))));
    public static final Block STRIPPED_BUG_OAK_LOG = registerBlock("stripped_bug_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "stripped_bug_oak_log")))));
    public static final Block BUG_OAK_PLANKS = registerBlock("bug_oak_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_planks")))));
    public static final Block BUG_OAK_BUTTON = registerBlock("bug_oak_button",
            new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_button")))));
    public static final Block BUG_OAK_PRESSURE_PLATE = registerBlock("bug_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_pressure_plate")))));
    public static final Block BUG_OAK_LEAVES = registerBlock("bug_oak_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_leaves")))));
    public static final Block BUG_OAK_STAIRS = registerBlock("bug_oak_stairs",
            new StairsBlock(ModBlocks.BUG_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_stairs")))));
    public static final Block BUG_OAK_SLAB = registerBlock("bug_oak_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_slab")))));
    public static final Block BUG_OAK_FENCE = registerBlock("bug_oak_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_fence")))));
    public static final Block BUG_OAK_FENCE_GATE = registerBlock("bug_oak_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_fence_gate")))));
    public static final Block BUG_OAK_DOOR = registerBlock("bug_oak_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_door")))));
    public static final Block BUG_OAK_TRAPDOOR = registerBlock("bug_oak_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_trapdoor")))));
    public static final Block BUG_OAK_WOOD = registerBlock("bug_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_wood")))));
    public static final Block STRIPPED_BUG_OAK_WOOD = registerBlock("stripped_bug_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "stripped_bug_oak_wood")))));
    public static final Block MYCENA_CHLOROPHOS = registerBlock("mycena_chlorophos",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "mycena_chlorophos")))));
    public static final Block POISON_VINE = registerBlock("poison_vine",
            new PoisonVineBlock(AbstractBlock.Settings.copy(Blocks.VINE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "poison_vine")))));

    public static final Block PATTERN_GLASS_FIELD_FLOWER = registerBlock("pattern_glass_field_flower",
            new TransparentBlock(AbstractBlock.Settings.copy(Blocks.GLASS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "pattern_glass_relaxing_melody")))));
    public static final Block PATTERN_GLASS_RELAXING_MELODY = registerBlock("pattern_glass_relaxing_melody",
            new TransparentBlock(AbstractBlock.Settings.copy(Blocks.GLASS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "pattern_glass_field_flower")))));
    public static final Block PATTERN_GLASS_SUNSHINE = registerBlock("pattern_glass_sunshine",
            new TransparentBlock(AbstractBlock.Settings.copy(Blocks.GLASS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "pattern_glass_sunshine")))));
    public static final Block PATTERN_GLASS_DARK_GOTHIC_SHADES = registerBlock("pattern_glass_dark_gothic_shades",
            new TransparentBlock(AbstractBlock.Settings.copy(Blocks.GLASS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "pattern_glass_dark_gothic_shades")))));

    // Potted Flowers
    public static final Block POTTED_BIOLLANTA = registerBlock("potted_biollanta",
            new FlowerPotBlock(BIOLLANTA, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "potted_biollanta")))));
    public static final Block POTTED_MYCENA_CHLOROPHOS = registerBlock("potted_mycena_chlorophos",
            new FlowerPotBlock(MYCENA_CHLOROPHOS, AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "potted_mycena_chlorophos")))));
    public static final Block POTTED_TERAPIA = registerBlock("potted_terapia",
            new FlowerPotBlock(TERAPIA, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "potted_terapia")))));

    protected static final Identifier BUG_OAK_SIGN_TEXTURE_ID = Identifier.of(CrawlingChaos.MOD_ID, "entity/signs/bug_oak");
    protected static final Identifier BUG_OAK_HANGING_SIGN_TEXTURE_ID = Identifier.of(CrawlingChaos.MOD_ID, "entity/signs/hanging/bug_oak");
    protected static final Identifier BUG_OAK_HANGING_SIGN_GUI_TEXTURE_ID = Identifier.of(CrawlingChaos.MOD_ID, "textures/gui/hanging_signs/bug_oak");

    public static final Block BUG_OAK_SIGN = registerBlock("bug_oak_sign",
            new TerraformSignBlock(BUG_OAK_SIGN_TEXTURE_ID, AbstractBlock.Settings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID,"bug_oak_sign")))));
    public static final Block BUG_OAK_WALL_SIGN = registerBlock("bug_oak_wall_sign",
            new TerraformWallSignBlock(BUG_OAK_SIGN_TEXTURE_ID, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID,"bug_oak_wall_sign")))));

    public static final Block BUG_OAK_HANGING_SIGN = registerBlock("bug_oak_hanging_sign",
            new TerraformHangingSignBlock(BUG_OAK_HANGING_SIGN_TEXTURE_ID, BUG_OAK_HANGING_SIGN_GUI_TEXTURE_ID, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.HANGING_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID,"bug_oak_hanging_sign")))));
    public static final Block BUG_OAK_WALL_HANGING_SIGN = registerBlock("bug_oak_wall_hanging_sign",
            new TerraformWallHangingSignBlock(BUG_OAK_HANGING_SIGN_TEXTURE_ID, BUG_OAK_HANGING_SIGN_GUI_TEXTURE_ID, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).sounds(BlockSoundGroup.HANGING_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID,"bug_oak_wall_hanging_sign")))));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, name), block);
    }

    private static void  registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CrawlingChaos.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        CrawlingChaos.LOGGER.info("Registering Mod Blocks for " + CrawlingChaos.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {

            // Don´t show mod items in Building Blocks
            //fabricItemGroupEntries.add(ModBlocks.BUG_OAK_LOG);
        });
    }
}