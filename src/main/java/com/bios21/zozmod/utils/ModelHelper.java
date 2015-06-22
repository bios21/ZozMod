package com.bios21.zozmod.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Asus on 20/06/2015.
 */
@SideOnly(Side.CLIENT)
public class ModelHelper {
    final static int DEFAULT_ITEM_SUBTYPE = 0;

    public static void registerItem(Item item, int metadata, String itemName) {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation(itemName, "inventory"));
        ZozLog.error("NAME : " + itemName);
    }

    public static void registerBlock(Block block, int metadata, String blockName) {
        registerItem(Item.getItemFromBlock(block), metadata, blockName);
    }

    public static void registerBlock(Block block, String blockName) {
        registerBlock(block, DEFAULT_ITEM_SUBTYPE, blockName);
    }

    public static void registerItem(Item item, String itemName) {
        registerItem(item, DEFAULT_ITEM_SUBTYPE, itemName);
    }
}