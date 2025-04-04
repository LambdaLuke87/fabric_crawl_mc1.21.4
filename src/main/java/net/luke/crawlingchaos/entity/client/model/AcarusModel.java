package net.luke.crawlingchaos.entity.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SpiderEntityModel;

public class AcarusModel extends SpiderEntityModel {
    private static final String BODY0 = "body0";
    private static final String BODY1 = "body1";
    private static final String RIGHT_MIDDLE_FRONT_LEG = "right_middle_front_leg";
    private static final String LEFT_MIDDLE_FRONT_LEG = "left_middle_front_leg";
    private static final String RIGHT_MIDDLE_HIND_LEG = "right_middle_hind_leg";
    private static final String LEFT_MIDDLE_HIND_LEG = "left_middle_hind_leg";
    private final ModelPart head;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightMiddleLeg;
    private final ModelPart leftMiddleLeg;
    private final ModelPart rightMiddleFrontLeg;
    private final ModelPart leftMiddleFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;

    public AcarusModel(ModelPart modelPart) {
        super(modelPart);
        this.head = modelPart.getChild("head");
        this.rightHindLeg = modelPart.getChild("right_hind_leg");
        this.leftHindLeg = modelPart.getChild("left_hind_leg");
        this.rightMiddleLeg = modelPart.getChild("right_middle_hind_leg");
        this.leftMiddleLeg = modelPart.getChild("left_middle_hind_leg");
        this.rightMiddleFrontLeg = modelPart.getChild("right_middle_front_leg");
        this.leftMiddleFrontLeg = modelPart.getChild("left_middle_front_leg");
        this.rightFrontLeg = modelPart.getChild("right_front_leg");
        this.leftFrontLeg = modelPart.getChild("left_front_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(21, 38).cuboid(-3.0F, -2.8333F, -3.3F, 6.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(40, 41).cuboid(-2.0F, 0.1667F, -4.1F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(44, 41).cuboid(1.0F, 0.1667F, -4.1F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 16.8333F, -5.7F));

        modelPartData2.addChild("eye", ModelPartBuilder.create().uv(39, 37).cuboid(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -2.3333F, -2.8F));
        //ModelPartData close_eye = head.addChild("close_eye", ModelPartBuilder.create().uv(39, 33).cuboid(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.02F)), ModelTransform.origin(0.0F, -2.3333F, -2.8F));

        modelPartData.addChild("body0", ModelPartBuilder.create().uv(0, 37).cuboid(-4.0F, -3.5F, -2.0F, 8.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 16.5F, -4.0F));
        modelPartData.addChild("body1", ModelPartBuilder.create().uv(0, 0).cuboid(-5.5F, -4.5F, -6.5F, 11.0F, 9.0F, 13.0F, new Dilation(0.0F)), ModelTransform.origin(0.05F, 16.5F, 2.5F));

        modelPartData.addChild("right_hind_leg", ModelPartBuilder.create().uv(0, 33).mirrored().cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, 16.0F, 2.0F, 0.0F, 0.7854F, -0.6109F));
        modelPartData.addChild("left_hind_leg", ModelPartBuilder.create().uv(0, 29).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 16.0F, 2.0F, 0.0F, -0.7854F, 0.6109F));
        modelPartData.addChild("right_middle_hind_leg", ModelPartBuilder.create().uv(0, 33).mirrored().cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, 16.0F, 1.0F, 0.0F, 0.2618F, -0.4363F));
        modelPartData.addChild("left_middle_hind_leg", ModelPartBuilder.create().uv(0, 29).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 16.0F, 1.0F, 0.0F, -0.2618F, 0.4363F));
        modelPartData.addChild("right_middle_front_leg", ModelPartBuilder.create().uv(0, 33).mirrored().cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, 16.0F, 0.0F, 0.0F, -0.2618F, -0.4363F));
        modelPartData.addChild("left_middle_front_leg", ModelPartBuilder.create().uv(0, 29).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 16.0F, 0.0F, 0.0F, 0.2618F, 0.4363F));
        modelPartData.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 33).mirrored().cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, 16.0F, -1.0F, 0.0F, -0.7854F, -0.6109F));
        modelPartData.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 29).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 16.0F, -1.0F, 0.0F, 0.7854F, 0.6109F));
        return TexturedModelData.of(modelData, 80, 80);
    }
}
