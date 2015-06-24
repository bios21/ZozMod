package com.bios21.zozmod;

import com.bios21.zozmod.handler.ZozConfigurationHandler;
import com.bios21.zozmod.handler.ZozEventHandler;
import com.bios21.zozmod.init.ZozBlocks;
import com.bios21.zozmod.init.ZozItems;
import com.bios21.zozmod.init.ZozRecipes;
import com.bios21.zozmod.init.ZozTileEntities;
import com.bios21.zozmod.proxy.IProxy;
import com.bios21.zozmod.reference.Reference;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.FULL_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class ZozMod {

    @Instance(Reference.MOD_ID)
    public static ZozMod instance;

    @SidedProxy(
            clientSide = Reference.CLIENT_PROXY_CLASS,
            serverSide = Reference.SERVER_PROXY_CLASS
    )
    public static IProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ZozConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ZozConfigurationHandler());
        FMLCommonHandler.instance().bus().register(new ZozEventHandler());

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        ZozItems.init();
        ZozBlocks.init();
        ZozTileEntities.init();
        ZozRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}