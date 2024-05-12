package net.dread.playGround.block.custom;


import net.dread.playGround.item.ModItems;
import net.dread.playGround.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ExtractorBlock extends Block{




    public ExtractorBlock(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        String item_name = pPlayer.getItemInHand(pHand).getDescriptionId();

        if(pPlayer.getItemInHand(pHand).is(ModTags.Items.EXTRACTOR_INPUT)){
            pLevel.playSound(pPlayer,pPos,SoundEvents.UI_STONECUTTER_TAKE_RESULT,SoundSource.BLOCKS,3f,1f);
            pPlayer.getItemInHand(pHand).shrink(1);
            Random rnd = new Random(pLevel.getGameTime());
            int o = 1;
            int b = 4;
            if (pPlayer.getItemInHand(pHand).is(Tags.Items.ORES_LAPIS)){b=16;o=7;}
            if (pPlayer.getItemInHand(pHand).is(Tags.Items.ORES_QUARTZ)){b=10;o=3;}
            for (int i = 0;i<=rnd.nextInt(o,b);i++) {
                pPlayer.addItem(ore_to_item(item_name));

            }
        }
            return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.playground.extractor.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
    private static ItemStack ore_to_item(String name){

        switch (name){
            case "block.playground.jade_ore_block":
                return ModItems.JADE.get().getDefaultInstance();
            case "block.minecraft.diamond_ore":
                return Items.DIAMOND.getDefaultInstance();
            case "block.minecraft.deepslate_diamond_ore":
                return Items.DIAMOND.getDefaultInstance();
            case "block.minecraft.nether_quartz_ore":
                return Items.QUARTZ.getDefaultInstance();
            case "block.minecraft.lapis_ore":
                return Items.LAPIS_LAZULI.getDefaultInstance();
            case "block.minecraft.deepslate_lapis_ore":
                return Items.LAPIS_LAZULI.getDefaultInstance();
            case "block.minecraft.emerald_ore":
                return Items.EMERALD.getDefaultInstance();
            case "block.minecraft.deepslate_emerald_ore":
                return Items.EMERALD.getDefaultInstance();
        }
        return  null;
    }
}



