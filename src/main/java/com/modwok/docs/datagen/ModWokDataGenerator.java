package com.modwok.docs.datagen;

import com.modwok.docs.worldgen.ModWokWorldFeatures;
import com.modwok.docs.worldgen.ModWokWorldGenProvider;
import com.modwok.docs.worldgen.ModWokWorldPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ModWokDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWokBlockLootTableProvider::new);
        pack.addProvider(ModWokBlockTagProvider::new);
        pack.addProvider(ModWokWorldGenProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.FEATURE, ModWokWorldFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, ModWokWorldPlacedFeatures::configure);
    }
}