package net.luke.crawlingchaos;

import net.fabricmc.api.ModInitializer;

import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.luke.crawlingchaos.item.ModItems;
import net.luke.crawlingchaos.item.ModItemsGroups;
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
	}
}