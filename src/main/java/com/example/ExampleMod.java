package com.example;

import com.example.modwok.ModItems;
import com.example.recipes.BreadedChickenCutsRecipe;
import com.example.recipes.TestRecipe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "modid";

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
		LOGGER.info("Hello Fabric world!");

		ModItems.initialize();

//		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ExampleMod.id("breaded_chicken_cut"), BreadedChickenCutsRecipe.SERIALIZER);
//		RecipeSynchronization.synchronizeRecipeSerializer(BreadedChickenCutsRecipe.SERIALIZER);

		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ExampleMod.id("breaded_chicken_cut"), TestRecipe.SERIALIZER);
		RecipeSynchronization.synchronizeRecipeSerializer(TestRecipe.SERIALIZER);

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
