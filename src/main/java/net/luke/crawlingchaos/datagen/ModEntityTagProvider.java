package net.luke.crawlingchaos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.luke.crawlingchaos.block.ModBlocks;
import net.luke.crawlingchaos.entity.client.ModEntities;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EntityTypeTags.UNDEAD)
                .add(ModEntities.ERODED_ZOMBIE)
                .add(ModEntities.SKELETON_FRIEND);

        getOrCreateTagBuilder(EntityTypeTags.ZOMBIES)
                .add(ModEntities.ERODED_ZOMBIE);

        getOrCreateTagBuilder(EntityTypeTags.SKELETONS)
                .add(ModEntities.SKELETON_FRIEND);

        getOrCreateTagBuilder(EntityTypeTags.IGNORES_POISON_AND_REGEN)
                .add(ModEntities.PRISM_FROG);
    }
}
