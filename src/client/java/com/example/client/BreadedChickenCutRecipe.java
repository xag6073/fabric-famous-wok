package com.example.client;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.level.Level;

import java.util.List;

public class BreadedChickenCutRecipe extends CustomRecipe {
    public static final BreadedChickenCutRecipe INSTANCE = new BreadedChickenCutRecipe();
    public static final MapCodec<BreadedChickenCutRecipe> CODEC = MapCodec.unit(INSTANCE);
    public static final StreamCodec<RegistryFriendlyByteBuf, BreadedChickenCutRecipe> STREAM_CODEC = StreamCodec.unit(INSTANCE);
    public static final RecipeSerializer<BreadedChickenCutRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    @Override
    public boolean matches(CraftingInput input, Level level) {
        return input.items().stream().anyMatch(items -> items.is(ModItems.BREADED_CHICKEN_CUTS));
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        return new ItemStack(ModItems.BREADED_CHICKEN_CUTS, 1);
    }

    @Override
    public RecipeType<CraftingRecipe> getType() {
        return super.getType();
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        return super.getRemainingItems(input);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return super.recipeBookCategory();
    }

    @Override
    public List<RecipeDisplay> display() {
        return super.display();
    }
}
