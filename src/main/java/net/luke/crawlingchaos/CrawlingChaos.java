package net.luke.crawlingchaos;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.luke.crawlingchaos.gen.ModWorldGeneration;
import net.luke.crawlingchaos.item.ModItems;
import net.luke.crawlingchaos.item.ModItemsGroups;
import net.luke.crawlingchaos.sound.ModSounds;
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
		ModSounds.registerSounds();
		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.BUG_OAK_LOG, ModBlocks.STRIPPED_BUG_OAK_LOG);
		StrippableBlockRegistry.register(ModBlocks.BUG_OAK_WOOD, ModBlocks.STRIPPED_BUG_OAK_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BUG_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BUG_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUG_OAK_LEAVES, 30, 60);
	}
}