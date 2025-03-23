package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.feature.CustomAcarusGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.model.AcarusModel;
import net.luke.crawlingchaos.entity.client.model.HelenaModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.custom.HelenaEntity;
import net.minecraft.client.render.entity.BatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.BatEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.Identifier;

public class HelenaRenderer extends MobEntityRenderer<HelenaEntity, BatEntityRenderState, HelenaModel>{
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/helena/helena.png");

    public HelenaRenderer(EntityRendererFactory.Context context) {
        super(context, new HelenaModel(context.getPart(ModEntityModelLayers.HELENA)), 0.25F);
    }

    @Override
    public BatEntityRenderState createRenderState() {
        return new BatEntityRenderState();
    }

    @Override
    public Identifier getTexture(BatEntityRenderState state) {
        return TEXTURE;
    }

    public void updateRenderState(HelenaEntity helenaEntity, BatEntityRenderState batEntityRenderState, float f) {
        super.updateRenderState(helenaEntity, batEntityRenderState, f);
        batEntityRenderState.roosting = helenaEntity.isRoosting();
    }
}
