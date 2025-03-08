package net.luke.crawlingchaos.world;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.world.treedecorator.LeavesPoisonVineTreeDecorator;
import net.minecraft.block.Blocks;
import net.minecraft.block.PropaguleBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BUG_OAK_KEY = registerKey("bug_oak");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIOLLANTA_KEY = registerKey("biollanta");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MYCENA_CHLOROPHOS_KEY = registerKey("mycena_chlorophos");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TERAPIA_KEY = registerKey("terapia");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, BUG_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BUG_OAK_LOG),
                new LargeOakTrunkPlacer(7, 8, 3),

                BlockStateProvider.of(ModBlocks.BUG_OAK_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),

                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(List.of(new LeavesPoisonVineTreeDecorator(0.125F),
                        new AttachedToLeavesTreeDecorator(0.14F, 1, 0,
                                new RandomizedIntBlockStateProvider(BlockStateProvider.of(Blocks.COBWEB),
                                        PropaguleBlock.AGE, UniformIntProvider.create(0, 4)), 2, List.of(Direction.DOWN)))).build());

        register(context, BIOLLANTA_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BIOLLANTA)),
                        List.of(Blocks.GRASS_BLOCK)));
        register(context, MYCENA_CHLOROPHOS_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MYCENA_CHLOROPHOS)),
                        List.of(Blocks.GRASS_BLOCK)));
        register(context, TERAPIA_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TERAPIA)),
                        List.of(Blocks.GRASS_BLOCK)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(CrawlingChaos.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}