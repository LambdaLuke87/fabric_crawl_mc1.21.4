package net.luke.crawlingchaos.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KnightBugEntity extends HostileEntity {

    public KnightBugEntity(EntityType<? extends KnightBugEntity> entityType, World world) {
        super(entityType, world);
    }

    private final ServerBossBar bossBar = new ServerBossBar(Text.literal("Knight Bug"),
            BossBar.Color.RED, BossBar.Style.NOTCHED_10);

    public static DefaultAttributeContainer.Builder createKnightBugAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, (double)200.0F).add(EntityAttributes.MOVEMENT_SPEED, (double)0.3F).add(EntityAttributes.ATTACK_DAMAGE, (double)8.0F).add(EntityAttributes.KNOCKBACK_RESISTANCE, (double)1.0F);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
        this.goalSelector.add(4, new MeleeAttackGoal(this, (double)1.0F, false));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, SnowGolemEntity.class, true));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SILVERFISH_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 2.0F);
    }

    /* BOSS BAR */
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    protected void mobTick(ServerWorld world) {
        super.mobTick(world);
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }
}