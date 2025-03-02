package net.luke.crawlingchaos;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.luke.crawlingchaos.entity.client.ErodedZombieRenderer;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class CrawlingChaosClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityModelLayers.registerEntityModelLayers();
        EntityRendererRegistry.register(ModEntities.ERODED_ZOMBIE, ErodedZombieRenderer::new);

        RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CrawlingChaos.MOD_ID, "eroded_zombie"));
    }
}
