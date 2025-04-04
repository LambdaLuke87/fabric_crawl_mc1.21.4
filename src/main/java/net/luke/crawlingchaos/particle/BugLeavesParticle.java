package net.luke.crawlingchaos.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

@Environment(EnvType.CLIENT)
public class BugLeavesParticle extends LeavesParticle {
    private float angularVelocity;
    private final float field_43370;
    private final float angularAcceleration;
    private final float field_55127;
    private boolean field_55128;
    private boolean field_55129;
    private double field_55130;
    private double field_55131;
    private double field_55132;

    protected BugLeavesParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float gravity, float f, boolean bl, boolean bl2, float size, float initialYVelocity) {
        super(world, x, y, z, spriteProvider, gravity, f, bl, bl2, size, initialYVelocity);
        this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));
        this.angularVelocity = (float)Math.toRadians(this.random.nextBoolean() ? (double)-30.0F : (double)30.0F);
        this.field_43370 = this.random.nextFloat();
        this.angularAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? (double)-5.0F : (double)5.0F);
        this.field_55127 = f;
        this.field_55128 = bl;
        this.field_55129 = bl2;
        this.maxAge = 300;
        this.gravityStrength = gravity * 1.2F * 0.0025F;
        float g = size * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.scale = g;
        this.setBoundingBoxSpacing(g, g);
        this.velocityMultiplier = 1.0F;
        this.velocityY = (double)(-initialYVelocity);
        this.field_55130 = Math.cos(Math.toRadians((double)(this.field_43370 * 60.0F))) * (double)this.field_55127;
        this.field_55131 = Math.sin(Math.toRadians((double)(this.field_43370 * 60.0F))) * (double)this.field_55127;
        this.field_55132 = Math.toRadians((double)(1000.0F + this.field_43370 * 3000.0F));
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new BugLeavesParticle(clientWorld, d, e, f, this.spriteProvider, 0.07F, 10.0F, false, true, 2.0F, 0.021F);
        }
    }
}
