package net.luke.crawlingchaos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider<Item> {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SERUPINEA_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SERUPINEA_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SERUPINEA_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SERUPINEA_SHOVEL);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SERUPINEA_SWORD);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.SERUPINEA_HELMET)
                .add(ModItems.KNIGHT_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.SERUPINEA_CHESTPLATE)
                .add(ModItems.KNIGHT_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.SERUPINEA_LEGGINGS)
                .add(ModItems.KNIGHT_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.SERUPINEA_BOOTS)
                .add(ModItems.KNIGHT_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.SERUPINEA_HELMET)
                .add(ModItems.SERUPINEA_CHESTPLATE)
                .add(ModItems.SERUPINEA_LEGGINGS)
                .add(ModItems.SERUPINEA_BOOTS)
                .add(ModItems.KNIGHT_HELMET)
                .add(ModItems.KNIGHT_CHESTPLATE)
                .add(ModItems.KNIGHT_LEGGINGS)
                .add(ModItems.KNIGHT_BOOTS);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.SERUPINEA_AXE)
                .add(ModItems.SERUPINEA_HOE)
                .add(ModItems.SERUPINEA_PICKAXE)
                .add(ModItems.SERUPINEA_SHOVEL)
                .add(ModItems.SERUPINEA_SWORD)
                .add(ModItems.SERUPINEA_HELMET)
                .add(ModItems.SERUPINEA_CHESTPLATE)
                .add(ModItems.SERUPINEA_LEGGINGS)
                .add(ModItems.SERUPINEA_BOOTS)
                .add(ModItems.KNIGHT_HELMET)
                .add(ModItems.KNIGHT_CHESTPLATE)
                .add(ModItems.KNIGHT_LEGGINGS)
                .add(ModItems.KNIGHT_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SERUPINEA_HELMET)
                .add(ModItems.SERUPINEA_CHESTPLATE)
                .add(ModItems.SERUPINEA_LEGGINGS)
                .add(ModItems.SERUPINEA_BOOTS)
                .add(ModItems.KNIGHT_HELMET)
                .add(ModItems.KNIGHT_CHESTPLATE)
                .add(ModItems.KNIGHT_LEGGINGS)
                .add(ModItems.KNIGHT_BOOTS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BUG_OAK_LOG.asItem())
                .add(ModBlocks.BUG_OAK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BUG_OAK_LOG.asItem())
                .add(ModBlocks.STRIPPED_BUG_OAK_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BUG_OAK_PLANKS.asItem());
    }
}