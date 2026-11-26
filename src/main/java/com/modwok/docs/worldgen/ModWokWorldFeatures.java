package com.modwok.docs.worldgen;

import com.modwok.ModWok;
import com.modwok.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModWokWorldFeatures {

    public static final ResourceKey<Feature> GORANGE_CHICKEN_ORE_VEIN_FEATURE_KEY =
        ResourceKey.create(
                Registries.FEATURE,
                ModWok.id("gorange_chicken_ore_vein")
        );

    public static void configure(BootstrapContext<Feature> context) {
        // Replace RuleTests
        RuleTest deepslateReplaceableRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // Replace Deepslate
        List<BlockReplacement> deepslateReplaceConfig =
            List.of(
                    BlockReplacement.replace(deepslateReplaceableRule, ModBlocks.GORANGE_CHICKEN_ORE.defaultBlockState())
            );

        context.register(
                GORANGE_CHICKEN_ORE_VEIN_FEATURE_KEY,
                new OreFeature(deepslateReplaceConfig, 3) // 3 is the blocks per vein
        );
    }
}
