package com.modwok.docs.datagen;

import com.modwok.registry.ModBlocks;
import com.modwok.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.concurrent.CompletableFuture;

public class ModWokBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModWokBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Ores
        add(ModBlocks.GORANGE_CHICKEN_ORE,
            createSilkTouchDispatchTable(
                ModBlocks.GORANGE_CHICKEN_ORE,
                LootItem.lootTableItem(ModItems.GORANGE_CHICKEN_NUG)
            )
        );
    }

}
