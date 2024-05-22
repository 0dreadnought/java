package net.dread.playGround.datagen;

import net.dread.playGround.block.ModBlocks;
import net.dread.playGround.playGround;
import net.dread.playGround.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, playGround.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.EXTRACTOR_INPUT)
                .add(ModBlocks.JADE_ORE_BLOCK.get().asItem())
                .addTag(Tags.Items.ORES_DIAMOND)
                .addTag(Tags.Items.ORES_EMERALD)
                .addTag(Tags.Items.ORES_QUARTZ)
                .addTag(Tags.Items.ORES_LAPIS);

    }
}
