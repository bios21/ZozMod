package com.bios21.zozmod.reference;

public class Reference {
	public static final String MOD_ID = "ZozMod";
    public static final String MOD_NAME = "ZOZ";
    public static final String MOD_DESC = "Testage de bg";
    public static final String VERSION = "1.0";
    public static final String MC_VERSION = "1.8";
    public static final String FULL_VERSION = MC_VERSION + "-" + VERSION;


    public static final String CLIENT_PROXY_CLASS = "com.bios21.zozmod.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.bios21.zozmod.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "com.bios21.zozmod.client.gui.GuiFactory";


    public static final class Items {
        public static final String chargedIronIngot = "charged_iron_ingot";
        public static final String chargedIronNugget = "charged_iron_nugget";
    }

    public static final class Blocks {
        public static final String chargedIronBlock = "charged_iron_block";
        public static final String lightningRod = "lightning_rod";
    }
}