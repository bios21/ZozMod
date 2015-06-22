package com.bios21.zozmod.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 21/06/2015.
 */
public class ZozUtils {
    public static boolean isOreDictionnaryEqual(final ItemStack a, final ItemStack b) {
        final int[] oreDictIDs = OreDictionary.getOreIDs(a);
        for (final int id : oreDictIDs) {
            final List<ItemStack> oreDictStacks = OreDictionary.getOres(OreDictionary.getOreName(id));
            for (final ItemStack oreDictStack : oreDictStacks) {
                if (OreDictionary.itemMatches(oreDictStack, b, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float pixelToFloat(final int pixel) {
        return ((float) pixel) / 16f;
    }

    public static <T> T[] getFilledArray(final int size, final T clonable) {
        final List<T> filledArray = new ArrayList<T>(size);

        for (int i = 0; i < size; i++) {
            final Method methods[] = clonable.getClass().getMethods();
            for (final Method m : methods) {
                if ("clone".equalsIgnoreCase(m.getName()) || "copy".equalsIgnoreCase(m.getName())) {
                    try {
                        filledArray.add((T) m.invoke(clonable, null));
                        break;
                    } catch (final InvocationTargetException e) {
                        ZozLog.info(clonable.toString() + " clone or copy not callable.");
                    } catch (final IllegalAccessException e) {
                        ZozLog.info(clonable.toString() + " clone or copy not accessible.");
                    }
                }
            }
        }


        return (T[]) filledArray.toArray();
    }
}