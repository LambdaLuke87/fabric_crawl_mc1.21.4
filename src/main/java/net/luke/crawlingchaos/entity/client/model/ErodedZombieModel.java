package net.luke.crawlingchaos.entity.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.luke.crawlingchaos.entity.client.ErodedZombieAnimations;
import net.luke.crawlingchaos.entity.client.state.ErodedZombieRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.util.math.MathHelper;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class ErodedZombieModel<S extends ErodedZombieRenderState> extends ZombieEntityModel<S> {
    public static final ModelTransformer ERODED_ZOMBIE_BABY_TRANSFORMER =
            new BabyModelTransformer (true, 16.0F, 0.0F, 2.0F, 2.0F, 24.0F, Set.of("head"));

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public ErodedZombieModel(ModelPart modelPart) {
        super(modelPart);
        this.head = modelPart.getChild("head");
        this.body = modelPart.getChild("body");
        this.rightArm = modelPart.getChild("right_arm");
        this.leftArm = modelPart.getChild("left_arm");
        this.leftLeg = modelPart.getChild("right_leg");
        this.rightLeg = modelPart.getChild("left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData2.addChild("hat", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.NONE);
        modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        ModelPartData leftArm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(40, 33).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(16, 53).cuboid(0.5F, 6.5F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData bone4_r1 = leftArm.addChild("bone4_r1", ModelPartBuilder.create().uv(1, 59).cuboid(-1.3F, -1.0F, -1.2F, 3.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(0.8F, 5.5F, 0.0F, 1.5708F, 0.0F, -1.5708F));

        ModelPartData rightLeg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        ModelPartData leftLeg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

        ModelPartData bone3 = rightLeg.addChild("bone3", ModelPartBuilder.create().uv(16, 59).cuboid(-2.0F, -1.5F, -2.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.1F, 7.5F, 2.0F, 0.0F, 0.0F, -0.3491F));
        ModelPartData bone4 = rightLeg.addChild("bone4", ModelPartBuilder.create().uv(1, 52).mirrored().cuboid(0.2F, -0.4F, -3.0F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.of(-4.1F, 7.5F, 2.0F, 0.0F, 0.0F, -1.7453F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(S erodedzombieRenderState) {
        super.setAngles(erodedzombieRenderState);

        this.animate(erodedzombieRenderState.idleAnimationState, ErodedZombieAnimations.ANIM_ERODED_ZOMBIE_IDLE, erodedzombieRenderState.age, 1f);
        //this.animate(erodedzombieRenderState.walkAnimationState, ErodedZombieAnimations.ANIM_ERODED_ZOMBIE_WALK, erodedzombieRenderState.age, 1f);
        this.animate(erodedzombieRenderState.attackAnimationState, ErodedZombieAnimations.ANIM_ERODED_ZOMBIE_ATTACK, erodedzombieRenderState.age, 1f);

        float g = erodedzombieRenderState.limbFrequency;
        float h = erodedzombieRenderState.limbAmplitudeMultiplier;

        // Make Left Arm (worm hand) point down, so avoid having it up
        // DISCLAIMER: When he is chasing a victim, just by raising his right hand he seems to be making the National Socialist salute.
        // If you are offended by this, you are an idiot.
        this.leftArm.pitch = MathHelper.cos(g * 0.0F) * 0.0F * h * 0.0F / erodedzombieRenderState.limbAmplitudeInverse;
    }
}
