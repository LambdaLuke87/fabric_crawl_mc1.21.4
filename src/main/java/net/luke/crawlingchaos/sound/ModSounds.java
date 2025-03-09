package net.luke.crawlingchaos.sound;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent HEAL_SKELETON_FRIEND = registerSoundEvent("entity.skeleton_friend.heal");
    public static final SoundEvent FILL_VIRUS_TEMPLATE = registerSoundEvent("item.fill_virus_template");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(CrawlingChaos.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CrawlingChaos.LOGGER.info("Registering Mod Sounds for " + CrawlingChaos.MOD_ID);
    }
}