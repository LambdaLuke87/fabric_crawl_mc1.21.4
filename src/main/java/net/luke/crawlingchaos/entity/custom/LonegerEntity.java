package net.luke.crawlingchaos.entity.custom;

import net.luke.crawlingchaos.entity.LonegerTradeOffers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class LonegerEntity extends MerchantEntity {
    private static final int field_30629 = 5;
    @Nullable
    private BlockPos lonegerTarget;

    public LonegerEntity(EntityType<? extends LonegerEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StopFollowingCustomerGoal(this));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, ZombieEntity.class, 8.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, EvokerEntity.class, 12.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, VindicatorEntity.class, 8.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, VexEntity.class, 8.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, PillagerEntity.class, 15.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, IllusionerEntity.class, 12.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, ZoglinEntity.class, 10.0F, (double)0.5F, (double)0.5F));
        this.goalSelector.add(1, new EscapeDangerGoal(this, (double)0.5F));
        this.goalSelector.add(1, new LookAtCustomerGoal(this));
        this.goalSelector.add(4, new GoToWalkTargetGoal(this, 0.35));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.35));
        this.goalSelector.add(9, new StopAndLookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
    }

    @Nullable
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public boolean isLeveledMerchant() {
        return false;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.hasCustomer() && !this.isBaby()) {
            if (hand == Hand.MAIN_HAND) {
                player.incrementStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.getWorld().isClient) {
                if (this.getOffers().isEmpty()) {
                    return ActionResult.CONSUME;
                }

                this.setCustomer(player);
                this.sendOffers(player, this.getDisplayName(), 1);
            }

            return ActionResult.SUCCESS;
        } else {
            return super.interactMob(player, hand);
        }
    }

    protected void fillRecipes() {
        if (this.getWorld().getEnabledFeatures().contains(FeatureFlags.TRADE_REBALANCE)) {
            this.fillRebalancedRecipes();
        } else {
            LonegerTradeOffers.Factory[] factorys = (LonegerTradeOffers.Factory[]) LonegerTradeOffers.LONEGER_TRADES.get(1);
            LonegerTradeOffers.Factory[] factorys2 = (LonegerTradeOffers.Factory[]) LonegerTradeOffers.LONEGER_TRADES.get(2);
            if (factorys != null && factorys2 != null) {
                TradeOfferList tradeOfferList = this.getOffers();
                this.fillRecipesFromPool(tradeOfferList, factorys, 5);
                int i = this.random.nextInt(factorys2.length);
                TradeOffers.Factory factory = factorys2[i];
                TradeOffer tradeOffer = factory.create(this, this.random);
                if (tradeOffer != null) {
                    tradeOfferList.add(tradeOffer);
                }

            }
        }
    }

    private void fillRebalancedRecipes() {
        TradeOfferList tradeOfferList = this.getOffers();

        for(Pair<TradeOffers.Factory[], Integer> pair : TradeOffers.REBALANCED_WANDERING_TRADER_TRADES) {
            TradeOffers.Factory[] factorys = (TradeOffers.Factory[])pair.getLeft();
            this.fillRecipesFromPool(tradeOfferList, factorys, (Integer)pair.getRight());
        }

    }

    protected void afterUsing(TradeOffer offer) {
        if (offer.shouldRewardPlayerExperience()) {
            int i = 3 + this.random.nextInt(4);
            this.getWorld().spawnEntity(new ExperienceOrbEntity(this.getWorld(), this.getX(), this.getY() + (double)0.5F, this.getZ(), i));
        }

    }

    protected SoundEvent getAmbientSound() {
        return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WANDERING_TRADER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_DEATH;
    }

    protected SoundEvent getTradingSound(boolean sold) {
        return sold ? SoundEvents.ENTITY_WANDERING_TRADER_YES : SoundEvents.ENTITY_WANDERING_TRADER_NO;
    }

    public SoundEvent getYesSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_YES;
    }

    public void setLonegerTarget(@Nullable BlockPos lonegerTarget) {
        this.lonegerTarget = lonegerTarget;
    }

    @Nullable
    BlockPos getLonegerTarget() {
        return this.lonegerTarget;
    }

    class WanderToTargetGoal extends Goal {
        final LonegerEntity trader;
        final double proximityDistance;
        final double speed;

        WanderToTargetGoal(final LonegerEntity trader, final double proximityDistance, final double speed) {
            this.trader = trader;
            this.proximityDistance = proximityDistance;
            this.speed = speed;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public void stop() {
            this.trader.setLonegerTarget((BlockPos)null);
            LonegerEntity.this.navigation.stop();
        }

        public boolean canStart() {
            BlockPos blockPos = this.trader.getLonegerTarget();
            return blockPos != null && this.isTooFarFrom(blockPos, this.proximityDistance);
        }

        public void tick() {
            BlockPos blockPos = this.trader.getLonegerTarget();
            if (blockPos != null && LonegerEntity.this.navigation.isIdle()) {
                if (this.isTooFarFrom(blockPos, (double)10.0F)) {
                    Vec3d vec3d = (new Vec3d((double)blockPos.getX() - this.trader.getX(), (double)blockPos.getY() - this.trader.getY(), (double)blockPos.getZ() - this.trader.getZ())).normalize();
                    Vec3d vec3d2 = vec3d.multiply((double)10.0F).add(this.trader.getX(), this.trader.getY(), this.trader.getZ());
                    LonegerEntity.this.navigation.startMovingTo(vec3d2.x, vec3d2.y, vec3d2.z, this.speed);
                } else {
                    LonegerEntity.this.navigation.startMovingTo((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), this.speed);
                }
            }

        }

        private boolean isTooFarFrom(BlockPos pos, double proximityDistance) {
            return !pos.isWithinDistance(this.trader.getPos(), proximityDistance);
        }
    }

    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }
}