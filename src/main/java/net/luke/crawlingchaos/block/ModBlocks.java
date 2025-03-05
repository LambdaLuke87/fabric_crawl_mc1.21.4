package net.luke.crawlingchaos.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.tree.ModSaplingGenerators;
import net.minecraft.block.*;
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
    public static final Block BUG_OAK_SIGN = registerBlock("bug_oak_sign",
            new SignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_sign")))));
    public static final Block BUG_OAK_WOOD = registerBlock("bug_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_wood")))));
    public static final Block STRIPPED_BUG_OAK_WOOD = registerBlock("stripped_bug_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "stripped_bug_oak_wood")))));

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