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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.INSECT_WINGS))
                    .displayName(Text.translatable("pack.crawling")
                            .styled(style -> style.withColor(0x622DBD)))
                    .entries((displayContext, entries) -> {

                        // Normal Items
                        entries.add(ModItems.BUTTERFLY_WINGS);
                        entries.add(ModItems.CRYSTALS_OF_VIRUS);
                        entries.add(ModItems.INSECT_WINGS);
                        entries.add(ModItems.SMALL_CRYSTALS);
                        entries.add(ModItems.STORAGE_ORGAN);
                        entries.add(ModItems.VIRUS_BUDS);
                        entries.add(ModItems.VIRUS_SEEDS);
                        entries.add(ModItems.VIRUS_SPROUTS);

                        // Spawn Eggs
                        entries.add(ModItems.ERODED_ZOMBIE_SPAWN_EGG);
                        entries.add(ModItems.SKELETON_FRIEND_SPAWN_EGG);

                        // Blocks
                        entries.add(ModBlocks.BUG_OAK_LOG);
                        entries.add(ModBlocks.BUG_OAK_PLANKS);

                    }).build());

    public static void registerItemsGroups() {
        CrawlingChaos.LOGGER.info("Registering Item Groups for " + CrawlingChaos.MOD_ID);
    }
}
