package com.logan.sift.block.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import com.logan.sift.SiftAnomalyMod;
import com.logan.sift.block.ModBlocks;

public final class ModBlockEntities {
    public static final BlockEntityType<RiftPortalBlockEntity> RIFT_PORTAL = Registry.register(
        BuiltInRegistries.BLOCK_ENTITY_TYPE, SiftAnomalyMod.id("rift_portal"),
        FabricBlockEntityTypeBuilder.create(RiftPortalBlockEntity::new, ModBlocks.RIFT_PORTAL).build());

    private ModBlockEntities() {}
    public static void initialize() {}
}
