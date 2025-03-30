package net.luke.crawlingchaos.entity.client.feature;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.KnightBugModel;
import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

public class CustomKnightBugGlowFeatureRenderer <M extends KnightBugModel> extends EyesFeatureRenderer<CommonRenderState, M> {
    private static final RenderLayer GLOW_TEXTURE_PATH = RenderLayer.getEyes(Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/knight_bug/knight_bug_glow.png"));

    public CustomKnightBugGlowFeatureRenderer(FeatureRendererContext<CommonRenderState, M> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return GLOW_TEXTURE_PATH;
    }
}
