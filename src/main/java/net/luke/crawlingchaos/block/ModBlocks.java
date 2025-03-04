package net.luke.crawlingchaos.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
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
    public static final Block BUG_OAK_LOG = registerBlock("bug_oak_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(0.25F)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_log")))
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block BUG_OAK_PLANKS = registerBlock("bug_oak_planks",
            new Block(AbstractBlock.Settings.create().strength(0.25F)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_planks")))
                    .sounds(BlockSoundGroup.WOOD)));

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