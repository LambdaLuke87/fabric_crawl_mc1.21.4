package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.entity.client.feature.CustomSkeletonGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.custom.SkeletonFriendEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

public class SkeletonFriendRenderer extends AbstractSkeletonEntityRenderer<SkeletonFriendEntity, SkeletonEntityRenderState> {
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/skeleton/skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton_friend/skeleton_friend_glow.png";

    public SkeletonFriendRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.SKELETON_FRIEND, ModEntityModelLayers.SKELETON_FRIEND_INNER_ARMOR,
                ModEntityModelLayers.SKELETON_FRIEND_OUTER_ARMOR);
        this.addFeature(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    public SkeletonEntityRenderState createRenderState() {
        return new SkeletonEntityRenderState();
    }

    @Override
    public Identifier getTexture(SkeletonEntityRenderState state) {
        return TEXTURE;
    }
}
