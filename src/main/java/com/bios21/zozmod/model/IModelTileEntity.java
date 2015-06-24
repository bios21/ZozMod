package com.bios21.zozmod.model;

import com.bios21.zozmod.tileentity.BaseTileEntityZoz;

/**
 * Created by Asus on 24/06/2015.
 */
public interface IModelTileEntity {
    BaseTileEntityZoz getTileEntity();
    void setTileEntity(final BaseTileEntityZoz tileEntity);
}
