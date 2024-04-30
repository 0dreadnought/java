package net.dread.playGround.item;

import net.dread.playGround.block.ModBlocks;
import net.dread.playGround.playGround;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, playGround.MODID);

    public static final RegistryObject<CreativeModeTab> PlayGround_TAB = CREATIVE_MODE_TABS.register("playground",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModItems.GIGA_CHAD_TOKEN.get()))
            .title(Component.translatable("creativetab.playground"))
            .displayItems((pParameters, pOutput)->{
                pOutput.accept(ModItems.GIGA_CHAD_TOKEN.get());
                pOutput.accept(ModItems.JADE.get());

                pOutput.accept(ModBlocks.ES_BLOCK.get());
                pOutput.accept(ModBlocks.JADE_BLOCK.get());
                pOutput.accept(ModBlocks.JADE_ORE_BLOCK.get());
            }).build());

    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}