package net.luke.crawlingchaos.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item WING_TEST = registerItem("wing_test", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "wing_test")))));

    // SpawnEggs
    public static final Item ERODED_ZOMBIE_SPAWN_EGG = registerItem("eroded_zombie_spawn_egg", new SpawnEggItem(ModEntities.ERODED_ZOMBIE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie_spawn_egg")))));

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
