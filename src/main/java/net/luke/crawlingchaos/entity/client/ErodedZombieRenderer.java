package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.model.ErodedZombieModel;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.state.ErodedZombieRenderState;
import net.luke.crawlingchaos.entity.custom.ErodedZombieEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ErodedZombieRenderer extends ZombieBaseEntityRenderer<ErodedZombieEntity, ErodedZombieRenderState, ErodedZombieModel<ErodedZombieRenderState>> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/eroded_zombie/eroded_zombie.png");

    public ErodedZombieRenderer(EntityRendererFactory.Context context) {
        this(context,
                ModEntityModelLayers.ERODED_ZOMBIE,
                ModEntityModelLayers.ERODED_ZOMBIE_BABY,
                ModEntityModelLayers.ERODED_ZOMBIE_INNER_ARMOR,
                ModEntityModelLayers.ERODED_ZOMBIE_OUTER_ARMOR,
                ModEntityModelLayers.ERODED_ZOMBIE_BABY_INNER_ARMOR,
                ModEntityModelLayers.ERODED_ZOMBIE_BABY_OUTER_ARMOR);
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
    public Identifier getTexture(ErodedZombieRenderState state) {
        return TEXTURE;
    }

    public void updateRenderState(ErodedZombieEntity erodedZombieEntity, ErodedZombieRenderState erodedZombieRenderState, float f) {
        super.updateRenderState(erodedZombieEntity, erodedZombieRenderState, f);
        erodedZombieRenderState.idleAnimationState.copyFrom(erodedZombieEntity.idleAnimationState);
        //erodedZombieRenderState.walkAnimationState.copyFrom(erodedZombieEntity.walkAnimationState);
        erodedZombieRenderState.attackAnimationState.copyFrom(erodedZombieEntity.attackAnimationState);
    }
}