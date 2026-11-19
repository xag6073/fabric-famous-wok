package com.example.client;

import com.example.ExampleMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class ExampleModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ModItems.initialize();

		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ExampleMod.id("breaded_chicken_cut"), BreadedChickenCutRecipe.SERIALIZER);
		RecipeSynchronization.synchronizeRecipeSerializer(BreadedChickenCutRecipe.SERIALIZER);

	}
}