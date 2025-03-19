package net.luke.crawlingchaos.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
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
            if (world.getDifficulty() != Difficulty.PEACEFUL && entity instanceof LivingEntity livingEntity) {
                // && entity.getType() != EntityType.BEE
                //entity.damage(serverWorld, world.getDamageSources().sweetBerryBush(), 0.5F);
                livingEntity.addStatusEffect(this.getPoisonEffect());
            }
        }
    }

    public StatusEffectInstance getPoisonEffect() {
        return new StatusEffectInstance(StatusEffects.POISON, 40);
    }
}
