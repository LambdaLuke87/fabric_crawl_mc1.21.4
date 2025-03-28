package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.CarrierBugModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.luke.crawlingchaos.entity.custom.CarrierBugEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CarrierBugRenderer <T extends CarrierBugEntity> extends MobEntityRenderer<T, CommonRenderState, CarrierBugModel> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/carrier_bug/carrier_bug.png");

    public CarrierBugRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.CARRIER_BUG);
    }

    public CarrierBugRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context, new CarrierBugModel(context.getPart(layer)), 0.8F);
    }

    public void updateRenderState(T spiderEntity, CommonRenderState commonRenderState, float f) {
        super.updateRenderState(spiderEntity, commonRenderState, f);
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