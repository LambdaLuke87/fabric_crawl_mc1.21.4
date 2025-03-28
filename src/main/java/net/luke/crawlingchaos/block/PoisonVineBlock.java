package net.luke.crawlingchaos.block;

import net.luke.crawlingchaos.entity.ModEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PoisonVineBlock extends VineBlock {

    public PoisonVineBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld serverWorld) {
            if (world.getDifficulty() != Difficulty.PEACEFUL && entity instanceof LivingEntity livingEntity && entity.getType() != ModEntities.PARASITE_WORM) {
                livingEntity.addStatusEffect(this.getPoisonEffect());
            }
        }
    }

    public StatusEffectInstance getPoisonEffect() {
        return new StatusEffectInstance(StatusEffects.POISON, 40);
    }
}
