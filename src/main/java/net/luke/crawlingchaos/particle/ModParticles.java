package net.luke.crawlingchaos.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.luke.crawlingchaos.CrawlingChaos;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType ACID_BUBBLES_PARTICLE =
            registerParticle("acid_bubbles_particle", FabricParticleTypes.simple());

    public static final SimpleParticleType BUG_LEAVES =
            registerParticle("bug_leaves", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CrawlingChaos.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        CrawlingChaos.LOGGER.info("Registering Particles for " + CrawlingChaos.MOD_ID);
    }
}