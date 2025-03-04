package net.luke.crawlingchaos.entity.client.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class CustomSkeletonGlowFeatureRenderer<M extends SkeletonEntityModel<SkeletonEntityRenderState>>
        extends EyesFeatureRenderer<SkeletonEntityRenderState, M> {

    private final RenderLayer eyes;

    public CustomSkeletonGlowFeatureRenderer(FeatureRendererContext<SkeletonEntityRenderState, M> featureRendererContext, String path) {
        super(featureRendererContext);
        eyes = RenderLayer.getEyes(Identifier.of(CrawlingChaos.MOD_ID, path));
    }

    @Override
    public RenderLayer getEyesTexture() {
        return eyes;
    }
}