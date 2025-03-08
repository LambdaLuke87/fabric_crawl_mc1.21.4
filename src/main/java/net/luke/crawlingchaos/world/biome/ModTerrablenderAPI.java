package net.luke.crawlingchaos.world.biome;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized(){
        Regions.register(new ModOverworldRegion(Identifier.of(CrawlingChaos.MOD_ID, "overworld"), 3));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, CrawlingChaos.MOD_ID, ModMaterialRules.makeRules());
    }
}
