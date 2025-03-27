package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.model.ParasiteWormModel;
import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.luke.crawlingchaos.entity.custom.ParasiteWormEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ParasiteWormRenderer <T extends ParasiteWormEntity> extends MobEntityRenderer<T, CommonRenderState, ParasiteWormModel> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/parasite_worm/parasite_worm.png");

    public ParasiteWormRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.PARASITE_WORM);
    }

    public ParasiteWormRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context, new ParasiteWormModel(context.getPart(layer)), 0.8F);
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

    public void render(CommonRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(0.3f, 0.3f, 0.3f);
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }
}