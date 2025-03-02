package net.luke.crawlingchaos.entity.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class ErodedZombieRenderState extends BipedEntityRenderState {
    public boolean attacking;
    //public boolean convertingInWater;

    public ErodedZombieRenderState() {
    }
}
