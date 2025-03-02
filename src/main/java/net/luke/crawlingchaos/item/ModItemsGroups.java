package net.luke.crawlingchaos.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {
    public static final ItemGroup CRAWLINGCHAOS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrawlingChaos.MOD_ID, "crawling_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WING_TEST))
                    .displayName(Text.translatable("pack.crawling")
                            .styled(style -> style.withColor(0x106050)))
                    .entries((displayContext, entries) -> {

                        // Normal Items
                        entries.add(ModItems.WING_TEST);
                        entries.add(ModItems.ERODED_ZOMBIE_SPAWN_EGG);

                    }).build());

    public static void registerItemsGroups() {
        CrawlingChaos.LOGGER.info("Registering Item Groups for " + CrawlingChaos.MOD_ID);
    }
}
