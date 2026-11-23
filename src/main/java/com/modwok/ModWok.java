package com.modwok;

import com.modwok.docs.worldgen.ModWokWorldPlacedFeatures;
import com.modwok.registry.ModItems;
import com.modwok.registry.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModWok implements ModInitializer {
	public static final String MOD_ID = "modwok";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.initialize();
		ModBlocks.initialize();
		LOGGER.info("Hello Fabric world!");

		// Spawns in Mountain biomes only
		BiomeModifications.addFeature(
            BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            ModWokWorldPlacedFeatures.GORANGE_CHICKEN_ORE_VEIN_PLACED_KEY
		);

//		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ExampleMod.id("breaded_chicken_cut"), BreadedChickenCutsRecipe.SERIALIZER);
//		RecipeSynchronization.synchronizeRecipeSerializer(BreadedChickenCutsRecipe.SERIALIZER);
//
//		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ExampleMod.id("breaded_chicken_cut"), TestRecipe.SERIALIZER);
//		RecipeSynchronization.synchronizeRecipeSerializer(TestRecipe.SERIALIZER);

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
