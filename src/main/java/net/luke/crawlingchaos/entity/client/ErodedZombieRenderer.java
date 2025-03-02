package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.ErodedZombieModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.state.ErodedZombieRenderState;
import net.luke.crawlingchaos.entity.custom.ErodedZombieEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.util.Identifier;

public class ErodedZombieRenderer extends BipedEntityRenderer<ErodedZombieEntity, ErodedZombieRenderState, ErodedZombieModel<ErodedZombieRenderState>> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/eroded_zombie/eroded_zombie.png");

    public ErodedZombieRenderer(EntityRendererFactory.Context context) {
        this(context, ModEntityModelLayers.ERODED_ZOMBIE, ModEntityModelLayers.ERODED_ZOMBIE_BABY, ModEntityModelLayers.ERODED_ZOMBIE_INNER_ARMOR, ModEntityModelLayers.ERODED_ZOMBIE_OUTER_ARMOR, ModEntityModelLayers.ERODED_ZOMBIE_BABY_INNER_ARMOR, ModEntityModelLayers.ERODED_ZOMBIE_BABY_OUTER_ARMOR);
    }

    public ErodedZombieRenderer(EntityRendererFactory.Context context, EntityModelLayer body, EntityModelLayer baby, EntityModelLayer innerArmor, EntityModelLayer outerArmor, EntityModelLayer babyInnerArmor, EntityModelLayer babyOuterArmor) {
        super(context,
                new ErodedZombieModel<>(context.getPart(body)),
                new ErodedZombieModel<>(context.getPart(baby)),
                new ErodedZombieModel<>(context.getPart(innerArmor)),
                new ErodedZombieModel<>(context.getPart(outerArmor)),
                new ErodedZombieModel<>(context.getPart(babyInnerArmor)),
                new ErodedZombieModel<>(context.getPart(babyOuterArmor)));
    }

    @Override
    public ErodedZombieRenderState createRenderState() {
        return new ErodedZombieRenderState();
    }

    @Override
    public Identifier getTexture(ErodedZombieRenderState erodedzombieRenderState) {
        return TEXTURE;
    }

    /*@Override
    public void render(ErodedZombieRenderState erodedzombieRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(erodedzombieRenderState.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(erodedzombieRenderState, matrixStack, vertexConsumerProvider, i);
    }
    public void updateRenderState(ErodedZombieEntity erodedZombieEntity, ErodedZombieRenderState erodedZombieRenderState, float f) {
        super.updateRenderState(erodedZombieEntity, erodedZombieRenderState, f);
        erodedZombieRenderState.idleAnimationState.copyFrom(erodedZombieEntity.idleAnimationState);
        erodedZombieRenderState.attackAnimationState.copyFrom(erodedZombieEntity.attackAnimationState);
    }*/
}