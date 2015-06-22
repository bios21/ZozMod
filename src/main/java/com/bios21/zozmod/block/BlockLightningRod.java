package com.bios21.zozmod.block;

import com.bios21.zozmod.reference.Reference;
import com.bios21.zozmod.utils.ZozLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Asus on 21/06/2015.
 */
public class BlockLightningRod extends BaseBlockZoz {

    public BlockLightningRod() {
        super(Material.iron, Reference.Blocks.lightningRod);
        this.setUnlocalizedName(Reference.Blocks.lightningRod);
        this.setTickRandomly(true);
        this.setSize(8, 11, 8);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
        ZozLog.info(this + "Random tick !");
    }
}
