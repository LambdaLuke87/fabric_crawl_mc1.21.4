package net.luke.crawlingchaos.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.luke.crawlingchaos.world.ModPlacedFeatures;
import net.luke.crawlingchaos.world.biome.ModBiomes;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BUG_FOREST), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ANCIENT_EXOSKELETON_STONE_PLACED_KEY);
    }
}
