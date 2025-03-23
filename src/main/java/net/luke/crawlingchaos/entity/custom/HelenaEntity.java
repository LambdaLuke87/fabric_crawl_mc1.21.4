package net.luke.crawlingchaos.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HelenaEntity extends BatEntity {
    public HelenaEntity(EntityType<? extends BatEntity> entityType, World world) {
        super(entityType, world);
        if (!world.isClient) {
            this.setRoosting(true);
        }
    }

    public SoundEvent getAmbientSound() { return null; }
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }
    protected SoundEvent getDeathSound() {
        return null;
    }
}
