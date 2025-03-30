package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.feature.CustomAcarusGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.feature.CustomKnightBugArmorFeatureRenderer;
import net.luke.crawlingchaos.entity.client.feature.CustomKnightBugGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.model.KnightBugModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.luke.crawlingchaos.entity.custom.KnightBugEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class KnightBugRenderer <T extends KnightBugEntity> extends MobEntityRenderer<T, CommonRenderState, KnightBugModel> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/knight_bug/knight_bug.png");

    public KnightBugRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.KNIGHT_BUG);
        this.addFeature(new CustomKnightBugArmorFeatureRenderer(this, context.getEntityModels()));
    }

    public KnightBugRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context, new KnightBugModel(context.getPart(layer)), 0.8F);
        this.addFeature(new CustomKnightBugGlowFeatureRenderer<>(this));
    }

    public void updateRenderState(T knightbugEntity, CommonRenderState commonRenderState, float f) {
        super.updateRenderState(knightbugEntity, commonRenderState, f);
        commonRenderState.renderOverlay = knightbugEntity.shouldRenderOverlay();
    }

    @Override
    public CommonRenderState createRenderState() {
        return new CommonRenderState();
    }

    @Override
    public Identifier getTexture(CommonRenderState state) {
        return TEXTURE;
    }
}
