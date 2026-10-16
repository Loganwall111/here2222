package com.logan.sift.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public final class RiftPortalBlockEntity extends BlockEntity {
    private int animationAge;

    public RiftPortalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RIFT_PORTAL, pos, state);
    }

    public int getAnimationAge() { return animationAge; }
    public void restartAnimation() { animationAge = 0; setChanged(); }

    public static void tick(Level level, BlockPos pos, BlockState state, RiftPortalBlockEntity entity) {
        if (entity.animationAge < 1_000_000) entity.animationAge++;
    }

    @Override public AABB getRenderBoundingBox() {
        return new AABB(worldPosition).inflate(5.5D, 4.5D, 5.5D);
    }

    @Override public boolean shouldRenderOffScreen() { return true; }
}
