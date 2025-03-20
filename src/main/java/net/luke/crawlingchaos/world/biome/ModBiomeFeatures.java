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
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
        addCaveMobs(builder);
        addMonsters(builder, 69, 1, 100, false);
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.ACARUS, 60, 1, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.ERODED_ZOMBIE, 30, 1, 2));
    }
}
