package net.luke.crawlingchaos.sound;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent COMMIT_SKELETON_FRIEND = registerSoundEvent("entity.skeleton_friend.commit");
    public static final SoundEvent HEAL_SKELETON_FRIEND = registerSoundEvent("entity.skeleton_friend.heal");
    public static final SoundEvent FILL_VIRUS_TEMPLATE = registerSoundEvent("item.fill_virus_template");
    public static final SoundEvent FILL_TEST_TUBE = registerSoundEvent("item.fill_test_tube");

    public static final SoundEvent BLOCK_FERTILE_SLIME_MUD_BREAK = registerSoundEvent("block.fertile_slime.break");
    public static final SoundEvent BLOCK_FERTILE_SLIME_MUD_FALL = registerSoundEvent("block.fertile_slime.fall");
    public static final SoundEvent BLOCK_FERTILE_SLIME_MUD_HIT = registerSoundEvent("block.fertile_slime.hit");
    public static final SoundEvent BLOCK_FERTILE_SLIME_MUD_PLACE = registerSoundEvent("block.fertile_slime.place");
    public static final SoundEvent BLOCK_FERTILE_SLIME_MUD_STEP = registerSoundEvent("block.fertile_slime.step");

    public static final BlockSoundGroup FERTILE_SLIME_SOUNDS = new BlockSoundGroup(1f, 1f,
            BLOCK_FERTILE_SLIME_MUD_BREAK, BLOCK_FERTILE_SLIME_MUD_FALL, BLOCK_FERTILE_SLIME_MUD_HIT,
            BLOCK_FERTILE_SLIME_MUD_PLACE, BLOCK_FERTILE_SLIME_MUD_STEP);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(CrawlingChaos.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CrawlingChaos.LOGGER.info("Registering Mod Sounds for " + CrawlingChaos.MOD_ID);
    }
}