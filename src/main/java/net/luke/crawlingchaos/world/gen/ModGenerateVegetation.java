package net.luke.crawlingchaos.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.luke.crawlingchaos.world.ModPlacedFeatures;
import net.luke.crawlingchaos.world.biome.ModBiomes;
import net.minecraft.world.gen.GenerationStep;

public class ModGenerateVegetation {
    public static void generateBiollantas() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BUG_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIOLLANTA_PLACED_KEY);
    }
    public static void generateMycenas() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BUG_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MYCENA_CHLOROPHOS_PLACED_KEY);
    }
    public static void generateTerapias() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BUG_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TERAPIA_PLACED_KEY);
    }
}