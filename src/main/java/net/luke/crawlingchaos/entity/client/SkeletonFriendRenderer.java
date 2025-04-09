package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.feature.CustomSkeletonGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.client.state.SkeletonFriendRenderState;
import net.luke.crawlingchaos.entity.custom.SkeletonFriendEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class SkeletonFriendRenderer extends AbstractSkeletonEntityRenderer<SkeletonFriendEntity, SkeletonFriendRenderState> {
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/skeleton/skeleton.png");
    private static final Identifier TEXTURE_WITHERED = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/skeleton_friend/skeleton_friend_withered.png");
    private static final Identifier TEXTURE_MOSSY = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/skeleton_friend/skeleton_friend_mossy.png");
    private static final Identifier TEXTURE_BURNED = Identifier.of(CrawlingChaos.MOD_ID, "textures/entity/skeleton_friend/skeleton_friend_burned.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton_friend/skeleton_friend_glow.png";

    public SkeletonFriendRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SKELETON_FRIEND, ModEntityModelLayers.SKELETON_FRIEND_INNER_ARMOR,
                ModEntityModelLayers.SKELETON_FRIEND_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    public SkeletonFriendRenderState createRenderState() {
        return new SkeletonFriendRenderState();
    }

    @Override
    public Identifier getTexture(SkeletonFriendRenderState state) {
        if (state.withered) {
            return TEXTURE_WITHERED;
        }
        else if (state.burned) {
            return TEXTURE_BURNED;
        } else if (state.mossy) {
            return TEXTURE_MOSSY;
        } else {
            return TEXTURE;
        }
    }

    @Override
    public void updateRenderState(SkeletonFriendEntity skeletonfriendEntity, SkeletonFriendRenderState state, float f) {
        super.updateRenderState(skeletonfriendEntity, state, f);
        state.withered = skeletonfriendEntity.isWithered();
        state.burned = skeletonfriendEntity.isBurned();
        state.mossy = skeletonfriendEntity.isMossy();
    }
}
