package net.ginos.funmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;


public class ModSapplingBlock extends SaplingBlock {
    private final Block block;

    public ModSapplingBlock(SaplingGenerator generator, Settings settings, Block block) {
        super(generator, settings);
        this.block = block;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(this.block);
    }
}
