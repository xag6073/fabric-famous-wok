package com.example.modwok;

import com.example.modwok.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class ModWok implements ModInitializer {

    public static final String MOD_ID = "modwok";

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}