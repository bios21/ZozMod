package com.bios21.zozmod.tileentity;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by l.sagetlethias on 22/06/2015.
 */
public abstract class BaseTileEntityZoz extends TileEntity {
    private String owner = "[ZOZ]";

    public String getOwner() {
        return this.owner;
    }
}