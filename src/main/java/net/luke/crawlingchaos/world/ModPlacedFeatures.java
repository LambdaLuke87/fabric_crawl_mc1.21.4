package net.luke.crawlingchaos.world;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BUG_OAK_PLACED_KEY = registerKey("bug_oak_placed");
    public static final RegistryKey<PlacedFeature> BIOLLANTA_PLACED_KEY = registerKey("biollanta_placed");
    public static final RegistryKey<PlacedFeature> MYCENA_CHLOROPHOS_PLACED_KEY = registerKey("mycena_chlorophos_placed");
    public static final RegistryKey<PlacedFeature> TERAPIA_PLACED_KEY = registerKey("terapia_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BUG_OAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BUG_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.BUG_OAK_SAPLING));

        register(context, BIOLLANTA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIOLLANTA_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, MYCENA_CHLOROPHOS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MYCENA_CHLOROPHOS_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, TERAPIA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TERAPIA_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(CrawlingChaos.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}