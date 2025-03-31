package net.luke.crawlingchaos.entity.custom;

import net.luke.crawlingchaos.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.conversion.EntityConversionContext;
import net.minecraft.entity.conversion.EntityConversionType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ErodedZombieEntity extends ZombieEntity implements RangedAttackMob {

    public static DefaultAttributeContainer.Builder createErodedZombieAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, (double)60.0F) .add(EntityAttributes.FOLLOW_RANGE, (double)35.0F).add(EntityAttributes.MOVEMENT_SPEED, (double)0.23F).add(EntityAttributes.ATTACK_DAMAGE, (double)3.0F).add(EntityAttributes.ARMOR, (double)2.0F).add(EntityAttributes.SPAWN_REINFORCEMENTS);
    }

    public ErodedZombieEntity(EntityType<? extends ErodedZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new AvoidSunlightGoal(this));
        this.goalSelector.add(3, new EscapeSunlightGoal(this, (double)1.0F));
        this.goalSelector.add(2, new ZombieAttackGoal(this, (double)1.0F, false));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, (double)1.0F, true, 4, this::canBreakDoors));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, (double)1.0F));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[]{ZombifiedPiglinEntity.class}));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 140 * (int)f), this);
        }
        return bl;
    }

    public void remove(Entity.RemovalReason reason) {
        if (!this.getWorld().isClient && this.isDead()) {
            float f = this.getDimensions(this.getPose()).width();
            float g = f / 2.0F;
            int k;
            if (isBaby())
            {
                k = 1;
            }
            else
            {
                k = 2 + this.random.nextInt(2);
            }
            Team team = this.getScoreboardTeam();

            for (int l = 0; l < k; ++l) {
                float h = ((float) (l % 2) - 0.5F) * g;
                float m = ((float) (l / 2) - 0.5F) * g;
                this.convertTo(ModEntities.PARASITE_WORM, new EntityConversionContext(EntityConversionType.SPLIT_ON_DEATH, false, false, team), SpawnReason.TRIGGERED, (newParasite) -> {
                    newParasite.refreshPositionAndAngles(this.getX() + (double) h, this.getY() + (double) 0.5F, this.getZ() + (double) m, this.random.nextFloat() * 360.0F, 0.0F);
                });
            }
        }

        super.remove(reason);
    }

    protected boolean canConvertInWater() {
        return false;
    }

    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (super.damage(world, source, amount) && this.getAttacker() != null) {
            double spit_distance = this.squaredDistanceTo(this.getAttacker());
            if (spit_distance < (double)76.0F) {
                this.spitAt(this.getAttacker());
            }
            return true;
        } else {
            return false;
        }
    }

    private void spitAt(LivingEntity target) {
        ErodedZombieSpitEntity erodedzombieSpitEntity = new ErodedZombieSpitEntity(this.getWorld(), this);
        double d = target.getX() - this.getX();
        double e = target.getBodyY(0.3333333333333333) - erodedzombieSpitEntity.getY();
        double f = target.getZ() - this.getZ();
        double g = Math.sqrt(d * d + f * f) * (double)0.2F;
        World var12 = this.getWorld();
        if (var12 instanceof ServerWorld serverWorld) {
            ProjectileEntity.spawnWithVelocity(erodedzombieSpitEntity, serverWorld, ItemStack.EMPTY, d, e + g, f, 1.5F, 10.0F);
        }

        if (!this.isSilent()) {
            this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_LLAMA_SPIT, this.getSoundCategory(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
        }
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress)  {
        this.spitAt(target);
    }
}