package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.feature.CustomAcarusGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.model.AcarusModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.custom.AcarusEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class AcarusRenderer <T extends AcarusEntity> extends MobEntityRenderer<T, LivingEntityRenderState, AcarusModel> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/acarus/acarus.png");

    public AcarusRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.ACACURS);
    }

    public AcarusRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context, new AcarusModel(context.getPart(layer)), 0.8F);
        this.addFeature(new CustomAcarusGlowFeatureRenderer<>(this));
    }

    protected float method_3919() {
        return 180.0F;
    }

    public void updateRenderState(T spiderEntity, LivingEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(spiderEntity, livingEntityRenderState, f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
