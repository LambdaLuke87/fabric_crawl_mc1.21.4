package net.luke.crawlingchaos.world.treedecorator;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.mixin.TreeDecoratorTypeInvoker;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorators {
    public static final TreeDecoratorType<?> POISON_LEAVE_VINE =
            TreeDecoratorTypeInvoker.callRegister("poison_vine_placer", LeavesPoisonVineTreeDecorator.CODEC);

    public static void register() {
        CrawlingChaos.LOGGER.info("Registering Tree Decorator Types for " + CrawlingChaos.MOD_ID);
    }
}