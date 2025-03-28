package net.luke.crawlingchaos;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.entity.ModEntities;
import net.luke.crawlingchaos.gen.ModWorldGeneration;
import net.luke.crawlingchaos.item.ModItems;
import net.luke.crawlingchaos.item.ModItemsGroups;
import net.luke.crawlingchaos.sound.ModSounds;
import net.luke.crawlingchaos.world.treedecorator.ModTreeDecorators;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrawlingChaos implements ModInitializer {
	public static final String MOD_ID = "crawling-chaos";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//LOGGER.info("Hello Fabric world!");
		ModItemsGroups.registerItemsGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModEntities.registerAttributes();
		ModEntities.addMobsToBiome();
		ModSounds.registerSounds();
		ModWorldGeneration.generateModWorldGen();
		ModTreeDecorators.register();

		StrippableBlockRegistry.register(ModBlocks.BUG_OAK_LOG, ModBlocks.STRIPPED_BUG_OAK_LOG);
		StrippableBlockRegistry.register(ModBlocks.BUG_OAK_WOOD, ModBlocks.STRIPPED_BUG_OAK_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BUG_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BUG_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_LEAVES, 30, 60);

		// Signs
		SignItem signItem = new SignItem(ModBlocks.BUG_OAK_SIGN, ModBlocks.BUG_OAK_WALL_SIGN, new Item.Settings().maxCount(16)
				.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_sign"))).useBlockPrefixedTranslationKey());
		HangingSignItem hangingSignItem = new HangingSignItem(ModBlocks.BUG_OAK_HANGING_SIGN, ModBlocks.BUG_OAK_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)
				.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrawlingChaos.MOD_ID, "bug_oak_hanging_sign"))).useBlockPrefixedTranslationKey());

		// Register
		signItem.appendBlocks(Item.BLOCK_ITEMS, signItem);
		hangingSignItem.appendBlocks(Item.BLOCK_ITEMS, hangingSignItem);

		Registry.register(Registries.ITEM, "bug_oak_sign", signItem);
		Registry.register(Registries.ITEM, "bug_oak_hanging_sign", hangingSignItem);
	}
}