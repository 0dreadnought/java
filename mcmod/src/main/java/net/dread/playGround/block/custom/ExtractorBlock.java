package net.dread.playGround.block.custom;

import net.dread.playGround.block.ModBlocks;
import net.dread.playGround.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class ExtractorBlock extends Block{

    public ExtractorBlock(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.getItemInHand(pHand).getItem()== ModBlocks.JADE_ORE_BLOCK.get().asItem()){
            pLevel.playSound(pPlayer,pPos,SoundEvents.UI_STONECUTTER_TAKE_RESULT,SoundSource.BLOCKS,3f,1f);
            pPlayer.getItemInHand(pHand).shrink(1);
            Random rnd = new Random();
            for (int i = 0;i<=rnd.nextInt(4);i++) {
                pPlayer.addItem(ModItems.JADE.get().getDefaultInstance());
            }
        }
            return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.playground.extractor.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}



