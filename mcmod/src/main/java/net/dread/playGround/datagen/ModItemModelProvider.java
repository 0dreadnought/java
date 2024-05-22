package net.dread.playGround.datagen;

import net.dread.playGround.item.ModItems;
import net.dread.playGround.playGround;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, playGround.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.FIREWOOD);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.GIGA_CHAD_TOKEN);
        simpleItem(ModItems.ONION);
        simpleItem(ModItems.ORE_PROSPECTOR);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(playGround.MODID,"item/"+item.getId().getPath()));
    }
}
