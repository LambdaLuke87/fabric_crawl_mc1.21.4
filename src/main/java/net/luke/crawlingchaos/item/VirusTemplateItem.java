package net.luke.crawlingchaos.item;

import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class VirusTemplateItem extends Item {
    private static final Map<Block, Block> VIRUS_MAP_SAPLINGS =
            Map.of(
                    Blocks.OAK_SAPLING, Blocks.DEAD_BUSH,
                    Blocks.DARK_OAK_SAPLING, Blocks.DEAD_BUSH,
                    Blocks.PALE_OAK_SAPLING, Blocks.DEAD_BUSH,
                    ModBlocks.BUG_OAK_SAPLING, Blocks.DEAD_BUSH,
                    Blocks.BIRCH_SAPLING, Blocks.DEAD_BUSH,
                    Blocks.SPRUCE_SAPLING, Blocks.DEAD_BUSH
            );
    private static final Map<Block, Block> VIRUS_MAP_OTHERS =
            Map.of(
                    Blocks.SHORT_GRASS, Blocks.AIR,
                    Blocks.POPPY, Blocks.AIR,
                    Blocks.DANDELION, Blocks.AIR
            );

    public VirusTemplateItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (!world.isClient()) {
            if (VIRUS_MAP_SAPLINGS.containsKey(clickedBlock) || VIRUS_MAP_OTHERS.containsKey(clickedBlock)) {
                if (clickedBlock.equals(Blocks.OAK_SAPLING) || clickedBlock.equals(Blocks.DARK_OAK_SAPLING)
                        || clickedBlock.equals(Blocks.PALE_OAK_SAPLING))
                    Block.dropStack(world, context.getBlockPos(), new ItemStack(ModItems.VIRUS_A));
                else if (clickedBlock.equals(Blocks.SHORT_GRASS) || clickedBlock.equals(Blocks.POPPY)
                        || clickedBlock.equals(Blocks.DANDELION))
                    Block.dropStack(world, context.getBlockPos(), new ItemStack(ModItems.VIRUS_B));
                else if (clickedBlock.equals(ModBlocks.BUG_OAK_SAPLING))
                    Block.dropStack(world, context.getBlockPos(), new ItemStack(ModItems.VIRUS_C));

                if (VIRUS_MAP_SAPLINGS.containsKey(clickedBlock)) {
                    world.setBlockState(context.getBlockPos(), VIRUS_MAP_SAPLINGS.get(clickedBlock).getDefaultState());
                }
                else if (VIRUS_MAP_OTHERS.containsKey(clickedBlock)) {
                    world.setBlockState(context.getBlockPos(), VIRUS_MAP_OTHERS.get(clickedBlock).getDefaultState());
                }

                context.getStack().decrementUnlessCreative(1, ((ServerPlayerEntity) context.getPlayer()));
                world.playSound(null, context.getBlockPos(), ModSounds.FILL_VIRUS_TEMPLATE, SoundCategory.BLOCKS);

                ((ServerWorld) world).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, clickedBlock.getDefaultState()),
                        context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 1.0,
                        context.getBlockPos().getZ() + 0.5, 5, 0, 0, 0, 1);

                ((ServerWorld) world).spawnParticles(ParticleTypes.CLOUD,
                        context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 0.5,
                        context.getBlockPos().getZ() + 0.5, 15, 0.5, 0.5, 0.5, 0);
            }
        }

        return ActionResult.SUCCESS;
    }
}
