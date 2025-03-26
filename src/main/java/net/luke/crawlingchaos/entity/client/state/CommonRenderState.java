package net.luke.crawlingchaos.entity.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class CommonRenderState extends LivingEntityRenderState {
    public CommonRenderState() {
    }
}