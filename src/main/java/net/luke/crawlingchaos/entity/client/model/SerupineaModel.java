package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class SerupineaModel extends EntityModel<CommonRenderState> {
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart head_top;
    private final ModelPart head_mid;
    private final ModelPart head_end;
    private final ModelPart legs_r;
    private final ModelPart legs_l;

    public SerupineaModel(ModelPart modelPart) {
        super(modelPart);
        this.body = modelPart.getChild("body");
        this.head = this.body.getChild("head");
        this.head_top = this.head.getChild("head_top");
        this.head_mid = this.head.getChild("head_mid");
        this.head_end = this.head.getChild("head_end");
        this.legs_r = modelPart.getChild("legs_r");
        this.legs_l = modelPart.getChild("legs_l");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 90).cuboid(-10.0F, -11.0F, 2.0F, 19.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 80).cuboid(-11.0F, -11.0F, -4.0F, 21.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 100).cuboid(-8.5F, -11.0F, 8.0F, 16.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 110).cuboid(-8.0F, -11.0F, 20.0F, 15.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 110).cuboid(-8.0F, -11.0F, 14.0F, 15.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 120).cuboid(-7.0F, -11.0F, 31.0F, 13.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 120).cuboid(-7.0F, -11.0F, 26.0F, 13.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(-1, 130).cuboid(-9.0F, -10.0F, 35.0F, 17.0F, 0.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 178).cuboid(-7.0F, -10.5F, -23.0F, 11.0F, 2.0F, 54.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 20.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 0.0F, 0.0F));
        head.addChild("head_top", ModelPartBuilder.create().uv(160, 125).cuboid(-6.875F, -0.45F, -0.5625F, 13.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 130).cuboid(-5.875F, -0.45F, -1.5625F, 11.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 20).cuboid(-9.875F, -0.25F, -6.5625F, 19.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(160, 110).cuboid(-8.875F, -0.45F, 1.4375F, 17.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(160, 120).cuboid(-7.875F, -0.45F, 0.4375F, 15.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 140).cuboid(-3.875F, -0.45F, -3.5625F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 145).cuboid(-2.875F, -0.45F, -4.5625F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 150).cuboid(-1.875F, -0.45F, -5.5625F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 155).cuboid(-0.875F, -0.45F, -6.5625F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 135).cuboid(-4.875F, -0.45F, -2.5625F, 9.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 100).cuboid(-9.875F, -0.45F, 3.4375F, 19.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.125F, -10.55F, -29.4375F, 0.0698F, 0.0F, 0.0F));
        head.addChild("head_mid", ModelPartBuilder.create().uv(0, 40).cuboid(-13.5F, -0.3857F, -5.2857F, 27.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(160, 190).cuboid(-13.5F, -0.5857F, 1.7143F, 27.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(160, 180).cuboid(-13.5F, -0.5857F, 3.7143F, 27.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(160, 175).cuboid(-12.5F, -0.5857F, -0.2857F, 25.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(160, 170).cuboid(-11.5F, -0.5857F, -2.2857F, 23.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(160, 165).cuboid(-10.5F, -0.5857F, -4.2857F, 21.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(160, 160).cuboid(-9.5F, -0.5857F, -5.2857F, 19.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -10.4143F, -19.7143F, 0.0698F, 0.0F, 0.0F));
        head.addChild("head_end", ModelPartBuilder.create().uv(0, 60).cuboid(-14.6F, -0.56F, -8.5F, 29.0F, 0.0F, 11.0F, new Dilation(0.0F))
                .uv(160, 220).cuboid(12.4F, -0.56F, 1.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(171, 220).cuboid(-9.6F, -0.66F, 1.5F, 20.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(220, 220).cuboid(-14.6F, -0.56F, 1.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(160, 200).cuboid(-14.6F, -0.66F, -6.5F, 29.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-0.4F, -10.44F, -5.5F, 0.0698F, 0.0F, 0.0F));

        ModelPartData legs_r = modelPartData.addChild("legs_r", ModelPartBuilder.create(), ModelTransform.origin(-3.0F, 19.0F, -6.0F));
        legs_r.addChild("bone2_r1", ModelPartBuilder.create().uv(140, 0).mirrored().cuboid(-5.5F, 10.0F, -10.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 0).mirrored().cuboid(-5.0F, 10.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(110, 0).mirrored().cuboid(-5.5F, 11.0F, -20.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.0F, 7.0F, 0.0F, 0.0F, -2.138F));
        legs_r.addChild("bone7_r1", ModelPartBuilder.create().uv(139, 61).mirrored().cuboid(3.5F, 0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(139, 61).mirrored().cuboid(3.5F, 0.5F, -11.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(139, 61).mirrored().cuboid(3.5F, 0.5F, -21.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(21.0F, -0.5F, 8.0F, 0.0F, 0.0F, 1.2217F));
        legs_r.addChild("bone6_r1", ModelPartBuilder.create().uv(140, 55).mirrored().cuboid(-1.5F, -0.5F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 55).mirrored().cuboid(-1.5F, -0.5F, -10.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 55).mirrored().cuboid(-1.5F, -0.5F, -20.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(20.0F, -2.5F, 7.0F, 0.0F, 0.0F, 1.2217F));
        legs_r.addChild("bone5_r1", ModelPartBuilder.create().uv(140, 10).mirrored().cuboid(-3.0F, -0.5F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 10).mirrored().cuboid(-3.0F, -0.5F, -10.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 10).mirrored().cuboid(-3.0F, -0.5F, -20.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(17.0F, -2.5F, 7.0F, 0.0F, 0.0F, 2.618F));
        ModelPartData legs_l = modelPartData.addChild("legs_l", ModelPartBuilder.create(), ModelTransform.origin(5.0F, 19.0F, -4.0F));
        legs_l.addChild("bone8_r1", ModelPartBuilder.create().uv(139, 61).mirrored().cuboid(3.5F, 0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(139, 61).mirrored().cuboid(3.5F, 0.5F, -10.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-27.0F, 8.5F, 7.0F, 0.0F, 0.0F, -1.2217F));
        legs_l.addChild("bone7_r2", ModelPartBuilder.create().uv(140, 55).mirrored().cuboid(-1.5F, -0.5F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 55).mirrored().cuboid(-1.5F, -0.5F, -10.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-22.0F, -2.5F, 7.0F, 0.0F, 0.0F, 1.9199F));
        legs_l.addChild("bone6_r2", ModelPartBuilder.create().uv(140, 10).mirrored().cuboid(-3.0F, -0.5F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(140, 10).mirrored().cuboid(-3.0F, -0.5F, -10.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-20.0F, -2.5F, 7.0F, 0.0F, 0.0F, 0.48F));
        legs_l.addChild("bone6_r3", ModelPartBuilder.create().uv(139, 61).mirrored().cuboid(3.5F, 0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-29.0F, 8.5F, -12.0F, 0.0F, 0.0F, -1.2217F));
        legs_l.addChild("bone5_r2", ModelPartBuilder.create().uv(140, 55).mirrored().cuboid(-1.5F, -0.5F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-24.0F, -2.5F, -12.0F, 0.0F, 0.0F, 1.9199F));
        legs_l.addChild("bone4_r1", ModelPartBuilder.create().uv(140, 10).mirrored().cuboid(-3.0F, -0.5F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-22.0F, -2.5F, -12.0F, 0.0F, 0.0F, 0.48F));
        legs_l.addChild("bone_r1", ModelPartBuilder.create().uv(140, 0).cuboid(-9.0F, -15.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(140, 0).cuboid(-9.0F, -15.0F, -10.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(140, 0).cuboid(-10.0F, -16.0F, -20.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 7.0F, 0.0F, 0.0F, -0.8727F));

        return TexturedModelData.of(modelData, 256, 256);
    }
}
