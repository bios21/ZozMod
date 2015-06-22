package com.bios21.zozmod.block;

import com.bios21.zozmod.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Asus on 21/06/2015.
 */
public class BlockChargedIronBlock extends BaseBlockZoz {
    public BlockChargedIronBlock() {
        super(Material.iron, Reference.Blocks.chargedIronBlock);
        this.setUnlocalizedName(Reference.Blocks.chargedIronBlock);
    }

    @Override
    public int getDamageValue(World worldIn, BlockPos pos) {
        return 0;
    }
}