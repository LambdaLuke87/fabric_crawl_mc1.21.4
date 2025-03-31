package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.custom.ErodedZombieSpitEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.LlamaSpitEntityModel;
import net.minecraft.client.render.entity.state.LlamaSpitEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class ErodedZombieSpitRenderer extends EntityRenderer<ErodedZombieSpitEntity, LlamaSpitEntityRenderState> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/eroded_zombie/spit.png");
    private final LlamaSpitEntityModel model;

    public ErodedZombieSpitRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new LlamaSpitEntityModel(context.getPart(ModEntityModelLayers.ERODED_ZOMBIE_SPIT));
    }

    public void render(LlamaSpitEntityRenderState llamaSpitEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0F, 0.15F, 0.0F);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(llamaSpitEntityRenderState.yaw - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(llamaSpitEntityRenderState.pitch));
        this.model.setAngles(llamaSpitEntityRenderState);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(llamaSpitEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    public LlamaSpitEntityRenderState createRenderState() {
        return new LlamaSpitEntityRenderState();
    }

    public void updateRenderState(ErodedZombieSpitEntity erodedzombieSpitEntity, LlamaSpitEntityRenderState llamaSpitEntityRenderState, float f) {
        super.updateRenderState(erodedzombieSpitEntity, llamaSpitEntityRenderState, f);
        llamaSpitEntityRenderState.pitch = erodedzombieSpitEntity.getLerpedPitch(f);
        llamaSpitEntityRenderState.yaw = erodedzombieSpitEntity.getLerpedYaw(f);
    }
}