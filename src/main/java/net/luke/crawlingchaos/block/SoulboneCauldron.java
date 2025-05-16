package net.luke.crawlingchaos.block;

import net.luke.crawlingchaos.entity.ModEntities;
import net.luke.crawlingchaos.entity.custom.SkeletonFriendEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoulboneCauldron extends Block {
    public SoulboneCauldron(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }

    private void spawnskeletonfriend(World world, BlockPos pos) {
        SkeletonFriendEntity skeletonfriendEntity = (SkeletonFriendEntity) ModEntities.SKELETON_FRIEND.create(world, SpawnReason.MOB_SUMMONED);
        if (skeletonfriendEntity != null) {
            skeletonfriendEntity.refreshPositionAndAngles((double) pos.getX() + (double) 0.5F, (double) pos.getY() + 1.0f, (double) pos.getZ() + (double) 0.5F, 0.0F, 0.0F);
            world.spawnEntity(skeletonfriendEntity);
            skeletonfriendEntity.playSummonEffects();
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getStack().getItem() == Items.SKELETON_SKULL) {
                this.spawnskeletonfriend(world, pos);
                itemEntity.discard();
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
