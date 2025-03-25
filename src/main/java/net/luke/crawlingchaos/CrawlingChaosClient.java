package net.luke.crawlingchaos;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.entity.client.*;
import net.luke.crawlingchaos.entity.client.model.AcarusModel;
import net.luke.crawlingchaos.entity.client.model.ErodedZombieModel;
import net.luke.crawlingchaos.entity.client.model.HelenaModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.item.ModItems;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
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
        TerraformBoatClientHelper.registerModelLayers(ModItems.BUG_OAK_BOATS_ID);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIOLLANTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BIOLLANTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TERAPIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_TERAPIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUG_OAK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUG_OAK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUG_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYCENA_CHLOROPHOS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_MYCENA_CHLOROPHOS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POISON_VINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PATTERN_GLASS_FIELD_FLOWER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PATTERN_GLASS_RELAXING_MELODY, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PATTERN_GLASS_SUNSHINE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PATTERN_GLASS_DARK_GOTHIC_SHADES, RenderLayer.getTranslucent());

        ModEntityModelLayers.registerEntityModelLayers();
        EntityRendererRegistry.register(ModEntities.ACARUS, AcarusRenderer::new);
        EntityRendererRegistry.register(ModEntities.ERODED_ZOMBIE, ErodedZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.HELENA, HelenaRenderer::new);
        EntityRendererRegistry.register(ModEntities.LONEGER, LonegerRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRISM_FROG, PrismFrogRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKELETON_FRIEND, SkeletonFriendRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ACACURS, AcarusModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE, () -> TexturedModelData.of(ErodedZombieModel.getTexturedModelData(), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_BABY, () -> TexturedModelData.of(ErodedZombieModel.getTexturedModelData(), 64, 64).transform(ErodedZombieModel.ERODED_ZOMBIE_BABY_TRANSFORMER));
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_BABY_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ERODED_ZOMBIE_BABY_OUTER_ARMOR, () -> armorModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.HELENA, HelenaModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SKELETON_FRIEND, SkeletonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SKELETON_FRIEND_INNER_ARMOR, () -> hatModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SKELETON_FRIEND_OUTER_ARMOR, () -> armorModelData);

        RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "acarus"));
        RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"));
        //RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "loneger"));
    }
}
