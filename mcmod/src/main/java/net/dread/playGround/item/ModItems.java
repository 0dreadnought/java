package net.dread.playGround.item;

import net.dread.playGround.item.custom.FuelItem;
import net.dread.playGround.item.custom.OreProspectorItem;
import net.dread.playGround.playGround;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, playGround.MODID);

    public static final RegistryObject<Item> GIGA_CHAD_TOKEN = ITEMS.register("token",
            ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> ORE_PROSPECTOR = ITEMS.register("ore_prospector",
            ()->new OreProspectorItem(new Item.Properties().durability(128)));

    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            ()->new Item(new Item.Properties().food(ModFoods.ONION)));

    public static final RegistryObject<Item> FIRE_WOOD = ITEMS.register("fire_wood",
            ()->new FuelItem(new Item.Properties(),1200));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
