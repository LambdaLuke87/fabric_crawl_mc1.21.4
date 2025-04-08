package net.luke.crawlingchaos.entity.client;

import net.luke.crawlingchaos.entity.client.feature.CustomSkeletonGlowFeatureRenderer;
import net.luke.crawlingchaos.entity.client.model.ModEntityModelLayers;
import net.luke.crawlingchaos.entity.custom.WitherSkeletonFriendEntity;
import net.minecraft.client.render.entity.AbstractSkeletonEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.util.Identifier;

public class WitherSkeletonFriendRenderer extends AbstractSkeletonEntityRenderer<WitherSkeletonFriendEntity, SkeletonEntityRenderState> {
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/skeleton/wither_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton_friend/skeleton_friend_glow.png";

    public WitherSkeletonFriendRenderer(EntityRendererFactory.Context context) {
        super(context, ModEntityModelLayers.WITHER_SKELETON_FRIEND, ModEntityModelLayers.WITHER_SKELETON_FRIEND_INNER_ARMOR,
                ModEntityModelLayers.WITHER_SKELETON_FRIEND_OUTER_ARMOR);
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
