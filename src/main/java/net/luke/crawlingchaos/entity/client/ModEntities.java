package net.luke.crawlingchaos.entity.client;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.custom.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

public class ModEntities {
    public static final EntityType<AcarusEntity> ACARUS =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "acarus"),
            EntityType.Builder.create(AcarusEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "acarus"))));

    public static final EntityType<ErodedZombieEntity> ERODED_ZOMBIE =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"),
            EntityType.Builder.create(ErodedZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"))));

    public static final EntityType<LonegerEntity> LONEGER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "loneger"),
            EntityType.Builder.create(LonegerEntity::new, SpawnGroup.MISC)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "loneger"))));

    public static final EntityType<PrismFrogEntity> PRISM_FROG =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "prism_frog"),
            EntityType.Builder.create(PrismFrogEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "prism_frog"))));

    public static final EntityType<SkeletonFriendEntity> SKELETON_FRIEND =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend"),
            EntityType.Builder.create(SkeletonFriendEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend"))));

    public static void registerModEntities() {
        CrawlingChaos.LOGGER.info("Registering Mod Entities for " + CrawlingChaos.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ACARUS, SpiderEntity.createSpiderAttributes());
        FabricDefaultAttributeRegistry.register(ERODED_ZOMBIE, ErodedZombieEntity.createErodedZombieAttributes());
        FabricDefaultAttributeRegistry.register(LONEGER, LonegerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(PRISM_FROG, FrogEntity.createFrogAttributes());
        FabricDefaultAttributeRegistry.register(SKELETON_FRIEND, SkeletonFriendEntity.createSkeletonFriendAttributes());
    }

    public static void addMobsToBiome() {
        Predicate<BiomeSelectionContext> forest = BiomeSelectors.tag(ConventionalBiomeTags.IS_FOREST);
        Predicate<BiomeSelectionContext> jungle = BiomeSelectors.tag(ConventionalBiomeTags.IS_JUNGLE);
        Predicate<BiomeSelectionContext> plains = BiomeSelectors.tag(ConventionalBiomeTags.IS_PLAINS);
        Predicate<BiomeSelectionContext> swamp = BiomeSelectors.tag(ConventionalBiomeTags.IS_SWAMP);

        BiomeModifications.addSpawn(swamp, SpawnGroup.MONSTER, ERODED_ZOMBIE, 18, 1, 2);
        BiomeModifications.addSpawn(forest, SpawnGroup.MONSTER, ERODED_ZOMBIE, 15, 1, 2);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, ERODED_ZOMBIE, 10, 1, 2);
        BiomeModifications.addSpawn(plains, SpawnGroup.MONSTER, ERODED_ZOMBIE, 5, 1, 2);
    }
}
