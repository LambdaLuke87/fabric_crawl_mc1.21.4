package net.luke.crawlingchaos.entity.client.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class CustomAcarusGlowFeatureRenderer<M extends SpiderEntityModel> extends EyesFeatureRenderer<LivingEntityRenderState, M> {
    private static final RenderLayer GLOW_TEXTURE_PATH = RenderLayer.getEyes(Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/acarus/acarus_glow.png"));

    public CustomAcarusGlowFeatureRenderer(FeatureRendererContext<LivingEntityRenderState, M> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return GLOW_TEXTURE_PATH;
    }
}