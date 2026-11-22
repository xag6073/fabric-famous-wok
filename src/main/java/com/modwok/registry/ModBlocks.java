package com.modwok.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import vectorwing.farmersdelight.common.references.ModBlockIds;

import java.util.function.Function;

public class ModBlocks {

    public static final Block GORANGE_CHICKEN_ORE = registerBlockAndItem(
            ModBlockItemIds.GORANGE_CHICKEN_ORE_KEY,
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(100.0f, 100.0f)
                    .requiresCorrectToolForDrops()

    );


    private static Block registerBlockAndItem(BlockItemId blockId, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        Block block = registerBlock(blockId.block(), blockFactory, properties);

        // Create the block item instance
        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(blockId.item()));
        Registry.register(BuiltInRegistries.ITEM, blockId.item(), blockItem);

        return block;
    }

    private static Block registerBlock(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        Block block = blockFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(
                CreativeModeTabs.BUILDING_BLOCKS
        ).register(entries -> {
            entries.accept(GORANGE_CHICKEN_ORE.asItem());
        });
    }
}