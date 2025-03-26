package net.luke.crawlingchaos.mixin;

import net.luke.crawlingchaos.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StemBlock.class)
public class FertileSlimeStemBlock {
    @Inject(method = "canPlantOnTop",
            at = @At("HEAD"),
            cancellable = true)
    private void canPlantOnTopMixin(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(floor.isOf(Blocks.FARMLAND) || floor.isOf(ModBlocks.FERTILE_SLIME));
    }
}