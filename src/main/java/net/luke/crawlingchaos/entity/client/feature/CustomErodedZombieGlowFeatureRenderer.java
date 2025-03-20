package net.luke.crawlingchaos.entity.client.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.ErodedZombieModel;
import net.luke.crawlingchaos.entity.client.state.ErodedZombieRenderState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class CustomErodedZombieGlowFeatureRenderer<M extends ErodedZombieModel<ErodedZombieRenderState>>
        extends EyesFeatureRenderer<ErodedZombieRenderState, M> {

    private final RenderLayer eyes;

    public CustomErodedZombieGlowFeatureRenderer(FeatureRendererContext<ErodedZombieRenderState, M> featureRendererContext, String path) {
        super(featureRendererContext);
        eyes = RenderLayer.getEyes(Identifier.of(CrawlingChaos.MOD_ID, path));
    }

    @Override
    public RenderLayer getEyesTexture() {
        return eyes;
    }
}