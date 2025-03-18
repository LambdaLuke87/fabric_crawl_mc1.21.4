package net.luke.crawlingchaos.entity.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class ErodedZombieRenderState extends ZombieEntityRenderState {
    public ErodedZombieRenderState() {
    }

    public final AnimationState idleAnimationState = new AnimationState();
}
