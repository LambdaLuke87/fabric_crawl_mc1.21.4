package net.luke.crawlingchaos.world.biome;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized(){
        Regions.register(new ModOverworldRegion(Identifier.of(CrawlingChaos.MOD_ID, "overworld"), 3));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, CrawlingChaos.MOD_ID, VanillaSurfaceRules.createOverworldSurfaceRule());
    }
}
