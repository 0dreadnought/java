package net.dread.playGround.block;

import net.dread.playGround.block.custom.ExtractorBlock;
import net.dread.playGround.item.ModItems;
import net.dread.playGround.playGround;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, playGround.MODID);

    public static final RegistryObject<Block> ES_BLOCK =
            registerBlock("es_block",()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> JADE_BLOCK =
            registerBlock("jade_block",()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> JADE_ORE_BLOCK =
            registerBlock("jade_ore_block",()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    UniformInt.of(1,3)));

    public static final RegistryObject<Block> EXTRACTOR_BLOCK =
            registerBlock("extractor_block",()->new ExtractorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
