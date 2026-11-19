package com.example.items;

import com.example.ModWok;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {

    public static final ResourceKey<Item> BREADED_CHICKEN_CUTS = create("breaded_chicken_cuts");

    public static final ResourceKey<Item> BREADCRUMBS_KEY = create("breadcrumbs");

    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, ModWok.id(name));
    }
}
