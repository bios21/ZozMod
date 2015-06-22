package com.bios21.zozmod.handler;

import com.bios21.zozmod.init.ZozItems;
import com.bios21.zozmod.utils.ZozUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Asus on 21/06/2015.
 */
public class ZozEventHandler {

    private static ItemStack IRON_INGOT = new ItemStack(Items.iron_ingot);

    @SubscribeEvent
    public void handleIronLightningStrike(EntityStruckByLightningEvent event) {
        Entity entity = event.entity;
        if (entity instanceof EntityItem) {
            ItemStack stack = ((EntityItem)entity).getEntityItem();

            if (stack != null && !entity.isDead && ZozUtils.isOreDictionnaryEqual(stack, IRON_INGOT)) {
                ((EntityItem)entity).setEntityItemStack(new ItemStack(ZozItems.chargedIronIngot, stack.stackSize, stack.getItemDamage()));
                event.setCanceled(true);
            }
        }
    }
}