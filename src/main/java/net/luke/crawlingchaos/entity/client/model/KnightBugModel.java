package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class KnightBugModel extends EntityModel<CommonRenderState> {
    private final ModelPart body;
    private final ModelPart legs1;
    private final ModelPart legs2;
    private final ModelPart legs3;
    private final ModelPart legs4;
    private final ModelPart legs5;
    private final ModelPart legs6;

    public KnightBugModel(ModelPart modelPart) {
        super(modelPart);
        this.body = modelPart.getChild("body");

        this.legs1 = modelPart.getChild("legs1");
        this.legs2 = modelPart.getChild("legs2");
        this.legs3 = modelPart.getChild("legs3");
        this.legs4 = modelPart.getChild("legs4");
        this.legs5 = modelPart.getChild("legs5");
        this.legs6 = modelPart.getChild("legs6");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(85, 49).cuboid(-10.0F, -17.0F, -30.0F, 24.0F, 8.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 24.0F, -23.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(152, 96).cuboid(-1.5F, -13.2642F, 1.8085F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 98).cuboid(-10.0F, -17.2642F, -23.1915F, 24.0F, 14.0F, 15.0F, new Dilation(0.0F))
                .uv(152, 110).cuboid(-4.0F, -14.2642F, -8.1915F, 11.0F, 8.0F, 10.0F, new Dilation(0.0F))
                .uv(178, 97).cuboid(0.5F, -11.2642F, 7.8085F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

        ModelPartData body_r2 = body.addChild("body_r2", ModelPartBuilder.create().uv(88, 100).cuboid(-10.0F, -40.5F, 20.6603F, 17.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.618F, 0.0F, -3.1416F));

        ModelPartData body_r3 = body.addChild("body_r3", ModelPartBuilder.create().uv(84, 80).cuboid(-10.0F, -40.0F, 28.6602F, 17.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.618F, 0.0F, 3.1416F));

        ModelPartData body_r4 = body.addChild("body_r4", ModelPartBuilder.create().uv(0, 34).cuboid(-10.0F, -32.1644F, -32.763F, 24.0F, 14.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        ModelPartData body_r5 = body.addChild("body_r5", ModelPartBuilder.create().uv(0, 67).mirrored().cuboid(-14.0F, -28.0F, 9.0F, 24.0F, 13.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData legs1 = modelPartData.addChild("legs1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 4.0F));

        ModelPartData legs1_r1 = legs1.addChild("legs1_r1", ModelPartBuilder.create().uv(70, 21).cuboid(24.0F, -17.0F, -20.0F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(40.0F, 0.0F, -18.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0F, 0.5236F, 0.0F));

        ModelPartData legs1_r2 = legs1.addChild("legs1_r2", ModelPartBuilder.create().uv(110, 20).cuboid(0.0F, -40.0F, -18.5F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.49F, 0.1925F, 1.2264F));

        ModelPartData legs2 = modelPartData.addChild("legs2", ModelPartBuilder.create(), ModelTransform.of(-9.0F, 24.0F, 8.0F, 0.0F, -0.48F, 0.0F));

        ModelPartData legs2_r1 = legs2.addChild("legs2_r1", ModelPartBuilder.create().uv(70, 21).cuboid(23.5638F, -17.0F, -10.0095F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(39.5638F, 0.0F, -8.0095F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

        ModelPartData legs2_r2 = legs2.addChild("legs2_r2", ModelPartBuilder.create().uv(110, 20).cuboid(-0.1669F, -39.597F, -8.5095F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.49F, 0.1925F, 1.2264F));

        ModelPartData legs3 = modelPartData.addChild("legs3", ModelPartBuilder.create(), ModelTransform.of(-17.0F, 24.0F, -3.0F, 0.0F, -1.1781F, 0.0F));

        ModelPartData legs3_r1 = legs3.addChild("legs3_r1", ModelPartBuilder.create().uv(70, 21).cuboid(30.0876F, -17.0F, -12.0665F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(46.0876F, 0.0F, -10.0665F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

        ModelPartData legs3_r2 = legs3.addChild("legs3_r2", ModelPartBuilder.create().uv(110, 20).cuboid(2.3296F, -45.6242F, -10.5665F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.49F, 0.1925F, 1.2264F));

        ModelPartData legs4 = modelPartData.addChild("legs4", ModelPartBuilder.create(), ModelTransform.of(6.0F, 24.0F, -27.0F, -3.1416F, 0.0436F, 3.1416F));

        ModelPartData legs4_r1 = legs4.addChild("legs4_r1", ModelPartBuilder.create().uv(70, 21).cuboid(28.6175F, -17.0F, -28.8701F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(44.6175F, 0.0F, -26.8701F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

        ModelPartData legs4_r2 = legs4.addChild("legs4_r2", ModelPartBuilder.create().uv(110, 20).cuboid(1.767F, -44.266F, -27.3701F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.49F, 0.1925F, 1.2264F));

        ModelPartData legs5 = modelPartData.addChild("legs5", ModelPartBuilder.create(), ModelTransform.of(19.0F, 24.0F, -28.0F, -3.1416F, 0.5236F, 3.1416F));

        ModelPartData legs5_r1 = legs5.addChild("legs5_r1", ModelPartBuilder.create().uv(70, 21).cuboid(24.0F, -17.0F, -30.0F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(40.0F, 0.0F, -28.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

        ModelPartData legs5_r2 = legs5.addChild("legs5_r2", ModelPartBuilder.create().uv(110, 20).cuboid(0.0F, -40.0F, -28.5F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.49F, 0.1925F, 1.2264F));

        ModelPartData legs6 = modelPartData.addChild("legs6", ModelPartBuilder.create(), ModelTransform.of(21.0F, 24.0F, -23.0F, -3.1416F, 1.0472F, 3.1416F));

        ModelPartData legs6_r1 = legs6.addChild("legs6_r1", ModelPartBuilder.create().uv(70, 21).cuboid(19.0F, -17.0F, -28.6602F, 13.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(35.0F, 0.0F, -26.6602F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

        ModelPartData legs6_r2 = legs6.addChild("legs6_r2", ModelPartBuilder.create().uv(110, 20).cuboid(-1.9134F, -35.3806F, -27.1602F, 16.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.49F, 0.1925F, 1.2264F));
        return TexturedModelData.of(modelData, 256, 128);
    }
}
