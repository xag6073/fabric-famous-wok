package com.modwok.crafting;

import com.modwok.registry.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class BreadedChickenCutsRecipe implements CraftingRecipe {
    public static final BreadedChickenCutsRecipe INSTANCE = new BreadedChickenCutsRecipe();
    public static final MapCodec<BreadedChickenCutsRecipe> CODEC = MapCodec.unit(INSTANCE);
    public static final StreamCodec<RegistryFriendlyByteBuf, BreadedChickenCutsRecipe> STREAM_CODEC = StreamCodec.unit(INSTANCE);
    public static final RecipeSerializer<BreadedChickenCutsRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    @Override
    public boolean matches(CraftingInput input, Level level) {
       ItemStack chickenCutsStack = ItemStack.EMPTY;
       ItemStack doughStack = ItemStack.EMPTY;

       for (int index = 0; index < input.size(); index++) {
           ItemStack currentStack = input.getItem(index);
           if (!currentStack.isEmpty()) {
               if (currentStack.is(vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get())) {
                   if (!chickenCutsStack.isEmpty()) return false;
                   chickenCutsStack = currentStack;
               } else if (currentStack.is(vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get())) {
                   if (!doughStack.isEmpty()) return false;
                   doughStack = currentStack;
               }
           }
       }

       return !chickenCutsStack.isEmpty() && !doughStack.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        return new ItemStack(ModItems.BREADED_CHICKEN_CUTS);
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "";
    }


    @Override
    public RecipeSerializer<? extends CraftingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public PlacementInfo placementInfo() {
        return null;
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }
}
