package net.dread.playGround.datagen;

import net.dread.playGround.block.ModBlocks;
import net.dread.playGround.item.ModItems;
import net.dread.playGround.playGround;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.JADE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ES_BLOCK.get())
                .pattern("#Y#")
                .pattern("F#G")
                .pattern("#X#")
                .define('#',ModItems.JADE.get())
                .define('Y', Items.COBBLESTONE)
                .define('F', Items.END_STONE)
                .define('G', Items.NETHERRACK)
                .define('X', Items.DEEPSLATE)
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EXTRACTOR_BLOCK.get())
                .pattern("#Y#")
                .pattern("XXX")
                .pattern("#X#")
                .define('#', ItemTags.PLANKS)
                .define('Y', Items.DIAMOND)
                .define('X', Items.STONE)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIREWOOD.get(),1)
                .requires(Items.STICK,4)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JADE.get(),9)
                .requires(ModBlocks.JADE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.JADE_BLOCK.get()), has(ModBlocks.JADE_BLOCK.get()))
                .save(consumer);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, playGround.MODID+":"+ getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
