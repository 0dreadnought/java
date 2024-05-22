package net.dread.playGround.datagen;

import net.dread.playGround.block.ModBlocks;
import net.dread.playGround.playGround;
import net.dread.playGround.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, playGround.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.ALLORES)
                .add(ModBlocks.JADE_ORE_BLOCK.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.JADE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.JADE_ORE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.JADE_ORE_BLOCK.get(),
                        ModBlocks.ES_BLOCK.get(),
                        ModBlocks.JADE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE);
        this.tag(BlockTags.MINEABLE_WITH_HOE);
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ES_BLOCK.get());
    }
}
