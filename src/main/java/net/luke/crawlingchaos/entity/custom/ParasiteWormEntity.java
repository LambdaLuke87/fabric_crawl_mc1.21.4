package net.luke.crawlingchaos.entity.custom;

import net.luke.crawlingchaos.entity.ModEntities;
import net.luke.crawlingchaos.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.conversion.EntityConversionContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class ParasiteWormEntity extends HostileEntity {

    public ParasiteWormEntity(EntityType<? extends ParasiteWormEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(4, new MeleeAttackGoal(this, (double)1.0F, false));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ZombieEntity.class, 5, false, false,
                (entity, world) -> entity instanceof Monster && (entity.getType().isIn(ModTags.EntityTypeTags.PARASITE_INFECTS))));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createParasiteWormAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, (double)14.0F).add(EntityAttributes.MOVEMENT_SPEED, (double)0.25F).add(EntityAttributes.ATTACK_DAMAGE, (double)2.0F);
    }

    protected Entity.MoveEffect getMoveEffect() {
        return MoveEffect.EVENTS;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SILVERFISH_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SILVERFISH_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15F, 1.0F);
    }

    public boolean infectZombie(ServerWorld world, ZombieEntity zombie) {
        ErodedZombieEntity erodedZombieEntity = (ErodedZombieEntity)zombie.convertTo(ModEntities.ERODED_ZOMBIE, EntityConversionContext.create(zombie, true, true), (erodedZombie) -> {
            erodedZombie.initialize(world, world.getLocalDifficulty(erodedZombie.getBlockPos()), SpawnReason.CONVERSION, new ZombieEntity.ZombieData(false, true));
            if (!this.isSilent()) {
                world.syncWorldEvent((PlayerEntity)null, 1026, this.getBlockPos(), 0);
            }

        });
        return erodedZombieEntity != null;
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (target instanceof ZombieEntity zombieEntity && target.getType().isIn(ModTags.EntityTypeTags.PARASITE_INFECTS)) {
            if (this.random.nextBoolean()) {
                return bl;
            }

            if (this.infectZombie(world, zombieEntity)) {
                bl = false;

                this.discard();
            }
        }

        return bl;
    }

    public static boolean canSpawn(EntityType<ParasiteWormEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return canSpawnInDark(type, world, spawnReason, pos, random) && (SpawnReason.isAnySpawner(spawnReason) || world.isSkyVisible(pos));
    }
}
