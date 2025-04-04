package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class KnightBugModel extends EntityModel<CommonRenderState> {
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart tail;
    private final ModelPart legs2;
    private final ModelPart bone2;
    private final ModelPart legs6;
    private final ModelPart bone5;
    private final ModelPart legs3;
    private final ModelPart bone;
    private final ModelPart legs7;
    private final ModelPart bone6;
    private final ModelPart legs5;
    private final ModelPart bone3;
    private final ModelPart legs4;
    private final ModelPart bone4;

    public KnightBugModel(ModelPart modelPart) {
        super(modelPart);
        this.body = modelPart.getChild("body");

        this.head = this.body.getChild("head");

        this.tail = this.body.getChild("tail");
        this.legs2 = modelPart.getChild("legs2");
        this.bone2 = this.legs2.getChild("bone2");
        this.legs6 = modelPart.getChild("legs6");
        this.bone5 = this.legs6.getChild("bone5");
        this.legs3 = modelPart.getChild("legs3");
        this.bone = this.legs3.getChild("bone");
        this.legs7 = modelPart.getChild("legs7");
        this.bone6 = this.legs7.getChild("bone6");
        this.legs5 = modelPart.getChild("legs5");
        this.bone3 = this.legs5.getChild("bone3");
        this.legs4 = modelPart.getChild("legs4");
        this.bone4 = this.legs4.getChild("bone4");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 66).mirrored().cuboid(-10.0F, -28.0F, -35.0F, 24.0F, 13.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(-2.0F, 24.0F, 22.0F));

        body.addChild("body_r1", ModelPartBuilder.create().uv(0, 97).cuboid(-10.0F, -20.5F, -23.0F, 24.0F, 16.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -16.0F, -17.0F, 0.6109F, 0.0F, 0.0F));
        body.addChild("body_r2", ModelPartBuilder.create().uv(0, 33).cuboid(-10.0F, -33.5F, -32.763F, 24.0F, 16.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, 6.0F, -0.2182F, 0.0F, 0.0F));
        body.addChild("body_r3", ModelPartBuilder.create().uv(1, 12).cuboid(-8.0F, -0.7F, -8.0F, 17.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -10.5F, -1.0F, -0.1745F, 0.0F, 0.0F));
        body.addChild("body_r4", ModelPartBuilder.create().uv(83, 47).cuboid(-12.0F, -4.0F, -12.0F, 24.0F, 8.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -12.0F, -25.0F, 0.0873F, 0.0F, 0.0F));
        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.origin(1.5F, -12.2642F, -47.1915F));
        head.addChild("body_r5", ModelPartBuilder.create().uv(178, 98).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.0F, -10.5F, 0.7418F, 0.0F, 0.0F));
        head.addChild("body_r6", ModelPartBuilder.create().uv(152, 96).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, -6.0F, 0.6981F, 0.0F, 0.0F));
        head.addChild("body_r7", ModelPartBuilder.create().uv(152, 110).cuboid(-5.5F, -4.0F, -5.0F, 11.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.0F));
        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.origin(0.0F, -5.0F, 6.0F));
        tail.addChild("body_r8", ModelPartBuilder.create().uv(86, 80).cuboid(-8.5F, -4.55F, -4.0F, 17.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, -8.95F, 0.25F, -0.3491F, 0.0F, 0.0F));
        tail.addChild("body_r9", ModelPartBuilder.create().uv(81, 100).cuboid(-8.5F, -5.5F, -8.5F, 17.0F, 11.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, -13.0F, -11.5F, -0.3491F, 0.0F, 0.0F));

        ModelPartData legs2 = modelPartData.addChild("legs2", ModelPartBuilder.create(), ModelTransform.origin(12.4333F, 7.8859F, -0.6069F));
        ModelPartData bone2 = legs2.addChild("bone2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.4712F, 0.0F));
        bone2.addChild("legs2_r1", ModelPartBuilder.create().uv(110, 20).cuboid(-0.1669F, -39.597F, -8.5095F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-18.5854F, 15.1141F, 19.3782F, 0.49F, 0.1925F, 1.2264F));
        bone2.addChild("legs2_r2", ModelPartBuilder.create().uv(70, 21).cuboid(23.5638F, -17.0F, -10.0095F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(39.5638F, 0.0F, -8.0095F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-18.5854F, 15.1141F, 19.3782F, 0.0F, 0.5236F, 0.0F));
        ModelPartData legs6 = modelPartData.addChild("legs6", ModelPartBuilder.create(), ModelTransform.of(-11.5667F, 7.8859F, 0.3931F, 0.0F, 3.1416F, 0.0F));
        ModelPartData bone5 = legs6.addChild("bone5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.4712F, 0.0F));
        bone5.addChild("legs3_r1", ModelPartBuilder.create().uv(110, 20).cuboid(-0.1669F, -39.597F, -8.5095F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-18.5854F, 15.1141F, 19.3782F, 0.49F, 0.1925F, 1.2264F));
        bone5.addChild("legs3_r2", ModelPartBuilder.create().uv(70, 21).cuboid(23.5638F, -17.0F, -10.0095F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(39.5638F, 0.0F, -8.0095F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-18.5854F, 15.1141F, 19.3782F, 0.0F, 0.5236F, 0.0F));
        ModelPartData legs3 = modelPartData.addChild("legs3", ModelPartBuilder.create(), ModelTransform.origin(12.8698F, 6.8859F, 10.1652F));
        ModelPartData bone = legs3.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.1694F, 0.0F));
        bone.addChild("legs3_r3", ModelPartBuilder.create().uv(110, 20).cuboid(2.3296F, -45.6242F, -10.5665F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-25.1245F, 16.1141F, 26.2536F, 0.49F, 0.1925F, 1.2264F));
        bone.addChild("legs3_r4", ModelPartBuilder.create().uv(0, 0).cuboid(46.0876F, 0.0F, -10.0665F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(70, 21).cuboid(30.0876F, -17.0F, -12.0665F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-25.1245F, 16.1141F, 26.2536F, 0.0F, 0.5236F, 0.0F));
        ModelPartData legs7 = modelPartData.addChild("legs7", ModelPartBuilder.create(), ModelTransform.of(-13.1302F, 6.8859F, 13.1652F, 0.0F, -1.789F, 0.0F));
        ModelPartData bone6 = legs7.addChild("bone6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.1694F, 0.0F));
        bone6.addChild("legs4_r1", ModelPartBuilder.create().uv(110, 20).cuboid(2.3296F, -45.6242F, -10.5665F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-25.1245F, 16.1141F, 26.2536F, 0.49F, 0.1925F, 1.2264F));
        bone6.addChild("legs4_r2", ModelPartBuilder.create().uv(0, 0).cuboid(46.0876F, 0.0F, -10.0665F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(70, 21).cuboid(30.0876F, -17.0F, -12.0665F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-25.1245F, 16.1141F, 26.2536F, 0.0F, 0.5236F, 0.0F));
        ModelPartData legs5 = modelPartData.addChild("legs5", ModelPartBuilder.create(), ModelTransform.origin(6.0F, 22.0F, 24.0F));
        ModelPartData bone3 = legs5.addChild("bone3", ModelPartBuilder.create().uv(190, 46).cuboid(-2.3697F, -5.1375F, -4.8878F, 6.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(6.2524F, -14.8625F, -36.9949F, 0.0F, 0.3491F, 0.0F));
        bone3.addChild("legs5_r1", ModelPartBuilder.create().uv(200, 6).cuboid(0.0F, -2.0F, -3.0968F, 15.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.7476F, -0.1375F, -0.0051F, 0.0F, 0.0436F, -0.3491F));
        bone3.addChild("legs5_r2", ModelPartBuilder.create().uv(151, 6).cuboid(-9.9582F, -0.7719F, -1.5889F, 19.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(19.2057F, 8.1344F, -0.4162F, 0.0436F, 0.0F, 1.309F));
        bone3.addChild("legs5_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -0.5F, -1.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(22.7476F, 17.3625F, -0.0051F, 0.0F, 0.0436F, 0.0F));
        ModelPartData legs4 = modelPartData.addChild("legs4", ModelPartBuilder.create(), ModelTransform.of(20.0F, 22.0F, -31.0F, 3.0771F, 0.828F, 3.094F));
        ModelPartData bone4 = legs4.addChild("bone4", ModelPartBuilder.create().uv(190, 46).cuboid(-2.3697F, -4.6375F, -4.8878F, 6.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(6.2524F, -14.8625F, -36.9949F, 0.0F, 0.3491F, 0.0F));
        bone4.addChild("legs6_r1", ModelPartBuilder.create().uv(200, 6).cuboid(0.0F, -2.0F, -3.0968F, 15.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.7476F, -0.1375F, -0.0051F, 0.0F, 0.0436F, -0.3491F));
        bone4.addChild("legs6_r2", ModelPartBuilder.create().uv(151, 6).cuboid(-9.9582F, -0.7719F, -1.5889F, 19.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(19.2057F, 8.1344F, -0.4162F, 0.0436F, 0.0F, 1.309F));
        bone4.addChild("legs6_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -0.5F, -1.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(22.7476F, 17.3625F, -0.0051F, 0.0F, 0.0436F, 0.0F));

        return TexturedModelData.of(modelData, 256, 128);
    }

    @Override
    public void setAngles(CommonRenderState commonState) {
        super.setAngles(commonState);

        this.head.yaw = commonState.relativeHeadYaw * ((float)Math.PI / 180F);
        this.head.pitch = commonState.pitch * ((float)Math.PI / 180F);

        float f = commonState.limbSwingAnimationProgress * 0.6662F;
        float g = commonState.limbSwingAmplitude;
        float h = -(MathHelper.cos(f * 2.0F + 0.0F) * 0.4F) * g;
        //float i = -(MathHelper.cos(f * 2.0F + (float)Math.PI) * 0.4F) * g;
        //float j = -(MathHelper.cos(f * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * g;
        float k = -(MathHelper.cos(f * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * g;
        float l = Math.abs(MathHelper.sin(f + 0.0F) * 0.4F) * g;
        //float m = Math.abs(MathHelper.sin(f + (float)Math.PI) * 0.4F) * g;
        //float n = Math.abs(MathHelper.sin(f + ((float)Math.PI / 2F)) * 0.4F) * g;
        float o = Math.abs(MathHelper.sin(f + ((float)Math.PI * 1.5F)) * 0.4F) * g;

        ModelPart var10000 = this.legs7;
        var10000.yaw += h;
        var10000 = this.legs6;
        var10000.yaw -= h;
        //var10000 = this.legs5;
        //var10000.yaw += i;
        //var10000 = this.legs4;
        //var10000.yaw -= i;
        var10000 = this.legs3;
        var10000.yaw += k;
        var10000 = this.legs2;
        var10000.yaw -= k;
        var10000 = this.legs7;
        var10000.roll += l;
        var10000 = this.legs6;
        var10000.roll -= l;
        //var10000 = this.legs5;
        //var10000.roll += m;
        //var10000 = this.legs4;
        //var10000.roll -= m;
        var10000 = this.legs3;
        var10000.roll += o;
        var10000 = this.legs2;
        var10000.roll -= o;
    }
}
