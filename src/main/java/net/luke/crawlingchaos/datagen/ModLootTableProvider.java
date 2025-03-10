package net.luke.crawlingchaos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.luke.crawlingchaos.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BIOLLANTA);
        addDrop(ModBlocks.BUG_OAK_SAPLING);
        addDrop(ModBlocks.BUG_OAK_LOG);
        addDrop(ModBlocks.BUG_OAK_WOOD);
        addDrop(ModBlocks.STRIPPED_BUG_OAK_LOG);
        addDrop(ModBlocks.STRIPPED_BUG_OAK_WOOD);
        addDrop(ModBlocks.BUG_OAK_PLANKS);
        addDrop(ModBlocks.BUG_OAK_BUTTON);
        addDrop(ModBlocks.BUG_OAK_PRESSURE_PLATE);
        addDrop(ModBlocks.BUG_OAK_STAIRS);
        addDrop(ModBlocks.BUG_OAK_SLAB);
        addDrop(ModBlocks.BUG_OAK_FENCE);
        addDrop(ModBlocks.BUG_OAK_FENCE_GATE);
        //addDrop(ModBlocks.BUG_OAK_SIGN);
        addDrop(ModBlocks.BUG_OAK_DOOR);
        addDrop(ModBlocks.BUG_OAK_TRAPDOOR);
        addDrop(ModBlocks.MYCENA_CHLOROPHOS);
        addDrop(ModBlocks.TERAPIA);
    }
}