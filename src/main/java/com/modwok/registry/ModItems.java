package com.modwok.registry;

import com.modwok.ModWokFoodValues;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.function.Function;

import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;

public class ModItems {

    // FOOD_AND_DRINKS & INGREDIENTS
    public static final Item BREADED_CHICKEN_CUTS = register(
            ModItemIds.BREADED_CHICKEN_CUTS,
            Item::new,
            new Item.Properties().food(FoodValues.CHICKEN_CUTS)
    );
    public static final Item BREADCRUMBS = register(
            ModItemIds.BREADCRUMBS_KEY,
            Item::new,
            new Item.Properties()
    );

    // BOWL REQUIRED FOODS
    public static final Item EGG_DROP_SOUP = register(
        ModItemIds.EGG_DROP_SOUP_KEY,
        properties -> new ConsumableItem(properties, true),
        bowlFoodItem(ModWokFoodValues.EGG_DROP_SOUP, FoodValues.ConsumableValues.NOURISHMENT_SHORT_DURATION)
    );

    public static final Item LO_MEIN = register(
        ModItemIds.LO_MEIN_KEY,
        properties -> new ConsumableItem(properties, true),
        bowlFoodItem(ModWokFoodValues.LO_MEIN, FoodValues.ConsumableValues.NOURISHMENT_SHORT_DURATION));

    // ORE DROPS
    public static final Item GORANGE_CHICKEN_NUG = register(
            ModItemIds.GORANGE_CHICKEN_NUG_KEY,
            Item::new,
            new Item.Properties().food(ModWokFoodValues.GORANGE_CHICKEN_NUG)
    );

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our item to the ingredients group.

        // INGREDIENTS
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.BREADED_CHICKEN_CUTS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.BREADCRUMBS));

        // FOOD_AND_DRINKS
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> creativeTab.accept(ModItems.LO_MEIN));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> creativeTab.accept(ModItems.GORANGE_CHICKEN_NUG));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> creativeTab.accept(ModItems.EGG_DROP_SOUP));
    }

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

}