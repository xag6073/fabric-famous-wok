package com.modwok.registry;

import com.modwok.ModWok;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockItemIds {

    public static final BlockItemId GORANGE_CHICKEN_ORE_KEY =
            BlockItemId.create(
                    ModWok.id("gorange_chicken_ore"),
                    ModWok.id("gorange_chicken_ore")
            );

    private static BlockItemId create(String name) {
        Identifier id = ModWok.id(name);
        return BlockItemId.create(id, id);
    }
}