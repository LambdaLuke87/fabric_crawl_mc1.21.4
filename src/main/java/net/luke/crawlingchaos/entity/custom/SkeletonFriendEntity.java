package net.luke.crawlingchaos.entity.custom;

import net.luke.crawlingchaos.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SkeletonFriendEntity extends SkeletonEntity implements Angerable {
    private int disabledSlots;

    public SkeletonFriendEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSkeletonFriendAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, (double)35.0F).add(EntityAttributes.MOVEMENT_SPEED, (double)0.25F);
    }

    protected void initGoals() {
        this.goalSelector.add(3, new FleeEntityGoal<>(this, WolfEntity.class, 6.0F, (double)1.0F, 1.2));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, (double)1.0F));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MobEntity.class, 5, false, false,
                (entity, world) -> entity instanceof Monster && !(entity instanceof SkeletonFriendEntity || entity instanceof CreeperEntity)));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, TurtleEntity.class, 10, true, false, this::shouldAngerAt));
    }

    public void playSummonEffects() {
        this.playSound(ModSounds.COMMIT_SKELETON_FRIEND, 1.0F, 1.0F);

        for(int i = 0; i < 20; ++i) {
            double d = this.random.nextGaussian() * 0.02;
            double e = this.random.nextGaussian() * 0.02;
            double f = this.random.nextGaussian() * 0.02;
            this.getWorld().addParticleClient(ParticleTypes.SCULK_SOUL, this.getParticleX((double)1.0F) - d * (double)10.0F, this.getRandomBodyY() - e * (double)10.0F, this.getParticleZ((double)1.0F) - f * (double)10.0F, d, e, f);
        }
    }

    protected boolean isAffectedByDaylight() {
        return false;
    }

    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    private boolean isSlotDisabled(EquipmentSlot slot) {
        return (this.disabledSlots & 1 << slot.getOffsetIndex(0)) != 0 || slot.getType() == EquipmentSlot.Type.HAND;
    }

    private boolean equip(PlayerEntity player, EquipmentSlot slot, ItemStack stack, Hand hand) {
        ItemStack itemStack = this.getEquippedStack(slot);
        if (!itemStack.isEmpty() && (this.disabledSlots & 1 << slot.getOffsetIndex(8)) != 0) {
            return false;
        } else if (itemStack.isEmpty() && (this.disabledSlots & 1 << slot.getOffsetIndex(16)) != 0) {
            return false;
        } else if (player.isInCreativeMode() && itemStack.isEmpty() && !stack.isEmpty()) {
            this.equipStack(slot, stack.copyWithCount(1));
            return true;
        } else if (!stack.isEmpty() && stack.getCount() > 1) {
            if (!itemStack.isEmpty()) {
                return false;
            } else {
                this.equipStack(slot, stack.split(1));
                return true;
            }
        } else {
            this.equipStack(slot, stack);
            player.setStackInHand(hand, itemStack);
            return true;
        }
    }

    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!itemStack.isOf(Items.NAME_TAG) && !itemStack.isOf(Items.BONE)) {
            if (player.isSpectator()) {
                return ActionResult.SUCCESS;
            } else if (player.getWorld().isClient) {
                return ActionResult.SUCCESS_SERVER;
            } else {
                EquipmentSlot equipmentSlot = this.getPreferredEquipmentSlot(itemStack);
                if (itemStack.isEmpty()) {
                    EquipmentSlot equipmentSlot2 = this.getSlotFromPosition(hitPos);
                    EquipmentSlot equipmentSlot3 = this.isSlotDisabled(equipmentSlot2) ? equipmentSlot : equipmentSlot2;
                    if (this.hasStackEquipped(equipmentSlot3) && this.equip(player, equipmentSlot3, itemStack, hand)) {
                        return ActionResult.SUCCESS_SERVER;
                    }
                } else {
                    if (this.equip(player, equipmentSlot, itemStack, hand)) {
                        return ActionResult.SUCCESS_SERVER;
                    }
                }

                return ActionResult.PASS;
            }
        } else if (!itemStack.isOf(Items.BONE)) {
            return ActionResult.PASS;
        } else {
            float f = this.getHealth();
            this.heal(2);
            if (this.getHealth() == f) {
                return ActionResult.PASS;
            } else {
                float g = 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F;
                this.playSound(ModSounds.HEAL_SKELETON_FRIEND, 1.0F, g);
                itemStack.decrementUnlessCreative(1, player);
                return ActionResult.SUCCESS;
            }
        }
    }

    private EquipmentSlot getSlotFromPosition(Vec3d hitPos) {
        EquipmentSlot equipmentSlot = EquipmentSlot.MAINHAND;
        double d = hitPos.y / (double)(this.getScale() * this.getScaleFactor());
        EquipmentSlot equipmentSlot2 = EquipmentSlot.FEET;
        if (d >= 0.1 && d < 0.1 + 0.8 && this.hasStackEquipped(equipmentSlot2)) {
            equipmentSlot = EquipmentSlot.FEET;
        } else if (d >= 0.9 + 0.3 && d < 0.9 + (double)1.0F && this.hasStackEquipped(EquipmentSlot.CHEST)) {
            equipmentSlot = EquipmentSlot.CHEST;
        } else if (d >= 0.4 && d < 0.4 + (double)1.0F && this.hasStackEquipped(EquipmentSlot.LEGS)) {
            equipmentSlot = EquipmentSlot.LEGS;
        } else if (d >= 1.6 && this.hasStackEquipped(EquipmentSlot.HEAD)) {
            equipmentSlot = EquipmentSlot.HEAD;
        } else if (!this.hasStackEquipped(EquipmentSlot.MAINHAND) && this.hasStackEquipped(EquipmentSlot.OFFHAND)) {
            equipmentSlot = EquipmentSlot.OFFHAND;
        }

        return equipmentSlot;
    }

    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    public int getAngerTime() {
        return 0;
    }

    @Override
    public void setAngerTime(int angerTime) {

    }

    @Override
    public @Nullable UUID getAngryAt() {
        return null;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {

    }

    @Override
    public void chooseRandomAngerTime() {

    }
}
