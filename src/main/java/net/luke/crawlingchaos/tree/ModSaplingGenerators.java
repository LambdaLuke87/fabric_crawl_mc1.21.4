package net.luke.crawlingchaos.tree;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator BUG_OAK = new SaplingGenerator(CrawlingChaos.MOD_ID + ":bug_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BUG_OAK_KEY), Optional.empty());
}