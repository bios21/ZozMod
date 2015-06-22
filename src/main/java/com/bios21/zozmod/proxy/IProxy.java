package com.bios21.zozmod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
	void preInit(final FMLPreInitializationEvent event);
	void init(final FMLInitializationEvent event);
	void postInit(final FMLPostInitializationEvent event);
}
