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
    public static final Item BUTTERFLY_WINGS = registerItem("butterfly_wings", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "butterfly_wings")))));
    public static final Item CRYSTALS_OF_VIRUS = registerItem("crystals_of_virus", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "crystals_of_virus")))));
    public static final Item INSECT_WINGS = registerItem("insect_wings", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "insect_wings")))));
    public static final Item SMALL_CRYSTALS = registerItem("small_crystals", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "small_crystals")))));
    public static final Item STORAGE_ORGAN = registerItem("storage_organ", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "storage_organ")))));
    public static final Item VIRUS_BUDS = registerItem("virus_buds", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_buds")))));
    public static final Item VIRUS_SEEDS = registerItem("virus_seeds", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_seeds")))));
    public static final Item VIRUS_SPROUTS = registerItem("virus_sprouts", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "virus_sprouts")))));

    // SpawnEggs
    public static final Item ERODED_ZOMBIE_SPAWN_EGG = registerItem("eroded_zombie_spawn_egg", new SpawnEggItem(ModEntities.ERODED_ZOMBIE, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie_spawn_egg")))));
    public static final Item SKELETON_FRIEND_SPAWN_EGG = registerItem("skeleton_friend_spawn_egg", new SpawnEggItem(ModEntities.SKELETON_FRIEND, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend_spawn_egg")))));

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
