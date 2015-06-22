package com.bios21.zozmod.item;

import com.bios21.zozmod.reference.Reference;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Asus on 20/06/2015.
 */
public class ItemChargedIronIngot extends BaseItemZoz {
    public ItemChargedIronIngot() {
        super(Reference.Items.chargedIronIngot);
        this.setUnlocalizedName(Reference.Items.chargedIronIngot);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(final ItemStack itemStack) {
        return EnumRarity.RARE;
    }

}
