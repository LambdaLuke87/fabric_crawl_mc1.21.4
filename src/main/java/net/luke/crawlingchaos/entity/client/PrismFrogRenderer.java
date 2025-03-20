package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FrogEntityRenderer;
import net.minecraft.client.render.entity.state.FrogEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PrismFrogRenderer extends FrogEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/prism_frog/red_frog.png");

    public PrismFrogRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(FrogEntityRenderState state) {
        return TEXTURE;
    }

    public void render(FrogEntityRenderState frogEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(2f, 2f, 2f);
        super.render(frogEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }
}