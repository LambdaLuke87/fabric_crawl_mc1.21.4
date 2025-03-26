package net.luke.crawlingchaos.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.world.World;

public class ParasiteWormEntity extends SilverfishEntity {

    public ParasiteWormEntity(EntityType<? extends ParasiteWormEntity> entityType, World world) {
        super(entityType, world);
    }
}
