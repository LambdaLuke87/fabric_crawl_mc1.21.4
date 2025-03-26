package net.luke.crawlingchaos.world.biome;

import net.luke.crawlingchaos.entity.client.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomeFeatures extends DefaultBiomeFeatures {
    public ModBiomeFeatures() {
    }

    public static void addBugForestMobs(SpawnSettings.Builder builder) {
        addCaveMobs(builder);
        addMonsters(builder, 69, 1, 100, false);
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.PRISM_FROG, 15, 4, 4));

        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.ACARUS, 35, 1, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.SERUPINEA, 20, 1, 2));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.KNIGHT_BUG, 1, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.PARASITE_WORM, 15, 1, 3));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.ERODED_ZOMBIE, 30, 1, 2));
    }
}
