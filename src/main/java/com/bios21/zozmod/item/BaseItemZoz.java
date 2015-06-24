package com.bios21.zozmod.item;

import com.bios21.zozmod.core.IBlockItem;
import com.bios21.zozmod.creativetab.CreativeTabsZoz;
import com.bios21.zozmod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Asus on 20/06/2015.
 */
public abstract class BaseItemZoz extends Item implements IBlockItem {
    private String name;

    public BaseItemZoz(final String name) {
        super();
        this.setNoRepair();
        this.setCreativeTab(CreativeTabsZoz.ZOZ_MAIN_TAB);
        this.name = name;
    }

    @Override
    public String getUnlocalizedName() {
        final StringBuilder sbName = new StringBuilder("item.");
        sbName.append(Reference.MOD_ID.toLowerCase()).append(":");
        sbName.append(this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

        return sbName.toString();
    }

    @Override
    public String getUnlocalizedName(final ItemStack stack) {
        return this.getUnlocalizedName();
    }

    @Override
    public String getTextureName() {
        return String.format("%s:%s", Reference.MOD_ID.toLowerCase(), this.name);
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public boolean isItem() {
        return true;
    }

    protected String getUnwrappedUnlocalizedName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
