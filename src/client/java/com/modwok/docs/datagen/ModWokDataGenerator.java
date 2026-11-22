package com.modwok.docs.datagen;

//import com.modwok.docs.worldgen.ModWokWorldGenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModWokDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWokBlockLootTableProvider::new);
        pack.addProvider(ModWokBlockTagProvider::new);
//        pack.addProvider(ModWokWorldGenProvider::new);
    }
}