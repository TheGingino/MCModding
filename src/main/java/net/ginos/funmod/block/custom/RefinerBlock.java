package net.ginos.funmod.block.custom;


import com.mojang.serialization.MapCodec;
import net.ginos.funmod.entity.ModBlockEntityTypes;
import net.ginos.funmod.entity.block.RefinerBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class RefinerBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE = Block.createCuboidShape(0,0,0,16,12,20);

    public RefinerBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RefinerBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        // Make sure to check world.isClient if you only want to tick only on serverside.
        return validateTicker(type, ModBlockEntityTypes.TESTBLOCK, RefinerBlockEntity::tick);
    }

    @Override
    protected MapCodec<? extends RefinerBlock> getCodec() {
        return createCodec(RefinerBlock::new);
    }
}
