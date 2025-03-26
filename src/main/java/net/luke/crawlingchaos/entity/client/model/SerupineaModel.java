package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class SerupineaModel extends EntityModel<CommonRenderState> {
    private final ModelPart body;
    private final ModelPart bone2;
    private final ModelPart bone;

    public SerupineaModel(ModelPart modelPart) {
        super(modelPart);
        this.body = modelPart.getChild("body");

        this.bone2 = modelPart.getChild("bone2");
        this.bone = modelPart.getChild("bone");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 40).cuboid(-14.0F, -10.0F, -25.0F, 27.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 61).cuboid(-15.0F, -10.0F, -15.0F, 29.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(-1, 80).cuboid(-11.0F, -10.0F, -4.0F, 21.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(-1, 90).cuboid(-10.0F, -10.0F, 3.0F, 19.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(-1, 100).cuboid(-9.0F, -10.0F, 10.0F, 17.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(-1, 110).cuboid(-8.0F, -10.0F, 17.0F, 15.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(-1, 120).cuboid(-7.0F, -10.0F, 24.0F, 13.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(-1, 130).cuboid(-9.0F, -10.0F, 28.0F, 17.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 20).cuboid(-11.0F, -10.0F, -36.0F, 27.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 177).cuboid(-6.0F, -10.0F, -23.0F, 10.0F, 2.0F, 55.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bone2 = modelPartData.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 24.0F, -4.0F));

        ModelPartData bone2_r1 = bone2.addChild("bone2_r1", ModelPartBuilder.create().uv(140, 0).mirrored().cuboid(-5.0F, 10.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 0).mirrored().cuboid(-5.5F, 10.0F, -10.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 0).mirrored().cuboid(-5.5F, 11.0F, -20.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.0F, 7.0F, 0.0F, 0.0F, -2.138F));

        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 24.0F, -4.0F));

        ModelPartData bone_r1 = bone.addChild("bone_r1", ModelPartBuilder.create().uv(140, 0).cuboid(-9.0F, -15.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(140, 0).cuboid(-9.0F, -15.0F, -10.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(140, 0).cuboid(-10.0F, -16.0F, -20.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 7.0F, 0.0F, 0.0F, -0.8727F));
        return TexturedModelData.of(modelData, 256, 256);
    }
}
