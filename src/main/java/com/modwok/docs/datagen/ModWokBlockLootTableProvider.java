package com.modwok.docs.datagen;

import com.modwok.registry.ModBlocks;
import com.modwok.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

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
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
                        .apply(
                                SetItemCountFunction.setCount(ContextIntProviders.exactly(2))
                                        .when(Holder.direct(
                                                BonusLevelTableCondition.bonusLevelFlatChance(
                                                        this.enchantments.getOrThrow(Enchantments.FORTUNE),
                                                        0.0F, 0.05F, 0.10F, 0.20F
                                                ).build()
                                        ))
                        )
            )
        );
    }

}
