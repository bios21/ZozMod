package com.bios21.zozmod.init;

import com.bios21.zozmod.item.BaseItemZoz;
import com.bios21.zozmod.item.ItemChargedIronIngot;
import com.bios21.zozmod.reference.Reference;
import com.bios21.zozmod.utils.ModelHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Asus on 20/06/2015.
 */
public class ZozItems {
    public static final BaseItemZoz chargedIronIngot = new ItemChargedIronIngot();

    public static void init() {
        registerItems();
        registerItemModels();
    }

    public static void registerItems() {
        GameRegistry.registerItem(chargedIronIngot, Reference.Items.chargedIronIngot);
    }

    public static void registerItemModels() {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            ModelHelper.registerItem(chargedIronIngot, chargedIronIngot.getTextureName());
        }
    }
}