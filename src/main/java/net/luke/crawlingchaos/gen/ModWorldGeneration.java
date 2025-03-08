package net.luke.crawlingchaos.gen;

import net.luke.crawlingchaos.world.gen.ModGenerateVegetation;
import net.luke.crawlingchaos.world.gen.ModTreeGeneration;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModGenerateVegetation.generateBiollantas();
        ModGenerateVegetation.generateMycenas();
        ModGenerateVegetation.generateTerapias();
    }
}