package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SilverfishEntityModel;

public class ParasiteWormModel extends EntityModel<CommonRenderState> {
    private final ModelPart Head;
    private final ModelPart bone8;
    private final ModelPart bone9;
    private final ModelPart bone10;
    private final ModelPart bone11;
    private final ModelPart bone12;
    private final ModelPart bone15;
    private final ModelPart bone13;
    private final ModelPart bone14;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bone6;
    private final ModelPart bone7;

    public ParasiteWormModel(ModelPart modelPart) {
        super(modelPart);
        this.Head = modelPart.getChild("Head");
        this.bone8 = this.Head.getChild("bone8");
        this.bone9 = this.Head.getChild("bone9");
        this.bone10 = this.Head.getChild("bone10");
        this.bone11 = this.Head.getChild("bone11");
        this.bone12 = this.Head.getChild("bone12");
        this.bone15 = this.Head.getChild("bone15");
        this.bone13 = this.Head.getChild("bone13");
        this.bone14 = this.Head.getChild("bone14");
        this.bone2 = modelPart.getChild("bone2");
        this.bone3 = modelPart.getChild("bone3");
        this.bone4 = modelPart.getChild("bone4");
        this.bone5 = modelPart.getChild("bone5");
        this.bone6 = modelPart.getChild("bone6");
        this.bone7 = modelPart.getChild("bone7");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create().uv(206, 0).cuboid(-4.9444F, -8.8333F, -14.2222F, 9.0F, 9.0F, 16.0F, new Dilation(-0.8F)), ModelTransform.pivot(-0.0556F, -0.1667F, -18.7778F));

        ModelPartData bone8 = Head.addChild("bone8", ModelPartBuilder.create().uv(61, 30).cuboid(13.3564F, -2.0F, 3.134F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.9444F, -24.3333F, -14.2222F, 0.0F, 0.5236F, 1.5708F));
        ModelPartData bone9 = Head.addChild("bone9", ModelPartBuilder.create().uv(80, 30).cuboid(-0.5F, 11.1139F, -13.5506F, 2.0F, 1.0F, 7.0F, new Dilation(0.1F)), ModelTransform.of(-0.9444F, -24.3333F, -20.7222F, 0.6981F, 0.0F, 0.0F));
        ModelPartData bone10 = Head.addChild("bone10", ModelPartBuilder.create().uv(61, 30).cuboid(20.3564F, -2.0F, -16.866F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.9444F, -24.3333F, -14.2222F, 0.0F, -0.5236F, 1.5708F));
        ModelPartData bone11 = Head.addChild("bone11", ModelPartBuilder.create().uv(80, 30).cuboid(-0.5F, 18.3995F, 12.0186F, 2.0F, 1.0F, 7.0F, new Dilation(0.1F)), ModelTransform.of(-0.9444F, -24.3333F, -20.7222F, -0.6981F, 0.0F, 0.0F));
        ModelPartData bone12 = Head.addChild("bone12", ModelPartBuilder.create().uv(61, 30).cuboid(2.8264F, -22.0F, -3.9848F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.9444F, -24.3333F, -14.2222F, 0.0F, -0.1745F, 3.1416F));
        ModelPartData bone15 = Head.addChild("bone15", ModelPartBuilder.create().uv(80, 30).cuboid(19.5F, 2.5471F, -2.9044F, 2.0F, 1.0F, 7.0F, new Dilation(0.1F)), ModelTransform.of(-0.9444F, -24.3333F, -20.7222F, -0.2618F, 0.0F, 1.5708F));
        ModelPartData bone13 = Head.addChild("bone13", ModelPartBuilder.create().uv(61, 30).cuboid(1.2412F, -26.5F, -1.5956F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.5556F, -28.8333F, -14.2222F, 0.0F, -2.8798F, 3.1416F));
        ModelPartData bone14 = Head.addChild("bone14", ModelPartBuilder.create().uv(80, 30).cuboid(19.5F, -4.8412F, -2.9044F, 2.0F, 1.0F, 7.0F, new Dilation(0.1F)), ModelTransform.of(-0.9444F, -24.3333F, -20.7222F, 0.2618F, 0.0F, 1.5708F));
        ModelPartData bone2 = modelPartData.addChild("bone2", ModelPartBuilder.create().uv(157, 0).cuboid(-4.0F, -7.0521F, -8.3618F, 8.0F, 8.0F, 16.0F, new Dilation(-0.8F)), ModelTransform.of(0.0F, 1.4292F, -11.1055F, -0.3491F, 0.0F, 0.0F));
        ModelPartData bone3 = modelPartData.addChild("bone3", ModelPartBuilder.create().uv(108, 0).cuboid(-5.0F, 7.5622F, -18.4643F, 8.0F, 8.0F, 16.0F, new Dilation(-0.8F)), ModelTransform.of(0.0F, 12.106F, 15.5426F, -1.1345F, 0.0F, 0.0873F));
        ModelPartData bone4 = modelPartData.addChild("bone4", ModelPartBuilder.create().uv(65, 0).cuboid(-3.0F, -12.5357F, -0.5622F, 6.0F, 6.0F, 15.0F, new Dilation(-0.8F)), ModelTransform.of(0.0F, 24.0F, 0.0F, -0.4363F, 0.0F, -0.0873F));
        ModelPartData bone5 = modelPartData.addChild("bone5", ModelPartBuilder.create().uv(216, 27).cuboid(-3.0F, -3.0229F, -1.6228F, 6.0F, 5.0F, 14.0F, new Dilation(-0.8F)), ModelTransform.of(0.0F, 21.5F, 17.4F, -0.0873F, 0.0F, 0.0873F));
        ModelPartData bone6 = modelPartData.addChild("bone6", ModelPartBuilder.create().uv(181, 26).cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 12.0F, new Dilation(-0.8F)), ModelTransform.of(0.5F, 22.5F, 28.0F, 0.0F, 0.0F, -0.0873F));
        ModelPartData bone7 = modelPartData.addChild("bone7", ModelPartBuilder.create().uv(156, 26).cuboid(-1.0F, -2.0F, 38.0F, 3.0F, 3.0F, 9.0F, new Dilation(-0.8F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 256, 64);
    }
}
