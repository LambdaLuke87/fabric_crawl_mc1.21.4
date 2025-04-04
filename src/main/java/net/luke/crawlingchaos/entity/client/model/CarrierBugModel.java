package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class CarrierBugModel extends EntityModel<CommonRenderState> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart bone6;
    private final ModelPart bone9;
    private final ModelPart bone7;
    private final ModelPart bone8;
    private final ModelPart bone10;
    private final ModelPart legr1;
    private final ModelPart bone4;
    private final ModelPart bone11;
    private final ModelPart legr2;
    private final ModelPart bone3;
    private final ModelPart bone12;
    private final ModelPart legr3;
    private final ModelPart bone14;
    private final ModelPart bone15;
    private final ModelPart legl1;
    private final ModelPart bone17;
    private final ModelPart bone18;
    private final ModelPart legl2;
    private final ModelPart bone20;
    private final ModelPart bone21;
    private final ModelPart legl3;
    private final ModelPart bone23;
    private final ModelPart bone24;

    public CarrierBugModel(ModelPart modelPart) {
        super(modelPart);
        this.head = modelPart.getChild("head");
        this.body = modelPart.getChild("body");
        this.bone6 = this.body.getChild("bone6");
        this.bone9 = this.bone6.getChild("bone9");
        this.bone7 = this.body.getChild("bone7");
        this.bone8 = this.bone7.getChild("bone8");
        this.bone10 = this.body.getChild("bone10");
        this.legr1 = modelPart.getChild("legr1");
        this.bone4 = this.legr1.getChild("bone4");
        this.bone11 = this.bone4.getChild("bone11");
        this.legr2 = modelPart.getChild("legr2");
        this.bone3 = this.legr2.getChild("bone3");
        this.bone12 = this.bone3.getChild("bone12");
        this.legr3 = modelPart.getChild("legr3");
        this.bone14 = this.legr3.getChild("bone14");
        this.bone15 = this.bone14.getChild("bone15");
        this.legl1 = modelPart.getChild("legl1");
        this.bone17 = this.legl1.getChild("bone17");
        this.bone18 = this.bone17.getChild("bone18");
        this.legl2 = modelPart.getChild("legl2");
        this.bone20 = this.legl2.getChild("bone20");
        this.bone21 = this.bone20.getChild("bone21");
        this.legl3 = modelPart.getChild("legl3");
        this.bone23 = this.legl3.getChild("bone23");
        this.bone24 = this.bone23.getChild("bone24");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 20).cuboid(-3.0F, -3.0F, -5.1667F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(15, 30).cuboid(1.0F, 0.0F, -7.1667F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(15, 30).cuboid(-2.0F, 0.0F, -7.1667F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 20.0F, -2.8333F));
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(20, 46).cuboid(-5.0F, -8.0F, -3.0F, 10.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-3.0F, -7.0F, 8.0F, 6.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, 0.0F));
        ModelPartData bone6 = body.addChild("bone6", ModelPartBuilder.create().uv(25, 14).mirrored().cuboid(-8.2207F, 1.25F, -3.2075F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, -5.25F, 0.75F, 0.0F, -0.6109F, 0.0F));
        bone6.addChild("bone9", ModelPartBuilder.create().uv(43, 21).cuboid(2.4575F, 5.5F, -2.2207F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-6.5F, -4.25F, -0.25F, 0.0F, 1.5708F, 0.0F));
        ModelPartData bone7 = body.addChild("bone7", ModelPartBuilder.create().uv(25, 21).cuboid(2.2207F, 1.25F, -3.2075F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -5.25F, 0.75F, 0.0F, 0.6109F, 0.0F));
        bone7.addChild("bone8", ModelPartBuilder.create().uv(43, 14).cuboid(2.4575F, 5.5F, 1.2207F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, -4.25F, -0.25F, 0.0F, 1.5708F, 0.0F));
        body.addChild("bone10", ModelPartBuilder.create().uv(32, 25).cuboid(-4.0F, -24.0F, -1.0F, 8.0F, 11.0F, 8.0F, new Dilation(0.0F))
                .uv(1, 50).cuboid(-2.0F, -15.0F, 1.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 35).cuboid(3.0F, -23.0F, 1.0F, 2.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 35).cuboid(-5.0F, -23.0F, 1.0F, 2.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(14, 35).cuboid(-2.0F, -23.0F, -2.0F, 4.0F, 8.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 35).cuboid(-2.0F, -23.0F, 6.0F, 4.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));
        ModelPartData legr1 = modelPartData.addChild("legr1", ModelPartBuilder.create(), ModelTransform.origin(-4.0F, 19.5F, 1.5F));
        ModelPartData bone4 = legr1.addChild("bone4", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.7725F, 4.0652F, -3.5111F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -6.0F, 0.0F, -0.2618F, -0.4363F, 0.6981F));
        bone4.addChild("bone11", ModelPartBuilder.create().uv(30, 6).cuboid(-17.9915F, -0.3102F, -4.0111F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -0.5F, 0.5F, 0.0F, 0.0F, -1.9199F));
        ModelPartData legr2 = modelPartData.addChild("legr2", ModelPartBuilder.create(), ModelTransform.origin(-4.0F, 18.5F, 2.5F));
        ModelPartData bone3 = legr2.addChild("bone3", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-5.8965F, 2.5658F, -3.9103F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -5.0F, 2.0F, 0.1745F, 0.0873F, 0.6981F));
        bone3.addChild("bone12", ModelPartBuilder.create().uv(30, 6).cuboid(-17.2241F, 1.9654F, -4.4103F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -0.5F, 0.5F, 0.0F, 0.0F, -1.9199F));
        ModelPartData legr3 = modelPartData.addChild("legr3", ModelPartBuilder.create(), ModelTransform.origin(-4.0F, 18.5F, 8.5F));
        ModelPartData bone14 = legr3.addChild("bone14", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-8.6322F, 0.0637F, -1.4092F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -1.0F, -2.0F, 0.2618F, 0.0873F, 0.6981F));
        bone14.addChild("bone15", ModelPartBuilder.create().uv(30, 6).cuboid(-17.2241F, 1.9654F, -4.4103F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-12.7357F, -3.0021F, 3.0011F, 0.0F, 0.0F, -1.9199F));
        ModelPartData legl1 = modelPartData.addChild("legl1", ModelPartBuilder.create(), ModelTransform.origin(4.0F, 19.5F, 1.5F));
        ModelPartData bone17 = legl1.addChild("bone17", ModelPartBuilder.create().uv(0, 6).mirrored().cuboid(-10.3343F, 0.1F, -1.8821F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, -1.0F, -2.0F, 0.4363F, -2.618F, -0.7854F));
        bone17.addChild("bone18", ModelPartBuilder.create().uv(30, 6).cuboid(-17.9915F, -0.3102F, -4.0111F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-12.5619F, -4.5967F, 2.129F, 0.0F, 0.0F, -1.9199F));
        ModelPartData legl2 = modelPartData.addChild("legl2", ModelPartBuilder.create(), ModelTransform.origin(4.0F, 19.5F, 2.5F));
        ModelPartData bone20 = legl2.addChild("bone20", ModelPartBuilder.create().uv(0, 6).mirrored().cuboid(-10.3343F, -0.3F, -1.8821F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, 0.0F, -1.0F, -0.1745F, 3.1416F, -0.7854F));
        bone20.addChild("bone21", ModelPartBuilder.create().uv(30, 6).cuboid(-17.9915F, -0.3102F, -4.0111F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-12.5619F, -4.5967F, 2.129F, 0.0F, 0.0F, -1.9199F));
        ModelPartData legl3 = modelPartData.addChild("legl3", ModelPartBuilder.create(), ModelTransform.origin(4.0F, 18.5F, 6.5F));
        ModelPartData bone23 = legl3.addChild("bone23", ModelPartBuilder.create().uv(0, 6).mirrored().cuboid(-10.3343F, -0.3F, -1.8821F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, 1.0F, -1.0F, -0.2618F, 3.0543F, -0.7854F));
        bone23.addChild("bone24", ModelPartBuilder.create().uv(30, 0).cuboid(-17.9915F, -0.3103F, -4.0111F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-12.5619F, -4.5967F, 2.129F, 0.0F, 0.0F, -1.9199F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(CommonRenderState commonState) {
        super.setAngles(commonState);

        this.head.yaw = commonState.relativeHeadYaw * ((float)Math.PI / 180F);
        this.head.pitch = commonState.pitch * ((float)Math.PI / 180F);

        float f = commonState.limbSwingAnimationProgress * 0.6662F;
        float g = commonState.limbSwingAmplitude;
        float h = -(MathHelper.cos(f * 2.0F + 0.0F) * 0.4F) * g;
        float i = -(MathHelper.cos(f * 2.0F + (float)Math.PI) * 0.4F) * g;
        float k = -(MathHelper.cos(f * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * g;
        float l = Math.abs(MathHelper.sin(f + 0.0F) * 0.4F) * g;
        float m = Math.abs(MathHelper.sin(f + (float)Math.PI) * 0.4F) * g;
        float o = Math.abs(MathHelper.sin(f + ((float)Math.PI * 1.5F)) * 0.4F) * g;

        ModelPart var10000 = this.legr1;
        var10000.yaw += h;
        var10000 = this.legl1;
        var10000.yaw -= h;
        var10000 = this.legr2;
        var10000.yaw += i;
        var10000 = this.legl2;
        var10000.yaw -= i;
        var10000 = this.legr3;
        var10000.yaw += k;
        var10000 = this.legl3;
        var10000.yaw -= k;
        var10000 = this.legr1;
        var10000.roll += l;
        var10000 = this.legl1;
        var10000.roll -= l;
        var10000 = this.legr2;
        var10000.roll += m;
        var10000 = this.legl2;
        var10000.roll -= m;
        var10000 = this.legr3;
        var10000.roll += o;
        var10000 = this.legl3;
        var10000.roll -= o;
    }
}
