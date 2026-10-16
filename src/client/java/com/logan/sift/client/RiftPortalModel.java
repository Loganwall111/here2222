package com.logan.sift.client;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;

/** Source-derived model: cube UVs, sizes, origins and bone pivots come from rift_portal.geo.json. */
public final class RiftPortalModel {
    public final ModelPart portal;
    private final ModelPart left;
    private final ModelPart right;
    private final ModelPart small1, small2, small3, small4, small5;
    private final ModelPart all;

    public RiftPortalModel(ModelPart bakedRoot) {
        portal = bakedRoot.getChild("rift_portal");
        left = portal.getChild("left_first_cubes");
        right = portal.getChild("right_first_cubes");
        small1 = portal.getChild("small_cube_1");
        small2 = portal.getChild("small_cube_2");
        small3 = portal.getChild("small_cube_3");
        small4 = portal.getChild("small_cube_4");
        small5 = portal.getChild("small_cube_5");
        all = portal.getChild("all");
    }

    public static LayerDefinition createMainLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition portal = root.addOrReplaceChild("rift_portal", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));
        portal.addOrReplaceChild("left_first_cubes",
            CubeListBuilder.create()
                .texOffs(0, 147).addBox(-6.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F)
                .texOffs(46, 172).addBox(2.0F, 0.0F, -8.0F, 4.0F, 8.0F, 16.0F)
                .texOffs(192, 35).addBox(1.5F, 0.5F, -4.0F, 4.0F, 7.0F, 8.0F)
                .texOffs(192, 20).addBox(-5.5F, -3.5F, -4.0F, 7.0F, 7.0F, 8.0F),
            PartPose.offset(62.0F, -11.0F, 0.0F));
        portal.addOrReplaceChild("small_cube_4",
            CubeListBuilder.create().texOffs(182, 187).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 16.0F),
            PartPose.offset(29.0F, 13.0F, 0.0F));
        portal.addOrReplaceChild("small_cube_5",
            CubeListBuilder.create().texOffs(192, 0).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 16.0F),
            PartPose.offset(70.0F, 22.0F, 0.0F));
        portal.addOrReplaceChild("small_cube_3",
            CubeListBuilder.create().texOffs(190, 94).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 16.0F),
            PartPose.offset(-15.0F, 28.0F, 0.0F));
        portal.addOrReplaceChild("small_cube_2",
            CubeListBuilder.create().texOffs(188, 149).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 16.0F),
            PartPose.offset(-61.0F, -12.0F, 0.0F));
        portal.addOrReplaceChild("small_cube_1",
            CubeListBuilder.create().texOffs(182, 187).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 16.0F),
            PartPose.offset(-26.0F, -26.0F, 0.0F));
        portal.addOrReplaceChild("right_first_cubes",
            CubeListBuilder.create()
                .texOffs(142, 172).addBox(-4.0F, -6.0F, -8.0F, 4.0F, 8.0F, 16.0F)
                .texOffs(86, 173).addBox(0.0F, -2.0F, -8.0F, 4.0F, 8.0F, 16.0F)
                .texOffs(192, 129).addBox(-3.5F, -5.5F, -4.0F, 3.0F, 7.0F, 8.0F)
                .texOffs(192, 114).addBox(-0.5F, -1.5F, -4.0F, 4.0F, 7.0F, 8.0F),
            PartPose.offset(-48.0F, 7.0F, 0.0F));
        portal.addOrReplaceChild("all",
            CubeListBuilder.create()
                .texOffs(0, 0).addBox(-24.0F, -23.0F, -8.0F, 48.0F, 46.0F, 16.0F)
                .texOffs(0, 62).addBox(-23.6F, -22.5F, -4.0F, 47.0F, 45.0F, 8.0F)
                .texOffs(142, 149).addBox(-55.5F, -22.6F, -4.0F, 15.0F, 15.0F, 8.0F)
                .texOffs(48, 149).addBox(-39.6F, -6.5F, -4.0F, 16.0F, 15.0F, 8.0F)
                .texOffs(128, 0).addBox(-56.0F, -23.0F, -8.0F, 16.0F, 16.0F, 16.0F)
                .texOffs(64, 117).addBox(-40.0F, -7.0F, -8.0F, 16.0F, 16.0F, 16.0F)
                .texOffs(0, 171).addBox(-71.5F, -6.6F, -4.0F, 15.0F, 15.0F, 8.0F)
                .texOffs(128, 117).addBox(-72.0F, -7.0F, -8.0F, 16.0F, 16.0F, 16.0F)
                .texOffs(182, 172).addBox(56.4F, 9.5F, -4.0F, 15.0F, 7.0F, 8.0F)
                .texOffs(128, 32).addBox(56.0F, 9.0F, -8.0F, 16.0F, 8.0F, 16.0F)
                .texOffs(110, 62).addBox(24.0F, -7.0F, -8.0F, 32.0F, 16.0F, 16.0F)
                .texOffs(110, 94).addBox(23.4F, -6.5F, -4.0F, 32.0F, 15.0F, 8.0F)
                .texOffs(96, 149).addBox(-7.6F, 22.5F, -4.0F, 15.0F, 16.0F, 8.0F)
                .texOffs(0, 115).addBox(-8.0F, 23.0F, -8.0F, 16.0F, 16.0F, 16.0F),
            PartPose.ZERO);
        return LayerDefinition.create(mesh, 256, 256);
    }

    public static LayerDefinition createEffectLayer() {
        MeshDefinition mesh = new MeshDefinition();
        mesh.getRoot().addOrReplaceChild("effect",
            CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -32.0F, 0.0F, 64.0F, 64.0F, 0.05F),
            PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }

    public void animate(int ageTicks) {
        portal.resetPose();
        left.resetPose(); right.resetPose();
        small1.resetPose(); small2.resetPose(); small3.resetPose(); small4.resetPose(); small5.resetPose(); all.resetPose();
        float seconds = ageTicks / 20.0F;
        float tau = (float)(Math.PI * 2.0);
        if (ageTicks < 30) {
            float t = Math.min(1.0F, ageTicks / 22.0F);
            float ease = t * t * (3.0F - 2.0F * t);
            left.x -= 55.0F * (1.0F - Math.min(1.0F, ageTicks / 10.0F));
            right.x += 55.0F * (1.0F - Math.min(1.0F, ageTicks / 10.0F));
            left.y += 4.0F * (1.0F - ease);
            right.y += 4.0F * (1.0F - ease);
            for (ModelPart p : new ModelPart[]{small1, small2, small3, small4, small5}) {
                p.xScale *= Math.max(0.08F, ease); p.yScale *= Math.max(0.08F, ease); p.zScale *= Math.max(0.08F, ease);
            }
            all.xScale *= Math.max(0.03F, ease); all.yScale *= Math.max(0.03F, ease); all.zScale *= Math.max(0.03F, ease);
            left.zRot += (float)Math.toRadians(4.0F * (1.0F - ease));
            right.zRot -= (float)Math.toRadians(4.0F * (1.0F - ease));
        }
        float phase = (seconds % 6.0F) / 6.0F * tau;
        float bobL = (float)Math.sin(phase) * 1.5F;
        float bobR = (float)Math.sin(phase + 1.25F) * 1.5F;
        left.zRot += (float)Math.toRadians(1.0F * Math.sin(phase + 0.3F));
        right.zRot += (float)Math.toRadians(1.1F * Math.sin(phase + 2.0F));
        left.y += 0.3F + 1.85F * (1.0F - (float)Math.cos(phase)) + bobL * 0.18F;
        right.y += 0.45F + 1.55F * (1.0F - (float)Math.cos(phase + 1.3F)) + bobR * 0.18F;
        portal.zRot += (float)Math.toRadians(Math.sin(phase * 0.5F) * 0.8F);
        portal.y += (float)Math.sin(phase + 0.8F) * 0.8F;
        small1.zRot += (float)Math.toRadians(Math.sin(phase * 1.17F) * 2.5F);
        small2.zRot += (float)Math.toRadians(Math.sin(phase * 0.91F + 1.2F) * 2.0F);
        small3.zRot += (float)Math.toRadians(Math.sin(phase * 1.31F + 2.3F) * 2.0F);
        small4.zRot += (float)Math.toRadians(Math.sin(phase * 0.83F + 2.8F) * 2.0F);
        small5.zRot += (float)Math.toRadians(Math.sin(phase * 0.97F + 3.9F) * 2.0F);
    }
}
