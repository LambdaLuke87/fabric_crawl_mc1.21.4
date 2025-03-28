package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.entity.client.state.CommonRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class ParasiteWormModel extends EntityModel<CommonRenderState> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart u_tusk_top;
    private final ModelPart u_tusk_end;
    private final ModelPart d_tusk_top;
    private final ModelPart d_tusk_end;
    private final ModelPart l_tusk_top;
    private final ModelPart l_tusk_end;
    private final ModelPart r_tusk_top;
    private final ModelPart r_tusk_end;
    private final ModelPart section1;
    private final ModelPart section2;
    private final ModelPart section3;
    private final ModelPart section4;
    private final ModelPart section5;
    private final ModelPart tail;

    public ParasiteWormModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.u_tusk_top = this.head.getChild("u_tusk_top");
        this.u_tusk_end = this.u_tusk_top.getChild("u_tusk_end");
        this.d_tusk_top = this.head.getChild("d_tusk_top");
        this.d_tusk_end = this.d_tusk_top.getChild("d_tusk_end");
        this.l_tusk_top = this.head.getChild("l_tusk_top");
        this.l_tusk_end = this.l_tusk_top.getChild("l_tusk_end");
        this.r_tusk_top = this.head.getChild("r_tusk_top");
        this.r_tusk_end = this.r_tusk_top.getChild("r_tusk_end");
        this.section1 = this.root.getChild("section1");
        this.section2 = this.root.getChild("section2");
        this.section3 = this.root.getChild("section3");
        this.section4 = this.root.getChild("section4");
        this.section5 = this.root.getChild("section5");
        this.tail = this.root.getChild("tail");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(206, 0).cuboid(-4.5F, -4.75F, -16.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -27.25F, -18.0F));
        head.addChild("head_r1", ModelPartBuilder.create().uv(0, 40).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.75F, 0.5F, -0.1745F, 0.0F, 0.0F));

        ModelPartData u_tusk_top = head.addChild("u_tusk_top", ModelPartBuilder.create().uv(80, 30).cuboid(-1.5F, -1.0F, -5.8F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1361F, -15.2F, -0.6545F, 0.0F, 0.0F));
        u_tusk_top.addChild("u_tusk_end", ModelPartBuilder.create().uv(0, 20).cuboid(-0.5F, -0.5F, -6.0F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.6139F, -5.8F, 1.5708F, 0.0F, 0.0F));
        ModelPartData d_tusk_top = head.addChild("d_tusk_top", ModelPartBuilder.create().uv(80, 30).cuboid(-1.5F, -1.0F, -5.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.8639F, -16.0506F, 0.6545F, 0.0F, 0.0F));
        d_tusk_top.addChild("d_tusk_end", ModelPartBuilder.create().uv(0, 20).cuboid(-1.0F, -0.5F, -6.0F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, -5.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData l_tusk_top = head.addChild("l_tusk_top", ModelPartBuilder.create().uv(60, 30).cuboid(-1.5F, -1.5F, -5.9044F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -0.25F, -14.5956F, 0.0F, -0.6458F, 0.0F));
        ModelPartData l_tusk_end = l_tusk_top.addChild("l_tusk_end", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 0.0F, -6.0F));
        l_tusk_end.addChild("l_tusk_end_r1", ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, -1.0F, -7.4044F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, -0.5F, 0.0F, 1.5708F, 0.0F));
        ModelPartData r_tusk_top = head.addChild("r_tusk_top", ModelPartBuilder.create().uv(60, 30).cuboid(-1.0F, -1.5F, -4.9044F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -0.25F, -15.5956F, 0.0F, 0.6458F, 0.0F));
        r_tusk_top.addChild("r_tusk_end", ModelPartBuilder.create().uv(0, 10).cuboid(-1.0F, -1.0F, -5.5F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, -4.5F, 0.0F, -1.5708F, 0.0F));

        root.addChild("section1", ModelPartBuilder.create().uv(157, 0).cuboid(-4.0F, -3.153F, -11.9837F, 8.0F, 8.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 50).cuboid(-1.0F, -0.153F, 3.4489F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.2962F, -24.847F, -6.4489F, -0.3142F, 0.0262F, 0.0F));
        root.addChild("section2", ModelPartBuilder.create().uv(108, 0).cuboid(-5.0F, 7.5622F, -18.4643F, 8.0F, 8.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 50).cuboid(-2.0F, 12.394F, -3.0426F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.894F, 16.5426F, -1.0472F, 0.0F, 0.0873F));
        root.addChild("section3", ModelPartBuilder.create().uv(65, 0).cuboid(-4.0F, -13.5F, 0.4378F, 7.0F, 7.0F, 14.0F, new Dilation(0.0F))
                .uv(0, 50).cuboid(-2.0F, -10.0F, 13.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, -0.0873F));
        root.addChild("section4", ModelPartBuilder.create().uv(216, 26).cuboid(-3.0F, -4.0229F, -2.8F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.5F, 19.4F, -0.0873F, 0.0F, 0.0873F));
        root.addChild("section5", ModelPartBuilder.create().uv(181, 26).cuboid(-2.5F, -2.5F, 0.1F, 5.0F, 5.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.5F, 30.0F, 0.0F, 0.0F, -0.0873F));

        root.addChild("tail", ModelPartBuilder.create().uv(156, 26).cuboid(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -1.5F, 42.5F));
        return TexturedModelData.of(modelData, 256, 64);
    }

    @Override
    public void setAngles(CommonRenderState commonState) {
        super.setAngles(commonState);

        this.head.yaw = commonState.yawDegrees * ((float)Math.PI / 180F);
        this.head.pitch = commonState.pitch * ((float)Math.PI / 180F);
    }
}
