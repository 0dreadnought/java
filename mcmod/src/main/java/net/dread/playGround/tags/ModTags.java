package net.dread.playGround.tags;

import net.dread.playGround.playGround;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks{

        public static final TagKey<Block> ALLORES = tag("allores");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(playGround.MODID, name));
        }
    }

    public static class Items{

        public static final TagKey<Item> EXTRACTOR_INPUT = tag("extractor_input");


        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(playGround.MODID, name));
        }
    }
}
