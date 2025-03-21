package net.luke.crawlingchaos.util;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_SERUPINEA_TOOL = CreateTag("incorrect_for_serupinea_tool");

        private static TagKey<Block> CreateTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(CrawlingChaos.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SERUPINEA_TOOL_MATERIALS = CreateTag("serupinea_tool_materials");
        public static final TagKey<Item> KNIGHT_TOOL_MATERIALS = CreateTag("knight_tool_materials");
        public static final TagKey<Item> REPAIRS_SERUPINEA_ARMOR = CreateTag("repairs_serupinea_armor");
        public static final TagKey<Item> REPAIRS_KNIGHT_ARMOR = CreateTag("repairs_knight_armor");

        private static TagKey<Item> CreateTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, name));
        }
    }
}
