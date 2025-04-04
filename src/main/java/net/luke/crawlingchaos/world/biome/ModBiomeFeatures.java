package net.luke.crawlingchaos.world.biome;

import net.luke.crawlingchaos.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomeFeatures extends DefaultBiomeFeatures {
    public ModBiomeFeatures() {
    }

    public static void addBugForestMobs(SpawnSettings.Builder builder) {
        addCaveMobs(builder);
        builder.spawn(SpawnGroup.CREATURE, 15, new SpawnSettings.SpawnEntry(ModEntities.PRISM_FROG, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, 5, new SpawnSettings.SpawnEntry(ModEntities.HELENA, 3, 4));

        // add vanilla monsters
        builder.spawn(SpawnGroup.MONSTER, 69, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, 1, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, 100, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 4, 4));

        // add mod monsters
        builder.spawn(SpawnGroup.MONSTER, 25, new SpawnSettings.SpawnEntry(ModEntities.ACARUS,1, 4));
        builder.spawn(SpawnGroup.MONSTER, 20, new SpawnSettings.SpawnEntry(ModEntities.CARRIER_BUG,1, 1));
        builder.spawn(SpawnGroup.MONSTER, 12, new SpawnSettings.SpawnEntry(ModEntities.SERUPINEA, 1, 2));
        builder.spawn(SpawnGroup.MONSTER, 1, new SpawnSettings.SpawnEntry(ModEntities.KNIGHT_BUG, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, 15, new SpawnSettings.SpawnEntry(ModEntities.PARASITE_WORM, 1, 3));
        builder.spawn(SpawnGroup.MONSTER, 30 ,new SpawnSettings.SpawnEntry(ModEntities.ERODED_ZOMBIE, 1, 2));
    }
}
