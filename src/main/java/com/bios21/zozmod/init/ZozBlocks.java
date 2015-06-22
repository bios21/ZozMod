package com.bios21.zozmod.init;

import com.bios21.zozmod.block.BaseBlockZoz;
import com.bios21.zozmod.block.BlockChargedIronBlock;
import com.bios21.zozmod.block.BlockLightningRod;
import com.bios21.zozmod.reference.Reference;
import com.bios21.zozmod.utils.ModelHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ZozBlocks {
    public static final BaseBlockZoz chargedIronBlock = new BlockChargedIronBlock();
    public static final BaseBlockZoz lightningRod = new BlockLightningRod();

    public static void init() {
        registerBlocks();
        registerBlockModels();
    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(chargedIronBlock, Reference.Blocks.chargedIronBlock);
        GameRegistry.registerBlock(lightningRod, Reference.Blocks.lightningRod);
    }

    public static void registerBlockModels() {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            ModelHelper.registerBlock(chargedIronBlock, chargedIronBlock.getTextureName());
            ModelHelper.registerBlock(lightningRod, lightningRod.getTextureName());
        }
    }
}
