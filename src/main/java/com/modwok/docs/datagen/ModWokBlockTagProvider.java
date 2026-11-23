package com.modwok.docs.datagen;

import com.modwok.registry.ModBlockItemIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModWokBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModWokBlockTagProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture
    ) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        // Makes the ore mineable with a pickaxe
        builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlockItemIds.GORANGE_CHICKEN_ORE_KEY.block());

        // Requires a diamond pickaxe or better to drop items
        builder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlockItemIds.GORANGE_CHICKEN_ORE_KEY.block());
    }
}
