package net.ginos.funmod.entity.block;

import net.ginos.funmod.entity.ModBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RefinerBlockEntity extends BlockEntity {
    public RefinerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TESTBLOCK, pos, state);
    }

    //@Override
    public static void tick(World world, BlockPos pos, BlockState state, RefinerBlockEntity blockEntity) {

    }


}
