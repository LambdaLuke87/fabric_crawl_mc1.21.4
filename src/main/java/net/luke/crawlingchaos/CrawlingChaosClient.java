package net.luke.crawlingchaos;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.luke.crawlingchaos.entity.client.ErodedZombieRenderer;
import net.luke.crawlingchaos.entity.client.SkeletonFriendRenderer;
import net.luke.crawlingchaos.entity.client.model.ErodedZombieModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class CrawlingChaosClient implements ClientModInitializer {
    private static final Dilation ARMOR_DILATION = new Dilation(1.0f);
    private static final Dilation HAT_DILATION = new Dilation(0.5f);
    TexturedModelData armorModelData = TexturedModelData.of(ArmorEntityModel.getModelData(ARMOR_DILATION), 64, 32);
    TexturedModelData hatModelData = TexturedModelData.of(ArmorEntityModel.getModelData(HAT_DILATION), 64, 32);

    @Override
    public void onInitializeClient() {
        ModEntityModelLayers.registerEntityModelLayers();
        EntityRendererRegistry.register(ModEntities.ERODED_ZOMBIE, ErodedZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKELETON_FRIEND, SkeletonFriendRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE, ErodedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_BABY, () -> TexturedModelData.of(ErodedZombieModel.getModelData(Dilation.NONE, 0f), 64, 64).transform(ErodedZombieModel.ERODED_ZOMBIE_BABY_TRANSFORMER));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_BABY_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_BABY_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SKELETON_FRIEND, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SKELETON_FRIEND_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SKELETON_FRIEND_OUTER_ARMOR, () -> armorModelData);

        RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"));
    }
}
