package net.luke.crawlingchaos.entity.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BatEntityRenderState;
import net.minecraft.util.math.MathHelper;

public class HelenaModel extends EntityModel<BatEntityRenderState> {
    private final ModelPart body;
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public HelenaModel(ModelPart modelPart) {
        super(modelPart);
        this.body = modelPart.getChild("body");

        this.rightWing = this.body.getChild("right_wing");
        this.leftWing = this.body.getChild("left_wing");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("body", ModelPartBuilder.create().uv(8, 12).cuboid(0.0F, -1.5F, -1.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        modelPartData2.addChild("right_wing", ModelPartBuilder.create().uv(-6, 9).cuboid(0.0F, -1.0F, -2.8F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));
        modelPartData2.addChild("left_wing", ModelPartBuilder.create().uv(-6, 9).mirrored().cuboid(-3.0F, -1.0F, -2.8F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 16, 16);
    }

    public void setAngles(BatEntityRenderState batEntityRenderState) {
        super.setAngles(batEntityRenderState);
        float f = batEntityRenderState.age * 120.32113F * ((float)Math.PI / 180F);
        this.rightWing.yaw = 0.0F;
        this.rightWing.roll = MathHelper.cos(f) * (float)Math.PI * 0.15F;
        this.leftWing.pitch = this.rightWing.pitch;
        this.leftWing.yaw = this.rightWing.yaw;
        this.leftWing.roll = -this.rightWing.roll;
    }
}
