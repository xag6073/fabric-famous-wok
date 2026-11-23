package com.modwok.docs.worldgen;

import com.modwok.ModWok;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModWokWorldPlacedFeatures {

    public static final ResourceKey<PlacedFeature> GORANGE_CHICKEN_ORE_VEIN_PLACED_FEATURE =
        ResourceKey.create(
            Registries.PLACED_FEATURE,
            ModWok.id("gorange_chicken_ore_placed")
        );

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<Feature> features = context.lookup(Registries.FEATURE);
        List<PlacementModifier> gorangeChickenOreVeinModifiers = List.of(
            CountPlacement.of(1),
            BiomeFilter.biome(),
            InSquarePlacement.spread(),
            HeightRangePlacement.of(
                BiasedToBottomHeight.of(
                    VerticalAnchor.BOTTOM, VerticalAnchor.absolute(0), 3
                )
            )
        );

        context.register(
            GORANGE_CHICKEN_ORE_VEIN_PLACED_FEATURE,
            new PlacedFeature(
                features.getOrThrow(ModWokWorldFeatures.GORANGE_CHICKEN_ORE_VEIN_FEATURE_KEY),
                gorangeChickenOreVeinModifiers
            )
        );
    }
}
