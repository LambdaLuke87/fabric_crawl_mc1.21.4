package net.luke.crawlingchaos.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.world.World;

public class PrismFrogEntity extends FrogEntity {
    public PrismFrogEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        //this.lookControl = new FrogLookControl(this);
        //this.setPathfindingPenalty(PathNodeType.WATER, 4.0F);
        //this.setPathfindingPenalty(PathNodeType.TRAPDOOR, -1.0F);
        //this.moveControl = new AquaticMoveControl(this, 85, 10, 0.02F, 0.1F, true);
    }
}
