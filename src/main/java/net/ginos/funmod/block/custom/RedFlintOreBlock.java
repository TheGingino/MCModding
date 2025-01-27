package net.ginos.funmod.block.custom;

import net.ginos.funmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;

public class RedFlintOreBlock extends ExperienceDroppingBlock {

    public static final IntProperty USE_COUNT = IntProperty.of("use_count", 0, 2); // Tracks 0 to 2 interactions

    public RedFlintOreBlock(Settings settings, IntProvider experienceDropped) {
        super(UniformIntProvider.create(1,5), settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(USE_COUNT, 0)); // Default use count
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(USE_COUNT); // Add the USE_COUNT property
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            int use_count = state.get(USE_COUNT);
            ItemStack heldItem = player.getStackInHand(Hand.MAIN_HAND);

            if ((heldItem.getItem() == ModItems.RED_FLINT_PICKAXE)) {
                if (use_count < 2) {
                    ItemStack flint = new ItemStack(ModItems.BURNT_COAL, 1);
                    dropStack(world, pos, flint);
                    world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK,
                            SoundCategory.BLOCKS, 1.0f, 1.0f);

                    world.setBlockState(pos, state.with(USE_COUNT, use_count  + 1));
                    return ActionResult.SUCCESS;
                } else {
                    // Break the block when fully carved (like cake)
                    ItemStack flint = new ItemStack(ModItems.RED_FLINT, 1);
                    dropStack(world, pos, flint);

                    world.removeBlock(pos, false);
                    world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK,
                            SoundCategory.BLOCKS, 1.0f, 1.0f);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }
}
