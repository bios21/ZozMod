package com.bios21.zozmod.handler;

import com.bios21.zozmod.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ZozConfigurationHandler {
	public static Configuration configuration;
    public static boolean debugMode = false;

	public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
	}

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        debugMode = configuration.get(Configuration.CATEGORY_GENERAL, "debugMode", false, "Activate debug mode").getBoolean();

        if (configuration.hasChanged()) configuration.save();
    }
}