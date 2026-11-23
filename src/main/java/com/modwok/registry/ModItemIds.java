package com.modwok.registry;

import com.modwok.ModWok;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {

    // FOODS
    public static final ResourceKey<Item> BREADED_CHICKEN_CUTS = create("breaded_chicken_cuts");
    public static final ResourceKey<Item> BREADCRUMBS_KEY = create("breadcrumbs");
    public static final ResourceKey<Item> LO_MEIN_KEY = create("lo_mein");
    public static final ResourceKey<Item> EGG_DROP_SOUP_KEY = create("egg_drop_soup");

    // ORE DROPS
    public static final ResourceKey<Item> GORANGE_CHICKEN_NUG_KEY = create("gorange_chicken_nug");

    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, ModWok.id(name));
    }
}
