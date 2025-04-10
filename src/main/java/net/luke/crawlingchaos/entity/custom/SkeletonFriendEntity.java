package net.luke.crawlingchaos.entity.custom;

import net.luke.crawlingchaos.item.ModItems;
import net.luke.crawlingchaos.sound.ModSounds;
import net.luke.crawlingchaos.util.ModTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SkeletonFriendEntity extends SkeletonEntity implements Angerable {
    private static final TrackedData<Float> SKELETON_FRIEND_MODE;
    private int disabledSlots;

    public SkeletonFriendEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
        //this.setSFMode(0);
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

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putFloat("SkellyMode", this.getSFMode());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setSFMode(nbt.getFloat("SkellyMode", this.getSFMode()));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SKELETON_FRIEND_MODE, 0.0f);
    }

    public float getSFMode() {
        return (Float) this.getDataTracker().get(SKELETON_FRIEND_MODE);
    }

    public void setSFMode(float mode) {
        this.dataTracker.set(SKELETON_FRIEND_MODE, MathHelper.clamp(mode, mode, this.getMaxHealth()));
    }

    public boolean isWithered() {
        return this.getSFMode() == 1;
    }

    public boolean isBurned() {
        return this.getSFMode() == 2;
    }

    public boolean isMossy() {
        return this.getSFMode() == 3;
    }

    public boolean isObsidian() {
        return this.getSFMode() == 4;
    }

    public boolean isFrozen() {
        return this.getSFMode() == 5;
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


        if (itemStack.isIn(ModTags.Items.SKELETON_FRIEND_UPGRADES)) {
            if (this.getSFMode() == 0) {
                if (itemStack.isOf(ModItems.BONE_WITHERED_UPGRADE)) {
                    this.setSFMode(1);
                } else if (itemStack.isOf(ModItems.BONE_FLAME_UPGRADE)) {
                    this.setSFMode(2);
                } else if (itemStack.isOf(ModItems.BONE_MOSSY_UPGRADE)) {
                    this.setSFMode(3);
                } else if (itemStack.isOf(ModItems.BONE_OBSIDIAN_UPGRADE)) {
                    this.setSFMode(4);
                } else if (itemStack.isOf(ModItems.BONE_FROZEN_UPGRADE)) {
                    this.setSFMode(5);
                }

                itemStack.decrementUnlessCreative(1, player);
            }
            return ActionResult.SUCCESS;
        }
        else if (!itemStack.isOf(Items.NAME_TAG) && !itemStack.isOf(Items.BONE)) {
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

    public void tick() {
        if (isObsidian()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1));
        }
        super.tick();
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        if (!super.tryAttack(world, target)) {
            return false;
        } else {
            if (target instanceof LivingEntity) {
                if (isWithered()) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200), this);
                } else if (isMossy()) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), this);
                }
                else if (isFrozen()) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200), this);
                }
                else if (isBurned()) {
                    ((LivingEntity) target).setOnFireFor(200);
                }
            }

            return true;
        }
    }

    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier, @Nullable ItemStack shotFrom) {
        PersistentProjectileEntity persistentProjectileEntity = super.createArrowProjectile(arrow, damageModifier, shotFrom);
        if (isBurned()) {
            persistentProjectileEntity.setOnFireFor(100.0F);
        } else if (isMossy()) {
            if (persistentProjectileEntity instanceof ArrowEntity arrowEntity) {
                arrowEntity.addEffect(new StatusEffectInstance(StatusEffects.POISON, 100));
            }
        } else if (isWithered()) {
            if (persistentProjectileEntity instanceof ArrowEntity arrowEntity) {
                arrowEntity.addEffect(new StatusEffectInstance(StatusEffects.WITHER, 100));
            }
        } else if (isFrozen()) {
            if (persistentProjectileEntity instanceof ArrowEntity arrowEntity) {
                arrowEntity.addEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100));
            }
        }
        return persistentProjectileEntity;
    }

    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        Entity entity = source.getAttacker();
        if (source.isIn(DamageTypeTags.IS_EXPLOSION) && isObsidian()) {
            return false;
        } else if (source.isIn(DamageTypeTags.IS_FIRE) && (isBurned() || isObsidian())) {
            return false;
        } else if (entity != null && entity.getType().isIn(ModTags.EntityTypeTags.SKELETON_FRIEND_MATES)) {
            return false;
        } else return super.damage(world, source, amount) && this.getAttacker() != null;
    }

    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    public boolean canTarget(EntityType<?> type) {
        if (type == EntityType.PLAYER) {
            return false;
        } else {
            return type != EntityType.CREEPER && super.canTarget(type);
        }
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

    static {
        SKELETON_FRIEND_MODE = DataTracker.registerData(SkeletonFriendEntity.class, TrackedDataHandlerRegistry.FLOAT);
    }
}
