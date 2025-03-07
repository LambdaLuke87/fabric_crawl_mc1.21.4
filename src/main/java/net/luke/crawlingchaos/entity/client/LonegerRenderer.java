package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.custom.LonegerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.VillagerHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.render.entity.state.ItemHolderEntityRenderState;
import net.minecraft.client.render.entity.state.VillagerEntityRenderState;
import net.minecraft.util.Identifier;

public class LonegerRenderer extends MobEntityRenderer<LonegerEntity, VillagerEntityRenderState, VillagerResemblingModel>
{
    public LonegerRenderer(EntityRendererFactory.Context context) {
        super(context, new VillagerResemblingModel(context.getPart(EntityModelLayers.VILLAGER)), 0.5F);
        this.addFeature(new HeadFeatureRenderer<>(this, context.getEntityModels()));
        this.addFeature(new VillagerHeldItemFeatureRenderer<>(this));
    }

    public Identifier getTexture(VillagerEntityRenderState villagerEntityRenderState) {
        return Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/loneger.png");
    }

    @Override
    public VillagerEntityRenderState createRenderState() {
        return new VillagerEntityRenderState();
    }

    public void updateRenderState(LonegerEntity lonegerEntity, VillagerEntityRenderState villagerEntityRenderState, float f) {
        super.updateRenderState(lonegerEntity, villagerEntityRenderState, f);
        ItemHolderEntityRenderState.update(lonegerEntity, villagerEntityRenderState, this.itemModelResolver);
        villagerEntityRenderState.headRolling = lonegerEntity.getHeadRollingTimeLeft() > 0;
    }
}