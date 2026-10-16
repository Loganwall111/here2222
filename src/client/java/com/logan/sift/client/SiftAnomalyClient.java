package com.logan.sift.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import com.logan.sift.block.entity.ModBlockEntities;

public final class SiftAnomalyClient implements ClientModInitializer {
    @Override public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.RIFT_PORTAL, RiftPortalRenderer::new);
    }
}
