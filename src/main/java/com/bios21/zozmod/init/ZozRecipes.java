package com.bios21.zozmod.init;

import com.bios21.zozmod.block.BaseBlockZoz;
import com.bios21.zozmod.core.IBlockItem;
import com.bios21.zozmod.item.BaseItemZoz;
import com.bios21.zozmod.utils.ZozUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 22/06/2015.
 */
public class ZozRecipes {
    private static final Map<String, ItemStack> stacks = new HashMap<String, ItemStack>();

    public static void init() {
        initShapedRecipes();
        initShapelessRecipes();
        initFurnaceRecipes();
    }

    private static ItemStack getOrFeedStack(final IBlockItem blockItem, int amount) {
        if (amount > 9) {
            amount = 9;
        }

        if (amount < 1) {
            amount = 1;
        }

        String keyToFind = blockItem.getName()+amount;

        ItemStack stack = stacks.get(keyToFind);
        if (stack == null) {
            if (blockItem.isBlock()) {
                stack = new ItemStack((BaseBlockZoz)blockItem, amount);
            } else {
                stack = new ItemStack((BaseItemZoz)blockItem, amount);
            }
            stacks.put(keyToFind, stack);
        }

        return stack;
    }

    private static ItemStack getOrFeedStack(final IBlockItem blockItem) {
        return getOrFeedStack(blockItem, 1);
    }

    private static void initShapedRecipes() {

    }

    private static void initShapelessRecipes() {
        GameRegistry.addShapelessRecipe(getOrFeedStack(ZozItems.chargedIronIngot, 9), getOrFeedStack(ZozBlocks.chargedIronBlock));
        GameRegistry.addShapelessRecipe(getOrFeedStack(ZozBlocks.chargedIronBlock), ZozUtils.getFilledArray(9, getOrFeedStack(ZozItems.chargedIronIngot)));
    }

    private static void initFurnaceRecipes() {

    }
}