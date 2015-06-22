package com.bios21.zozmod.creativetab;

import com.bios21.zozmod.init.ZozBlocks;
import com.bios21.zozmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Asus on 21/06/2015.
 */
public abstract class CreativeTabsZoz {
    public static final CreativeTabs ZOZ_MAIN_TAB = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ZozBlocks.lightningRod);
        }

        @Override
        public String getTranslatedTabLabel() {
            return Reference.MOD_NAME;
        }
    };
}
