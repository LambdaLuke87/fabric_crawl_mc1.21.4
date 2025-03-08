package net.luke.crawlingchaos.world.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.mixin.TreeDecoratorTypeInvoker;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;

public class LeavesPoisonVineTreeDecorator extends TreeDecorator {
    public static final MapCodec<LeavesPoisonVineTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(LeavesPoisonVineTreeDecorator::new, decorator -> decorator.probability);
    private final float probability;

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.POISON_LEAVE_VINE;
    }
    public LeavesPoisonVineTreeDecorator(float probability) {
        this.probability = probability;
    }

    public void generate(Generator generator) {
        Random random = generator.getRandom();
        generator.getLeavesPositions().forEach((pos) -> {
            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.west();
                if (generator.isAir(blockPos)) {
                    placePoisonVines(blockPos, VineBlock.EAST, generator);
                }
            }

            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.east();
                if (generator.isAir(blockPos)) {
                    placePoisonVines(blockPos, VineBlock.WEST, generator);
                }
            }

            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.north();
                if (generator.isAir(blockPos)) {
                    placePoisonVines(blockPos, VineBlock.SOUTH, generator);
                }
            }

            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.south();
                if (generator.isAir(blockPos)) {
                    placePoisonVines(blockPos, VineBlock.NORTH, generator);
                }
            }

        });
    }

    private static void placePoisonVines(BlockPos pos, BooleanProperty faceProperty, Generator generator) {
        generator.replace(pos, ModBlocks.POISON_VINE.getDefaultState().with(faceProperty, true));
        int i = 4;

        for(BlockPos var4 = pos.down(); generator.isAir(var4) && i > 0; --i) {
            generator.replace(var4, ModBlocks.POISON_VINE.getDefaultState().with(faceProperty, true));
            var4 = var4.down();
        }

    }
}
