package net.luke.crawlingchaos.entity.client.model;

import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    private static final String MAIN = "main";
    private static final String INNER_ARMOR = "inner_armor";
    private static final String OUTER_ARMOR = "outer_armor";

    public static final EntityModelLayer ERODED_ZOMBIE = createEntityModelLayer("eroded_zombie", MAIN);
    //public static final EntityModelLayer ERODED_ZOMBIE_INNER_ARMOR = createEntityModelLayer("eroded_zombie", INNER_ARMOR);
    //public static final EntityModelLayer ERODED_ZOMBIE_OUTER_ARMOR = createEntityModelLayer("eroded_zombie", OUTER_ARMOR);
    //public static final EntityModelLayer ERODED_ZOMBIE_BABY = createEntityModelLayer("eroded_zombie_baby", MAIN);
    //public static final EntityModelLayer ERODED_ZOMBIE_BABY_INNER_ARMOR = createEntityModelLayer("eroded_zombie_baby", INNER_ARMOR);
    //public static final EntityModelLayer ERODED_ZOMBIE_BABY_OUTER_ARMOR = createEntityModelLayer("eroded_zombie_baby", OUTER_ARMOR);

    public static void registerEntityModelLayers() {
        CrawlingChaos.LOGGER.info("Registering Model Layers for " + CrawlingChaos.MOD_ID);
    }

    public static EntityModelLayer createEntityModelLayer(String path, String layer) {
        return new EntityModelLayer(Identifier.of(CrawlingChaos.MOD_ID, path), layer);
    }
}
