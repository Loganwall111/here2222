package com.logan.sift.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import com.logan.sift.SiftAnomalyMod;

public final class ModBlocks {
    public static final Identifier RIFT_ID = SiftAnomalyMod.id("rift_portal");
    public static final ResourceKey<Block> RIFT_BLOCK_KEY = ResourceKey.create(Registries.BLOCK, RIFT_ID);
    public static final Block RIFT_PORTAL = Registry.register(BuiltInRegistries.BLOCK, RIFT_BLOCK_KEY,
        new RiftPortalBlock(BlockBehaviour.Properties.of().noCollision().noOcclusion().strength(3.0F).setId(RIFT_BLOCK_KEY)));

    private ModBlocks() {}

    public static void initialize() {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, RIFT_ID);
        Registry.register(BuiltInRegistries.ITEM, itemKey,
            new BlockItem(RIFT_PORTAL, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey)));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
            .register(tab -> tab.accept(RIFT_PORTAL.asItem()));
    }
}
