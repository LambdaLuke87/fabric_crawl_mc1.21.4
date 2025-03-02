package net.luke.crawlingchaos.entity.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.luke.crawlingchaos.entity.client.ErodedZombieAnimations;
import net.luke.crawlingchaos.entity.client.state.ErodedZombieRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;

@Environment(EnvType.CLIENT)
public class ErodedZombieModel<S extends ErodedZombieRenderState> extends BipedEntityModel<S> {

    public ErodedZombieModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData rightArm = root.addChild("rightArm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));
        ModelPartData leftArm = root.addChild("leftArm", ModelPartBuilder.create().uv(40, 33).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(16, 53).cuboid(0.5F, 6.5F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

        ModelPartData bone4_r1 = leftArm.addChild("bone4_r1", ModelPartBuilder.create().uv(1, 59).cuboid(-1.3F, -1.0F, -1.2F, 3.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(0.8F, 5.5F, 0.0F, 1.5708F, 0.0F, -1.5708F));

        ModelPartData leftLeg = root.addChild("leftLeg", ModelPartBuilder.create().uv(0, 32).mirrored().cuboid(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.9F, -12.0F, 0.0F));
        ModelPartData rightLeg = root.addChild("rightLeg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

        ModelPartData bone3 = rightLeg.addChild("bone3", ModelPartBuilder.create().uv(16, 59).cuboid(-2.0F, -1.5F, -2.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.1F, 7.5F, 2.0F, 0.0F, 0.0F, -0.3491F));
        ModelPartData bone4 = rightLeg.addChild("bone4", ModelPartBuilder.create().uv(1, 52).mirrored().cuboid(0.2F, -0.4F, -3.0F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.of(-4.1F, 7.5F, 2.0F, 0.0F, 0.0F, -1.7453F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(S erodedzombieRenderState) {
        super.setAngles(erodedzombieRenderState);
        float f = erodedzombieRenderState.handSwingProgress;
        CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, erodedzombieRenderState.attacking, f, erodedzombieRenderState.age);
    }
}
