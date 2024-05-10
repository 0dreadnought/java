package net.dread.playGround.item.custom;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.dread.playGround.playGround;

import java.util.function.Predicate;

public class OreProspectorItem extends Item {

    boolean isVert = true;
    CompoundTag tag = new CompoundTag();


    public OreProspectorItem(Properties pProperties) {
        super(pProperties);
        ItemProperties.register(this, new ResourceLocation(playGround.MODID,"texture"),
                (stack, level, living, id) -> {
                    return this.isVert ? 1 : 0;
                });
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext){

        if (!pContext.getLevel().isClientSide()){
            BlockPos pos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean notFoundBlock = true;
            if (isVert){

                for(int i =0; i<=pos.getY()+64;i++){
                    BlockState state = pContext.getLevel().getBlockState(pos.below(i));

                    if(isValuableOre(state)){
                        player.sendSystemMessage(Component.literal("Found " + I18n.get(state.getBlock().getDescriptionId()) + " " + i +
                                " blocks below"));
                        notFoundBlock = false;
                    }
                }
            }
            else{
                int py = pos.getY();
                ChunkPos chunk = new ChunkPos(pos);
                for (int x = chunk.getMinBlockX();x<=chunk.getMaxBlockX();x++) {
                    for (int z = chunk.getMinBlockZ();z<=chunk.getMaxBlockZ();z++) {
                        for (int y = py-5; y <= py+5; y++) {
                            BlockPos bpos = new BlockPos(x,y,z);
                            BlockState state = pContext.getLevel().getBlockState(bpos);

                            if(isValuableOre(state)){
                                player.sendSystemMessage(Component.literal("Found " + I18n.get(state.getBlock().getDescriptionId())));
                                notFoundBlock = false;
                            }
                        }
                    }
                }
            }
            if(notFoundBlock){
                player.sendSystemMessage(Component.literal("No ore found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(!pLevel.isClientSide()) {
            isVert = !isVert;
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private boolean isValuableOre(BlockState state) {
        return state.getTags().anyMatch(Predicate.isEqual(Tags.Blocks.ORES));
    }
}
