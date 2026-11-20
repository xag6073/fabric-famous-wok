package com.example.items;

import com.example.modwok.ModWokFoodValues;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.FoodValues;

import java.util.function.Function;

public class ModItems {

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our item to the ingredients group.
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.BREADED_CHICKEN_CUTS));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.BREADCRUMBS));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> creativeTab.accept(ModItems.LO_MEIN));
    }

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

    public static final Item LO_MEIN = register(
            ModItemIds.LO_MEIN_KEY,
            Item::new,
            new Item.Properties().food(ModWokFoodValues.LO_MEIN)
    );

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

}
