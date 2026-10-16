package com.logan.sift.client;

import org.jetbrains.annotations.Nullable;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import com.logan.sift.SiftAnomalyMod;
import com.logan.sift.block.entity.RiftPortalBlockEntity;

/** Full-bright renderer using the supplied model texture and video-extracted effect strips. */
public final class RiftPortalRenderer implements BlockEntityRenderer<RiftPortalBlockEntity, RiftPortalRenderState> {
    private static final int FULL_BRIGHT = 0x00F000F0;
    private static final Identifier PORTAL_TEXTURE = SiftAnomalyMod.id("textures/entity/rift_portal.png");
    private static final Identifier CHARGE = SiftAnomalyMod.id("textures/effect/charge_sequence.png");
    private static final Identifier IMPACT = SiftAnomalyMod.id("textures/effect/impact_sequence.png");
    private static final Identifier EMERGENCE = SiftAnomalyMod.id("textures/effect/anomaly_emergence.png");

    private final RiftPortalModel model = new RiftPortalModel(RiftPortalModel.createMainLayer().bakeRoot());
    private final net.minecraft.client.model.geom.ModelPart chargeA = RiftPortalModel.createEffectLayer().bakeRoot().getChild("effect");
    private final net.minecraft.client.model.geom.ModelPart chargeB = RiftPortalModel.createEffectLayer().bakeRoot().getChild("effect");
    private final net.minecraft.client.model.geom.ModelPart impactA = RiftPortalModel.createEffectLayer().bakeRoot().getChild("effect");
    private final net.minecraft.client.model.geom.ModelPart impactB = RiftPortalModel.createEffectLayer().bakeRoot().getChild("effect");
    private final net.minecraft.client.model.geom.ModelPart emergenceA = RiftPortalModel.createEffectLayer().bakeRoot().getChild("effect");
    private final net.minecraft.client.model.geom.ModelPart emergenceB = RiftPortalModel.createEffectLayer().bakeRoot().getChild("effect");

    public RiftPortalRenderer(BlockEntityRendererProvider.Context context) {}
    @Override public boolean shouldRenderOffScreen() { return true; }
    @Override public int getViewDistance() { return 128; }


    @Override public RiftPortalRenderState createRenderState() { return new RiftPortalRenderState(); }

    @Override public void extractRenderState(RiftPortalBlockEntity entity, RiftPortalRenderState state,
            float tickProgress, Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        state.ageTicks = entity.getAnimationAge();
    }

    @Override public void submit(RiftPortalRenderState state, PoseStack matrices,
            SubmitNodeCollector queue, CameraRenderState cameraState) {
        model.animate(state.ageTicks);
        matrices.pushPose();
        matrices.translate(0.5D, 3.875D, 0.5D);
        matrices.scale(-1.0F / 16.0F, -1.0F / 16.0F, 1.0F / 16.0F);
        queue.submitModelPart(model.portal, matrices, RenderTypes.entityTranslucent(PORTAL_TEXTURE),
            FULL_BRIGHT, OverlayTexture.NO_OVERLAY, null, -1, null, 0);
        matrices.popPose();

        int t = state.ageTicks % 1_000_000;
        if (t < 30) {
            submitEffect(chargeA, matrices, queue, CHARGE, 0.72F, 0.0F);
            submitEffect(chargeB, matrices, queue, CHARGE, 0.72F, 90.0F);
        } else if (t < 45) {
            submitEffect(impactA, matrices, queue, IMPACT, 1.12F, 0.0F);
            submitEffect(impactB, matrices, queue, IMPACT, 1.12F, 90.0F);
        } else if (t < 104) {
            float pulse = 1.0F + 0.035F * (float)Math.sin(t * 0.28F);
            submitEffect(emergenceA, matrices, queue, EMERGENCE, 1.25F * pulse, 0.0F);
            submitEffect(emergenceB, matrices, queue, EMERGENCE, 1.25F * pulse, 90.0F);
        }
    }

    private void submitEffect(net.minecraft.client.model.geom.ModelPart part, PoseStack matrices,
            SubmitNodeCollector queue, Identifier texture, float size, float yaw) {
        matrices.pushPose();
        matrices.translate(0.5D, 1.9D, 0.5D);
        matrices.mulPose(Axis.YP.rotationDegrees(yaw));
        matrices.scale(size * 0.10F, -size * 0.10F, size * 0.10F);
        queue.submitModelPart(part, matrices, RenderTypes.entityTranslucent(texture),
            FULL_BRIGHT, OverlayTexture.NO_OVERLAY, null, false, false, -1, null, 0);
        matrices.popPose();
    }
}
