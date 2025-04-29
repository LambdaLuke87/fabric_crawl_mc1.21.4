package net.luke.crawlingchaos.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModOreGeneration.generateOres();
        ModGenerateVegetation.generateBiollantas();
        ModGenerateVegetation.generateMycenas();
        ModGenerateVegetation.generateTerapias();
    }
}