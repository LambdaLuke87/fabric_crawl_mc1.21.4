package net.luke.crawlingchaos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.luke.crawlingchaos.entity.ModEntities;
import net.luke.crawlingchaos.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;
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
                .add(ModEntities.HELENA)
                .add(ModEntities.PRISM_FROG);

        getOrCreateTagBuilder(ModTags.EntityTypeTags.PARASITE_INFECTS)
                .add(EntityType.ZOMBIE);

        getOrCreateTagBuilder(ModTags.EntityTypeTags.POISON_VINES_IGNORES)
                .add(ModEntities.CARRIER_BUG)
                .add(ModEntities.KNIGHT_BUG)
                .add(ModEntities.PARASITE_WORM)
                .add(ModEntities.SERUPINEA);
    }
}
