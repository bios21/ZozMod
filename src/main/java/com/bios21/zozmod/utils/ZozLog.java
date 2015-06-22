package com.bios21.zozmod.utils;

import com.bios21.zozmod.reference.Reference;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class ZozLog {
	public static void log(final Level logLevel, final Object object) {
        FMLLog.log(Reference.MOD_ID, logLevel, String.valueOf(object));
    }

    public static void debug(final Object object) {
        log(Level.DEBUG, object);
    }

    public static void info(final Object object) {
        log(Level.INFO, object);
    }

    public static void error(final Object object) {
        log(Level.ERROR, object);
    }
}
