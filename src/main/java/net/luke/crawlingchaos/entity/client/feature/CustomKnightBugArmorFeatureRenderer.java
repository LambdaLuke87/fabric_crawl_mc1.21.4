package net.luke.crawlingchaos.entity.client.feature;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.KnightBugModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.render.entity.feature.EnergySwirlOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class CustomKnightBugArmorFeatureRenderer extends EnergySwirlOverlayFeatureRenderer<CommonRenderState, KnightBugModel> {
    private static final Identifier SKIN = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/knight_bug/knight_bug_armor.png");
    private final KnightBugModel model;

    public CustomKnightBugArmorFeatureRenderer(FeatureRendererContext<CommonRenderState, KnightBugModel> context, LoadedEntityModels loader) {
        super(context);
        this.model = new KnightBugModel(loader.getModelPart(ModEntityModelLayers.KNIGHT_BUG_ARMOR));
    }

    protected boolean shouldRender(CommonRenderState commonRenderState) {
        return commonRenderState.renderOverlay;
    }

    protected float getEnergySwirlX(float partialAge) {
        return MathHelper.cos(partialAge * 0.02F) * 3.0F;
    }

    protected Identifier getEnergySwirlTexture() {
        return SKIN;
    }

    protected KnightBugModel getEnergySwirlModel() {
        return this.model;
    }
}
