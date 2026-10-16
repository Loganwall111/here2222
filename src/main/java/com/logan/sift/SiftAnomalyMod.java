package com.logan.sift;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.logan.sift.block.ModBlocks;
import com.logan.sift.block.entity.ModBlockEntities;

public final class SiftAnomalyMod implements ModInitializer {
    public static final String MOD_ID = "sift";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Identifier id(String path) { return Identifier.fromNamespaceAndPath(MOD_ID, path); }

    @Override public void onInitialize() {
        ModBlocks.initialize();
        ModBlockEntities.initialize();
        LOGGER.info("Sift Anomaly loaded: source geometry and video-derived VFX enabled.");
    }
}
