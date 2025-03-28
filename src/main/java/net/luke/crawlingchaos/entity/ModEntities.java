package net.luke.crawlingchaos.entity;

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
                    .dimensions(1.4F, 0.9F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "acarus"))));

    public static final EntityType<CarrierBugEntity> CARRIER_BUG =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "carrier_bug"),
            EntityType.Builder.create(CarrierBugEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.4F, 0.9F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "carrier_bug"))));

    public static final EntityType<ErodedZombieEntity> ERODED_ZOMBIE =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"),
            EntityType.Builder.create(ErodedZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"))));

    public static final EntityType<HelenaEntity> HELENA =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "helena"),
            EntityType.Builder.create(HelenaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.4F, 0.4F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "helena"))));

    public static final EntityType<KnightBugEntity> KNIGHT_BUG =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "knight_bug"),
            EntityType.Builder.create(KnightBugEntity::new, SpawnGroup.MONSTER)
                    .dimensions(2.0F, 2.0F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "knight_bug"))));

    public static final EntityType<LonegerEntity> LONEGER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "loneger"),
            EntityType.Builder.create(LonegerEntity::new, SpawnGroup.MISC)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "loneger"))));

    public static final EntityType<ParasiteWormEntity> PARASITE_WORM =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "parasite_worm"),
            EntityType.Builder.create(ParasiteWormEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8F, 0.9F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "parasite_worm"))));

    public static final EntityType<PrismFrogEntity> PRISM_FROG =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "prism_frog"),
            EntityType.Builder.create(PrismFrogEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.0F, 1.0F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "prism_frog"))));

    public static final EntityType<SerupineaEntity> SERUPINEA =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "serupinea"),
            EntityType.Builder.create(SerupineaEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.4F, 0.9F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "serupinea"))));

    public static final EntityType<SkeletonFriendEntity> SKELETON_FRIEND =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend"),
            EntityType.Builder.create(SkeletonFriendEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend"))));

    public static void registerModEntities() {
        CrawlingChaos.LOGGER.info("Registering Mod Entities for " + CrawlingChaos.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ACARUS, SpiderEntity.createSpiderAttributes());
        FabricDefaultAttributeRegistry.register(CARRIER_BUG, CarrierBugEntity.createCarrierBugAttributes());
        FabricDefaultAttributeRegistry.register(ERODED_ZOMBIE, ErodedZombieEntity.createErodedZombieAttributes());
        FabricDefaultAttributeRegistry.register(HELENA, HelenaEntity.createHelenaAttributes());
        FabricDefaultAttributeRegistry.register(KNIGHT_BUG, KnightBugEntity.createKnightBugAttributes());
        FabricDefaultAttributeRegistry.register(LONEGER, LonegerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(PARASITE_WORM, ParasiteWormEntity.createParasiteWormAttributes());
        FabricDefaultAttributeRegistry.register(PRISM_FROG, FrogEntity.createFrogAttributes());
        FabricDefaultAttributeRegistry.register(SERUPINEA, SerupineaEntity.createSerupineaBugAttributes());
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

        BiomeModifications.addSpawn(swamp, SpawnGroup.MONSTER, PARASITE_WORM, 10, 1, 4);
        BiomeModifications.addSpawn(forest, SpawnGroup.MONSTER, PARASITE_WORM, 8, 1, 2);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, PARASITE_WORM, 5, 1, 3);
        BiomeModifications.addSpawn(plains, SpawnGroup.MONSTER, PARASITE_WORM, 5, 1, 2);

        BiomeModifications.addSpawn(swamp, SpawnGroup.MONSTER, SERUPINEA, 10, 1, 1);
        BiomeModifications.addSpawn(forest, SpawnGroup.MONSTER, SERUPINEA, 8, 1, 1);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, SERUPINEA, 5, 1, 1);
        BiomeModifications.addSpawn(plains, SpawnGroup.MONSTER, SERUPINEA, 5, 1, 1);
    }
}
