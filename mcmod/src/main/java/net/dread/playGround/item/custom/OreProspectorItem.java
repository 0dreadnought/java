package net.dread.playGround.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

import java.util.function.Predicate;

public class OreProspectorItem extends Item {
    public OreProspectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext){
        if (pContext.getLevel().isClientSide()){
            BlockPos pos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i =0; i<=pos.getY()+64;i++){
                BlockState state = pContext.getLevel().getBlockState(pos.below(i));

                if(isValuableOre(state)){
                    player.sendSystemMessage(Component.literal("Found " + I18n.get(state.getBlock().getDescriptionId()) + " " + i +
                            " blocks below"));
                    foundBlock = true;
                }
            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No ore found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private boolean isValuableOre(BlockState state) {
        return state.getTags().anyMatch(Predicate.isEqual(Tags.Blocks.ORES));
    }
}
