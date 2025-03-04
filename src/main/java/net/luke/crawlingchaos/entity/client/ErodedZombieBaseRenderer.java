package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class ErodedZombieBaseRenderer<T extends ZombieEntity, S extends ZombieEntityRenderState, M extends ZombieEntityModel<S>> extends BipedEntityRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/eroded_zombie/eroded_zombie.png");

    protected ErodedZombieBaseRenderer(EntityRendererFactory.Context context, M mainModel) {
        super(context, mainModel, 0.5F);
        //this.addFeature(new ArmorFeatureRenderer(this, armorInnerModel, armorOuterModel, context.getEquipmentRenderer()));
    }

    @Override
    public S createRenderState() {
        return null;
    }

    public void updateRenderState(T zombieEntity, S zombieEntityRenderState, float f) {
        super.updateRenderState(zombieEntity, zombieEntityRenderState, f);
        zombieEntityRenderState.attacking = zombieEntity.isAttacking();
        zombieEntityRenderState.convertingInWater = zombieEntity.isConvertingInWater();
    }

    @Override
    public Identifier getTexture(S state) {
        return TEXTURE;
    }

    protected boolean isShaking(S zombieEntityRenderState) {
        return super.isShaking(zombieEntityRenderState) || zombieEntityRenderState.convertingInWater;
    }
}