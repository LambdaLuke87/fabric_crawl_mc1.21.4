package net.luke.crawlingchaos.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class HelenaEntity extends AnimalEntity {
    public HelenaEntity(EntityType<? extends HelenaEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, true);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 16.0F);
        this.setPathfindingPenalty(PathNodeType.COCOA, -1.0F);
        this.setPathfindingPenalty(PathNodeType.FENCE, -1.0F);
    }

    public static DefaultAttributeContainer.Builder createHelenaAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.MAX_HEALTH, (double)1.0F).add(EntityAttributes.FLYING_SPEED, (double)0.6F).add(EntityAttributes.MOVEMENT_SPEED, (double)0.1F);
    }

    protected void initGoals() {
        this.goalSelector.add(8, new HelenaEntity.ButterflyWanderAroundGoal());
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public void tickMovement() {
        super.tickMovement();
    }

    public boolean canBeLeashed() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    protected void pushAway(Entity entity) {
    }

    protected void tickCramming() {
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world) {
            public boolean isValidPosition(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }
        };
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setMaxFollowRange(48.0F);
        return birdNavigation;
    }

    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    public boolean isFlappingWings() {
        return !this.isOnGround();
    }

    class ButterflyWanderAroundGoal extends Goal {
        ButterflyWanderAroundGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            return HelenaEntity.this.navigation.isIdle() && HelenaEntity.this.random.nextInt(10) == 0;
        }

        public boolean shouldContinue() {
            return HelenaEntity.this.navigation.isFollowingPath();
        }

        public void start() {
            Vec3d vec3d = this.getRandomLocation();
            if (vec3d != null) {
                HelenaEntity.this.navigation.startMovingAlong(HelenaEntity.this.navigation.findPathTo(BlockPos.ofFloored(vec3d), 1), (double)1.0F);
            }

        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d vec3d2;
            vec3d2 = HelenaEntity.this.getRotationVec(0.0F);

            int i = 8;
            Vec3d vec3d3 = AboveGroundTargeting.find(HelenaEntity.this, 8, 7, vec3d2.x, vec3d2.z, ((float)Math.PI / 2F), 3, 1);
            return vec3d3 != null ? vec3d3 : NoPenaltySolidTargeting.find(HelenaEntity.this, 8, 4, -2, vec3d2.x, vec3d2.z, (double)((float)Math.PI / 2F));
        }
    }
}
