package com.bios21.zozmod.init;

import com.bios21.zozmod.reference.Reference;
import com.bios21.zozmod.renderer.TileEntityLightningRodRenderer;
import com.bios21.zozmod.tileentity.TileLightningRod;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Asus on 22/06/2015.
 */
public class ZozTileEntities {
    public static final String TILE = "tile.";

    public static void init() {
        registerTileEntities();
    }

    public static void registerTileEntities() {
        GameRegistry.registerTileEntityWithAlternatives(TileLightningRod.class, Reference.Blocks.lightningRod, TILE + Reference.Blocks.lightningRod);
        ClientRegistry.bindTileEntitySpecialRenderer(TileLightningRod.class, new TileEntityLightningRodRenderer());
    }
}