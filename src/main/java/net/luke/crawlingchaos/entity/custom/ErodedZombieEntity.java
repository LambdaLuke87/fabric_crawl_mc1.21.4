package net.luke.crawlingchaos.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ErodedZombieEntity extends ZombieEntity {
    private static final int MAX_HEALTH = 60;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    //public final AnimationState walkAnimationState = new AnimationState();
    //public int walkAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public static DefaultAttributeContainer.Builder createErodedZombieAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, (double)60.0F) .add(EntityAttributes.FOLLOW_RANGE, (double)35.0F).add(EntityAttributes.MOVEMENT_SPEED, (double)0.23F).add(EntityAttributes.ATTACK_DAMAGE, (double)3.0F).add(EntityAttributes.ARMOR, (double)2.0F).add(EntityAttributes.SPAWN_REINFORCEMENTS);
    }

    public ErodedZombieEntity(EntityType<? extends ErodedZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 140 * (int)f), this);
        }
        return bl;
    }

    public static boolean shouldBeBaby(Random random) {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 19;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }
}