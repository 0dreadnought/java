package net.dread.playGround.datagen;

import net.dread.playGround.datagen.loot.ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    public static LootTableProvider crete(PackOutput output){
        return new LootTableProvider(output, Set.of(), List.of(
           new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
