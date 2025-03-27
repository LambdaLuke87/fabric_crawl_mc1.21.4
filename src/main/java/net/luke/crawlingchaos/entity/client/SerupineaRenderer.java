package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.model.SerupineaModel;
import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.luke.crawlingchaos.entity.custom.SerupineaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SerupineaRenderer <T extends SerupineaEntity> extends MobEntityRenderer<T, CommonRenderState, SerupineaModel> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/serupinea/serupinea.png");

    public SerupineaRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.SERUPINEA);
    }

    public SerupineaRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context, new SerupineaModel(context.getPart(layer)), 0.8F);
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
        matrixStack.scale(0.4f, 0.4f, 0.4f);
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }
}
