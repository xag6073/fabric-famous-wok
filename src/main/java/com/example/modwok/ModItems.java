package com.example.modwok;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {

    public static ResourceKey<Item> createKey(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                ModWok.id(name)
        );
    }

    public static Item register(ResourceKey<Item> key) {
        Item item = new Item(
                new Item.Properties().setId(key)
        );

        Registry.register(
                BuiltInRegistries.ITEM,
                key,
                item
        );

        return item;
    }

    public static final ResourceKey<Item> BREADCRUMBS_KEY =
            createKey("breadcrumbs");

    public static final Item BREADCRUMBS =
            register(BREADCRUMBS_KEY);

    public static void initialize() {
        // Initializes the registered items.
    }
}