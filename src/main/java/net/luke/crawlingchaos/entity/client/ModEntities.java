package net.luke.crawlingchaos.entity.client;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.custom.ErodedZombieEntity;
import net.luke.crawlingchaos.entity.custom.SkeletonFriendEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.rmi.server.Skeleton;

public class ModEntities {
    public static final EntityType<ErodedZombieEntity> ERODED_ZOMBIE =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"),
            EntityType.Builder.create(ErodedZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"))));

    public static final EntityType<SkeletonFriendEntity> SKELETON_FRIEND =  Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend"),
            EntityType.Builder.create(SkeletonFriendEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "skeleton_friend"))));

    public static void registerModEntities() {
        CrawlingChaos.LOGGER.info("Registering Mod Entities for " + CrawlingChaos.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ERODED_ZOMBIE, ErodedZombieEntity.createErodedZombieAttributes());
        FabricDefaultAttributeRegistry.register(SKELETON_FRIEND, SkeletonFriendEntity.createSkeletonFriendAttributes());
    }
}
